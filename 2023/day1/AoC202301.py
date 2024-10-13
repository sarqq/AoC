"""
AoC 2023 day 1
Extract integers from strings to put together calibration values.

Silver: Extract first and last integer of string to get calibration value.
        Return the sum of all calibration values.
Gold:   Same as silver, but some integers are spelled with letters.
"""

def silver():
    calibration_values = []
        
    try:
        file = open("input.txt", mode="r")
        for line in file:
            value = ""
            
            for char in line:
                if char.isdigit():
                    value += char
                    break
            
            for char in reversed(line):
                if char.isdigit():
                    value += char
                    break
        
            if len(value)==2:
                calibration_values.append(int(value))
            elif len(value)==1:
                value += value
                calibration_values.append(int(value))

        file.close()
        return sum(calibration_values)
    except OSError:
        print("Error in reading file.")

def gold():
    calibration_values = []

    try:
        file = open("input.txt", mode="r")
        for line in file:
            line.replace("one", "1")
            line.replace("two", "2")
            line.replace("three", "3")
            line.replace("four", "4")
            line.replace("five", "5")
            line.replace("six", "6")
            line.replace("seven", "7")
            line.replace("eight", "8")
            line.replace("nine", "9")
            
            print(line)
            value = ""
            
            for char in line:
                if char.isdigit():
                    value += char
                    break
            
            for char in reversed(line):
                if char.isdigit():
                    value += char
                    break
            
            if len(value)==2:
                calibration_values.append(int(value))
            elif len(value)==1:
                value += value
                calibration_values.append(int(value))

        file.close()
        return sum(calibration_values)
    except OSError:
        print("Error in reading file.")

def main():
    while True:
        cmd = input("[Part (1)] [Part (2)] [(Q)uit]] ")
    
        if cmd == "1":
            print(silver())
        elif cmd == "2":
            print(gold())
        elif cmd == "Q":
            print("Bye!")
            break

if __name__ == "__main__":
    main()
