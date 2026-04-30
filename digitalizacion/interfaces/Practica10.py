import tkinter as tk
from tkinter import ttk, Widget
from dateutil.tz import win

root = tk.Tk()
root.title("Conversor de temperatura")
root.config(width=300, height=400)

entryVar = tk.DoubleVar()
farenheit = tk.DoubleVar()
kelvin = tk.DoubleVar()

def convertir():
    farenheit.set(entryVar.get()+273.15)
    kelvin.set(entryVar.get()*1.8+32)

label1 = tk.Label(root, text="Temperatura en ºC")
entrada=tk.Entry(root,textvariable=entryVar)
convertir = tk.Button(text="Convertir", command=convertir)
label2 = tk.Label(root, text="Temperatura en F:")
entrada1 = tk.Entry(root,textvariable=farenheit)
label3 = tk.Label(root, text="Temperatura en K:")
entrada2 = tk.Entry(root,textvariable=kelvin)


label1.grid(row=0, column=0, padx=10, pady=10)
entrada.grid(row=0, column=1, padx=10, pady=10)
convertir.grid(row=1, column=0, padx=10, pady=10)
label2.grid(row=2, column=0, padx=10, pady=10)
entrada1.grid(row=3, column=0, padx=10, pady=10)
label3.grid(row=4, column=0, padx=10, pady=10)
entrada2.grid(row=5, column=0, padx=10, pady=10)



root.mainloop()