def countX(text, count = 0):
    if len(text) == 0:
        return count
    if text[0] != "x":
        return countX(text[1:], count)
    if text[0] == "x":
        count += 1
        return countX(text[1:], count)
    
        
print(countX("dadxifcsixsxxxxxucvaxbx"))