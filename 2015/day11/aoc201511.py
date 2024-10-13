"""
@sarqq
Advent of Code 2015 - day 

asd
"""
DEFAULT_FILENAME = "input.txt"

def read_input(filaname):
    instructions = []
    
    try:
        file = open(filename, "r")
        
        instructions = file.read().split()

        file.close()
        return instructions
    except OSError:
        print("Error reading file!")
        return

def part1():
    pass

def part2():
    pass

def main():
    filename = input("Enter file name: ")
    
    if not filename:
        filename = DEFAULT_FILENAME

    part1()
    part2()

if __name__ == "__main__":
    main()
