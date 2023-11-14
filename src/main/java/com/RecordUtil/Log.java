package com.RecordUtil;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Log is class to access record file. The record is writable
 */
public class Log<T> extends Record<T> {

    public Log(String recordFileName, Class<T[]> modelClass) {
        super(recordFileName, modelClass);
    }

    /**
     * Write record to record file
     * 
     * @param record record to be written to record file
     * @return `true` if writing operation is succesful or `false` if the writing
     *         operation failed
     */
    public boolean appendRecord(T record) {
        List<T> recordList = new ArrayList<>();
        recordList.addAll(this.readRecordFile());
        recordList.add(record);
        String s = this.gson.toJson(recordList);
        try {
            FileWriter fileWriter = new FileWriter(this.recordFile);
            fileWriter.write(s);
            fileWriter.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean appendRecord(List<T> records) {
        List<T> recordList = new ArrayList<>();
        recordList.addAll(this.readRecordFile());
        System.out.println(recordList);
        recordList.addAll(records);
        String s = this.gson.toJson(recordList);
        try {
            FileWriter fileWriter = new FileWriter(this.recordFile);
            fileWriter.write(s);
            fileWriter.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean rewriteRecord(T record) {
        List<T> recordList = new ArrayList<>();
        recordList.add(record);
        String s = this.gson.toJson(recordList);
        try {
            FileWriter fileWriter = new FileWriter(this.recordFile);
            fileWriter.write(s);
            fileWriter.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean rewriteRecord(List<T> records) {
        List<T> recordList = new ArrayList<>();
        recordList.addAll(records);
        String s = this.gson.toJson(recordList);
        try {
            FileWriter fileWriter = new FileWriter(this.recordFile);
            fileWriter.write(s);
            fileWriter.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
