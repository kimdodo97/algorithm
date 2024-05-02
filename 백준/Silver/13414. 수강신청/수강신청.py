import sys
n,m = map(int,sys.stdin.readline().split())
student_dict = {}

order = 0
for i in range(m):
    student = sys.stdin.readline().rstrip()
    student_dict[student] = i

students = list(student_dict.items())
students.sort(key=lambda x:x[1])

k = 0
for student in students:
    print(student[0])
    k += 1
    if k==n:
        break