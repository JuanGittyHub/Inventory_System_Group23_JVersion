/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.group23.inventory_system_group23_jversion;

/**
 *
 * @author Mbuso Kotob's
 */
public class GUIUtility {

    private final static int BARCODE_LENGTH = 12;
    private final static int VALID_NAME_LENGTH = 3;
    
    public static boolean isValidUnsignedNumber(String number)
    {
        var invalidCharsFound = 0;
        for (var i = 0; i < number.length(); ++i)
        {
            if(!Character.isDigit(number.charAt(i))) 
            {
                ++invalidCharsFound;
                break;
            }
        }
        return (invalidCharsFound == 0) ? Integer.parseInt(number) > 0 : false;
    }

    public static boolean isValidProductPrice(String productPrice)
    {
        boolean isValidProductPrice = false;
        var dotCount = 0;
        for (var i = 0; i < productPrice.length(); ++i)
        {
            if (!Character.isDigit(productPrice.charAt(i)))
            {
                if(productPrice.charAt(i) == '.') 
                {
                    ++dotCount;
                    continue;
                }
                isValidProductPrice = false;
                break;
            } else
            {
                isValidProductPrice = true;
            }
        }
        return isValidProductPrice && (dotCount == 1 || dotCount == 0);
    }

    public static boolean isNameValid(String name)
    {
        return name.length() >= VALID_NAME_LENGTH;
    }

    public static boolean isValidBarcode(String barcode)
    {
        return (barcode.isEmpty()) ? false : barcode.length() == BARCODE_LENGTH;
    }

    public static boolean isValidEmail(String email)
    {
        int specialEmailCharCounter = 0;
        for (int i = 0; i < email.length(); ++i)
        {
            if (email.charAt(i) == '@')
            {
                ++specialEmailCharCounter;
            }
        }
        return (specialEmailCharCounter == 1) && email.contains(".");
    }

    public static boolean isCellphoneNumberValid(String cellphone)
    {
        int cellphoneNumberLength = 0;
        for (int i = 0; i < cellphone.length(); ++i)
        {
            if (Character.isDigit(cellphone.charAt(i)))
            {
                ++cellphoneNumberLength;
            }
        }
        return (cellphoneNumberLength == 10);
    }

    public static void main(String args[])
    {
        //System.out.println(isValidEmail("mbusokotobes@gmail.com"));
        System.out.println(isValidUnsignedNumber("1520"));
    }
}
