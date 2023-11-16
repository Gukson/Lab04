package io.github.gukson.lab04.client;

import com.google.gson.Gson;

import io.github.gukson.lab04.client.model.MeasurmentExternal;


public class Main {
    public static void main(String[] args) {
        Gson gson = new Gson();
        String json = "[{\"id_stacji\":\"12295\",\"stacja\":\"Bia\\u0142ystok\",\"data_pomiaru\":\"2023-11-15\",\"godzina_pomiaru\":\"16\",\"temperatura\":\"4.2\",\"predkosc_wiatru\":\"3\",\"kierunek_wiatru\":\"310\",\"wilgotnosc_wzgledna\":\"93.1\",\"suma_opadu\":\"12.2\",\"cisnienie\":\"1004.4\"}, {\"id_stacji\":\"12295\",\"stacja\":\"Bia\\u0142ystok\",\"data_pomiaru\":\"2023-11-15\",\"godzina_pomiaru\":\"16\",\"temperatura\":\"4.2\",\"predkosc_wiatru\":\"3\",\"kierunek_wiatru\":\"310\",\"wilgotnosc_wzgledna\":\"93.1\",\"suma_opadu\":\"12.2\",\"cisnienie\":\"1004.4\"}] ";

        MeasurmentExternal[] data =  gson.fromJson(json, MeasurmentExternal[].class);
        System.out.println(data[0].getStacja());
        System.out.println(data[0]);
        System.out.println(data[1]);

//        MeasurmentService - gada z dao
//        MeasurmentDao
    }
}
