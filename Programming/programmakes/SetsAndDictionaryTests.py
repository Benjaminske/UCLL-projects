dictionary = {"a" : 1 , "b" : 2 , "c" : 3}

keys = dictionary.keys()
items = dictionary.items()
values = dictionary.values()

#print(values)

def Enumerating_test(dictionary):
    for key, value in dictionary.items():
        print(value)
        
Enumerating_test(dictionary)