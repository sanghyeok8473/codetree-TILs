for _ in range(5):
    arr = list(input().split())
    print("%s %s %s" %(chr(ord(arr[0]) - 32), chr(ord(arr[1]) - 32), chr(ord(arr[2]) - 32)))