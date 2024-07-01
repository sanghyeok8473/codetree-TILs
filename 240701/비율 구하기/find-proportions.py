from sortedcontainers import SortedDict

n = int(input())
sd = SortedDict()      # treemap

for _ in range(n):
    order = input()
    if order in sd:
        sd[order] += 1
    else:
        sd[order] = 1

for key in sd.keys():
    print("%s %.4f" % (key, (sd[key]/n)*100))