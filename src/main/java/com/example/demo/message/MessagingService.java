package com.example.demo.message;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.converter.RecordMessageConverter;
import org.springframework.kafka.support.converter.StringJsonMessageConverter;
import org.springframework.web.bind.annotation.PathVariable;

@Configuration
@Profile("dev")
@Slf4j
public class MessagingService {

    @Autowired
    private KafkaTemplate<Object, Object> template;

    @Bean
    public RecordMessageConverter converter() {
        return new StringJsonMessageConverter();
    }

   @Bean
    public NewTopic topic() {
        return new NewTopic("topic1", 1, (short) 1);
    }

    public void sendFoo(@PathVariable String what) {
        this.template.send("topic1", new Foo1(what));
    }
}
