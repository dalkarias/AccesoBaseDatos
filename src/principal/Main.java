package principal;

import controladores.Controlador_MySql;
import modelos.Animal;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            Controlador_MySql controlador = new Controlador_MySql();
            Animal animal  = new Animal(1,"Anfibio","nemo","naranja",1,1);
            Connection conexion = controlador.obtenerConexion();
            System.out.println(controlador.getAnimal(1,conexion));
        } catch (SQLException e) {
        e.getLocalizedMessage();
        }
    }
}
