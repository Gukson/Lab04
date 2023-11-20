package io.github.gukson.lab04.gui;
import io.github.gukson.lab04.client.Client;
public class Main {
    public static void main(String[] args) {
        System.setProperty("log4j.defaultInitOverride","true");
        Client client = new Client();
        client.client();
    }
}
