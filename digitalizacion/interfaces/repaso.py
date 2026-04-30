import tkinter as tk
from tkinter import ttk, Widget, Radiobutton, BooleanVar

root = tk.Tk()
root.title("Repaso")
root.config(width=400, height=400)

# DOS CUADRADOS AL LADO DE DIFERENTE COLOR , 1º 2 RADIOBUTTONS, 2º ADIVINAR NUMERO, 3º responder con nombre

frame1 = tk.Frame(bg="red", width=100, height=100)
frame1.grid(row=0, column=0, padx=10, pady=10)

nivel = tk.BooleanVar()

RadiobuttonH = ttk.Radiobutton(frame1, text="Hombre", variable=nivel, value=1)
RadiobuttonM = ttk.Radiobutton(frame1, text="Mujer", variable=nivel, value=2)
RadiobuttonH.grid(row=0, column=0, padx=10, pady=10)
RadiobuttonM.grid(row=1, column=0, padx=10, pady=10)



frame2 = tk.Frame(bg="blue", width=100, height=100)
frame2.grid(row=0, column=1, padx=10, pady=10)

frame3 = tk.Frame(bg="green", width=100, height=100)
frame3.grid(row=1, column=0, padx=10, pady=10)

frame4 = tk.Frame(bg="yellow", width=100, height=100)
frame4.grid(row=1, column=1, padx=10, pady=10)
root.mainloop()


