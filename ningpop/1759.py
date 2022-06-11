# 2022.06.11
# 풀이 시간 34분 11초
# 채점 결과: 정답
# 시간복잡도: O(N)?
# 문제 링크: https://www.acmicpc.net/problem/1759

import sys
from itertools import combinations, product

input = sys.stdin.readline

l, c = map(int, input().split())
alphabet = list(input().rstrip().split())

vowels = []
consonants = []
for ch in alphabet:
    if ch in ('a', 'e', 'i', 'o', 'u'):
        vowels.append(ch)
    else:
        consonants.append(ch)

combis = []
vo, co = 1, l - 1
while 1 <= vo <= 5 and co >= 2:
    combis.append((vo, co))
    vo += 1
    co -= 1

result = []
for vo, co in combis:
    if len(vowels) < vo or len(consonants) < co:
        continue
    vowel = list(combinations(vowels, vo))
    consonant = list(combinations(consonants, co))
    result += list(product(vowel, consonant))

answer = []
for vowel, consonant in result:
    answer.append(''.join(sorted(list(vowel) + list(consonant))))

for i in sorted(answer):
    print(i)