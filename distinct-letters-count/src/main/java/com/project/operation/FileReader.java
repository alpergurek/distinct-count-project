package com.project.operation;

import com.project.algorithm.DistinctLettersCountAlgorithm;
import com.project.validation.FileLineValidation;
import com.project.validation.FileLineValidationImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author Alper Gurek
 * @since 11.03.2021
 *
 * That class is responsible about the reading operations.
 * Also , it checks about the validation with FileLineValidation object
 * and calculate the result with the Distinct Count Algorithm object.
 */
public class FileReader{

    private String filePath;
    private DistinctLettersCountAlgorithm algorithm;
    private FileLineValidation fileLineValidation;
    private static final String RESOURCE_PATH = "/test/";

    public FileReader() {
        this.fileLineValidation = new FileLineValidationImpl();
        this.algorithm = new DistinctLettersCountAlgorithm();
    }

    public FileReader(String filePath)
    {
        this.filePath = filePath;
        this.fileLineValidation = new FileLineValidationImpl();
        this.algorithm = new DistinctLettersCountAlgorithm();
    }

    /**
     * That method is reading from command line argument path files.
     * Also , it checks about the validation with FileLineValidation object
     * and calculate the result with the Distinct Count Algorithm object.
     */
    public void showDistinctLettersCount()
    {
        BufferedReader reader;
        int lineNumber = 1;
        try {
            reader = new BufferedReader(new java.io.FileReader(
                    filePath));
            String line = reader.readLine();
            line = checkDistinctLines(line,lineNumber);
            while (line != null) {
                System.out.println(line);
                // read next line
                line = reader.readLine();
                lineNumber++;
                line = checkDistinctLines(line,lineNumber);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * That method is reading included project resources files
     * which will be choosen with user.
     * Also , it checks about the validation with FileLineValidation object
     * and calculate the result with the Distinct Count Algorithm object.
     * @param fileName
     */
    public void showDistinctLettersCountOnResources(String fileName)
    {
        int lineNumber = 1;
        try {
            InputStream in = getClass().getResourceAsStream(RESOURCE_PATH +fileName);
            BufferedReader ResourceReader = new BufferedReader(new InputStreamReader(in));
            String line = ResourceReader.readLine();
            line = checkDistinctLines(line,lineNumber);
            while (line != null) {
                System.out.println(line);
                line = ResourceReader.readLine();
                lineNumber++;
                line = checkDistinctLines(line,lineNumber);
            }
            ResourceReader.close();
        } catch (IOException io) {
            System.out.println("Please check your input !!");
        }
        catch (Exception ex) {
            System.out.println("File Can not Be Found !!");
        }
    }

    /**
     *
     * @param line Every line of the files will be transfer to that method to control
     *             whether contraints , calculating the algoritm and how to show the message on screen.
     * @param lineNumber The line number of the file which will be reading.
     * @return User message of the result will be return from that method.
     */
    private String checkDistinctLines(String line,int lineNumber)
    {
        if(line != null)
        {
            String invalidLine = fileLineValidation.checkLineConstraints(line);
            if("".equals(invalidLine)) {
                int distinctCount = algorithm.getDistinctLettersCountOnLine(line);
                line = lineNumber + "- " + Integer.toString(distinctCount);
            }
            else {
                line = lineNumber + "- " + invalidLine;
            }
        }
        return line;
    }
}
