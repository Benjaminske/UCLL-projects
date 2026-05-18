# Assignment: Home Automation

Consider the starter code (in `starter_code.py`). It is part of an implementation of a new home automation system we are developing.

In this application, we are currently able to add three types of devices: `Lamp`, `Heating` and `WashingMachine`. These three classes have several things in common:

- fields:
  - `name`: the specific name of the device
  - `location`: a location object of where in the house it is located
  - `energy_consumption`: how much watts this device uses
- methods/properties:
  - `is_on`: returns True if the device is turned on, else returns False.
  - `turn_on`: turns the device on
  - `turn_off`: turns the device off

Nonetheless, these three classes also have their differences:

### Lamp
- Has a `brightness` level (0–100).
- Turning on sets the `brightness` to 100.
- Turning off sets the `brightness` to 0.

### Heating
- Has a `temperature` setting.
- Has a `preferred_temperature` setting, the default is 20°C.
- Turning on sets the `temperature` to the value of the `preferred_temperature`.
- Turning off sets the `temperature` to 0.

### WashingMachine
- Has a simple status `is_on` (True/False).
- Turning on sets the `is_on` to `True`.
- Turning off sets the `is_on` to `False`.

## Copy the code

Create a copy of the starter code in `student.py`. Implement all following questions in this file.

## Question 1: Refactor the code

Although the devices have some specific behavior, they also share common attributes and methods. 

Create a new abstract class `Device` that serves as a blueprint for all device types. Let the existing devices inherit from this blueprint. This shared class should contain all functionality that is identical across devices.

Wherever appropriate, use abstract methods or properties to enforce that each subclass provides its own implementation for behavior that differs.

> Tip: In the file `example_usage.py` you'll find some example usage of these classes. Use this example usage to make sure changes you make don't break the application.

## Question 2: The `HomeAutomation` system

Create a class `HomeAutomation` that keeps track of all devices added to the system.

Add at least the following methods:
- `add_device(device)` – adds a new `Device`-object to the system.
- `turn_on_all()` – turns on all devices.
- `turn_off_all()` – turns off all devices.
- `get_status()` - returns a string with information about all `Device`-objects in the system

## Question 3: Comparing devices

Whenever we compare an instance of any `Device`-object to another `Device`-object, we want to compare the energy consumption of both devices. Make sure to implement at least the following functionalities:


```
kitchen = Location("kitchen", 0)
lamp1 = Lamp("lamp_1", kitchen, 100)
lamp2 = Lamp("lamp_2", kitchen, 100)

print(lamp1 > lamp2)
print(lamp1 < lamp2)
print(lamp1 == lamp2)
```

output:
```
False
False
True
```

## Question 4: Higher-order functions and lambdas

Extend the HomeAutomation class with the following methods, using **list comprehensions** and **lambda expressions**:

- a method `filter(self,condition)` for the class `HomeAutomation` which returns a list of the `Device`-items, filtered on a the given `condition`.
- a method `filter_by_location(self, location)` which returns a list of the `Device`-items, where the `Device`-item's location must match the given `location`. Use the earlier made `filter(self,condition)` as part of the implementation.
- a method `filter_by_energy_consumption(self, energy_consumption)`, where the `Device`-item's energy consumption must be equal or lower than the given `energy_consumption`. Use the earlier made `filter(self,condition)` as part of the implementation.

## Question 5: testing

In the `tests.py`-file, write tests for the `Heating` class constructor and include the following:
  - at least one succesful creation of a `Heating` object
  - test all possible exceptions using a parameterized test.
