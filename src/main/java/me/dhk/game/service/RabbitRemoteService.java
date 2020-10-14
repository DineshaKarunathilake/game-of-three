package me.dhk.game.service;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import me.dhk.game.model.Acceptable;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

public class RabbitRemoteService implements IRemoteService {

    private final String HOST_NAME = "localhost";

    @Override
    public void sendMove(String opponent, int move) {
        String message= String.valueOf(move);
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(HOST_NAME);
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.queueDeclare(opponent, false, false, false, null);
            channel.basicPublish("", opponent, null, message.getBytes(StandardCharsets.UTF_8));
            System.out.println(" [x] Sending  " + message + "");
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void registerAcceptor(Acceptable acceptable, String playerName) {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(HOST_NAME);

        try{
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();

            channel.queueDeclare(playerName, false, false, false, null);

            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String message = new String(delivery.getBody(), "UTF-8");
                System.out.println(" [x] Received " + message + "");
                acceptable.accept(Integer.parseInt(message));
            };
            channel.basicConsume(playerName, true, deliverCallback, consumerTag -> { });
        } catch (Exception exception) {

            System.out.println("Something went wrong!!!");
        }
    }
}
