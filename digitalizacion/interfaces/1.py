import tkinter as tk
from tkinter import ttk, Widget

root = tk.Tk()
root.title("Hola")
root.config(width=400, height=400)
label = tk.Label(text="Formulario Datos")

frame1 = tk.Frame(bg="red", width=200, height=200)
frame1.grid(row=0, column=0, padx=20,pady=20)
label1 = tk.Label(frame1, text="Nivel de estudios")
label1.place(x=50, y=50)
radiobutton1= ttk.Radiobutton(frame1, text="Estudios basicos")
radiobutton1.place(x=50, y=80)

radiobutton2= ttk.Radiobutton(frame1, text="Estudios medios")
radiobutton2.place(x=50, y=110)

radiobutton3= ttk.Radiobutton(frame1, text="Estudios avanzados")
radiobutton3.place(x=50, y=140)



frame2 = tk.Frame(bg="blue", width=200, height=200)
frame2.grid(row=0, column=1,padx=20,pady=20)
label2 = tk.Label(frame2, text="Aficiones")
label2.place(x=50, y=50)


frame3 = tk.Frame(bg="yellow", width=200, height=200)
frame3.grid(row=1, column=0,padx=20,pady=20)


frame4 = tk.Frame(bg="green", width=200, height=200)
frame4.grid(row=1, column=1,padx=20,pady=20)


root.mainloop()
