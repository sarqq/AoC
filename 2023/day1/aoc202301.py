"""
AoC 2023 day 1
Extract integers from strings to put together calibration values.

Part 1: Extract first and last integer of string to get calibration value.
        Return the sum of all calibration values.
Part 2: Same as silver, but some integers are spelled with letters.

TODO: find out why part 2 doesn't work as intended
"""

DEFAULT_FILENAME = "input.txt"
WORDS_TO_NUMBERS = {"one":"1", "two":"2", "three":"3", "four":"4",
                    "five":"5", "six":"6", "seven":"7", "eight":"8",
                    "nine":"9"}

def read_file(filename):
    calibration_values = []

    try:
        file = open(filename, mode="r")
        
        for line in file:
            calibration_values.append(line.strip())
        
        file.close()
    except OSError:
        print("Error in reading file.")
    
    return calibration_values

def find_values(ciphertext):
    calibration_values = []

    for line in ciphertext:
        first = ""
        last = ""

        for i in range(len(line)):
            #if character at index is a digit and first is empty
            if line[i].isdigit() and not first:
                first = line[i]
            #if character at index is a digit, and last is empty
            if line[-1-i].isdigit() and not last:
                last = line[-1-i]

            #when first and last have a value        
            if first and last:
                value = first+last
                calibration_values.append(int(value))
                break

    return sum(calibration_values)

def replace_words(ciphertext):
    replaced_values = []

    #TODO: fix
    for line in ciphertext:
        for word in WORDS_TO_NUMBERS:
            line = line.replace(word, WORDS_TO_NUMBERS[word])
        
        replaced_values.append(line)
    
    return replaced_values

def main():
    filename = input("Enter filename: ")

    if not filename:
        filename = DEFAULT_FILENAME

    instructions = read_file(filename)

    if instructions:
        part1 = find_values(instructions)
        part2 = find_values(replace_words(instructions))

        print(f"Part 1 - Sum of all calibration values: {part1}")
        print(f"Part 2 - Sum of all calibration values: {part2}")
        
if __name__ == "__main__":
    main()
