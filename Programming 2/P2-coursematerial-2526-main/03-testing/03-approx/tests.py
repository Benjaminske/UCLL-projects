import pytest
from pytest import approx
from mystatistics import average

@pytest.mark.parametrize("ns, expected",  [
    ([10, 2, 30], 14),
    ([1, 2, 3], 2),
    ([4, 1, 7], 4),
    ([000.1, 000.1, 000.1], 000.1)


])

def test_average(ns, expected):
        assert approx(average(ns)) == expected
   