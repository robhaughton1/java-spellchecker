# Java Spell Checker

A Java spell-checking program that uses the Wagner-Fischer algorithm to calculate edit distance and suggest corrections for words that are not found in a dictionary.

This project was originally completed as a CSE 1322L programming assignment and was reconstructed from the original assignment specification after the original source files were lost.

## How It Works

For each word that is not found in the dictionary, the program compares it against the dictionary using the Wagner-Fischer edit-distance algorithm. Edit distance measures the minimum number of character insertions, deletions, and substitutions required to transform one word into another.

The algorithm uses a two-dimensional integer array to store the edit distances between progressively larger portions of the two strings. The value in the bottom-right cell represents the final edit distance.

The program then keeps the five dictionary words with the smallest edit distances and allows the user to either replace the unknown word with one of those suggestions or add the word to the dictionary.

## Features

- Calculates edit distance using the Wagner-Fischer dynamic programming algorithm
- Uses a 2D integer array to build the edit-distance table
- Compares unknown words against a dictionary
- Maintains the five closest candidate words in sorted order
- Allows users to replace misspelled words with a suggested word
- Allows users to add unknown words to the dictionary
- Processes complete sentences
- Uses Java classes and `ArrayList` collections

## Project Structure

- `Assignment2.java` — driver class containing the edit-distance algorithm, candidate management, sentence spell-checking, and main program loop
- `Word.java` — stores the original word, candidate word, and calculated edit distance
- `Dictionary.java` — dictionary loader supplied with the original assignment
- `dictionary.txt` — word list supplied with the original assignment

## Concepts Practiced

- Dynamic programming
- Wagner-Fischer / Levenshtein edit distance
- Two-dimensional arrays
- Nested loops
- String manipulation
- Classes and objects
- `ArrayList`
- Sorted insertion
- User input and validation

## Running

The original assignment depends on the provided `Dictionary.java` and `dictionary.txt` files. Once those files are present, compile the Java files and run `Assignment2`:

```bash
javac *.java
java Assignment2
```

## Example

Given an unknown word such as `beter`, the program calculates its edit distance against words in the dictionary and presents the five closest candidates. The user can then select a replacement such as `better` or add the original word to the dictionary.
