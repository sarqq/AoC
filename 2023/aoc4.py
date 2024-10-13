def Card:
    def __init__(self, numbers):
        self.__winning = []
        self.__card_numbers = []
        
        nums = numbers.split("|")
        w_nums = nums[0].split(" ")
        c_nums = nums[1].split(" ")

        for w in w_nums:
            self.__winning.append(int(w))
        for c in c_nums:
            self.__card_numbers.append(int(c))

def main():
    scratchcards = []

    try:
        file = open("aoc2023_4.txt", mode="r")
        
        for line in file:
        
        

    except OSError:
        print("Error reading file.")

def __init__ == "__main__":
    main()
