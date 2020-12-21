package code.pubsub.fanout;

import code.utils.RabbitMQUtil;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Consumer2 {
    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = RabbitMQUtil.getConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare("fanout_exchange", BuiltinExchangeType.FANOUT);
        channel.queueDeclare("fanout_queue_2", true, false, false, null);
        channel.queueBind("fanout_queue_2", "fanout_exchange", "");
        DefaultConsumer defaultConsumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println(envelope.getDeliveryTag());
                System.out.println(envelope.getExchange());
                System.out.println(envelope.getRoutingKey());
            }
        };
        channel.basicConsume("fanout_queue_2", true, defaultConsumer);
    }
}
