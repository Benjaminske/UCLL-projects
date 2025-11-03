def print_numbers(start, stop, step):
    count = start
    while count < stop:
        print(count)
        count += step
    
print(print_numbers(1, 5, 1))