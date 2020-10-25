package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void sendBroadcastMessage(Message message){
        for (String key : connectionMap.keySet()){
            try {
                connectionMap.get(key).send(message);
            } catch (IOException e) {
                ConsoleHelper.writeMessage("Сообщение не отправилось!");
            }
        }
    }




    private static class Handler extends Thread{
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            ConsoleHelper.writeMessage("Установлено новое соединение с удаленным адремом: " + socket.getRemoteSocketAddress());
            Connection connection = null;
            String name = null;
            try {
                connection = new Connection(socket);
                name = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, name));
                notifyUsers(connection, name);
                serverMainLoop(connection, name);
                connectionMap.remove(name);
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED, name));
                socket.close();

            } catch (IOException | ClassNotFoundException e) {
                ConsoleHelper.writeMessage("Ошибка обмена данными");
               
            }
            ConsoleHelper.writeMessage("Соединение с удаленным сервером закрыто");
        }

        private void notifyUsers(Connection connection, String userName) throws IOException{
            for (String key : connectionMap.keySet()){
                String name = key;
                if (!name.equals(userName)){
                    connection.send(new Message(MessageType.USER_ADDED, name));
                }
            }
         }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException{
            while (true) {
                Message message = connection.receive();
                if (message.getType() == MessageType.TEXT) {
                    String text = userName + ": " + message.getData();
                    sendBroadcastMessage(new Message(MessageType.TEXT, text));
                    
                } else {
                    ConsoleHelper.writeMessage("Ошибка. Не текстовое сообщение");
                }
            }
        }


        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException{
            String name;
            Message message;
            while (true){
                connection.send(new Message(MessageType.NAME_REQUEST));
                message = connection.receive();

                if (message.getType() != MessageType.USER_NAME) {
                    ConsoleHelper.writeMessage("Ошибка в имени клиента, полученного сервером");
                    continue;
                }

                name = message.getData();

                if (name.isEmpty()){
                    ConsoleHelper.writeMessage("Ошибка. Имя клиента пустое");
                    continue;
                }

                if (connectionMap.containsKey(name)){
                    ConsoleHelper.writeMessage("Ошибка. Пользователь подключен");
                    continue;
                }

                connectionMap.put(name, connection);
                connection.send(new Message(MessageType.NAME_ACCEPTED));
                return name;
            }
        }
    }




    public static void main(String[] args) throws IOException, ClassNotFoundException {
        int port = ConsoleHelper.readInt();
        ServerSocket serverSocket = null;
        try {

            serverSocket = new ServerSocket(port);
            ConsoleHelper.writeMessage("Сервер запущен!");
            while (true){
              new Handler(serverSocket.accept()).start();
            }

        } catch (IOException e) {
            ConsoleHelper.writeMessage("Ошибка!");
            serverSocket.close();
        }

    }

}
