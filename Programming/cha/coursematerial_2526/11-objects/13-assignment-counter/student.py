class Counter:
    def __init__(self):
        self.__count = 0
        
    def increment(self):
        self.__count += 1

    def get_count(self):
        print(self.__count)
        return self.__count 
    def reset(self):
        self.__count = 0
       
counter = Counter()
counter.increment()
counter.increment()
counter.get_count()
counter.reset()
counter.get_count()

    