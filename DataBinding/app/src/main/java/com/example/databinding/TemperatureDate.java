package com.example.databinding;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

/**
 * Create by mitt on 3/9/2020.
 */
public class TemperatureDate extends BaseObservable {

    private String celsius;
    private String fahrenheit;

    public TemperatureDate(String celsius, String fahrenheit) {
        this.celsius = celsius;
        this.fahrenheit = fahrenheit;
    }
    @Bindable
    public String getCelsius() {

        return celsius;
    }
    @Bindable
    public void setCelsius(String celsius) {
        this.celsius = celsius;
        notifyPropertyChanged(BR.celsius);
        /*tu dong tro den la thay doi du lieu hai chieu,
        * giao dien thay doi -> doi tuong cung thay doi, nguoc lai*/

    }
    @Bindable
    public String getFahrenheit() {
        return fahrenheit;
    }
    @Bindable
    public void setFahrenheit(String fahrenheit) {
        this.fahrenheit = fahrenheit;
    }
}
