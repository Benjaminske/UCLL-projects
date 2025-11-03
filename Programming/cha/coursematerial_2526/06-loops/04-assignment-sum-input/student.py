def sum_input():
    total = 0
    number = int(input("Enter integer: "))
    while number != 0:
        total += number
        number = int(input("Enter integer: "))
    print(f"The sum equals {total}.")

#sum_input()  this is only needed if a user uses it. pytest doesnt need it