import pytest

from student import Heating, Location
def test_heating_success():
    kitchen = Location("Kitchen", 1)
    Heating("Main Heater", kitchen , 2000)

@pytest.mark.parametrize("name,  location, energy_consumption, type")([
    ("Main Heater", "Kitchen" , 2000, TypeError),
    (9, Location("Kitchen", 1), 2000, TypeError),
    ("", Location("Kitchen", 1), 2000, ValueError),
    ("Main heater", Location("Kitchen", 1), -2000, TypeError),
    ])
def test_heating_failed(name,  location, energy_consumption, type):
    with pytest.raises(type):
        Heating(name, location , energy_consumption)
    