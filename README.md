spring.kafka.bootstrap-servers={{SERVER_URL}}\
spring.kafka.properties.sasl.jaas.config=org.apache.kafka.common.security.plain.PlainLoginModule   required username='{{CLUSTER_API_KEY}}'   password=''{{CLUSTER_API_SECRET}}'';\

