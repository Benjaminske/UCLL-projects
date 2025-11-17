def remove_duplicates(xs):
    setxs = set(xs)
    result = []
    check = set()
    for i in xs:
        if i not in check:
            result.append(i)
            check.add(i)
    return result
    
    
print(remove_duplicates([1,1,3,2]))