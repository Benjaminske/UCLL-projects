import pytest
from dog import *
from student import (
    all_dogs, count, count_breed, count_color,
    count_breed_recursive, count_color_recursive,
    from_same_nest, find_dog_names_regex,
    count_ancestors, is_pure_breed,
    years_of_birth, years_of_birth_sorted
)


#  count 

@pytest.mark.parametrize("collection, condition, expected", [
    ([1, 2, 3],     lambda x: x > 0,      3),
    ([1, 2, 3],     lambda x: x > 10,     0),
    ([],            lambda x: True,        0),
    ([1, 2, 3, 4],  lambda x: x % 2 == 0, 2),
])
def test_count(collection, condition, expected):
    assert count(collection, condition) == expected, \
        f"Expected count to be {expected} for collection {collection}"


#  count_breed 

@pytest.mark.parametrize("breed, expected", [
    ("Labrador",        15),
    ("Labracollie",      1),
    ("Beagle",           3),
    ("German Shepherd",  3),
    ("Poodle",           0),
])
def test_count_breed(breed, expected):
    assert count_breed(all_dogs, breed) == expected, \
        f"Expected {expected} dogs of breed '{breed}', got {count_breed(all_dogs, breed)}"

def test_count_breed_empty_list():
    assert count_breed([], "Labrador") == 0, \
        "Expected 0 for an empty dog list"


#  count_color 

@pytest.mark.parametrize("color, expected", [
    ("black",       9),
    ("brown",       4),
    ("golden",      6),
    ("purple",      0),
])
def test_count_color(color, expected):
    assert count_color(all_dogs, color) == expected, \
        f"Expected {expected} dogs of color '{color}', got {count_color(all_dogs, color)}"

def test_count_color_empty_list():
    assert count_color([], "black") == 0, \
        "Expected 0 for an empty dog list"


#  count_breed_recursive 

@pytest.mark.parametrize("breed, expected", [
    ("Labrador",    15),
    ("Labracollie",  1),
    ("Poodle",       0),
])
def test_count_breed_recursive(breed, expected):
    assert count_breed_recursive(all_dogs, breed) == expected, \
        f"Expected {expected} dogs of breed '{breed}' (recursive), got {count_breed_recursive(all_dogs, breed)}"

@pytest.mark.parametrize("dogs, breed, expected", [
    ([],    "Labrador", 0),
    ([rex], "Labrador", 1),
    ([rex], "Beagle",   0),
])
def test_count_breed_recursive_edge_cases(dogs, breed, expected):
    assert count_breed_recursive(dogs, breed) == expected, \
        f"Expected {expected} for dogs={[d.name for d in dogs]}, breed='{breed}'"


#  count_color_recursive 

@pytest.mark.parametrize("color, expected", [
    ("black",  9),
    ("brown",  4),
    ("purple", 0),
])
def test_count_color_recursive(color, expected):
    assert count_color_recursive(all_dogs, color) == expected, \
        f"Expected {expected} dogs of color '{color}' (recursive), got {count_color_recursive(all_dogs, color)}"

def test_count_color_recursive_empty_list():
    assert count_color_recursive([], "black") == 0, \
        "Expected 0 for an empty dog list"


#  from_same_nest ─

@pytest.mark.parametrize("dog1, dog2", [
    (buddy, rocky),  # same father (charlie), mother (luna), birth year (2014)
])
def test_from_same_nest_true(dog1, dog2):
    assert from_same_nest(dog1, dog2) is True, \
        f"{dog1.name} and {dog2.name} should be from the same nest"

@pytest.mark.parametrize("dog1, dog2, reason", [
    (buddy,  buddy,  "same dog"),
    (buddy,  daisy,  "different father"),
    (daisy,  milo,   "same parents but different birth year (2016 vs 2015)"),
    (nala,   bailey, "different fathers and birth years"),
])
def test_from_same_nest_false(dog1, dog2, reason):
    assert from_same_nest(dog1, dog2) is False, \
        f"{dog1.name} and {dog2.name} should NOT be from the same nest ({reason})"

@pytest.mark.parametrize("year1, year2, expected", [
    (2010, 2010, True),   # no parents, same year → same nest
    (2010, 2011, False),  # no parents, different year → not same nest
])
def test_from_same_nest_no_parents(year1, year2, expected):
    dog_a = Dog("A", year1, "Labrador", "black")
    dog_b = Dog("B", year2, "Labrador", "black")
    assert from_same_nest(dog_a, dog_b) is expected, \
        f"Dogs with no parents born in {year1} and {year2} — expected same_nest={expected}"


