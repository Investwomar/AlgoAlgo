def JobSequence(arr):
    u_times = set(i[1] for i in arr)

    job_profit = [0] * len(u_times)

    sorting(arr)

    x = 0
    for i in u_times:
        for j in range(len(arr)):  # To Zero Index
            if arr[j][1] != i: continue
            job_profit[x] = arr[j][2]
            break
        x += 1

    return len(u_times), sum(job_profit)

def sorting(arr):
    n = len(arr)
    for i in range(1, n):
        key = arr[i]
        j = i - 1
        while j >= 0 and arr[j][2] < key[2]:  # Compare in reverse order
            arr[j + 1] = arr[j]
            j -= 1
        arr[j + 1] = key

print(JobSequence([[1,4,20], [2,1,10], [3,1,40], [4,1,30]]))
