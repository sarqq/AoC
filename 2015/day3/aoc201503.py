"""
@sarqq
Advent of Code 2015 - day 3

Part 1
Read directions from input file and return amount of houses that are visited at
least once. This solution uses a 2D list as a coordinate system, increasing the
value at [x][y] every time it is visited.

Part 2
Same as part 1, but now there is a robot assisting Santa.
"""
#Constants
DEFAULT_FILENAME = "input.txt"
N = "^"
E = ">"
S = "v"
W = "<"

def read_input():
    """
    Reads input data and stores it into a list.
    
    Arguments: none
    Returns: instructions, a list of directions as strings
    """
    instructions = []
    
    try:
        #Allow the use of other input files than the one given by AoC
        filename = input("Enter file name: ")
        
        #Uses the default input file given by AoC if given an empty line
        if not filename:
            filename = DEFAULT_FILENAME

        #Open given input file and store data to variable
        input_file = open(filename, "r")
        instructions = input_file.read()
        
        #Close file and return data
        input_file.close()
        return instructions

    except OSError:
        print("Error opening file!")
        exit()

def move(instructions):
    """
    Moves Santa according to instructions from input file.
    
    Arguments:  instructions - list of instructions
    Returns:    houses - a list of coordinates visited
    """
    houses = [(0,0)]

    #Read character of line of instructions (see constants)
    for step in instructions:
        #Last house visited
        last = houses[-1]
        
        #Add visited coordinate to list
        if step == N:
            houses.append((last[0], last[1]+1))
        elif step == E:
            houses.append((last[0]+1, last[1]))
        elif step == S:
            houses.append((last[0], last[1]-1))
        elif step == W:
            houses.append((last[0]-1, last[1]))
        #Invalid direction
        else:
            continue

    return houses

def part1(instructions):
    """
    Find houses that are visited at least once by Santa according to instructions.
    
    Arguments:  instructions - list of instructions
    Returns:    none
    """
    #Go give gifts according to instructions
    houses = move(instructions)

    #Print the result, here I'm using the size of a set to remove duplicates
    print(f"Part 1 - Houses visited at least once: {len(set(houses))}")

def part2(instructions):
    """
    Find houses that are visited at least once by Santa and Robot according to
    instructions.

    Arguments:  instructions - list of instructions
    Returns:    none
    """
    #Have Santa and Robot take alternating instructions.
    #Technically the Robot also starts from index 0, but as we're using sets to
    #remove duplicates at the end anyways, it doesn't matter.
    instructions_santa = instructions[::2]
    instructions_robot = instructions[1::2]

    houses_santa = move(instructions_santa)
    houses_robot = move(instructions_robot)

    #Combine and print results, again using sets to remove duplicates
    all_houses_visited = set(houses_santa).union(set(houses_robot))
    print(f"Part 2 - Houses visited at least once: {len(all_houses_visited)}")
                

def main():
    instructions = read_input()
    
    #If list not empty, proceed with challenges
    if instructions:
        part1(instructions)
        part2(instructions)

if __name__ == "__main__":
    main()
