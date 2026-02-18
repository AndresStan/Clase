import tkinter as tk
from tkinter import ttk, Widget

root = tk.Tk()

root.title("Hola")

root.config(width=400, height=400, bg="green")
label = tk.Label(text="Hola", bg="red", fg="white")
entry = tk.Entry(width=40, bg="white", justify="center")
button1 = tk.Button(text="Boton 1")
button2 = tk.Button(text="Boton 1")
button3 = tk.Button(text="Boton 1")
button4 = tk.Button(text="Boton 1")

label.pack(padx=10, pady=10)
entry.pack(padx=10, pady=10)
button1.place(x=500, y=200, width=200, height=200)
button2.place(x=1000, y=200, width=200, height=200)
button3.place(x=500, y=600, width=200, height=200)
button4.place(x=1000, y=600, width=200, height=200)
root.mainloop()
