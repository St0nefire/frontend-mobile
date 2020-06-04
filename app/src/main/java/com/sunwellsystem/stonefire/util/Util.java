package com.sunwellsystem.stonefire.util;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by sunwell on 10/3/17.
 */

public class Util {

    public static final String LOGIN_URL = "http://192.168.1.13:8080/stonefire/resource/login";
    public static final String TENANTS_URL = "http://192.168.1.13:8080/stonefire/resource/tenants";
    public static final String IMAGES_URL = "http://192.168.1.13:8080/stonefire/resource/image/";

    public static String getRequest(String urlSpec) throws IOException {
        return new String(sendGetRequest(urlSpec));
    }

    public static String postRequest(String urlSpec, String jsonData) throws IOException {
        return new String(sendPostRequest(urlSpec, jsonData));
    }

    public static byte[] sendGetRequest(String urlSpec) throws IOException
    {
        URL url = new URL(urlSpec);
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        return getRawBytes(connection);
    }

    public static byte[] sendPostRequest(String urlSpec, String jsonData) throws IOException
    {
        URL url = new URL(urlSpec);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setDoOutput(true);
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Accept", "application/json");

        Writer writer = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream(), "UTF-8"));
        writer.write(jsonData);
        writer.flush();
        writer.close();


        return getRawBytes(connection);
    }

    public static String getImageURL(String _tenantId, String image) {
        return IMAGES_URL + "?tenantId=" + _tenantId + "&image=" +  image ;
    }

    private static byte[] getRawBytes(HttpURLConnection _connection) throws IOException {
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            InputStream in = _connection.getInputStream();
            if (_connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
                throw new IOException(_connection.getResponseMessage());
            }

            int bytesRead = 0;
            byte[] buffer = new byte[1024];
            while ((bytesRead = in.read(buffer)) > 0) {
                out.write(buffer, 0, bytesRead);
            }
            out.close();

            return out.toByteArray();
        }
        finally {
            _connection.disconnect();
        }
    }

}
