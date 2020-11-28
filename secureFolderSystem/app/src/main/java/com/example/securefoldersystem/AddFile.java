package com.example.securefoldersystem;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class AddFile extends AppCompatActivity {
    File directory;
    String filepath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS) + "/secureFolderSystem/";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_file);

        //List<File> files = storage.getNestedFiles("secureFolderSystem/");

        Button saveFile = (Button) findViewById(R.id.saveFile);
        saveFile.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View v) {
                EditText fn = (EditText) findViewById(R.id.editFileName);
                String fileName = fn.getText().toString();
                EditText fc = (EditText) findViewById(R.id.editFileContent);
                String fileContent = fc.getText().toString();
//                File f = new File(filepath + fileName);
//                if (f.exists()) {
//                    Toast.makeText(EditFile.this, "A file already exists with this name.", 10).show();
//                } else {
//                    f.mkdirs();
//                    try {
//                        FileWriter writer = new FileWriter(f);
//                        writer.append(fileContent);
//                        writer.flush();
//                        writer.close();
//                        Toast.makeText(EditFile.this, "File created successfully.", 10).show();
//
//                    } catch (IOException e) {
//                        Toast.makeText(EditFile.this, "File failed.", 10).show();
//                        e.printStackTrace();
//                    }

                FileOutputStream fOut = null;
                try{
                    fOut = openFileOutput(fileName, Context.MODE_PRIVATE);
                    fOut.write(fileContent.getBytes());
                    fOut.close();
                    Intent save = new Intent(AddFile.this, Edit.class);
                    startActivity(save);
                    Toast.makeText(AddFile.this, "File created successfuly.", 10).show();
                    System.out.println("successful :)");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    Toast.makeText(AddFile.this, "File not found.", 10).show();
                    System.out.println("file not found error :(");
                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(AddFile.this, "File Failed.", 10).show();
                    System.out.println("IO Exception error :(");
                }

            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();

    }
}