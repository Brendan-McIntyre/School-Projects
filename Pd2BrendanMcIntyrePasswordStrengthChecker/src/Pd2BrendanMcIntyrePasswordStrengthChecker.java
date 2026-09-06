public class Pd2BrendanMcIntyrePasswordStrengthChecker
{
    public static void main(String[] args)
    {
        // Sample passwords to test
        String[] passwords = {
                "12345",        // Very Weak
                "abcdef",       // Weak
                "abc123xyz",    // Strong
                "1337h@xor!",   // Very Strong
                "abc1234567",   // Strong
                "Abc!@#123"     // Very Strong
        };

        // Test each password
        for (String password : passwords) {
            int strength = passwordValidator(password);
            System.out.println("The password '" + password + "' " +
                    getStrengthDescription(strength) + ".");
        }
    }

    /**
     * Determines the strength of a given password.
     * @param password The input password.
     * @return An integer representing password strength:
     *         0 - Very Weak, 1 - Weak, 2 - Strong, 3 - Very Strong
     */
    public static int passwordValidator(String password)
    {
        boolean special = false;
        int num = 0;
        int letters = 0;
        String nums = "0123456789";
        String alpha = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for(int i = 0; i < password.length(); i++){
            if (alpha.indexOf(password.substring(i, i + 1)) != -1)
                letters++;
            else if (nums.indexOf(password.substring(i, i + 1)) != -1)
            num++;
            else special = true;
        }
        if (special = true && num > 0 && letters > 0 && password.length()>=8)
            return 3;
        else if (num > 0 && letters > 0 && password.length()>=8)
            return 2;
        else if (letters > 0)
            return 1;
        else return 0;
    } // passwordValidator

    /**
     * Converts password strength integer codes to a descriptive string.
     * @param strengthCode The strength code (0 to 3).
     * @return A descriptive string for password strength.
     */
    public static String getStrengthDescription(int strengthCode)
    {
        if (strengthCode == 3)
            return "Contains only numbers and if fewer than 8 characters";
        if (strengthCode == 2)
            return "Contains only letters and if fewer than 8 characters";
        if (strengthCode == 1)
            return "Contains letters and at least one numbers and at least 8 characters";
        else return "Contains letters, numbers and special characters and at least 8 characters";
    } // getStrengthDescription
} // PasswordStrengthChecker