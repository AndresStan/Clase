import random
import tkinter as tk
from tkinter import ttk, Widget

root = tk.Tk()
root.title("Adivina")
root.config(width=400, height=400)

def generar():
    return random.randint(1,10)

n1 = tk.IntVar(value=generar())

def win():
    if entryVar.get() == n1.get():
        labelVar.set("Ganado!!")
        boton2.grid(row=1, column=1, padx=20, pady=20)
def rei():
    n1.set(generar())
    boton2.grid_remove()
    labelVar.set(" ")

entryVar = tk.IntVar()
labelVar = tk.StringVar()

entrada=tk.Entry(root,textvariable=entryVar)

boton1=tk.Button(text="Comprobar", command=win)
boton2=tk.Button(text="Reiniciar", command=rei)
label = tk.Label(textvariable=labelVar)


entrada.grid(row=0,column=0, padx=20,pady=20)
boton1.grid(row=1, column=0, padx=20,pady=20)
label.grid(row=2, column=0, padx=20,pady=20)

root.mainloop()
