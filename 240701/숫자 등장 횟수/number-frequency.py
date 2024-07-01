n, m = map(int, input().split())

arr = list(map(int, input().split()))

nums = list(map(int, input().split()))

num_to_index = {}

for el in arr:
    num_to_index[el] = 0

for el in arr:
    num_to_index[el] += 1

for num in nums:
    if(num not in num_to_index):
        print(0, end = " ")
    else:
        print(num_to_index[num], end = " ")