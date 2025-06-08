class Cliente:
    def __init__(self, id: int, nombre: str, telefono: int):
        self._id = id
        self._nombre = nombre
        self._telefono = telefono
    def get_id(self):
        return self._id
    def get_nombre(self):
        return self._nombre
    def get_telefono(self):
        return self._telefono
    def __str__(self):
        return f"Cliente{{id={self._id}, nombre='{self._nombre}', telefono={self._telefono}}}"
class ArchivoCliente:
    def __init__(self, nomA: str):
        self.nomA = nomA
        self.clientes = []
    def crear_archivo(self):
        self.clientes.clear()
    def guarda_cliente(self, c: Cliente):
        self.clientes.append(c)
    def buscar_cliente(self, c: int):
        for cliente in self.clientes:
            if cliente.get_id() == c:
                return cliente
        return None
    def buscar_celular_cliente(self, c: int):
        for cliente in self.clientes:
            if cliente.get_id() == c:
                print("Teléfono del cliente:", cliente.get_telefono())
                return cliente
        return None
    
if __name__ == "__main__":
    a1 = ArchivoCliente("Clientes.txt")

    c1 = Cliente(1, "Ana", 789456123)
    c2 = Cliente(2, "Luis", 723456789)
    c3 = Cliente(3, "Marta", 701112233)

    a1.guarda_cliente(c1)
    a1.guarda_cliente(c2)
    a1.guarda_cliente(c3)

    encontrado = a1.buscar_cliente(2)
    print(encontrado if encontrado else "Cliente no encontrado")

    con_telefono = a1.buscar_celular_cliente(3)
    print(con_telefono if con_telefono else "Cliente no encontrado")