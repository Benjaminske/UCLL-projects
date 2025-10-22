
plus = "plus"
minus = "minus"
times = "times"
divide = "divide"

def functie(x):
    if x == plus :
        addition(y,z)
        return (addition(y,z))
        
    if x == minus :
        subtraction(y,z)
        return(subtraction(y,z))
        
    if x == times :
        multiplication(y,z)
        return(multiplication(y,z))

        
    if x == divide :
        division(y,z)
        return(division(y,z))
        
     
def addition(y,z):
    result = y + z
    return result
def subtraction(y,z):
    result = y - z
    return result
def multiplication(y,z):
    result = y * z
    return result
def division(y,z):
    result = y / z
    return result
    
x = str(input("Enter plus,minus,times or divide:-"))
y = int(input("enter nr1:-"))
z = int(input("enter nr2:-"))

answer = functie(x)
print(f"the answer is: {answer}")

