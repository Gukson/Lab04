package io.github.gukson.lab04.client.service;

import com.google.gson.Gson;
import io.github.gukson.lab04.client.dao.MeasurementDao;
import io.github.gukson.lab04.client.model.Measurement;
import io.github.gukson.lab04.client.model.MeasurmentExternal;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.time.LocalDate;

import static org.apache.commons.lang3.math.NumberUtils.toDouble;
import static org.apache.commons.lang3.math.NumberUtils.toInt;

public class MeasurementService {
    private URL url;
    private MeasurementDao mDao;

    private String tableName;

    public MeasurementService(URL url, MeasurementDao mDao, String tabelName) {
        this.url = url;
        this.mDao = mDao;
        this.tableName = tabelName;
    }

    public void checkDataStatus(LocalDate todaysDate){
        if(!mDao.areDataFromThisDay(todaysDate)){
            this.importNewData(this.tableName);
        }
    }

    private void importNewData(String tableName){
        try {
            MeasurmentExternal[] data = this.getJsonFromAPI();
            for(MeasurmentExternal m: data){

                mDao.save(new Measurement(m));
            }

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
