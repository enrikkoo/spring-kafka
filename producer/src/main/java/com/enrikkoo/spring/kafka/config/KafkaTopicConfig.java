package com.enrikkoo.spring.kafka.config;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.config.SaslConfigs;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaTopicConfig {

    @Value("${kafka.topic}")
    private String kafkaTopic;


/*    @Bean
    public KafkaAdmin admin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        configs.put(ConsumerConfig.GROUP_ID_CONFIG, kafkaConsumerGroupId);
        configs.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        configs.put(SaslConfigs.SASL_MECHANISM, "PLAIN");
        configs.put(SaslConfigs.SASL_JAAS_CONFIG, SASL_JAAS_CONFIG);
        configs.put("security.protocol", "SASL_SSL");
        return new KafkaAdmin(configs);
    }*/

    @Bean
    public NewTopic topic() {
        return TopicBuilder.name(kafkaTopic)
                .partitions(2)
                .replicas(3)
                .build();
    }

    @Bean
    public NewTopic topicRetry() {
        return TopicBuilder.name(kafkaTopic + ".Retry")
                .partitions(2)
                .replicas(3)
                .build();
    }

    @Bean
    public NewTopic topicDLT() {
        return TopicBuilder.name(kafkaTopic+".DLT")
                .partitions(2)
                .replicas(3)
                .build();
    }
}
