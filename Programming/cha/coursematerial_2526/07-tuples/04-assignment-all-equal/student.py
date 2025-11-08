
def all_equal(xs):
    for i in range(len(xs) -1): 
        if xs[i] != xs[i+1]:
            return False
    else :
        return True

        
print(all_equal([1, 1, 1, 1, 2, 1, 1]))