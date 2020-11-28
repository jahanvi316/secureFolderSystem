package com.example.securefoldersystem;

import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.FilesViewHolder> implements android.widget.ListAdapter {
    private LayoutInflater inflater;
    private List<File> files;

    public ListAdapter(LayoutInflater layoutInflater, List<File> f) {
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


    public List<File> getFiles(){
        return files;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEnabled(int position) {
        return false;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public int getCount() {
        return files.size();
    }

    @Override
    public Object getItem(int position) {
        return files.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }

    @Override
    public int getViewTypeCount() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return files.isEmpty();
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
