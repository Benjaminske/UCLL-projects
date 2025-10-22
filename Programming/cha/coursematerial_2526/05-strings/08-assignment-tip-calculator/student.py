

def tip_calculator():
    total_price = float(input("Enter total price: "))
    default = 20
    tip_percentage = float(input("Enter Tip percentage the default is: ", default ," :"))
    if (tip_percentage == None): 
        result = round(total_price + (total_price/100) * default)
        return result
    else: 
        result = round(total_price + (total_price/100) * tip_percentage)
        return result

print(tip_calculator())

        

