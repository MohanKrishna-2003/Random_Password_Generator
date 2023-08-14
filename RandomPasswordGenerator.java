import java.util.*;
import java.security.*;

public class RandomPasswordGenerator
{
    public static String generatePassword(int length, int choice)
    {
        String lowerCase = "abcdefghijklmnopqrstuvwxyz";
        String upperCase = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String symbols = "!@#$%^&*()-_=+[]{}|;:,.<>?";

        StringBuilder characters = new StringBuilder();

        if(choice>=1)
            characters.append(lowerCase).append(upperCase);
        if(choice>=2)
            characters.append(numbers);
        if(choice>=3)
            characters.append(symbols);

        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        for(int i=0; i<length; i++)
        {
            int randomInd = random.nextInt(characters.length());
            password.append(characters.charAt(randomInd));
        }

        return password.toString();
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the length of your password: ");
        int length = sc.nextInt();

        System.out.println("Choose your password format:");
        System.out.println("1. Password with Letters\n" + "2. Password with Letters and Numbers\n" + "3. Mixed Password with Letters, Numbers and Symbols\n ");
        int choice = sc.nextInt();

        String password = generatePassword(length, choice);
        System.out.println("Generated Password: " + password);
    }
}
