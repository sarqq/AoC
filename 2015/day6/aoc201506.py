"""
@sarqq
Advent of Code 2015 - day 

asd
"""
DEFAULT_FILENAME = "input.txt"

def read_input(filename):
    instructions = []
    
    try:
        file = open(filename, "r")
        
        instructions = file.read().split()

        file.close()
        return instructions
    except OSError:
        print("Error reading file!")
        return

def part1(instructions, grid):
    #Instruction pattern <command> <x,y> through <x,y>
    for instruction in instructions:
        parts = instruction.split()
        
        #Turn off/on
        if len(parts) == 5 and parts[1] in ["on", "off"]:
            x1, y1 = parts[2].split(",")
            x2, y2 = parts[4].split(",")
            
            #Turn on lights through x1,y1 and x2,y2
            if parts[1] == "on":
                for i in range(x1, x2):
                    for j in range(y1, y2):
                        grid[i][j] = True

            
            if parts[1] == "off":
                for i in range(x1, x2):
                    for j in range(y1, y2):
                        grid[i][j] = False
        #Toggle
        elif len(parts) == 4 and parts[0] == "toggle":
            x1, y1 = parts[1].split(",")
            x2, y2 = parts[3].split(",")

            #Toggle lights through x1,y1 and x2,y2
            for i in range(x1, x2):
                for j in range(y1, y2):
                    grid[i][j] = not grid[i][j]
        else:
            print("Invalid command!")
            return

    #TODO: return amount of True values in list

def part2(instructions, grid):
    pass

def main():
    filename = input("Enter file name: ")
    
    if not filename:
        filename = DEFAULT_FILENAME

    instructions = read_input(filename)
    
    if instructions:
        #Creating 1000x1000 light grid
        grid = [1000*[False] for _ in range(1000)]

        part1(instructions, grid)
        part2(instructions, grid)

if __name__ == "__main__":
    main()
