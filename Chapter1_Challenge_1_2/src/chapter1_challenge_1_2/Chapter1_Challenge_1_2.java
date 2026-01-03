package chapter1_challenge_1_2;

public class Chapter1_Challenge_1_2 {

    public static void main(String[] args) {
        String[] winningNumbers = {"12-34-56-78-90", "33-44-11-66-22", "01-02-03-04-05"};
        
        String winningNumber = "";
        double highestAverage = -1.0;

        for (String number : winningNumbers) {
            double average = calculateDigitAverage(number);
            
            System.out.printf("Analyzing: %s%n", number);
            System.out.printf("Digit Average: %.2f%n", average);
            System.out.println();

            if (average > highestAverage) {
                highestAverage = average;
                winningNumber = number;
            }
        }

        System.out.println("--------------------------------------------------");
        System.out.printf("The winning number with the highest average is: %s%n", winningNumber);
        System.out.printf("Average: %.2f%n", highestAverage);
    }

    /**
     * Calculates the average of the individual digits in a string, ignoring dashes.
     * 
     * @param number The string containing numbers and dashes (e.g., "12-34")
     * @return The average value of the digits.
     */
    private static double calculateDigitAverage(String number) {
        String cleanNumber = number.replace("-", "");
        int sum = 0;
        int count = cleanNumber.length();

        if (count == 0) {
            return 0.0;
        }

        for (int i = 0; i < count; i++) {
            // Character.getNumericValue returns the int value of the char (e.g., '1' -> 1)
            sum += Character.getNumericValue(cleanNumber.charAt(i));
        }

        return (double) sum / count;
    }
}
