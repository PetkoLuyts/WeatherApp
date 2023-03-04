package com.example.weatherapp;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WeatherDataService {
    Context context;

    public WeatherDataService(Context context) {
        this.context = context;
    }

    public interface VolleyResponseListener {
        void onError(String message);

        void onResponse(WeatherReportModel weatherReport);
    }

    public void getCityForecastByName(String cityName, final VolleyResponseListener volleyResponseListener) {
        String url = "https://api.openweathermap.org/data/2.5/weather?q="+ cityName + "&appid=5d5affe841dd964f4563f5c3771df5d5";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                JSONArray weatherJSON;
                JSONObject weatherMainJsonObject;
                String weatherType, weatherMainDescription;

                JSONObject mainJSON;
                Double temp, temp_min, temp_max, windSpeed;
                Integer pressure, humidity;
                JSONObject windJSON;
                Integer visibility;

                try {
                    weatherJSON = response.getJSONArray("weather");
                    weatherMainJsonObject = weatherJSON.getJSONObject(0);
                    weatherType = weatherMainJsonObject.getString("main");
                    weatherMainDescription = weatherMainJsonObject.getString("description");

                    mainJSON = response.getJSONObject("main");
                    temp = mainJSON.getDouble("temp");
                    temp_min = mainJSON.getDouble("temp_min");
                    temp_max = mainJSON.getDouble("temp_max");
                    pressure = mainJSON.getInt("pressure");
                    humidity = mainJSON.getInt("humidity");

                    visibility = response.getInt("visibility");

                    windJSON = response.getJSONObject("wind");
                    windSpeed = windJSON.getDouble("speed");

                    WeatherReportModel report = new WeatherReportModel(weatherType, weatherMainDescription,
                            temp, temp_min, temp_max, pressure, humidity, visibility, windSpeed);

                    volleyResponseListener.onResponse(report);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }

                Toast.makeText(context, weatherJSON.toString(), Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "Error occurred", Toast.LENGTH_SHORT).show();
                volleyResponseListener.onError("Something is wrong");
            }
        });

        RequestQueueSingleton.getInstance(context).addToRequestQueue(request);
    }
}
