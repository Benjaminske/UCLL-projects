athletes = [
    ("James Thompson", 12.84, "Belgium"),
    ("Sophie Dubois", 12.75, "Belgium"),
    ("Lisa De Vries", None, "Germany"),
    ("Lisa De Vries", None, "Germany"),
    ("James Thompson", 13.21, "Japan"),
    ("James Thompson", 13.21, "Japan"),
]


def copy_athletes(athletes):
    copy = []
    for athlete in athletes:
        copy.append(athlete)
    return copy

print(copy_athletes(athletes))
#def remove_non_participating_athletes(athletes):
 #       for athlete in reversed(athletes):  
  #          if athlete[1] == None:
   #             athletes.remove(athlete)
        
#remove_non_participating_athletes(athletes)
#print(athletes)


#def print_countries(athletes):
 #   unique_countries = {athlete[2] for athlete in athletes}
  #  print(len(unique_countries))

#print_countries(athletes)    
    

#def print_name(athletes):
    #for numbers in athletes:
        #print(numbers[1])
        
#def print_winner(athletes):
    #winner = athletes[0]
    #for athlete in athletes:
        #if athlete[1] < winner[1]:
            #winner = athlete
    #print(winner)
        
        
#print_winner(athletes)