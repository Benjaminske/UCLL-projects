import re
def three_to_ten_times_abc(string):
    return re.fullmatch(r'(abc){3,10}', string)

print(three_to_ten_times_abc("abcabcabcabcabcabcabcabcabc"))