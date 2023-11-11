package com.RecordUtil;

/**
 * Log is class to access record file. The record is writable
 */
public class Log<T> extends Record<T> {

    public Log(String recordName, String recordFile) {
        super(recordName);
    }

    /**
     * Write record to record file
     * 
     * @param record record to be written to record file 
     * @return `true` if writing operation is succesful or `false` if the writing
     *         operation failed
     */
    public boolean writeRecord(T record) {
        // TODO: implement this method
        // NOTE: tuliskan record dari parameter ke file record
        return false;
    }
}
