import tkinter
from tkinter import *

canvas = Canvas(width=640, height=480, bg="white")
canvas.pack(expand=YES, fill=BOTH)

x1 = 290
y1 = 290

y2 = 20
x2 = 20


for i in range(14):

    if i % 2 == 0:
        color = "red"
    else:
        color = "white"

    canvas.create_oval(x1, y1, x2, y2, outline="black", fill=color, width=1)

    x1 = x1 - 10
    x2 = x2 + 10
    y1 = y1 - 10
    y2 = y2 + 10




mainloop()

