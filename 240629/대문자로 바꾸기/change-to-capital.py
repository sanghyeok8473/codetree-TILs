diff = ord('A') - ord('a')

for _ in range(5):
    arr = list(input().split())
    print("%s %s %s" %(chr(ord(arr[0]) + diff), chr(ord(arr[1]) + diff), chr(ord(arr[2]) + diff)))