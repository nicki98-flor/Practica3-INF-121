import java.util.*;

class Catalogo<T> {
    private List<T> elementos;

    public Catalogo() {
        elementos = new ArrayList<>();
    }

    public void agregar(T elemento) 
    {
        elementos.add(elemento);
    }

    public boolean buscar(T elemento) 
    {
        return elementos.contains(elemento);
    }

    public void mostrarCatalogo() 
    {
        for (T e : elementos)
            System.out.println(e);
    }
}
class Libro {
    private String titulo, autor;

    public Libro(String t, String a) 
    {
        this.titulo = t;
        this.autor = a;
    }

    @Override
    public String toString() 
    {
        return "Libro: " + titulo + " - Autor: " + autor;
    }

    @Override
    public boolean equals(Object obj) 
    {
        if (this == obj) 
            return true;
        if (!(obj instanceof Libro)) 
            return false;
        Libro otro = (Libro) obj;
        return this.titulo.equals(otro.titulo) && this.autor.equals(otro.autor);
    }

    @Override
    public int hashCode() 
    {
        return titulo.hashCode() + autor.hashCode();
    }
}
class Producto {
    private String nombre;
    private double precio;

    public Producto(String n, double p) 
    {
        this.nombre = n;
        this.precio = p;
    }

    @Override
    public String toString()
    {
        return "Producto: " + nombre + " - Precio: $" + precio;
    }

    @Override
    public boolean equals(Object obj) 
    {
        if (this == obj) 
            return true;
        if (!(obj instanceof Producto)) 
            return false;
        Producto otro = (Producto) obj;
        return this.nombre.equals(otro.nombre) && this.precio == otro.precio;
    }

    @Override
    public int hashCode() 
    {
        return nombre.hashCode() + Double.valueOf(precio).hashCode();
    }
}
class Main {
    public static void main(String[] args) {
        Catalogo<Libro> catalogoLibros = new Catalogo<>();
        Libro libro1 = new Libro("1984", "George Orwell");
        Libro libro2 = new Libro("El Principito", "Antoine de Saint-Exupery");
        catalogoLibros.agregar(libro1);
        catalogoLibros.agregar(libro2);

        System.out.println("Catalogo de libros:");
        catalogoLibros.mostrarCatalogo();

        System.out.println("¿Esta '1984'? " + catalogoLibros.buscar(new Libro("1984", "George Orwell")));
        System.out.println();

        Catalogo<Producto> catalogoProductos = new Catalogo<>();
        Producto prod1 = new Producto("Laptop", 1200.50);
        Producto prod2 = new Producto("Mouse", 25.00);
        catalogoProductos.agregar(prod1);
        catalogoProductos.agregar(prod2);

        System.out.println("Catalogo de productos:");
        catalogoProductos.mostrarCatalogo();

        System.out.println("¿Esta el Mouse? " + catalogoProductos.buscar(new Producto("Mouse", 25.00)));
    }
}