package com.example.securefoldersystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class ViewFile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_file);
        String path = Environment.getDataDirectory() + "/secureFolderSystem";
    }

    @Override
    protected void onStart() {
        super.onStart();
        setContentView(R.layout.activity_view_file);
       // System.out.println("VIEW FILE IS CALLED");
        String clickedFile = getIntent().getStringExtra("fileView");
        clickedFile = clickedFile.substring(4);
        System.out.println("clicked file: " + clickedFile);
        String fileContent = "";
        StringBuilder stringBuilder = new StringBuilder();
        try {
            FileInputStream fin = openFileInput(clickedFile);
            InputStreamReader inputStreamReader = new InputStreamReader(fin);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            while ((fileContent = bufferedReader.readLine()) != null) { // read line by line
                stringBuilder.append(fileContent + System.getProperty("line.separator")); // append the readed text line by line
            }
            fin.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        TextView viewFileName = (TextView) findViewById(R.id.viewFileName);
        TextView viewFileContent = (TextView) findViewById(R.id.viewFileContent);
        viewFileName.setText(clickedFile);
        System.out.println("clicked file toString(): " + clickedFile);
       // System.out.println("the file content is: " + fileContent);
        System.out.println("the string builder is: " + stringBuilder.toString());
        viewFileContent.setText(stringBuilder.toString());
    }
}