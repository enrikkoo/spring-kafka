# spring-kafka


## Required connection configs for Kafka producer, consumer, and admin
spring.kafka.bootstrap-servers={{SERVER_URL}}\
spring.kafka.properties.sasl.mechanism=PLAIN\
spring.kafka.properties.sasl.jaas.config=org.apache.kafka.common.security.plain.PlainLoginModule   required username='{{CLUSTER_API_KEY}}'   password=''{{CLUSTER_API_SECRET}}'';\
spring.kafka.properties.security.protocol=SASL_SSL
## common configs

## Producer configuration
spring.kafka.producer.key-serializer=org.apache.kafka.common.serialization.StringSerializer\
spring.kafka.producer.value-serializer=org.apache.kafka.common.serialization.StringSerializer

## Consumer configuration
#spring.kafka.consumer.group-id=kafka-test\
#spring.kafka.consumer.key-deserializer=org.apache.kafka.common.serialization.StringDeserializer\
#spring.kafka.consumer.value-deserializer=org.apache.kafka.common.serialization.StringDeserializer\
#spring.kafka.consumer.topic=thing1\
#client.dns.lookup=use_all_dns_ips

## Best practice for higher availability in Apache Kafka clients prior to 3.0
spring.kafka.properties.session.timeout.ms=45000
