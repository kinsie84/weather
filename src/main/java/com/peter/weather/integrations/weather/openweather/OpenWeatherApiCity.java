package com.peter.weather.integrations.weather.openweather;

public enum OpenWeatherApiCity {

    LONDON(2643743),
    HONG_KONG(1819729);

    public final int cityId;

    OpenWeatherApiCity(int cityId){
        this.cityId = cityId;
    }
}
