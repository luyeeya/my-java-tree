package kafka.interceptor;

import org.apache.kafka.clients.producer.ProducerInterceptor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Map;

public class MyProducerInterceptor implements ProducerInterceptor {
    /**
     * 发送消息的时候触发
     */
    @Override
    public ProducerRecord onSend(ProducerRecord record) {
        System.out.println("[onSend] 发送一条消息~");
        return record;
    }

    /**
     * 收到服务端ACK确认的时候触发
     */
    @Override
    public void onAcknowledgement(RecordMetadata meta, Exception e) {
        System.out.printf("[onAcknowledgement] 消息ACK确认 topic = %s, partition = %d, offset = %d%n", meta.topic(), meta.partition(), meta.offset());
    }

    /**
     * 生产者关闭的时候触发
     */
    @Override
    public void close() {
        System.out.println("[close] 生产者关闭了");
    }

    /**
     * 用来获取配置信息及初始化数据
     */
    @Override
    public void configure(Map<String, ?> map) {
        System.out.printf("[configure] map = %s%n", map);
    }
}
