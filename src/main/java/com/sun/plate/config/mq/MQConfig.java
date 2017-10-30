package com.sun.plate.config.mq;

import com.sun.plate.mq.Consumer;
import com.sun.plate.mq.impl.JeroMQConsumer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by sun on 2017/9/27.
 */
@Configuration
public class MQConfig {

  @Bean(initMethod = "init",destroyMethod = "destory")
  public Consumer testConsumer()
  {
    JeroMQConsumer consumer = new JeroMQConsumer();
    consumer.setHost("127.0.0.1");
    consumer.setPort(6001);
    consumer.setThreads(5);
    consumer.init();
    return consumer;
  }
}
