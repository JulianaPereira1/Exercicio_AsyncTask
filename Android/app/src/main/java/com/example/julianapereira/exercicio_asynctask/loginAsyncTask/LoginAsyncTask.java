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
        super.onPreExecute();
    }

    @Override
    protected Response doInBackground(String... valores) {

        try {
            JSONObject jsonObject = new JSONObject();
                    jsonObject.put("nome", User.getNome());
                    jsonObject.put("senha", User.getSenha());

            response = HttpUtil.sendJSONPostResquest(jsonObject, SERVICE_URL);
                } catch (IOException ioex) {
                     Log.e("IOException", ioex.getMessage());
                 }

        return response;
    }

    @Override
    protected void onPostExecute(Response response) {
        super.onPostExecute(response);

            if(response.getStatus() == 200){
                Toast.makeText("Sucesso!", Toast.LENGTH_LONG).show();
            }
    }
}