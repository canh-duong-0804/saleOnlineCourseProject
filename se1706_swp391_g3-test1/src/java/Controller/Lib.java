/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

/**
 *
 * @author ADMIN
 */
public class Lib {

    public static String checkPass(String password, String re_password) {
        if (!password.equals(re_password)) {
            return "Confirm Password does not match Password";
        } else {
            if (password.length() < 6) {
                return "Password must have at least 6 characters";
            }
            char[] check = password.toCharArray();
            int count = 0;
            for (int i = 0; i < check.length; i++) {
                if (!Character.isLetterOrDigit(check[i])&&!Character.isWhitespace(check[i])) {
                    count++;
                    break;
                }
            }
            if (count < 1) {
                return "Password must contain special character(s)";
            }
            for (int i = 0; i < check.length; i++) {
                if (Character.isUpperCase(check[i])) {
                    count++;
                    break;
                }
            }
            if (count < 2) {
                return "Password must contain uppercase character(s)";
            }
            for (int i = 0; i < check.length; i++) {
                if (Character.isLowerCase(check[i])) {
                    count++;
                    break;
                }
            }
            if (count < 3) {
                return "Password must contain lowercase character(s)";
            }
            for (int i = 0; i < check.length; i++) {
                if (Character.isDigit(check[i])) {
                    count++;
                    break;
                }
            }

            if (count < 4) {
                return "password must contain digit(s)";
            }
            return "Success";

        }
        
    }
     public static byte[] getSHA(String input) throws NoSuchAlgorithmException
    {
        // Static getInstance method is called with hashing SHA
        MessageDigest md = MessageDigest.getInstance("SHA-256");
 
        // digest() method called
        // to calculate message digest of an input
        // and return array of byte
        return md.digest(input.getBytes(StandardCharsets.UTF_8));
    }
     
    public static String toHexString(byte[] hash)
    {
        // Convert byte array into signum representation
        BigInteger number = new BigInteger(1, hash);
 
        // Convert message digest into hex value
        StringBuilder hexString = new StringBuilder(number.toString(16));
 
        // Pad with leading zeros
        while (hexString.length() < 64)
        {
            hexString.insert(0, '0');
        }
 
        return hexString.toString();
    }
    public static int convertVnPriceToInt(String priceVn) {
        // Set the locale to Vietnamese
        Locale localeVn = new Locale("vi", "VN");

        // Create a NumberFormat instance with the Vietnamese locale
        NumberFormat numberFormat = NumberFormat.getInstance(localeVn);

        try {
            // Parse the price string and return the integer value
            Number priceNumber = numberFormat.parse(priceVn);
            return priceNumber.intValue();
        } catch (ParseException e) {
            // In case of an invalid price format
            e.printStackTrace();
            return -1; // Or any other error handling logic
        }
    }
    public static String getAlphaNumericString(int n) {

        // choose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                    = (int) (AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }
}
