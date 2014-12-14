package com.anapaulagomes.myapplication;

import java.io.*;
import java.net.*;

/**
 * Created by anapaula on 14/12/14.
 */
public class Clima{

    public String consulta(String cidade) throws IOException {
        InputStream is = null;

        URL url = new URL("http://api.openweathermap.org/data/2.5/weather?q="+cidade);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.connect();

        if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
            is = con.getInputStream();
            return getStringFromInputStream(is);
        } else {
            return null;
        }
    }

    private String getStringFromInputStream(InputStream is) throws IOException {
        InputStreamReader isr = new InputStreamReader(is);
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(isr);
        String linha = br.readLine();

        while(linha != null) {
            sb.append(linha);
            linha = br.readLine();

        }

        return sb.toString();

    }

}
