package code.onetoone;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

public class Producer {
    public static void main(String[] args) throws MQClientException, RemotingException, InterruptedException, MQBrokerException {
        DefaultMQProducer defaultMQProducer = new DefaultMQProducer("group1");
        defaultMQProducer.setNamesrvAddr("192.168.134.2:9876");
        defaultMQProducer.start();
        String msg = "Hello";
        Message message = new Message("topic1", msg.getBytes());
        SendResult result = defaultMQProducer.send(message);
        System.out.println(result);
        defaultMQProducer.shutdown();
    }
}
