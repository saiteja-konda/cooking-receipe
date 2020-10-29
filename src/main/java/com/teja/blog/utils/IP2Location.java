package com.teja.blog.utils;

import io.ipdata.client.Ipdata;
import io.ipdata.client.model.IpdataModel;
import io.ipdata.client.service.IpdataService;

import java.net.URL;

public class IP2Location {
    private static final String API_KEY = "473231b30149b591e957dab0ea981b9d9d05b812b17bdf227a151b4f";

    public static String convert(String ip) throws Exception {
        URL url = new URL("https://api.ipdata.co");
        IpdataService ipdataService = Ipdata.builder().url(url)
            .key(API_KEY).get();
        IpdataModel model = ipdataService.ipdata(ip);
        return model.city();
//        return model.postal() + " " +  model.city() + "|" + model.region() + "|" + model.countryName();
    }
}
