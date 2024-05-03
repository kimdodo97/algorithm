import itertools
import sys

n,m = map(int,sys.stdin.readline().split())
cards = list(map(int,sys.stdin.readline().split()))

card_pers = list(itertools.permutations(cards,3))

max_value = sys.maxsize
result = 0
for card_per in card_pers:
    sum_value = sum(card_per)
    diff = m - sum_value
    if (diff <= max_value) and diff >= 0:
        max_value = diff
        result = sum_value
print(result)