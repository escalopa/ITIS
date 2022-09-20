# java_1_course_in

# Домашние задания

## 01
Магазин работает с 8 до 17, обед с 12 до 13.
Пользователь вводит с клавиатуры время, нужно
вывести на экран "Работет.", если магазин работает.     // This paragraph is not counted because there is no free line above it
Если нет, вывести "Не работает.".
Если ввести неверные данные, сообщить об этом.

## 02

Написать простой калькулятор, пользователь вводит два вещественных числа и операцию.
Используя switch-case, вычислить результат и вывести на экран. Если пользователь ввел неверные данные, сообщить об этом.  // This paragraph is counted

wd <- getwd()
setwd(tempdir())
fn=tempfile()
fn.Rmd <- paste(fn, ".Rmd", sep="")  //This paragraph is counted
fn.md <- paste(fn, ".md", sep="")
fn.html <- paste(fn, "-out.html", sep="") 





## Write R Markdown into a file

cat(knitrRmd, file=fn.Rmd)
render_markdown()				//This paragraph is counted
knit(fn.Rmd, fn.md)
knit2html(fn.md)

## Open HTML file in browser

plot.gvis(fn.html)			//This paragraph is not counted because there is no free line under it