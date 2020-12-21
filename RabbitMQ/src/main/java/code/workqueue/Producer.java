package code.workqueue;

import code.utils.RabbitMQUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Producer {
    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = RabbitMQUtil.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare("work_queue", true, false, false, null);
        for (int i = 0; i < 10; i++) {
            String message = "Hello" + i;
            channel.basicPublish("", "work_queue", null, message.getBytes());
        }
        channel.close();
        connection.close();
    }
}
