def reverse_from_left(text):
    if not text:
        return ""
    print(text)
    return reverse_from_left(text[1:]) + text[0]

def reverse_from_right(text):
    if not text:
        return ""
    text = text[::-1]
    new_text = reverse_from_left(text[1:]) + text[0]
    return new_text[::-1]

print(reverse_from_right("jemama"))