package modelos;

public class Empleado {
    private String dni;
    private String empleo;
    private String nombre;
    private int horasSemanales;

    public Empleado() {
    }

    public Empleado(String dni, String empleo, String nombre, int horasSemanales) {
        this.dni = dni;
        this.empleo = empleo;
        this.nombre = nombre;
        this.horasSemanales = horasSemanales;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmpleo() {
        return empleo;
    }

    public void setEmpleo(String empleo) {
        this.empleo = empleo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHorasSemanales() {
        return horasSemanales;
    }

    public void setHorasSemanales(int horasSemanales) {
        this.horasSemanales = horasSemanales;
    }

    @Override
    public String toString() {
        return "DNI = " + dni + "\n"+
                "Empleo = " + empleo + "\n"+
                "Nombre = " + nombre + "\n"+
                "HorasSemanales = " + horasSemanales;
    }
}
