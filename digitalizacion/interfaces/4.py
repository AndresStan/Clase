import tkinter as tk
from tkinter import ttk, Widget

root = tk.Tk()
root.title("Saluda")
root.config(width=400, height=400)
def salu():
    labelVar.set("Salu")

boton=tk.Button(text="Saluda", command=salu)
labelVar = tk.StringVar()
label = tk.Label(textvariable=labelVar)



boton.grid(row=0, column=0, padx=20,pady=20)
label.grid(row=1, column=0, padx=20,pady=20)

root.mainloop()
