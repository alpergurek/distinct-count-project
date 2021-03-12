package com.project.operation;

import java.io.*;

/**
 * @author Alper Gurek
 * @since  11.03.2021
 *
 * File Operation Class will be used as a service for the relevant file operations.
 * Main method should not be so overloaded with methods.
 * In that reason, service operations will make the code more readable and understandable.
 */
public class FileOperationServiceImpl implements FileOperationService {

    private File[] textFiles;
    private static final String RESOURCE_FILES = "test";

    private FileOperationServiceImpl()
    {
    }

    public FileOperationServiceImpl(String filePath)
    {
        textFiles = getTextFilesOnPath(filePath);
    }

    @Override
    public boolean checkTextFilesExist()
    {
        return textFiles != null && textFiles.length > 0;
    }

    private static File[] getTextFilesOnPath(String path) {
        File folder = new File(path);
        return folder.listFiles();
    }

    /**
     * When user input the path with command line arguments ,
     * that code will going to check about the textfiles in that folder.
     * Then it check about the line by line with FileReader class to show result
     * of minimum count for distinct counts.
     */
    @Override
    public void showDistinctLettersCountsOnFiles() {
        try {
            for (int i = 0; i < textFiles.length; i++) {
                FileReader fileReader = new FileReader(textFiles[i].getAbsolutePath());
                System.out.println("File Name = " + textFiles[i].getAbsolutePath());
                fileReader.showDistinctLettersCount();
            }
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void showDistinctLettersCountsOnResourceFiles(){
        try {
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            String path = loader.getResource(RESOURCE_FILES).getPath();
            File folder = new File(path);
            File[] listOfFiles = folder.listFiles();

            for (int i = 0; i < listOfFiles.length; i++) {
                FileReader fileReader = new FileReader(listOfFiles[i].getAbsolutePath());
                System.out.println("File Name = " + listOfFiles[i].getAbsolutePath());
                fileReader.showDistinctLettersCount();
            }

        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * When user does not input the path with command line arguments,
     * Main class asks about the already included resource test files will be used
     * or not. If it will be going to use, That method shown the  minimum count for distinct counts
     * of the resource test files which will be choosen by user.
     */
    @Override
    public void showDistinctLettersCountsOnResourceFile(String fileName){
        try {
            FileReader fileReader = new FileReader();
            System.out.println("Resource File Name = " + fileName);
            fileReader.showDistinctLettersCountOnResources(fileName);
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}
