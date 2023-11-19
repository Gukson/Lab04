package io.github.gukson.lab04.client;

import io.github.gukson.lab04.client.service.View;

import java.net.MalformedURLException;
import java.sql.SQLException;


public class Client {
    public void client() {

        View view = new View();
        try {
            view.clientView();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}