n = int(input())

dp = [0 for _ in range(10000001)]
for i in range(2, n + 1):
    dp[i] = dp[i - 1] + 1

    if i % 2 == 0:
        prev = i // 2
        dp[i] = min(dp[i], dp[prev] + 1)

    if i % 3 == 0:
        prev = i // 3
        dp[i] = min(dp[i], dp[prev] + 1)

print(dp[n])
