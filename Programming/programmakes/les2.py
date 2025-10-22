def rent_bicycles(num_bikes, rental_days, is_member, insurance):
    bike_price = 5.00
    member_discount = 15
    
    
    base_price = bike_price *num_bikes * rental_days
    
    if is_member  and insurance == True:
       member_price =base_price - ( base_price *member_discount)/100
       insurance_price = member_price + 2+rental_days
       return insurance_price
    if is_member == True and insurance == False:
        member_price =base_price - ( base_price *member_discount)/100
        return member_price
    if is_member == False and insurance == True:
        insurance_price = base_price + (2* rental_days)
        return insurance_price
    
print(rent_bicycles(10, 5, True, True))

        

        
       
    

    
    
    