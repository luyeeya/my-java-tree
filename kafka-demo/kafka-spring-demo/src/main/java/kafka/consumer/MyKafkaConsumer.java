package kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
public class MyKafkaConsumer {
    @KafkaListener(topics = "TopicA", groupId = "test-group-2")
    public void onMessage(ConsumerRecord<String, String> record, Acknowledgment ack) {
        System.out.printf("offset = %d, key = %s, value = %s, partition = %s%n",
                record.offset(), record.key(), record.value(), record.partition());
        ack.acknowledge();  // 消费消息后手动提交 ack
        System.out.println("消费完成~");
    }
}
