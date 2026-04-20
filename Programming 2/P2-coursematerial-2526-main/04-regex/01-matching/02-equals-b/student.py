import re
def equals_b(string):
    if re.fullmatch('b', string):
        return True
    
print(equals_b("b"))