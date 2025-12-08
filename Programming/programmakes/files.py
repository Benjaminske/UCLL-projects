
with open("mijn_tweede2_file.txt", 'w',encoding='utf-8') as file:
        file.write("yay")


with open("mijn_tweede2_file.txt", 'r',encoding='utf-8') as file:
        print(file.read())

