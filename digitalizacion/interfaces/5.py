import tkinter as tk
from tkinter import ttk, Widget

root = tk.Tk()
root.title("Saluda")
root.config(width=400, height=400)


boton1=tk.Button(text="Uno", command=lambda:labelVar.set("Uno"))
boton2=tk.Button(text="Dos", command=lambda:labelVar.set("Dos"))
labelVar = tk.StringVar()
label = tk.Label(textvariable=labelVar)



boton1.grid(row=0, column=0, padx=20,pady=20)
boton2.grid(row=0, column=1, padx=20,pady=20)
label.grid(row=1, column=0, padx=20,pady=20)

root.mainloop()
