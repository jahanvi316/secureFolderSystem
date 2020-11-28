package com.example.securefoldersystem;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class EditFile extends AppCompatActivity {
    String path = Environment.getDataDirectory() + "/secureFolderSystem";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_file);
    }

    @Override
    protected void onStart() {
        super.onStart();
        setContentView(R.layout.activity_edit_file);
       // System.out.println("EDIT FILE IS CALLED");

        String clickedFile = getIntent().getStringExtra("fileSelected");
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

        EditText editFileName = (EditText) findViewById(R.id.editFileName);
        EditText editFileContent = (EditText) findViewById(R.id.editFileContent);
        editFileName.setText(clickedFile);
        System.out.println("the file content is: " + fileContent);
        System.out.println("the string builder is: " + stringBuilder.toString());
        editFileContent.setText(stringBuilder.toString());

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
                    Intent save = new Intent(EditFile.this, Edit.class);
                    startActivity(save);
                    Toast.makeText(EditFile.this, "File updated successfuly.", 10).show();
                    System.out.println("successful :)");

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    Toast.makeText(EditFile.this, "File not found.", 10).show();
                    System.out.println("file not found error :(");
                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(EditFile.this, "File Failed.", 10).show();
                    System.out.println("IO Exception error :(");
                }

            }
        });

        Button deleteFile = (Button) findViewById(R.id.deleteFile);
        deleteFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText fn = (EditText) findViewById(R.id.editFileName);
                String fileName = fn.getText().toString();
                File dir = getFilesDir();
                final File f = new File(dir, fileName);
                final AlertDialog.Builder deleteConfirmation = new AlertDialog.Builder(EditFile.this);
                deleteConfirmation.setTitle("Delete File");
                deleteConfirmation.setMessage("Are you sure you want to delete this file?");
                deleteConfirmation.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        boolean deleted = f.delete();
                        System.out.println("DELETED: " + deleted);
                        Intent edit = new Intent(EditFile.this, Edit.class);
                        startActivity(edit);
                    }
                });
                deleteConfirmation.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        System.out.println("DELETE CANCELED");
                    }
                });
                deleteConfirmation.show();
            }
        });

    }



}