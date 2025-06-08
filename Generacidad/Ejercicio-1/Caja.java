
class Caja<T> {
    private T contenido;

    public void guardar(T objeto) {
        this.contenido = objeto;
    }

    public T obtener() {
        return contenido;
    }

    public static void main(String[] args) {
        Caja<String> cajaTexto = new Caja<>();
        cajaTexto.guardar("Hola mundo");

        Caja<Integer> cajaNumero = new Caja<>();
        cajaNumero.guardar(123);

        System.out.println("Contenido de la caja de texto: " + cajaTexto.obtener());
        System.out.println("Contenido de la caja de número: " + cajaNumero.obtener());
    }
}