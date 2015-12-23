package com.example.julianapereira.exercicio_asynctask;

import com.example.julianapereira.exercicio_asynctask.loginAsyncTask.LoginAsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button asyncTaskButton = (Button) findViewById(R.id.button);

        asyncTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("NotificationWearApp", "Clique no botão da AsyncTask");

                EditText nomeEditText = (EditText) findViewById(R.id.editText);
                String nome = nomeEditText.getText().toString();

                LoginAsyncTask loginAsyncTask = new LoginAsyncTask(view.getContext());
                String[] valores = {nome};

                loginAsyncTask.execute(valores);
            }
        });
    }
}