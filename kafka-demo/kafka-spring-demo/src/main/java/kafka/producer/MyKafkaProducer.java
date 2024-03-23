package kafka.producer;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class MyKafkaProducer {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public String send(String msg) {
        kafkaTemplate.send(new ProducerRecord<>("TopicA", null, msg));
        return "ok";
    }
}
