package com.example.securefoldersystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;

import com.sromku.simple.storage.SimpleStorage;
import com.sromku.simple.storage.Storage;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

public class Edit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        Button logout = (Button) findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent logout = new Intent(Edit.this, MainActivity.class);
                startActivity(logout);
            }
        });

        Button addFile = (Button) findViewById(R.id.addFile);
        addFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent addFile = new Intent(Edit.this, EditFile.class);
                startActivity(addFile);
            }
        });

        RecyclerView editFiles = (RecyclerView) findViewById(R.id.filesEdit);
        editFiles.setLayoutManager(new LinearLayoutManager(this));
        //FileAdapter fAdapter = new FileAdapter(this.getLayoutInflater(), files);
       // editFiles.setAdapter(fAdapter);
    }
}