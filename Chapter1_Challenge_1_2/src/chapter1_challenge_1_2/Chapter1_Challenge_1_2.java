
package chapter1_challenge_1_2;

public class Chapter1_Challenge_1_2 {

    public static void main(String[] args) {
        String[] winningNumbers = {"12-34-56-78-90", "33-44-11-66-22", "01-02-03-04-05"};
        double highestAverage = -1;
        String winningNumber = "";

        for (String number : winningNumbers) {
            // Remove the dashes
            String noDashes = number.replace("-", "");

            // Create an array of integer values
            int[] digits = new int[noDashes.length()];
            for (int i = 0; i < noDashes.length(); i++) {
                digits[i] = Character.getNumericValue(noDashes.charAt(i));
            }

            // Calculate the sum and average
            int sum = 0;
            for (int digit : digits) {
                sum += digit;
            }
            double average = (double) sum / digits.length;

            // Print the analysis
            System.out.println("Analyzing: " + number);
            System.out.println("Digit Sum: " + sum + ", Digit Average: " + average);

            // Check if this number has the highest average
            if (average > highestAverage) {
                highestAverage = average;
                winningNumber = number;
            }
        }

        // Announce the winning number
        System.out.println("The winning number with the highest average is: " + winningNumber
                + " with an average of " + highestAverage);
    }
}

