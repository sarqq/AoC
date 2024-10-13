"""
@sarqq
Advent of Code 2015 - day 5

Separate naughty and nice strings from input data according to criteria.

Part 1 criteria: must contain <=3 vowels, <=1 letter appearing twice in a row,
does not contain the strings "ab", "cd", "pq" or "xy".

Part 2 criteria: must contain <=2 occurrences of a length two substring
and <=1 letter repeating with one letter between (xyx pattern).
"""
#Importing re library for regex
import re

#Constants
DEFAULT_FILENAME = "input.txt"

def read_input(filename):
    """
    Reads strings from input file and stores them into a list
    
    Arguments:  filename - self-explanatory
    Return:     strings - list of input file lines
    """
    strings = []

    try:
        file = open(filename, "r")
        
        strings = file.read().split()

        file.close()
        return strings

    except OSError:
        print("Error opening file!")
        return

def part1(string):
    """
    Separates naughty and nice strings using regex patterns

    Arguments:  string - a single string from input file
    Return:    True/False - whether the string passes the criteria
    """
    #Check for forbidden strings
    if re.search(r"\w*(ab|cd|pq|xy)\w*", string):
        return False

    #Check for vowels
    if not re.search(r"[aeiou].*[aeiou].*[aeiou]", string):
        return False

    #Check for double letters
    if not re.search(r"(\w)\1", string):
        return False

    #Return True if string passed all niceness checks
    return True

def part2(string):
    """
    Separates naughty and nice strings using regex patterns

    Arguments:  string - a single string from input file
    Return:     True/False - whether the string passes the criteria
    """

    #Check for substrings with at least two occurrences without overlap
    if not re.search(r"\w*(\w\w)\w*\1\w*", string):
        return False
    
    #Check for at least one letter which repeats with exactly one letter between
    if not re.search(r"\w*(\w)[^\1]\1\w*", string):
        return False

    #Return True if string passed all niceness checks
    return True


def main():
    filename = input("Enter filename: ")

    if not filename:
        filename = DEFAULT_FILENAME

    strings = read_input(filename)
    
    #If file read correctly, proceed with challenges
    if strings:
        nice_strings1 = list(filter(part1, strings))
        print(f"Part 1 - The number of nice strings: {len(nice_strings1)}")

        nice_strings2 = list(filter(part2, strings))
        print(f"Part 2 - The number of nice strings: {len(nice_strings2)}")

if __name__ == "__main__":
    main()
