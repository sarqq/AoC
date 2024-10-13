"""
@sarqq
Advent of Code 2021 - day 6

Calculates how many fish will spawn within the given number of days.
Adult fish have a spawn cycle of 7 days, newborn fish have a spawn cycle of 9 days.

"""

DEFAULT_FILENAME = "input.txt"
CYCLE = 7
CYCLE_MAX = CYCLE+2

def spawn(data, days):
	tracker = [data.count(i) for i in range(CYCLE_MAX)]
	
	for day in range(days):
		#count fish spawning on day
		tracker[(day+CYCLE)%CYCLE_MAX] += tracker[day%CYCLE_MAX]

	#return total amount of fish spawned
	return sum(tracker)

def main():
	filename = input("Enter filename: ")
	
	if not filename:
		filename = DEFAULT_FILENAME
	
	data = []
	try:
		#list of fish, with value being days until spawning
		data = [int(x) for x in open(filename).read().strip().split(",")]

		if data:
			print(f"Part 1 - {spawn(data, 80)}")
			print(f"Part 2 - {spawn(data, 256)}")
		else:
			print("Error in input file format!")
			
	except OSError:
		print("Unable to open file!")

if __name__ == "__main__":
	main()
