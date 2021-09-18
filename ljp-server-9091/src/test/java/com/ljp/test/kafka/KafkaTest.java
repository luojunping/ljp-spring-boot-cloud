package com.ljp.test.kafka;

import com.google.common.collect.Maps;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

public class KafkaTest {

	private static final String KAFKA_TEST_TOPIC = "kafka_test_topic";

	public static void main(String[] args) {
		long s = System.currentTimeMillis();
		DecimalFormat decimalFormat = new DecimalFormat("0000000");
		HashMap<String, Object> kafkaConfigMap = Maps.newHashMap();
		kafkaConfigMap.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
		kafkaConfigMap.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		kafkaConfigMap.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		KafkaProducer<String, String> kafkaProducer = new KafkaProducer<>(kafkaConfigMap);
		for (int i = 0; i < 1000000; i++) {
			kafkaProducer.send(new ProducerRecord<>(KAFKA_TEST_TOPIC, "test", "test" + decimalFormat.format(i)), (metadata, exception) -> {
//				if (exception != null) {
//					exception.printStackTrace();
//				} else {
//					System.out.println(metadata.toString());
//				}
			});
		}
		kafkaProducer.close();
		long e = System.currentTimeMillis();
		System.out.println((e - s) / 1000);
	}

	@Test
	public void testOne() {
		long s = System.currentTimeMillis();
		HashMap<String, Object> kafkaConfigMap = Maps.newHashMap();
		kafkaConfigMap.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
		kafkaConfigMap.put(ConsumerConfig.GROUP_ID_CONFIG, "test");
		kafkaConfigMap.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		kafkaConfigMap.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<>(kafkaConfigMap);
		kafkaConsumer.subscribe(List.of(KAFKA_TEST_TOPIC));
		ConsumerRecords<String, String> consumerRecords = kafkaConsumer.poll(Duration.ofSeconds(6));
		consumerRecords.forEach(consumerRecord -> {
			System.out.println(consumerRecord.offset());
		});
		kafkaConsumer.seek(new TopicPartition(KAFKA_TEST_TOPIC, 0), 1002);
		kafkaConsumer.close();
		long e = System.currentTimeMillis();
		System.out.printf("总计消%d耗秒！！！%n", (e - s) / 1000);
	}

}
