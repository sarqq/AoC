"""
@sarqq
Advent of Code 2015 - day 4

Finds the lowest number which produces a MD5 hash starting with a specified
string of digits.
"""
import hashlib

#Constants
DEFAULT_INPUT = "ckczppom"


def find_lowest_number(secret_key, target):
    """
    Finds the lowest number which produces a hash starting with the
    target string when combined with the secret key.

    Arguments:  secret_key - any string
                target - desired head of produced hash
    """
    lowest_number = 0

    while True:
        hashable = secret_key + str(lowest_number)
        #Encodes the string and stores the hexadecimal value in the variable
        result = hashlib.md5(hashable.encode()).hexdigest()
        
        #If result head matches target -> break
        if str(result[0:len(target)]) == target:
            break

        lowest_number += 1

    print(f"The lowest number which produces a hash starting with {target}\n"
          f"when combined with the input \"{secret_key}\", is {lowest_number}")

def main():
    #Allow for other keys than the one given by AoC
    secret_key = input("Enter secret key: ")
    
    #If no input given, use the default input file
    if not secret_key:
        secret_key = DEFAULT_INPUT

    #Part 1
    find_lowest_number(secret_key, "00000")

    #Part 2
    find_lowest_number(secret_key, "000000")

if __name__ == "__main__":
    main()
