import re
def one_or_more_abc(string):
    if re.fullmatch('(abc)+', string):
        return True
    
print(one_or_more_abc("abcabcabc"))