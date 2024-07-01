class Secret:
    def __init__(self, code, place, time):
        self.code = code
        self.place = place
        self.time = time

code, place, time = input().split()

secret1 = Secret(code, place, int(time))

print("secret code :", secret1.code)
print("meeting point :", secret1.place)
print("time :", secret1.time)