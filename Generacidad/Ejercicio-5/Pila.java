import java.util.*;

class Pila <T>{
    private List<T> elementos;

    public Pila() 
    {
        elementos = new ArrayList<>();
    }

    public void apilar(T elemento) 
    {
        elementos.add(elemento);
    }

    public T desapilar() 
    {
        if (estaVacia())
            return null; 
        return elementos.remove(elementos.size() - 1);
    }

    public boolean estaVacia() 
    {
        return elementos.isEmpty();
    }

    public void mostrarPila() 
    {
        System.out.println("Contenido de la pila (de abajo hacia arriba):");
        for (T e : elementos)
            System.out.println(e);
    }
}