import tkinter
from tkinter import *

canvas = Canvas(width=1000, height=1000, bg="white")
canvas.pack(expand=YES, fill=BOTH)


canvas.create_text(500, 150, text="andres", fill="red", font=("Arial", 15))
canvas.create_oval(450, 200, 550, 300, fill="red")
canvas.create_polygon(450, 220,    500, 180,   550, 220, fill="lightblue", outline="black", width=2)
canvas.create_line(475, 240, 495, 240, fill="black")
canvas.create_line(505, 240, 525, 240, fill="black")
canvas.create_line(490, 265, 510, 265, fill="black")
mainloop()

