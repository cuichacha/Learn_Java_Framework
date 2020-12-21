package code.pubsub.fanout;

import code.utils.RabbitMQUtil;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Producer {
    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = RabbitMQUtil.getConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare("fanout_exchange", BuiltinExchangeType.FANOUT);
        channel.queueDeclare("fanout_queue_1", true, false, false, null);
        channel.queueDeclare("fanout_queue_2", true, false, false, null);
        channel.queueBind("fanout_queue_1", "fanout_exchange", "");
        channel.queueBind("fanout_queue_2", "fanout_exchange", "");
        for (int i = 0; i < 10; i++) {
            String message = "Hello" + i;
            channel.basicPublish("fanout_exchange", "", null, message.getBytes());
        }
        channel.close();
        connection.close();
    }
}
