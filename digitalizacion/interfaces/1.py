import tkinter as tk
from tkinter import ttk, Widget



root = tk.Tk()
root.title("Hola")
root.config(width=400, height=400)
label = tk.Label(text="Formulario Datos")

nivel = tk.BooleanVar(value=False)
frame1 = tk.Frame(bg="red", width=200, height=200)
frame1.grid(row=0, column=0, padx=20,pady=20)
label1 = tk.Label(frame1, text="Nivel de estudios")
label1.place(x=50, y=50)
radiobutton1= ttk.Radiobutton(frame1, text="Estudios basicos", value=1, variable=nivel)
radiobutton1.place(x=50, y=80)

radiobutton2= ttk.Radiobutton(frame1, text="Estudios medios", value=2, variable=nivel)
radiobutton2.place(x=50, y=110)

radiobutton3= ttk.Radiobutton(frame1, text="Estudios avanzados", value=3, variable=nivel)
radiobutton3.place(x=50, y=140)


aficiones = tk.BooleanVar(value=False)
frame2 = tk.Frame(bg="blue", width=200, height=200)
frame2.grid(row=0, column=1,padx=20,pady=20)
label2 = tk.Label(frame2, text="Aficiones")
label2.place(x=50, y=50)
radiobutton11= ttk.Radiobutton(frame2, text="Cine", value=1, variable=aficiones)
radiobutton11.place(x=50, y=80)

radiobutton22= ttk.Radiobutton(frame2, text="Viajes", value=2, variable=aficiones)
radiobutton22.place(x=50, y=110)

radiobutton33= ttk.Radiobutton(frame2, text="Deporte", value=3, variable=aficiones)
radiobutton33.place(x=50, y=140)


sexo = tk.BooleanVar(value=False)
frame3 = tk.Frame(bg="yellow", width=200, height=200)
frame3.grid(row=1, column=0,padx=20,pady=20)
label3 = tk.Label(frame3, text="Sexo:")
label3.place(x=50, y=50)
radiobutton111= ttk.Radiobutton(frame3, value=1, text="Hombre", variable=sexo)
radiobutton111.place(x=50, y=80)

radiobutton222= ttk.Radiobutton(frame3, value=2,text="Mujer", variable=sexo)
radiobutton222.place(x=50, y=110)


dias = tk.BooleanVar(value=False)
frame4 = tk.Frame(bg="green", width=200, height=200)
frame4.grid(row=1, column=1,padx=20,pady=20)
label4 = tk.Label(frame4, text="Días disponibles")
label4.place(x=50, y=50)
radiobutton1111= ttk.Radiobutton(frame4, text="Lunes", value=1, variable=dias)
radiobutton1111.place(x=50, y=80)

radiobutton2222= ttk.Radiobutton(frame4, text="Miercoles", value=2, variable=dias)
radiobutton2222.place(x=50, y=110)

radiobutton3333= ttk.Radiobutton(frame4, text="Viernes", value=3, variable=dias)
radiobutton3333.place(x=50, y=140)



root.mainloop()
