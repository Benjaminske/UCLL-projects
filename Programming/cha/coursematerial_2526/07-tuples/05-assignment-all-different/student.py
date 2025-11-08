def all_different(xs):
    for i in range(len(xs)):
        for j in range(i + 1, len(xs)):
            if xs[i] == xs[j]:
                return False
    return True
print(all_different([1, 2, 1, 3, 4, 5]))