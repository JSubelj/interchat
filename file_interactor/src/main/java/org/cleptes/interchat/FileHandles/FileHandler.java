package org.cleptes.interchat.FileHandles;

import org.cleptes.interchat.Objects.Message;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileHandler {
    String home = System.getProperty("user.home");
    String messages = home+"/Share/messages.txt";


    public FileHandler() {
    }



    public String getData() {
        String text = "";
        try {
            text = new String(Files.readAllBytes(Paths.get(messages)), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }

    public String writeData(Message msg){
        String sender = msg.getSender();
        String message = msg.getMessage();

        try {
            sender.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e){
            return "Sender non UTF-8!";
        }
        try {
            message.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e){
            return "Message non UTF-8!";
        }

        String timeStamp = new SimpleDateFormat("yyyy-MM-dd EEE HH:mm").format(new Date());
        String new_message = timeStamp+" <"+sender+"> - "+message+"\n";

        try {
            Files.write(Paths.get(messages), new_message.getBytes("UTF-8"), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
            return "Can't write to file!";
        }
        return null;

    }
}