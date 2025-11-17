p1 = (1, 2, 3)

def add_points(p1, p2):
    newpoint_x = p1[0] + p2[0]
    newpoint_y = p1[1] + p2[1]
    newpoint = (newpoint_x, newpoint_y)
    return newpoint

    
print(add_points((1,2), (3,4)))