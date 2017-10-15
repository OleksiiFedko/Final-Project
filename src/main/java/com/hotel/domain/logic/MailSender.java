package com.hotel.domain.logic;

public class MailSender {
    private static final String ADRESS_FROM = "alex.fedko2504@gmail.com";
    private static final String PASSWORD = "illidanf14";

    private String clientEmail;

    public void send () {

    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public MailSender(String clientEmail) {
        this.clientEmail = clientEmail;
    }
}
