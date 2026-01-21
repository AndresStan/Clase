import tkinter
from tkinter import *

canvas = Canvas(width=640, height=480, bg="white")
canvas.pack(expand=YES, fill=BOTH)

points = [150, 100, 200, 120, 240, 180, 210, 200, 150, 150, 100, 200]
canvas.create_polygon(points,  outline="blue", fill="red", width=2)

mainloop()

