package com.example.julianapereira.exercicio_asynctask.HttpService;

import android.util.Log;

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

public class Response {

    public class Response {
        private int status;

        private String contentValue;

        public Response(int status) {
            this.status = status;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }
    }
}