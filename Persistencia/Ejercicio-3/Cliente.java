import java.util.*;

class ArchivoCliente {
    private String nomA;
    private List<Cliente> clientes;

    public ArchivoCliente(String nomA) 
    {
        this.nomA = nomA;
        this.clientes = new ArrayList<>();
    }

    public void crearArchivo() {
        clientes.clear(); 
    }

    public void guardaCliente(Cliente c) 
    {
        clientes.add(c);
    }

    public Cliente buscarCliente(int c) 
    {
        for (Cliente cliente : clientes) 
        {
            if (cliente.getId() == c)
                return cliente;
        }
        return null;
    }

    public Cliente buscarCelularCliente(int c) 
    {
        for (Cliente cliente : clientes) 
        {
            if (cliente.getId() == c) 
            {
                System.out.println("Teléfono del cliente: " + cliente.getTelefono());
                return cliente;
            }
        }
        return null;
    }
}
class Cliente{
    private int id, telefono;
    private String nombre;

    public Cliente(int i, String n, int t) 
    {
        this.id = i;
        this.nombre = n;
        this.telefono = t;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    @Override
    public String toString() 
    {
        return "Cliente{" +"id=" + id +", nombre='" + nombre + '\'' +", telefono=" + telefono +'}';
    }
}
class Main{
    public static void main(String[] args) {
        ArchivoCliente a1   = new ArchivoCliente("Clientes.txt");

        Cliente c1 = new Cliente(1, "Ana", 789456123);
        Cliente c2 = new Cliente(2, "Luis", 723456789);
        Cliente c3 = new Cliente(3, "Marta", 701112233);

        a1.guardaCliente(c1);
        a1.guardaCliente(c2);
        a1.guardaCliente(c3);
        Cliente encontrado = a1.buscarCliente(2);
        System.out.println(encontrado != null ? encontrado : "Cliente no encontrado");

        Cliente conTelefono = a1.buscarCelularCliente(3);
        System.out.println(conTelefono != null ? conTelefono : "Cliente no encontrado");
    }
}