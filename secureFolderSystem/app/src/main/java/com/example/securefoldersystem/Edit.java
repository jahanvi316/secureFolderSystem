package com.example.securefoldersystem;

import androidx.appcompat.app.AppCompatActivity;

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

public class Edit extends AppCompatActivity {
    String path = Environment.getDataDirectory() + "/secureFolderSystem";
    Context context;

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
                Intent addFile = new Intent(Edit.this, AddFile.class);
                startActivity(addFile);
            }
        });

        final ListView editFiles = (ListView) findViewById(R.id.files_edit);

        context = getApplicationContext();
        ArrayList<File> fileList = new ArrayList<>();

        //File filesDir = context.getDir("files", context.MODE_PRIVATE);
        //File[] allFiles = filesDir.listFiles();
        String[] allFiles = context.fileList();
        for (String f : allFiles)  {
            Log.e("files for loop", "f: " + f);
            File fileName = context.getDir(f, Context.MODE_PRIVATE);
            fileList.add(fileName);
        }

       // editFiles.setLayoutManager(new LinearLayoutManager(this));
//        ListAdapter fAdapter;
//        LayoutInflater layout = new LayoutInflater(this) {
//            @Override
//            public LayoutInflater cloneInContext(Context newContext) {
//                return null;
//            }
//        };
//        fAdapter = (ListAdapter) new ListAdapter(layout, fileList);
//        editFiles.setAdapter(fAdapter);

        ArrayAdapter<File> fileArrayAdapter;
        fileArrayAdapter = new ArrayAdapter<File>(this, android.R.layout.simple_list_item_1, fileList);
        editFiles.setAdapter(fileArrayAdapter);
        editFiles.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // System.out.println("EDIT FILE SET ON ITEM CLICK LISTENER PRESSED");
                File clickedItem = (File) editFiles.getItemAtPosition(position);
                Intent editFile = new Intent(Edit.this, EditFile.class);
                startActivity(editFile);
            }

        });


    }
}