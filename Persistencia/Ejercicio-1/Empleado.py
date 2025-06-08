class Empleado:
    def __init__(self, nombre: str, edad: int, salario: float):
        self._nombre = nombre
        self._edad = edad
        self._salario = salario
    def get_nombre(self):
        return self._nombre
    def get_edad(self):
        return self._edad
    def get_salario(self):
        return self._salario
    def __str__(self):
        return f"Empleado{{nombre='{self._nombre}', edad={self._edad}, salario={self._salario}}}"

class ArchivoEmpleado:
    def __init__(self, nomA: str):
        self.nomA = nomA
        self.empleados = []
    def crear_archivo(self):
        self.empleados.clear()
    def guardar_empleado(self, e: Empleado):
        self.empleados.append(e)
    def busca_empleado(self, nombre: str):
        for e in self.empleados:
            if e.get_nombre().lower() == nombre.lower():
                return e
        return None
    def mayor_salario(self, salario: float):
        for e in self.empleados:
            if e.get_salario() > salario:
                return e
        return None
    def mostrar_empleados(self):
        for e in self.empleados:
            print(e)

if __name__ == "__main__":
    archivo = ArchivoEmpleado("Empleados2025")

    e1 = Empleado("Carlos", 30, 1500.0)
    e2 = Empleado("Lucia", 28, 2000.0)
    e3 = Empleado("Pedro", 35, 1800.0)

    archivo.guardar_empleado(e1)
    archivo.guardar_empleado(e2)
    archivo.guardar_empleado(e3)

    print("Buscar 'Lucia':")
    encontrado = archivo.busca_empleado("Lucia")
    print(encontrado if encontrado else "No encontrado")

    print("\nEmpleado con salario mayor a 1600:")
    mejor_pagado = archivo.mayor_salario(1600.0)
    print(mejor_pagado if mejor_pagado else "Ninguno encontrado")