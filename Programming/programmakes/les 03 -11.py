def entrance_exam(grades):
    number_skipped = 0
    totaal_score = 0
    for grade in grades:
        if grade == None:
            number_skipped += 1
        else: 
            totaal_score += grade
    average = totaal_score/ (len(grades) - number_skipped)
    if number_skipped <= 1 and average >= 12:
        return True,  average
    else:
        return False,  average
    
grades = (12, None, 19)
print(entrance_exam(grades))