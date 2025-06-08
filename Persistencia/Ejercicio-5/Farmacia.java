import java.util.*;

class Medicamento {
    private String nombre;
    private int codMedicamento;
    private String tipo;
    private double precio;

    public Medicamento(String n, int c, String t, double p) 
    {
        this.nombre = n;
        this.codMedicamento = c;
        this.tipo = t;
        this.precio = p;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void mostrar() 
    {
        System.out.println("Medicamento: " + nombre + ", Codigo: " + codMedicamento +", Tipo: " + tipo + ", Precio: " + precio);
    }
}
class Farmacia{
    private String nombreFarmacia, direccion;
    private int sucursal, nroMedicamentos;
    private Medicamento[] m;

    public Farmacia(String n, int s, String d) 
    {
        this.nombreFarmacia = n;
        this.sucursal = s;
        this.direccion = d;
        this.m = new Medicamento[100];
        this.nroMedicamentos = 0;
    }

    public void agregarMedicamento(Medicamento med) 
    {
        if (nroMedicamentos < 100)
            m[nroMedicamentos++] = med;
    }

    public void mostrar() 
    {
        System.out.println("Farmacia: " + nombreFarmacia + ", Sucursal: " + sucursal +", Direccion: " + direccion);
    }

    public String getDireccion() {
        return direccion;
    }

    public int getSucursal() {
        return sucursal;
    }

    public void mostrarMedicamentosTos() 
    {
        for (int i = 0; i < nroMedicamentos; i++) 
        {
            if (m[i].getTipo().equalsIgnoreCase("Tos"))
                m[i].mostrar();
        }
    }

    public boolean buscaMedicamento(String nombre) 
    {
        for (int i = 0; i < nroMedicamentos; i++) 
        {
            if (m[i].getNombre().equalsIgnoreCase(nombre))
                return true;
        }
        return false;
    }
}
class ArchFarmacia{
    private String na;
    private List<Farmacia> farmacias;

    public ArchFarmacia(String na) 
    {
        this.na = na;
        this.farmacias = new ArrayList<>();
    }

    public void crearArchivo() 
    {
        farmacias.clear();
    }

    public void adicionar(Farmacia f) 
    {
        farmacias.add(f);
    }

    public void listar() 
    {
        for (Farmacia f : farmacias)
            f.mostrar();
    }

    public void mostrarMedicamentosTos(int sucursalX) 
    {
        for (Farmacia f : farmacias) 
        {
            if (f.getSucursal() == sucursalX) 
            {
                System.out.println("Medicamentos para la tos en sucursal " + sucursalX + ":");
                f.mostrarMedicamentosTos();
            }
        }
    }

    public void mostrarFarmaciaConMedicamento(String nombreMed) 
    {
        for (Farmacia f : farmacias) 
        {
            if (f.buscaMedicamento(nombreMed)) 
                System.out.println("Sucursal: " + f.getSucursal() +", Direccion: " + f.getDireccion());
        }
    }
}
class Main {
    public static void main(String[] args) {
        ArchFarmacia archivo = new ArchFarmacia("Farmacias");

        Medicamento med1 = new Medicamento("Golpex", 101, "Tos", 8.50);
        Medicamento med2 = new Medicamento("Paracetamol", 102, "Resfrío", 5.20);
        Medicamento med3 = new Medicamento("MielTos", 103, "Tos", 6.00);

        Farmacia f1 = new Farmacia("Farmacia Santa Cruz", 1, "Av. Libertad 123");
        f1.agregarMedicamento(med1);
        f1.agregarMedicamento(med2);

        Farmacia f2 = new Farmacia("Farmacia La Paz", 2, "Calle Murillo 456");
        f2.agregarMedicamento(med3);

        archivo.adicionar(f1);
        archivo.adicionar(f2);

        archivo.listar();

        archivo.mostrarMedicamentosTos(2);

        archivo.mostrarFarmaciaConMedicamento("Golpex");
    }
}