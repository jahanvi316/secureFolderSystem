package com.example.securefoldersystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.io.File;
import java.util.ArrayList;

public class ViewOnly extends AppCompatActivity {
    String path = Environment.getDataDirectory() + "/secureFolderSystem";
    Context context;

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
        final ListView viewFiles = (ListView) findViewById(R.id.files_view);

        context = getApplicationContext();
        ArrayList<File> fileList = new ArrayList<>();

        String[] allFiles = context.fileList();
        for (String f : allFiles)  {
            Log.e("files for loop", "f: " + f);
            File fileName = context.getDir(f, Context.MODE_PRIVATE);
            fileList.add(fileName);
        }

        ArrayAdapter<File> fileArrayAdapter;
        fileArrayAdapter = new ArrayAdapter<File>(this, android.R.layout.simple_list_item_1, fileList);
        viewFiles.setAdapter(fileArrayAdapter);
        viewFiles.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // System.out.println("EDIT FILE SET ON ITEM CLICK LISTENER PRESSED");
                File clickedItem = (File) viewFiles.getItemAtPosition(position);
                Intent viewFile = new Intent(ViewOnly.this, ViewFile.class);
                String fileName = clickedItem.getName();
                viewFile.putExtra("fileSelected", fileName);
                startActivity(viewFile);
            }

        });

//        ArrayList<File> fileList = new ArrayList<>();
//        File filesDir = context.getDir("files", context.MODE_PRIVATE);
//        File[] allFiles = filesDir.listFiles();
//        if (allFiles != null && allFiles.length > 0) {
//            for (File f : allFiles)  {
//                if (f.isFile()) {
//                    fileList.add(f);
//                    System.out.println("File added: " + f);
//                }
//            }
//        }
//
//        RecyclerView viewFiles = (RecyclerView) findViewById(R.id.filesView);
//        ListAdapter fAdapter = new ListAdapter(this.getLayoutInflater(), fileList);
//        viewFiles.setLayoutManager(new LinearLayoutManager(this));
//        viewFiles.setAdapter(fAdapter);

    }

}