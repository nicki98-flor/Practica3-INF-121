from typing import Generic, TypeVar, List

T = TypeVar('T')

class Catalogo(Generic[T]):
    def __init__(self):
        self.elementos: List[T] = []

    def agregar(self, elemento: T):
        self.elementos.append(elemento)

    def buscar(self, elemento: T) -> bool:
        return elemento in self.elementos

    def mostrar_catalogo(self):
        for e in self.elementos:
            print(e)

class Libro:
    def __init__(self, titulo: str, autor: str):
        self.titulo = titulo
        self.autor = autor

    def __eq__(self, other):
        return isinstance(other, Libro) and self.titulo == other.titulo and self.autor == other.autor

    def __hash__(self):
        return hash((self.titulo, self.autor))

    def __str__(self):
        return f"Libro: {self.titulo} - Autor: {self.autor}"

class Producto:
    def __init__(self, nombre: str, precio: float):
        self.nombre = nombre
        self.precio = precio

    def __eq__(self, other):
        return isinstance(other, Producto) and self.nombre == other.nombre and self.precio == other.precio

    def __hash__(self):
        return hash((self.nombre, self.precio))

    def __str__(self):
        return f"Producto: {self.nombre} - Precio: ${self.precio}"

# Prueba
if __name__ == "__main__":
    catalogo_libros = Catalogo[Libro]()
    libro1 = Libro("1984", "George Orwell")
    libro2 = Libro("El Principito", "Antoine de Saint-Exupery")
    catalogo_libros.agregar(libro1)
    catalogo_libros.agregar(libro2)

    print("Catálogo de libros:")
    catalogo_libros.mostrar_catalogo()
    print("¿Está '1984'?", catalogo_libros.buscar(Libro("1984", "George Orwell")))
    print()

    catalogo_productos = Catalogo[Producto]()
    prod1 = Producto("Laptop", 1200.50)
    prod2 = Producto("Mouse", 25.00)
    catalogo_productos.agregar(prod1)
    catalogo_productos.agregar(prod2)

    print("Catálogo de productos:")
    catalogo_productos.mostrar_catalogo()
    print("¿Está el Mouse?", catalogo_productos.buscar(Producto("Mouse", 25.00)))