from typing import Generic, TypeVar

T = TypeVar('T')

class Caja(Generic[T]):
    def __init__(self):
        self.contenido: T = None

    def guardar(self, objeto: T):
        self.contenido = objeto

    def obtener(self) -> T:
        return self.contenido

if __name__ == "__main__":
    caja_texto = Caja[str]()
    caja_texto.guardar("Hola mundo")

    caja_numero = Caja[int]()
    caja_numero.guardar(123)

    print("Contenido de la caja de texto:", caja_texto.obtener())
    print("Contenido de la caja de número:", caja_numero.obtener())