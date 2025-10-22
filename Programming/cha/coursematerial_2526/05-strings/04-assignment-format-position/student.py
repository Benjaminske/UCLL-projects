
x = input("what is x?")
x = '{:.3f}'.format(float(x))

y = input("What is y?")
y = '{:.3f}'.format(float(y))
getallen =[x, y]


def format_position(getallen):
    result =list(map(str, getallen))
    return result
print(format_position(getallen))
    