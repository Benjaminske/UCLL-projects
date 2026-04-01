import pytest

from parentheses import matching_parentheses

@pytest.mark.parametrize("testvalue", [
    "()()()()", "()(","()"
])

def test_matching_parentheses(testvalue):
    assert matching_parentheses((testvalue)), f" value : {testvalue} is incorrect"
    