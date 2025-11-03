def thanos(queue_size, target_size):
    i = 0
    while queue_size > target_size:
        queue_size = queue_size/2
        i += 1
        if queue_size <= target_size:
         return(i)      
    
print(thanos(100, 3))
