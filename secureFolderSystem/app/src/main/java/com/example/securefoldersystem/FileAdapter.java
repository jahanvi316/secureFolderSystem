package com.example.securefoldersystem;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.util.List;

public class FileAdapter extends RecyclerView.Adapter<FileAdapter.FilesViewHolder> {
    private LayoutInflater inflater;
    private List<File> files;

    public FileAdapter(LayoutInflater layoutInflater, List<File> f) {
        inflater = layoutInflater;
        files = f;
    }

    @Override
    public FilesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemFile = inflater.inflate(R.layout.item_file, parent, false);
        FilesViewHolder filesViewHolder = new FilesViewHolder(itemFile);
        filesViewHolder.view =  itemFile;
        filesViewHolder.fileName = (TextView) itemFile.findViewById(R.id.fileName);

        return filesViewHolder;
    }

    @Override
    public void onBindViewHolder(FilesViewHolder holder, int position) {
        File f = files.get(position);
        holder.fileName.setText(f.getName());
        holder.position = position;
    }

    @Override
    public int getItemCount() {
        return files.size();
    }

    public static class FilesViewHolder extends RecyclerView.ViewHolder {
        View view;
        TextView fileName;
        int position;

        public FilesViewHolder(View itemView) {
            super(itemView);
            this.view = itemView;
        }
    }
}
