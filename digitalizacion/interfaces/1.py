import tkinter as tk
#from tkinter import ttk, Widget

root = tk.Tk()
root.title("Hola")
root.config(width=400, height=400)
label = tk.Label(text="Formulario Datos")

labelNombre = tk.Label(text="Nombre")
entryNombre = tk.Entry(width=40, bg="white", justify="center")

labelApellidos = tk.Label(text="Apellidos")
entryApellidos = tk.Entry(width=40, bg="white", justify="center")

labelEdad = tk.Label(text="Edad")
entryEdad = tk.Entry(width=40, bg="white", justify="center")

labelTelefono = tk.Label(text="Teléfono")
entryTelefono = tk.Entry(width=40, bg="white", justify="center")

label.grid(row=0, column=0, columnspan=2)

labelNombre.grid(row=1, column=0, padx=8, pady=10)
entryNombre.grid(row=1, column=1, padx=8, pady=10)

labelApellidos.grid(row=2, column=0, padx=8, pady=10)
entryApellidos.grid(row=2, column=1, padx=8, pady=10)

labelEdad.grid(row=3, column=0, padx=8, pady=10)
entryEdad.grid(row=3, column=1, padx=8, pady=10)

labelTelefono.grid(row=4, column=0, padx=8, pady=10)
entryTelefono.grid(row=4, column=1, padx=8, pady=10)



root.mainloop()
