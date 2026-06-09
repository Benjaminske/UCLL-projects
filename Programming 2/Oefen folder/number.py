def sum_odd_numbers(list):
    if len(list) == 0:
        return 0

    first = list[0]

    if first % 2 != 0:
        return first + sum_odd_numbers(list[1:])
    else:
        return sum_odd_numbers(list[1:])

print(sum_odd_numbers([1, 2, 3, 4, 5]))