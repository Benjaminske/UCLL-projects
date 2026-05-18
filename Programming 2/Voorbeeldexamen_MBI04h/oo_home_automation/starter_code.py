class Location:
    def __init__(self, room, floor):
        self.room = room
        self.floor = floor

class Lamp:
    def __init__(self, name, location, energy_consumption):
        self.__name = name
        self.__location = location
        self.__brightness = 0
        self.__energy_consumption = energy_consumption
        
    @property
    def name(self):
        return self.__name
    
    @property
    def location(self):
        return self.__location
    
    @property
    def energy_consumption(self):
        return self.__energy_consumption
    
    @property
    def brightness(self):
        return self.__brightness
    
    @property
    def is_on(self):
        return self.__brightness > 0
        
    def turn_on(self):
        self.__brightness = 100
        
    def turn_off(self):
        self.__brightness = 0
        
class Heating:
    def __init__(self, name, location, energy_consumption):
        if not isinstance(location, Location):
            raise TypeError("Location must be an instance of Location class")
        if not isinstance(name, str):
            raise TypeError("Name must be a string")
        if name.strip() == "":
            raise ValueError("Name cannot be an empty string")
        if not isinstance(energy_consumption, int):
            raise TypeError("Energy consumption must be an integer")
        if energy_consumption < 0:
            raise ValueError("Energy consumption cannot be negative")        

        self.__name = name
        self.__location = location
        
        self.__temperature = 0
        self.__preferred_temperature = 20
        self.__energy_consumption = energy_consumption
        
    @property
    def name(self):
        return self.__name
    
    @property
    def location(self):
        return self.__location
    
    @property
    def energy_consumption(self):
        return self.__energy_consumption
    
    @property
    def temperature(self):
        return self.__temperature
    
    @property
    def is_on(self):
        return self.__temperature > 0
        
    def turn_on(self):
        self.__temperature = self.__preferred_temperature
        
    def turn_off(self):
        self.__temperature = 0
        
    @property
    def preferred_temperature(self):
        return self.__preferred_temperature
    
    @preferred_temperature.setter
    def preferred_temperature(self, temperature):
        if not isinstance(temperature, (int, float)):
            raise TypeError("Preferred temperature must be a number")
        if temperature < 0 or temperature > 100:
            raise ValueError("Preferred temperature must be between 0 and 100")
        
        self.__preferred_temperature = temperature



class WashingMachine:
    def __init__(self, name, location, energy_consumption):
        self.__name = name
        self.__location = location
        self.__is_on = False
        self.__energy_consumption = energy_consumption

    @property
    def name(self):
        return self.__name
    
    @property
    def location(self):
        return self.__location
    
    @property
    def energy_consumption(self):
        return self.__energy_consumption
    
    @property
    def is_on(self):
        return self.__is_on
        
    def turn_on(self):
        self.__is_on = True

    def turn_off(self):
        self.__is_on = False
