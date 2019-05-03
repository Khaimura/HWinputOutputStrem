package com.Khaimura;

import java.io.File;
import java.io.IOException;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        MyFileFilter mFF = new MyFileFilter("docx");
        File folder = new File("/Users/Bohdan/Downloads");
        File[] fileList = folder.listFiles(mFF);
        for (File file : fileList) {
            System.out.println(file);
            File fos = new File("/Users/Bohdan/Documents/" + file.getName().replace(".pdf", "") + "Copy.pdf");
            try {
                IOStream.fileCopy(file, fos);
            } catch (IOException var4) {
                var4.printStackTrace();
            }
        }

    }
}
