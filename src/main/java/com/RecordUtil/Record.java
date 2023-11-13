package com.RecordUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * Record is class to access record file. The record is read-only
 */
public class Record<T> {
    private File recordFile;
    private Class<T[]> modelClass;
    private final Gson gson = new Gson();

    /**
     * @param recordFileName name of the file to be accessed. The file should be in the `/RecordFiles` directory with a structure like this project 
     * @param modelClass Class object which is the class of this record
     */
    public Record(String recordFileName, Class<T[]> modelClass) {
        this.recordFile = new File(String.format("./src/main/java/com/RecordFiles/%s.json", recordFileName));
        this.modelClass = modelClass;
    }

    /**
     * Read record file and return it as type specified
     * 
     * @return
     */
    public List<T> readRecordFile() {
        StringBuilder s = new StringBuilder();
        try {
            Scanner sc = new Scanner(this.recordFile);
            while (sc.hasNextLine()) {
                s.append(sc.nextLine());
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return Arrays.asList(gson.fromJson(s.toString(), modelClass)) ;
    }
}
