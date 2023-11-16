package io.github.gukson.lab04.client.model;

import com.google.gson.Gson;
import io.github.gukson.lab04.client.dao.MeasurementDao;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class MeasurementService {
    private URL url;
    private MeasurementDao mDao;

    public MeasurementService(URL url, MeasurementDao mDao) {
        this.url = url;
        this.mDao = mDao;
    }

    public void ImportNewData(String tableName){
        try {
            MeasurmentExternal[] data = getJsonFromAPI();
//            for(MeasurmentExternal m: data){
//
//            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private MeasurmentExternal[] getJsonFromAPI() throws IOException {
        InputStreamReader reader = new InputStreamReader(url.openStream());
        Gson gson = new Gson();
        MeasurmentExternal[] data =  gson.fromJson(reader, MeasurmentExternal[].class);
        return data;
    }

}
