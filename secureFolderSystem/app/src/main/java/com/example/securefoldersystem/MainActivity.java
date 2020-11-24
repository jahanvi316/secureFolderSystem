package com.example.securefoldersystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String viewPass = "lemmeSee";
    String editPass = "lemmeEdit";
    EditText password;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        password = (EditText) findViewById(R.id.password);

        Button login = (Button) findViewById(R.id.login);
        login.setOnClickListener(loginListener);

    }

    View.OnClickListener loginListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            passwordChecker();
        }
    };

    public void passwordChecker() {
        String passEntered = password.getText().toString();
        if (passEntered.equals(viewPass)){
            System.out.println("VIEW ONLY PASSWORED ENTERED");
            Intent view = new Intent(MainActivity.this, ViewOnly.class);
            startActivity(view);
        } else {
            if (passEntered.equals(editPass)){
                System.out.println("EDIT PASS ENTERED");
            } else {
                TextView error =  (TextView) findViewById(R.id.error);
                error.setVisibility(View.VISIBLE);
            }
        }
    }
}