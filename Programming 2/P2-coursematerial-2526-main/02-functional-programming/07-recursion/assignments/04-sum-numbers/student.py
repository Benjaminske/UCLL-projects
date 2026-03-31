def sum_numbers(number):
    string_nummer = str(number)
    if number < 0:
        string_nummer = string_nummer[1:]
        
    if len(string_nummer) == 1:
            return number
        
    number = int(string_nummer[0])
    new_number = int(string_nummer[1:])
    return number + sum_numbers(new_number)
print(sum_numbers(-328723561))