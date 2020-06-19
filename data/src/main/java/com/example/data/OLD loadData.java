/*
package com.example.data;
import android.util.Log;
import com.google.gson.Gson;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class loadData {
    Gson gson = new Gson();
    String url = "https://raw.githubusercontent.com/karl-park/com.ninetynine.healthysalad/master/server/api/";
    String[] ingredients = {"base", "crunchy", "dressing","protein","soft" };
    private static final String TAG = loadData.class.getSimpleName();

    public loadData() {
        for (int i = 0; i < ingredients.length; i ++) {
            makeServiceCall(url + ingredients[i]);
        }

    }

    public String makeServiceCall(String reqUrl) {
        String response = null;
        try {
            URL url = new URL(reqUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            // read the response
            InputStream in = new BufferedInputStream(conn.getInputStream());
            response = convertStreamToString(in);

        } catch (Exception e) {
            Log.e(TAG, "Exception: " + e.getMessage());
        }
        return response;
    }

    private String convertStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return sb.toString();
    }

    void parseData(){
        //Parse Data
    }


}*/
