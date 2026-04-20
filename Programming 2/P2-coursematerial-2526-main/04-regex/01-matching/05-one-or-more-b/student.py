import re
def one_or_more_b(string):
    if re.fullmatch('b+', string):
        return True
    
print(one_or_more_b("bbb"))
