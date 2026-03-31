def overlapping_intervals(interval1, interval2):
    left1, right1 = interval1
    left2, right2 = interval2

    return max(left1, left2) <= min(right1, right2)
