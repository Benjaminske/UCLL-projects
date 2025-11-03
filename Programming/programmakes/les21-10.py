def years_to_double(savings, interest_rate):
    number_of_years = 0
    target = savings*2
    while savings < target:
        savings += savings*interest_rate/100
        number_of_years += 1

    return number_of_years

#print(years_to_double(500, 10))

def dbl_space_annihalator(string):
    text_clear =""
    for i in range(0, len(string)):
        
        if string[i] == ' ':
            if (i == len(string)-1) or (string[i+1] != ' '):
                text_clear += string[i]
        else:
            text_clear += string[i]     
            
             
    return text_clear
print(f"'{dbl_space_annihalator("bert    en ernie en     ik ")}'")