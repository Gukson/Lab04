package io.github.gukson.lab04.client.model;

import com.google.gson.Gson;
import io.github.gukson.lab04.client.dao.MeasurementDao;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;

public class MeasurementService {
    private URL url;
    private MeasurementDao mDao;

    public MeasurementService(URL url, MeasurementDao mDao) {
        this.url = url;
        this.mDao = mDao;
    }

    public void checkDataStatus(LocalDate todaysDate, String tableName){
        if(!mDao.areDataFromThisDay(todaysDate)){
            this.ImportNewData(tableName);
        }
    }

    private void ImportNewData(String tableName){
        try {
            MeasurmentExternal[] data = this.getJsonFromAPI();
            for(MeasurmentExternal m: data){
                mDao.save(new Measurement(
                        Integer.parseInt(m.getIdStacji()),
                        m.getStacja(),
                        LocalDate.parse(m.getDataPomiaru()),
                        LocalTime.parse(m.getGodzinaPomiaru()),
                        Double.valueOf(m.getTemperatura()),
                        Integer.parseInt(m.getPredkoscWiatru()),
                        Integer.parseInt(m.getKierunekWiatru()),
                        Double.valueOf(m.getWilgotnoscWzgledna()),
                        Double.valueOf(m.getSumaOpadu()),
                        Double.valueOf(m.getCisnienie())
                ));
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
