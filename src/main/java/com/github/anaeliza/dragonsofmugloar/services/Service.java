package com.github.anaeliza.dragonsofmugloar.services;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

abstract class Service {
    
    private static final String BASE_URL = "http://www.dragonsofmugloar.com/";
    
    InputStream get(String serviceUrl) {
        try {
            URL url = new URL(BASE_URL + serviceUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            return con.getInputStream();
        } catch (IOException e) {
            throw new RuntimeException("Error while trying to access " + BASE_URL + serviceUrl, e);
        }
    }
    
    InputStream put(String serviceUrl, String data) {
        try {
            URL url = new URL(BASE_URL + serviceUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("PUT");
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Accept", "application/json");
            con.setDoOutput(true);
            
            OutputStreamWriter writer = new OutputStreamWriter(con.getOutputStream());
            writer.write(data);
            writer.flush();
            writer.close();
            
            return con.getInputStream();
        } catch (IOException e) {
            throw new RuntimeException("Error while trying to access " + BASE_URL + serviceUrl, e);
        }
    }
    
}
