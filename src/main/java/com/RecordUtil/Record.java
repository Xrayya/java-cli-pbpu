package com.RecordUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Record is class to access record file. The record is read-only
 */
public class Record<T> {
    private String recordName;
    private String recordFile;

    public Record(String recordName, String recordFile) {
        this.recordName = recordName;
        this.recordFile = recordFile;
    }

    /**
     * Read record file and return it as type specified
     * @return
     */
    public List<T> readRecordFile() {
        // TODO: implement this method
        // NOTE: baca file record lalu kembalikan sebagai list dari type objek
        return null;
    }
}
