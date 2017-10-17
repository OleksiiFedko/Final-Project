package com.hotel.domain.logic;

import com.hotel.model.entities.RequestEntity;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.UnsupportedEncodingException;
import java.util.Properties;


public class MailSender {
    private static final String ADDRESS_FROM = "alex.fedko2504@gmail.com";
    private static final String PASSWORD = "phantomf14";

    /**
     * Sending email message
     * @param requestEntity
     * @param price
     * @param roomNumber
     * @param isRoomExist
     */
    public void sendSSL (RequestEntity requestEntity,int price ,int roomNumber,boolean isRoomExist) {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(ADDRESS_FROM, PASSWORD);
            }
        });
        String messageText;
        if(isRoomExist) {
            messageText = "Dear, " + requestEntity.getFirstName() + "!\n" +
                    "Thank you that choose our hotel.\n" +
                    "You room is №" + roomNumber +"\n" +
                    "Total price for room will be " + price +"$\n" +
                    "You can make payment by bank details:\n" +
                    "\n" +
                    "421113290086514\n" +
                    "\n" +
                    "Best wishes, administration!";
        } else {
            messageText = "Dear, " + requestEntity.getFirstName() + "!\n" +
                    "Unfortunately there are no free room which suit your requirements." +
                    "But we can try to find other room, if you will change it." +
                    "\n" +
                    "Best wishes, administration!";
        }
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("alex.fedko2504@gmail.com", "alex"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(requestEntity.getEmail()));
            message.setSubject("Hotel. Room order.");
            message.setText(messageText);
            Transport.send(message);
        } catch (MessagingException e) {
        } catch (UnsupportedEncodingException e){
        }
    }
}
