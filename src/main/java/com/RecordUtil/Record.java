package com.RecordUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * Record is class to access record file. The record is read-only
 */
public class Record<T> {
    private File recordFile;
    private String recordName;
    private Class<T> modelClass;
    private final Gson gson = new Gson();

    public Record(String recordFileName) {
        this.recordName = recordFileName;
        this.recordFile = new File(String.format("./src/main/java/com/RecordFiles/%s.json", recordFileName));
    }

    /**
     * Read record file and return it as type specified
     * 
     * @return
     */
    public List<T> readRecordFile() {
        Type recordType = new TypeToken<ArrayList<T>>() {
        }.getType();
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

        return gson.fromJson(s.toString(), recordType);
    }
}
