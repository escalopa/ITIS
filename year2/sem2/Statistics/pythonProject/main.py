from termcolor import colored
import matplotlib.pyplot as plt
import numpy as np
import csv
import math

x = []
y = []
excel_file1 = 'EURCAD_180216_220216.csv'
excel_file2 = 'EURUSD_180216_220216.csv'


def read_files(file1, file2):
    with open(file1, newline='') as csvfile:
        data = csv.reader(csvfile, delimiter=',', quotechar='|')
        for row in data:
            x.append(float(row[0]))
    with open(file2, newline='') as csvfile:
        data = csv.reader(csvfile, delimiter=',', quotechar='|')
        for row in data:
            y.append(float(row[0]))


read_files(excel_file1, excel_file2)

print(colored('Задание 1,', 'green'))
print(colored('средние X: ', 'green'), np.mean(x))
print(colored('средние Y: ', 'green'), np.mean(y))
print(colored('дисперсии X: ', 'green'), np.var(x))
print(colored('дисперсии X: ', 'green'), np.var(x))
print(colored('средние квадратические отклонения X:', 'green'), np.std(x))
print(colored('средние квадратические отклонения Y:', 'green'), np.std(y))

print(colored('-------------------------------', 'blue'))
print(colored('Задание 2', 'green'))
print(colored('Гистограмма X', 'green'))
plt.hist(x, 10)
plt.show()

print(colored('Гистограмма X', 'green'))
plt.hist(y, 10)
plt.show()

print(colored('-------------------------------', 'blue'))
print(colored('Задание 3', 'green'))
print(colored('коэффициент корреляции X & Y: ', 'green'), np.corrcoef(x, y)[0][1])
print(colored('ковариацию X & Y: ', 'green'), np.cov(x, y)[0][1])
print(colored('-------------------------------', 'blue'))
