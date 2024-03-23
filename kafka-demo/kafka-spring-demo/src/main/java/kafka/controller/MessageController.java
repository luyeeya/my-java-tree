package kafka.controller;

import kafka.producer.MyKafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/msg")
public class MessageController {
    @Autowired
    private MyKafkaProducer producer;

    @GetMapping("produce")
    public String produce(@RequestParam("msg") String msg) {
        return producer.send(msg);
    }
}
