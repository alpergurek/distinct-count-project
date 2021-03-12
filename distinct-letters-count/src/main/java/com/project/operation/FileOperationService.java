package com.project.operation;

public interface FileOperationService {
    boolean checkTextFilesExist();
    void showDistinctLettersCountsOnFiles();
    void showDistinctLettersCountsOnResourceFiles();
    void showDistinctLettersCountsOnResourceFile(String file);
}
