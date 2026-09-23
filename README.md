# Java Spell Checker

A spell checker I made in Java for CSE 1322L. It uses the Wagner-Fischer algorithm to find the edit distance between words and suggest possible corrections.

## What it does

If a word isn't in the dictionary, the program compares it to the dictionary and finds the five words with the lowest edit distance. The user can replace the word with one of the suggestions or add the original word to the dictionary.

The edit distance is calculated with a 2D array. Each value keeps track of the number of changes needed to turn part of one word into part of another. The final value in the bottom-right of the array is the edit distance.

## Features

- Wagner-Fischer edit distance
- Spell checks full sentences
- Gives the five closest suggestions for unknown words
- Lets the user replace a word or add it to the dictionary
- Uses a 2D array, ArrayLists, classes, and nested loops

## Files

- `Assignment2.java` - main program and spell-checking logic
- `Word.java` - stores the original word, suggested word, and edit distance
- `Dictionary.java` and `dictionary.txt` - files provided with the original assignment

## Running

The program needs the provided `Dictionary.java` and `dictionary.txt` files.

```bash
javac *.java
java Assignment2
```

The original copy of my code was lost, so this repository is a reconstruction of the project from the original assignment instructions.
