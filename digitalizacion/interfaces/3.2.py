class Coche:
    marca = "Toyota"

    def __init__(self, modelo):
        self.modelo = modelo

a = Coche("Corolla")
print(a.marca)
print(a.modelo)
