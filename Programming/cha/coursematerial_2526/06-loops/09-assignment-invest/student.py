def invest(amount, rate, goal):
    counter = 0
    while amount < goal:
        amount = amount + (amount *rate/100)
        counter += 1
    if amount >= goal:
        return counter     
print(invest(100, 100, 1000))