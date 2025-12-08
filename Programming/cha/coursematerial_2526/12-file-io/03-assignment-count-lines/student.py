def count_lines_in_file(test):
    directory = "cha/coursematerial_2526/12-file-io/03-assignment-count-lines/"+ test
    with open(directory, encoding='utf-8') as file:
        result = len(file.readlines())
        return result
print(count_lines_in_file('test.txt'))