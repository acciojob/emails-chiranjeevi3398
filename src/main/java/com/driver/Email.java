package com.driver;

public class Email {

    private String emailId;
    private String password;

    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String oldPassword, String newPassword){
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character

        if(getPassword().equals(oldPassword))
        {
            if(isValid(newPassword))
            {
                this.password=newPassword;
            }
        }
    }

    public boolean isValid(String newPassword)
    {
        //checking if length is greater than 8
        if(newPassword.length()<8)
        {
            return false;
        }

        //Checking if lower and uppercase characters are present
        int upperCase=0;
        int lowerCase=0;
        int digit=0;
        int special=0;
        for(int i=0;i<newPassword.length();i++)
        {
            if(Character.isUpperCase(newPassword.charAt(i)))
            {
                upperCase++;
            }
            else if(Character.isLowerCase(newPassword.charAt(i)))
            {
                lowerCase++;
            }
            else if(Character.isDigit(newPassword.charAt(i)))
            {
                digit++;
            }
            else {
                special++;
            }
        }
        if(upperCase==0 || lowerCase==0 || digit==0 || special==0) return false;

        return true;
    }
}