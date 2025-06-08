import java.util.*;

class ArchivoEmpleado{
    private String nomA;
    private List<Empleado> empleados;

    public ArchivoEmpleado(String n) 
    {
        this.nomA = n;
        this.empleados = new ArrayList<>();
    }

    public void crearArchivo() 
    {
        empleados.clear(); 
    }

    public void guardarEmpleado(Empleado e) 
    {
        empleados.add(e);
    }

    public Empleado buscaEmpleado(String n) 
    {
        for (Empleado e : empleados) 
        {
            if (e.getNombre().equalsIgnoreCase(n))
                return e;
        }
        return null; 
    }

    public Empleado mayorSalario(float s) 
    {
        for (Empleado e : empleados) 
        {
            if (e.getSalario() > s)
                return e;
        }
        return null;
    }

    public void mostrarEmpleados() 
    {
        for (Empleado e : empleados)
            System.out.println(e);
    }
}
class Empleado{
    private String nombre;
    private int edad;
    private float salario;

    public Empleado(String n, int e, float s) 
    {
        this.nombre = n;
        this.edad = e;
        this.salario = s;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public float getSalario() {
        return salario;
    }

    @Override
    public String toString() 
    {
        return "Empleado{" +"nombre='" + nombre + '\'' +", edad=" + edad +", salario=" + salario +'}';
    }
}
class Main {
    public static void main(String[] args) {
        ArchivoEmpleado archivo = new ArchivoEmpleado("Empleados2025");

        Empleado e1 = new Empleado("Carlos", 30, 1500f);
        Empleado e2 = new Empleado("Lucia", 28, 2000f);
        Empleado e3 = new Empleado("Pedro", 35, 1800f);

        archivo.guardarEmpleado(e1);
        archivo.guardarEmpleado(e2);
        archivo.guardarEmpleado(e3);

        System.out.println("Buscar 'Lucia':");
        Empleado encontrado = archivo.buscaEmpleado("Lucia");
        System.out.println(encontrado != null ? encontrado : "No encontrado");

        System.out.println("\nEmpleado con salario mayor a 1600:");
        Empleado mejorPagado = archivo.mayorSalario(1600f);
        System.out.println(mejorPagado != null ? mejorPagado : "Ninguno encontrado");
    }
}