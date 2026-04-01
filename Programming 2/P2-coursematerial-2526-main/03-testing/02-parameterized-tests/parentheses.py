def matching_parentheses(string):
    count = 0
    for char in string:
        if char == '(' and count >= 0:
            count += 1
        if char == ')' and count >= 0:
            count -= 1
       
       
    if(count == 0):
        return True
    else:
        return False

