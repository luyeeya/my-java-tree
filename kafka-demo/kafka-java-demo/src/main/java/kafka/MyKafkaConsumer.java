package kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

public class MyKafkaConsumer {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "150.158.119.205:9092,120.55.167.193:9092,117.72.37.81:9092");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("group.id", "test-group-1"); // 当前消费者所属的组
        props.put("enable.auto.commit", "true"); // 是否自动提交偏移量，只有 commit 之后才更新消费组的 offset
        props.put("auto.commit.interval.ms", "1000"); // 消费者自动提交的间隔
        props.put("auto.offset.reset", "earliest"); // 从最早的数据开始消费 earliest | latest | exception | none

        try (KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props)) {
            consumer.subscribe(Collections.singletonList("TopicA"));
            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofSeconds(1));
                for (ConsumerRecord<String, String> record : records) {
                    System.out.printf("offset = %d, key = %s, value = %s, partition = %s%n",
                            record.offset(), record.key(), record.value(), record.partition());
                }
            }
        }
    }
}
