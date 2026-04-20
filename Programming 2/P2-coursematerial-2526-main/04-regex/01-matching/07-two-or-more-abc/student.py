import re
def two_or_more_abc(string):
    return re.fullmatch(r'(abc)+(abc)+', string)
    
print(two_or_more_abc("abcabcabc"))