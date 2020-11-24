package com.example.securefoldersystem;

public class File {
    private String fileName;
    private String fileContent;

    public File() {}

    public File(String name, String content) {
        fileName = name;
        fileContent = content;
    }

    public String getFileName(){
        return fileName;
    }

    public void setFileName(String newFileName) {
        fileName = newFileName;
    }

    public String getFileContent(){
        return fileContent;
    }

    public void setFileContent(String newFileContent){
        fileContent = newFileContent;
    }

}
