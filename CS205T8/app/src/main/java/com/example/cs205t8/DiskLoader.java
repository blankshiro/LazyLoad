package com.example.cs205t8;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageView;

import java.io.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DiskLoader {

    private File FileDir;
//    private ExecutorService executorService;

    /**
     * Constructor for DiskLoader.
     *
     * @param FileDirName The file directory path.
     */
    public DiskLoader(String FileDirName) {
        Log.i("CS205:", "creating diskLoader");
        // create new directory in storage
        this.FileDir = new File(FileDirName);
        if (!FileDir.exists()) { // Should not enter here
            // Create new directory
            FileDir.mkdirs();
            Log.i("CS205 - Disk Loader:", "disk load created directory " + FileDir);
        }
        // Log the information for debugging purposes
        Log.i("CS205 - Disk Loader:", "loaded directory " + FileDir);
//        this.executorService = Executors.newFixedThreadPool(3);
    }

    /**
     * This method gets the image file from the disk.
     *
     * @param url The URL of the image.
     * @return The File of the image.
     */
    public File getFile(String url) {
        try {
            // Our filename is simply just a hash of the url string
            String filename = String.valueOf(url.hashCode());
            if(new File(FileDir, filename).exists() == false){
                return null;
            }
            File file = new File(FileDir, filename);

            Log.i("CS205 - Disk Loader:", "found a file - " + file);
            return file;
        } catch (Exception e) {
            Log.e("CS205 - Disk Loader:", e.getMessage());
            return null;
        }
    }

}
