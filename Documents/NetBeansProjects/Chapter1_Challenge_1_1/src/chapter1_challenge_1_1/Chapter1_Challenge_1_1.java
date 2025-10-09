
package chapter1_challenge_1_1;

    import java.util.Scanner;

public class Chapter1_Challenge_1_1 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in); 
        System.out.print("Enter the secret integer: ");
        
        int n = sc.nextInt(); 

        // Ensure n is positive to avoid math errors
        if (n <= 0) {
            System.out.println("Please enter a positive integer.");
            sc.close();
            return;
        }

        int digits = (int) Math.log10(n);

        int first = n / (int) Math.pow(10, digits);
        int last = n % 10;
        int second = (n / (int) Math.pow(10, digits - 1)) % 10;
        int secondLast = (n / 10) % 10;

        int product = first * last;
        int sum = second + secondLast;

        String finalCode = String.valueOf(product) + String.valueOf(sum);

        System.out.println("The decrypted code is: " + finalCode);

        sc.close(); 
    }
}

   