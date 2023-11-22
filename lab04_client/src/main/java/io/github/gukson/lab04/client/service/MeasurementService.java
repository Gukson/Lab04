package io.github.gukson.lab04.client.service;

import com.google.gson.Gson;
import io.github.gukson.lab04.client.dao.MeasurementDao;
import io.github.gukson.lab04.client.model.Measurement;
import io.github.gukson.lab04.client.model.MeasurmentExternal;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.time.LocalDate;
import java.util.Objects;

public class MeasurementService {

    private static final Logger logger = LogManager.getLogger("vehicles");

    private URL url;
    private MeasurementDao mDao;

    private String tableName;

    public MeasurementService(URL url, MeasurementDao mDao, String tabelName) {
        this.url = url;
        this.mDao = mDao;
        this.tableName = tabelName;
    }

    public void checkDataStatus(LocalDate todaysDate) throws IOException {
        MeasurmentExternal[] data = this.getJsonFromAPI();
        if(!mDao.areDataFromThisDay(todaysDate) && Objects.equals(data[0].getDataPomiaru(), String.valueOf(todaysDate))){
            this.importNewData(data);
            logger.info("Zaktualizowano dane");
        }
        else {
            logger.info("Dane są aktualne");
        }

    }

    private void importNewData(MeasurmentExternal[] data){
            for(MeasurmentExternal m: data){

                mDao.save(new Measurement(m));
            }
    }

    private MeasurmentExternal[] getJsonFromAPI() throws IOException {
        InputStreamReader reader = new InputStreamReader(url.openStream());
        Gson gson = new Gson();
        MeasurmentExternal[] data =  gson.fromJson(reader, MeasurmentExternal[].class);
        return data;
    }

}
