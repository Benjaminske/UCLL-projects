def rpg2(n_sides, goal):
    counter = 0
    total = n_sides * n_sides  

    for dice1 in range(1, n_sides + 1):
        for dice2 in range(1, n_sides + 1):
            if dice1 + dice2 >= goal:
                counter += 1

    chance = (counter/total)*100
    return chance

print(rpg2(4, 8))
