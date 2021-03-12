package com.project.main;

import com.project.operation.FileOperationService;
import com.project.operation.FileOperationServiceImpl;
import java.util.Scanner;

/**
 * @author Alper Gurek
 * @since  11.03.2021
 *
 * Main Class of the Distinct Letters Of Count Algorithm Program
 */

public class DistinctLettersCountMain {

    private static String filePath = "";

    /**
     *
     * @param args Arguments could be input with
     *             command line "java -jar distinct-letters-count.jar c:\test"
     *             Program is searching the path. If there are multiple txt files
     *             it also checks about that files of distinct letters and show
     *             on screen.
     *             if there is no argument or could not be found.
     *             program will going to ask about the included resource test
     *             files. There are test1.txt , test2.txt , test3.txt
     *             if user will input on the screen, The result of that resource file
     *             will be shown on the screen.
     *
     */
    public static void main(String[] args)
    {

        if(args != null && args.length >0)
        {
            filePath = args[0];
        }

        FileOperationService fileOperation = new FileOperationServiceImpl(filePath);
        if(fileOperation.checkTextFilesExist()) {
            fileOperation.showDistinctLettersCountsOnFiles();
        }
        else {
            System.out.println("The path which is given by command line argument does not have any *.txt resource files.");
            System.out.println("Do you want to continue with project resources ? Y/N");
            Scanner optionScanner = new Scanner(System.in);
            String option = optionScanner.nextLine();

            System.out.println("please enter file name");
            String fileName = optionScanner.nextLine();

            if("Y".equalsIgnoreCase(option) && fileName != null && !fileName.isEmpty())
            {
                fileOperation.showDistinctLettersCountsOnResourceFile(fileName);
            }
            else {
                System.out.println("System will be exit.");
            }
        }
    }
}
