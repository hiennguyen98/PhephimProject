package com.example.service;

public class APIUtils {
    //public static final String Base_Url = "http://pokebizute15.000webhostapp.com/phephim/";
    //public static final String Base_Url = "http://192.168.218.1:8080/phephim/";
    public static final String Base_Url = "http://172.168.80.249:8080/phephim/";
    //public static final String Base_Url = "http://10.228.39.243:8080/phephim/";
    public static DataClient getData(){
        return RetrofitClient.getClient(Base_Url).create(DataClient.class);
    }
}
