📘 CHAPTER 1 CHALLENGE 1.1 SECRET CODE DECRYPTION PROGRAM

🧩 Overview -👇-👇-👇

✔ Chapter1_Challenge_1_1 is a simple Java console application that demonstrates basic mathematical operations,
digit manipulation, and input handling using the "Scanner" class.
✔  The program takes a positive integer input (the “secret integer”) and
generates a decrypted code by performing specific digit-based computations.

      ⚙️ HOW IT WORKS -👇-👇-👇

1. The program prompts the user to enter a positive integer.
2. It extracts:
   - The first digit
   - The last digit
   - The second digit
   - The second-last digit
3. It then computes:
   - Product = (first × last)
   - Sum = (second + second-last)
4. The final decrypted code is formed by concatenating the product and sum.
Example:
 Input:  58341
 First = 5
 Last = 1
 Second = 8
 Second-last = 4
 Product = 5 × 1 = 5
 Sum = 8 + 4 = 12
 Decrypted Code = "512"
      🧠 THE KEY CONCEPTS DEMONSTRATED -👇-👇-👇-  

  Reading user input with "Scanner"
 Extracting digits from an integer using:
   - Division ("/")
   - Modulus ("%")
   - Logarithmic and power operations ("Math.log10", "Math.pow")
- Type casting ("(int)")
- String concatenation
- Input validation (ensuring the integer is positive)
