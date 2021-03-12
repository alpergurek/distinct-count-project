package com.project.validation;

/**
 * @author Alper Gurek
 * @since  11.03.2021
 *
 * That class has responsibility about the control of the constraints.
 */
public class FileLineValidationImpl implements FileLineValidation {
    private static final String lowerCaseRule= "Characters on line does not include only uppercase";
    private static final String maximumCharacterOnLine= "The maximum character number of the input line is more than 300000";
    private static final String minimumCharacterOnLine = " minimum character number of the input line should be at least 1";

    /**
     *  That method controls the every constraints which are not valid.
     *  If there is , return the string messages on the screen about that invalid line.
     * @param line every line of the reading file will be transfer to that method.
     * @return that method returns the string messages on the screen about that invalid line.
     */
    public String checkLineConstraints(String line)
    {
        StringBuilder str = new StringBuilder();
        if(!isLowerCaseLetters(line))
        {
            str.append(lowerCaseRule);
        }
        if(!isMaximumCharacterOnLine(line))
        {
            str.append(maximumCharacterOnLine);
        }
        if(!isMinimumCharacterOnLine(line))
        {
            str.append(minimumCharacterOnLine);
            if(str.length()!=0)
            str.append("\n");
        }
        return str.toString();
    }

    private boolean isLowerCaseLetters(String line)
    {
        return line.equals(line.toLowerCase());
    }
    private boolean isMaximumCharacterOnLine(String line)
    {
        return line.length()<300000;
    }
    private boolean isMinimumCharacterOnLine(String line)
    {
        return line.length()>0;
    }
}
