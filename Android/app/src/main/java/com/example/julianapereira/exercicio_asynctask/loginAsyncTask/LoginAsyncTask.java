package com.example.julianapereira.exercicio_asynctask.loginAsyncTask;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import com.example.julianapereira.exercicio_asynctask.HttpService.HttpService;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * Created by Juliana Pereira on 22/12/2015.
 */
public class LoginAsyncTask extends AsyncTask<String, Void, Response>{

    Context context;
    private User user;

    public LoginAsyncTask(Context context, User user) {

        this.context = context;
        this.user = user;
    }

    @Override
    protected void onPreExecute() {

        Log.i("OnPreExecute");
    }

    @Override
    protected Response doInBackground(String... valores) {

        try {
            JSONObject jsonObject = new JSONObject();
                    jsonObject.put("nome", User.getUsername());
                    jsonObject.put("senha", User.getPassword());

            response = HttpUtil.sendJSONPostResquest(jsonObject, SERVICE_URL);
                } catch (IOException ioex) {
                     Log.e("IOException", ioex.getMessage());
                 }

        return response;
    }

    @Override
    protected void onPostExecute(HttpURLConnection connection) {

        try {

            int status = connection.getResponseCode();

            Log.i("NotificationWearApp", "Status HTTP-Response: " + status);

            String contentValue = HttpService.getHttpContent(connection);
            JSONObject json = new JSONObject(contentValue);

            String nome = json.getString("nome");
            Toast.makeText(context, nome, Toast.LENGTH_LONG).show();

        } catch (IOException e) {

            e.printStackTrace();

        } catch (JSONException e) {

            Log.e("NotificationWearApp", "JSONException");
        }
    }
}