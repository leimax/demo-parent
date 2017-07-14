package com.accelerator.demo.amqp.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MQProducer {

    private final static Logger LOGGER = LoggerFactory.getLogger(MQProducer.class);

    @Resource
    private AmqpTemplate amqpTemplate;

    /**
     * convertAndSend：将Java对象转换为消息发送到匹配Key的交换机中Exchange，
     * 由于配置了JSON转换，这里是将Java对象转换成JSON字符串的形式。
     * 原文：Convert a Java object to an Amqp Message and send it to a default exchange with a specific routing key.
     * @param queueKey
     * @param object
     */
    public void sendDataToQueue(String queueKey, Object object) {
        try {
            amqpTemplate.convertAndSend(queueKey, object);
        } catch (Exception e) {
            LOGGER.error("消息发送异常！", e);
        }

    }

}
