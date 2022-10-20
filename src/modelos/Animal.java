package modelos;

public class Animal {
    private int id;
    private String tipo;
    private String nombre;
    private String color;
    private int edad;
    private int enfermedades;

    public Animal(int id, String tipo, String nombre, int edad, int enfermedades) {
        this.id = id;
        this.tipo = tipo;
        this.nombre = nombre;
        this.edad = edad;
        this.enfermedades = enfermedades;
    }

    public Animal(int id, String tipo, String nombre, String color, int edad, int enfermedades) {
        this.id = id;
        this.tipo = tipo;
        this.nombre = nombre;
        this.color = color;
        this.edad = edad;
        this.enfermedades = enfermedades;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getEnfermedades() {
        return enfermedades;
    }

    public void setEnfermedades(int enfermedades) {
        this.enfermedades = enfermedades;
    }

    @Override
    public String toString() {
        return  "id=" + id +
                ", tipo='" + tipo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", color='" + color + '\'' +
                ", edad=" + edad +
                ", enfermedades=" + enfermedades +
                '}';
    }
}
