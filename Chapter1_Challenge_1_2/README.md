# Chapter 1 Challenge 1.2 - Winning Number Analyzer

This Java application analyzes a set of lottery-style numbers to determine which one has the highest average digit value.

## Description

The program processes a predefined list of number strings formatted with dashes (e.g., "12-34-56-78-90"). For each number, it:
1. Removes the dashes.
2. Calculates the sum of all individual digits.
3. Computes the average of the digits.
4. Identifies and prints the number with the highest average digit value.

## How to Run

1. Open the project in your IDE (NetBeans, IntelliJ IDEA, etc.).
2. Navigate to `src/chapter1_challenge_1_2/Chapter1_Challenge_1_2.java`.
3. Run the `main` method.

## Output Example

```text
Analyzing: 12-34-56-78-90
Digit Average: 4.50

Analyzing: 33-44-11-66-22
Digit Average: 3.20

Analyzing: 01-02-03-04-05
Digit Average: 2.50

--------------------------------------------------
The winning number with the highest average is: 12-34-56-78-90
Average: 4.50
```

## Project Structure

- `src/chapter1_challenge_1_2/Chapter1_Challenge_1_2.java`: Main application logic.
