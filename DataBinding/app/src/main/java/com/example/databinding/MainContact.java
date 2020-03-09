package com.example.databinding;

/**
 * Create by mitt on 3/9/2020.
 * dùng đẻ gán sự kiện trên tầng Binding
 */
public interface MainContact {

    public interface Presenter{
        void onShowDate(TemperatureDate temperatureDate);
    }

    public interface View{
        void showData(TemperatureDate temperatureDate);
    }
}