#  find_dog_names_regex ─

def test_find_dog_names_regex_full_list():
    assert find_dog_names_regex(all_dogs) == ['Bella', 'Buddy'], \
        f"Expected ['Bella', 'Buddy'], got {find_dog_names_regex(all_dogs)}"

@pytest.mark.parametrize("name, should_match", [
    ("Bella",  True),   # starts with B, has 'll'
    ("Buddy",  True),   # starts with B, has 'dd'
    ("Bruno",  False),  # starts with B but no double char
    ("Bailey", False),  # starts with B but no double char
    ("Rex",    False),  # doesn't start with B
    ("Cleo",   False),  # doesn't start with B
])
def test_find_dog_names_regex_individual(name, should_match):
    dogs = [Dog(name, 2010, "Labrador", "black")]
    result = find_dog_names_regex(dogs)
    if should_match:
        assert name in result, f"'{name}' should match the regex but didn't"
    else:
        assert name not in result, f"'{name}' should NOT match the regex but did"

def test_find_dog_names_regex_empty_list():
    assert find_dog_names_regex([]) == [], \
        "Expected empty list for empty input"


# count_ancestors 

@pytest.mark.parametrize("dog, color, expected", [
    (rex,    "golden", 1),  # rex himself is golden
    (max,    "golden", 2),  # max + rex
    (buddy,  "golden", 1),  # rex via luna's lineage
    (rocky,  "golden", 2),
    (pepper, "golden", 4),
    (rex,    "purple", 0),  # no purple ancestors
    (None,   "golden", 0),  # base case
])
def test_count_ancestors(dog, color, expected):
    dog_name = dog.name if dog else "None"
    assert count_ancestors(dog, color) == expected, \
        f"Expected {expected} '{color}' ancestors for {dog_name}, got {count_ancestors(dog, color)}"


#  is_pure_breed 

@pytest.mark.parametrize("dog, breed", [
    (rex,   "Labrador"),
    (max,   "Labrador"),
    (penny, "Beagle"),
    (leo,   "German Shepherd"),
    (None,  "Labrador"),  # None is always considered pure
])
def test_is_pure_breed_true(dog, breed):
    dog_name = dog.name if dog else "None"
    assert is_pure_breed(dog, breed) is True, \
        f"{dog_name} should be considered purebred '{breed}'"

@pytest.mark.parametrize("dog, breed, reason", [
    (ruby,   "Labrador", "Sophie (mother) is a Border Collie"),
    (maggie, "Labrador", "Penny (mother) is a Beagle"),
    (rex,    "Beagle",   "Rex itself is a Labrador"),
])
def test_is_pure_breed_false(dog, breed, reason):
    assert is_pure_breed(dog, breed) is False, \
        f"{dog.name} should NOT be purebred '{breed}' — {reason}"


#  years_of_birth ─

@pytest.mark.parametrize("start, end, expected", [
    (2010, 2015, {2010, 2011, 2012, 2014, 2015}),
    (2012, 2017, {2012, 2014, 2015, 2016, 2017}),
    (2022, 2022, {2022}),
    (2100, 2200, set()),
])
def test_years_of_birth(start, end, expected):
    result = years_of_birth(all_dogs, start, end)
    assert result == expected, \
        f"years_of_birth({start}, {end}): expected {expected}, got {result}"

def test_years_of_birth_empty_list():
    assert years_of_birth([], 2010, 2015) == set(), \
        "Expected empty set for empty dog list"


#  years_of_birth_sorted 

@pytest.mark.parametrize("start, end, expected", [
    (2010, 2015, [2010, 2011, 2012, 2014, 2015]),
    (2012, 2017, [2012, 2014, 2015, 2016, 2017]),
    (2022, 2022, [2022]),
    (2100, 2200, []),
])
def test_years_of_birth_sorted(start, end, expected):
    result = years_of_birth_sorted(all_dogs, start, end)
    assert result == expected, \
        f"years_of_birth_sorted({start}, {end}): expected {expected}, got {result}"

def test_years_of_birth_sorted_is_ordered():
    result = years_of_birth_sorted(all_dogs, 2005, 2022)
    assert result == sorted(result), \
        f"Result is not sorted: {result}"

def test_years_of_birth_sorted_empty_list():
    assert years_of_birth_sorted([], 2010, 2020) == [], \
        "Expected empty list for empty dog list"
