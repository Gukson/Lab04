package io.github.gukson.lab04.client.model;

import com.google.gson.annotations.SerializedName;


public class MeasurementExternal {
    @SerializedName("id_stacji")
    private String idStacji;
    @SerializedName("stacja")
    private String stacja;
    @SerializedName("data_pomiaru")
    private String dataPomiaru;
    @SerializedName("godzina_pomiaru")
    private String godzinaPomiaru;
    private String temperatura;
    @SerializedName("predkosc_wiatru")
    private String predkoscWiatru;
    @SerializedName("kierunek_wiatru")
    private String kierunekWiatru;
    @SerializedName("wilgotnosc_wzgledna")
    private String wilgotnoscWzgledna;
    @SerializedName("suma_opadu")
    private String sumaOpadu;
    @SerializedName("cisnienie")
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
