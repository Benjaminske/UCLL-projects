def contains_duplicates(xs):
    setxs = set(xs)
    filteredxs = list(setxs)
    if xs == filteredxs:
        return False
    else:
        return True
    
print(contains_duplicates([1]))
