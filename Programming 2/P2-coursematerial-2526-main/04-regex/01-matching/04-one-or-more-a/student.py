import re
def one_or_more_a(string):
    if re.fullmatch('a+', string):
        return True
    
print(one_or_more_a("aaa"))