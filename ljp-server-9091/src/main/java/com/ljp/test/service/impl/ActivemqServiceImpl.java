package com.ljp.test.service.impl;

import com.ljp.test.service.ActivemqService;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.jms.Destination;

@Service
public class ActivemqServiceImpl implements ActivemqService {

	@Resource
	private Destination testQueue;
	@Resource
	private JmsTemplate jmsTemplate;

	@Transactional
	@Override
	public void sendTextMessage(String textMessage) {
		jmsTemplate.convertAndSend(testQueue, textMessage);
		jmsTemplate.send(testQueue, session -> session.createTextMessage(textMessage));
	}

}
