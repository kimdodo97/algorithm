def bnp(amount, chart):
  cash = amount
  stock = 0
  for i in range(len(chart)):
    avalibale_stock = cash // chart[i]
    if avalibale_stock > 0:
      stock = avalibale_stock
      cash -= stock * chart[i]

  return stock * chart[-1] + cash


def timing(amount, chart):
  stock = 0
  cash = amount
  up_cnt = 0
  down_cnt = 0
  for i in range(1, len(chart)):
    if (chart[i - 1] < chart[i]):
      up_cnt += 1
    else:
      up_cnt = 0

    if (chart[i - 1] >= chart[i]):
      down_cnt += 1
    else:
      down_cnt = 0

    if (up_cnt >= 3 and stock > 0):
      cash = stock * chart[i]
      stock = 0
      up_cnt = 0

    if (down_cnt >= 3):
      avalibale_stock = cash // chart[i]
      if avalibale_stock > 0:
        stock += avalibale_stock
        cash -= stock * chart[i]
        down_cnt = 0

  return stock * chart[-1] + cash


amount = int(input())
chart = list(map(int, input().split()))
bnp_result = bnp(amount, chart)
timing_result = timing(amount, chart)

if(bnp_result > timing_result):
  print("BNP")
elif(timing_result > bnp_result):
  print("TIMING")
else:
  print("SAMESAME")