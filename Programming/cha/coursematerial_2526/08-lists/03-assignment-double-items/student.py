def double_items(ns):
    ns = [i*2 for i in ns]
    return ns

ns = [1,2,3,4]
print(ns)
ns = double_items(ns) 
print(ns)
