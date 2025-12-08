class Attraction:
    def __init__(self, name, height_limit):
        self.set_name(name)
        self.set_height_limit(height_limit)
        self.__visitors = 0
        
    def get_visitors(self):
        return self.__visitors
    
    def set_name(self, name):
        if isinstance(name, str):
            name = name.strip()
            if name != '':
                self.__name =name
            else:
                raise ValueError('Name cannot be empty')
        else:
                raise ValueError('Name must be a string')
    def get_name(self):
        return self.__name
    
    
    def set_height_limit(self, height_limit):
        if isinstance(height_limit, int) and height_limit != None and height_limit >= 0:
                self.__height_limit =height_limit
        else:
                raise ValueError('Height limit must be a positive number above 0')
    def get_height_limit(self):
        return self.__height_limit
    
    def visit(self, height):
        if height >= self.get_height_limit():
            self.__visitors += 1
        else : 
            with open('log.txt', "a", encoding='utf-8') as file:
                file.write(f'For the attraction {self.get_name}, you have to be atleast {self.get_height_limit}cm\n')
                
class Themepark:
    def __init__(self, name):
        self.__attractions = []
        if isinstance(name, str) and name != None and name.strip() != '' and name[0] == name[name[0]].upper():
            self.__name = name
        else:
            raise ValueError('Name is invalid. make sure you entered a name starting with a capital letter.')
    def add_attraction(self, attraction):
        found = False
        for attr in self.__attractions:
            if attr.get_name().replace(' ','').lower() == attraction.get_name().replace(' ','').lower():
                found = True
        if not found:
            self.__attractions.append(attraction)
    def print_overview(self):
        number_attractions = len(self.__attractions)
        if number_attractions == 1:
            attractions_suffix = ''
        else:
            attractions_suffix = 's'
        total_visist = self.totalNumberVisitors
        if total_visist == 1:
            visit_suffix ='s'
        else:
            visit_suffix = ''
        print(f'{self.__name} is a themepark with {number_attractions} attraction{attractions_suffix}, visited a total of {total_visist} time{visit_suffix}')
    def totalNumberVisitors(self):
        totalVisitors = 0
        for attraction in self.__attractions.get_visitiors():
            totalVisitors += attraction.get_visitors()
        return totalVisitors
    def safety_update(self, filename):
        with open(filename, 'r', encoding="utf-8") as file:
            lines = file.readline()
        for line in lines:
            height_limit, attractions = line.split(' cm : ')
            height_limit = int(height_limit)
            attractions = attractions.split(',')
            for attr in attractions:
                self.updateHeightLimit(attr, height_limit)
                
        self.print_update_overview()
    def print_update_overview(self):
        message = "attraction overviwe after update: \n"
        for attraction in self.__attractions:
            attraction_line = f'{attraction.get_name()}: {attraction.get_height_limit()} cm\n'
            message += attraction_line
            
    def updateHeightLimit(self, name, height_limit):
        found = False
        for attr in self.__attractions:
            if attr.get_name().replace(' ','').lower() == name.replace(' ','').lower():
                found = True
                attr.set_height_limit(height_limit)
        if not found:
            with open('log.txt', 'a', encoding='utf-8') as file:
                file.write(f'Attraction {name} does not exist')
                
    