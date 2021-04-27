package com.ljp.test.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.jupiter.api.Test;

import javax.jms.*;
import java.util.concurrent.TimeUnit;

public class ActivemqTest {

	private Connection connection;
	private Session session;
	private MessageProducer messageProducer;

	// @BeforeEach
	public void beforeOne() throws JMSException {
		ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory("failover:(tcp://127.0.0.1:61616,tcp://10.40.139.214:61616)");
		connection = activeMQConnectionFactory.createConnection();
		connection.start();
		session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
		Queue queue = session.createQueue("my-queue");
		messageProducer = session.createProducer(queue);
	}

	// @AfterEach
	public void afterOne() throws JMSException {
		session.close();
		connection.close();
	}

	@Test
	public void testOne() throws JMSException, InterruptedException {
		for (int i = 0; i < 100; i++) {
			TimeUnit.SECONDS.sleep(2);
			messageProducer.send(session.createTextMessage("hello world : " + i));
			session.commit();
		}
	}

	@Test
	public void testTwo() throws JMSException {
		ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory("failover:(tcp://127.0.0.1:61616,tcp://10.40.139.214:61616)");
		Connection connection = activeMQConnectionFactory.createConnection();
		connection.start();
		Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
		Queue queue = session.createQueue("my-queue");
		MessageConsumer messageConsumer = session.createConsumer(queue);
		for (int i = 0; i < 154; i++) {
			TextMessage textMessage = (TextMessage) messageConsumer.receive();
			session.commit();
			System.out.println(textMessage.getText());
		}
		session.close();
		connection.close();
	}

	@Test
	public void testThree() throws JMSException {
		ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory("failover:(tcp://127.0.0.1:61616,tcp://10.40.139.214:61616)?randomize=false");
		Connection connection = activeMQConnectionFactory.createConnection();
		connection.start();
		Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
		Queue evenQueue = session.createQueue("my-queue-even");
		Queue oddQueue = session.createQueue("my-queue-odd");
		MessageProducer messageProducer = session.createProducer(session.createQueue("my-queue"));
		try {
			for (int i = 0; i < 100; i++) {
//				if (i == 50) {
//					throw new IllegalArgumentException("illegal argument exception !!!");
//				}
				if (i % 2 == 0) {
					messageProducer.send(session.createTextMessage("even number : " + i));
				} else {
					messageProducer.send(session.createTextMessage("odd number : " + i));
				}
			}
			session.commit();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
			System.out.println("illegal argument exception !!!");
		} finally {
			messageProducer.close();
			session.close();
			connection.close();
		}
	}

}
