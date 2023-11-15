package io.github.gukson.lab04.client.model;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class MeasurementExternal {
    @SerializedName("id_stacji")
    @Expose
    private String idStacji;
    @SerializedName("stacja")
    @Expose
    private String stacja;
    @SerializedName("data_pomiaru")
    @Expose
    private String dataPomiaru;
    @SerializedName("godzina_pomiaru")
    @Expose
    private String godzinaPomiaru;
    @SerializedName("temperatura")
    @Expose
    private String temperatura;
    @SerializedName("predkosc_wiatru")
    @Expose
    private String predkoscWiatru;
    @SerializedName("kierunek_wiatru")
    @Expose
    private String kierunekWiatru;
    @SerializedName("wilgotnosc_wzgledna")
    @Expose
    private String wilgotnoscWzgledna;
    @SerializedName("suma_opadu")
    @Expose
    private String sumaOpadu;
    @SerializedName("cisnienie")
    @Expose
    private String cisnienie;

    public String getIdStacji() {
        return idStacji;
    }

    public void setIdStacji(String idStacji) {
        this.idStacji = idStacji;
    }

    public String getStacja() {
        return stacja;
    }

    public void setStacja(String stacja) {
        this.stacja = stacja;
    }

    public String getDataPomiaru() {
        return dataPomiaru;
    }

    public void setDataPomiaru(String dataPomiaru) {
        this.dataPomiaru = dataPomiaru;
    }

    public String getGodzinaPomiaru() {
        return godzinaPomiaru;
    }

    public void setGodzinaPomiaru(String godzinaPomiaru) {
        this.godzinaPomiaru = godzinaPomiaru;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public String getPredkoscWiatru() {
        return predkoscWiatru;
    }

    public void setPredkoscWiatru(String predkoscWiatru) {
        this.predkoscWiatru = predkoscWiatru;
    }

    public String getKierunekWiatru() {
        return kierunekWiatru;
    }

    public void setKierunekWiatru(String kierunekWiatru) {
        this.kierunekWiatru = kierunekWiatru;
    }

    public String getWilgotnoscWzgledna() {
        return wilgotnoscWzgledna;
    }

    public void setWilgotnoscWzgledna(String wilgotnoscWzgledna) {
        this.wilgotnoscWzgledna = wilgotnoscWzgledna;
    }

    public String getSumaOpadu() {
        return sumaOpadu;
    }

    public void setSumaOpadu(String sumaOpadu) {
        this.sumaOpadu = sumaOpadu;
    }

    public String getCisnienie() {
        return cisnienie;
    }

    public void setCisnienie(String cisnienie) {
        this.cisnienie = cisnienie;
    }
}
