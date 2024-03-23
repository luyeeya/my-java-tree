package kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class MyKafkaProducer {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "150.158.119.205:9092,120.55.167.193:9092,117.72.37.81:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("acks", "1"); // 0 发出去就确认 | 1 leader 落盘就确认| all(-1) 所有 Follower 同步完才确认
        props.put("retries", 3); // 异常自动重试次数
        props.put("batch.size", 16384); // 每次批量发送消息的最大数量（默认 16KB）
        props.put("linger.ms", 1000); // 批处理延迟时间上限，达到时间上限后，直接发送一次消息
        props.put("buffer.memory", 33554432); // 每次批量发送消息的最大内存（默认32M）
        props.put("max.block.ms", 3000); // 获取元数据时生产者的阻塞时间，超时后抛出异常

        try (KafkaProducer<String, String> producer = new KafkaProducer<>(props)) {
            String topic = "TopicA";
            String key = null; // 消息key的作用：(1)按照key的哈希值将消息分配到不同的分区 (2)同一个分区内，按照key的字典序将消息排序 (3)消费者可以通过key将多条消息聚合起来
            String value = "msg023";
            producer.send(new ProducerRecord<>(topic, key, value));
        }
    }
}
