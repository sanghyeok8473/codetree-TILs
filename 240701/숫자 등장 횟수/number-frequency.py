n, m = map(int, input().split())

arr = list(map(int, input().split()))

nums = list(map(int, input().split()))

num_to_index = {}

for el in arr:
    if el in num_to_index:
        num_to_index[el] += 1
    else:
        num_to_index[el] = 0

for num in nums:
    if(num not in num_to_index):
        print(0, end = " ")
    else:
        print(num_to_index[num], end = " ")