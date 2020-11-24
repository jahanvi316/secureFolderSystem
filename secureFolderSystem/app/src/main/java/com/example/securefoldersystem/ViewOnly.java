package com.example.securefoldersystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;

import com.sromku.simple.storage.SimpleStorage;
import com.sromku.simple.storage.Storage;

import java.io.File;
import java.nio.file.DirectoryStream;
import java.util.List;

public class ViewOnly extends AppCompatActivity {
    String path = Environment.getDataDirectory() + "/secureFolderSystem";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        Button logout = (Button) findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent logout = new Intent(ViewOnly.this, MainActivity.class);
                startActivity(logout);
            }
        });


        //List<File> files = s;
        RecyclerView viewFiles = (RecyclerView) findViewById(R.id.filesView);
        viewFiles.setLayoutManager(new LinearLayoutManager(this));
      //  FileAdapter fAdapter = new FileAdapter(this.getLayoutInflater(), files);
      //  viewFiles.setAdapter(fAdapter);
    }
}