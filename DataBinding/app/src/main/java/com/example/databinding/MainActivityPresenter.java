package com.example.databinding;

/**
 * Create by mitt on 3/9/2020.
 *
 */
public class MainActivityPresenter {

    private MainContact.View view;

    public MainActivityPresenter(MainContact.View view){
        this.view= view;
    }

    /*hiển thị dữ liệu khi t nhấn lên*/
    public void onShowData(TemperatureDate temperatureDate){
        view.showData(temperatureDate);
    }

}
