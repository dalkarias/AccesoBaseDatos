package controladores;

import modelos.Animal;
import modelos.Empleado;

import java.sql.*;
import java.util.ArrayList;

public class Controlador_MySql {
    // Herramientas para la gestión de la base de datos.

    private final String SERVER = "jdbc:mysql://localhost/granja";//conexion a la base de datos
    private final String USER = "root";
    private final String PASSWORD = "root";

    public Controlador_MySql() throws SQLException {
        inicializaTablas();
    }

    public Connection obtenerConexion() throws SQLException {
        return DriverManager.getConnection(SERVER, USER, PASSWORD);
    }

    private void inicializaTablas() throws SQLException {
        Connection conexion = obtenerConexion();
        String query ="create table if not exists" +Constantes.TABLA_ANIMALES+"(\n" +
                 Constantes.ID_ANIMAL+" int primary key ,\n" +
                 Constantes.TIPO + "varchar (40) not null,\n" +
                 Constantes.NOMBRE+ "varchar(40) not null,\n" +
                Constantes.COLOR + "varchar(10),\n" +
               Constantes.EDAD+"int not null,\n" +
               Constantes.NUM_ENFERMEDADES + "int not null\n" +
                ");";
        Statement stm = conexion.createStatement();
        stm.execute(query);
    }

    public int insertarAnimal(Animal animal, Connection conexion) throws SQLException {
        String query= "insert into "+Constantes.TABLA_ANIMALES+" values(?,?,?,?,?,?)";

        PreparedStatement pstm = conexion.prepareStatement(query);
        pstm.setInt(1,animal.getId());
        pstm.setString(2,animal.getTipo());
        pstm.setString(3,animal.getNombre());
        pstm.setString(4,animal.getColor());
        pstm.setInt(5,animal.getEdad());
        pstm.setInt(6,animal.getEnfermedades());

        return pstm.executeUpdate();
    }

    public Animal getAnimal(int idAnimal,Connection conexion) throws SQLException {
        String query="Select * from"+Constantes.TABLA_ANIMALES+" where id_animal = ? ";
        PreparedStatement pstm = conexion.prepareStatement(query);
        pstm.setInt(1,idAnimal);
        ResultSet rs = pstm.executeQuery();
        if(rs.next()){
            return new Animal(rs.getInt(Constantes.ID_ANIMAL),
                    rs.getString(Constantes.TIPO),
                    rs.getString(Constantes.NOMBRE),
                    rs.getString(Constantes.COLOR),
                    rs.getInt(Constantes.EDAD),
                    rs.getInt(Constantes.NUM_ENFERMEDADES)
                    );
        }
        return null;
    }

    //NUEVA CLASE 20/10

    public ArrayList<Animal> getAnimales(Connection connection) throws SQLException {
        ArrayList<Animal> animals = new ArrayList<>();
        String query = "Select * from "+Constantes.TABLA_ANIMALES;
        Statement stm = connection.createStatement();
        ResultSet rs = stm.executeQuery(query);

        while(rs.next()){
            animals.add(new Animal(rs.getInt(Constantes.ID_ANIMAL),
                    rs.getString(Constantes.TIPO),
                    rs.getString(Constantes.NOMBRE),
                    rs.getString(Constantes.COLOR),
                    rs.getInt(Constantes.EDAD),
                    rs.getInt(Constantes.NUM_ENFERMEDADES)
                    ));
        }

        return animals;
    }

    public boolean delteAnimal(Animal animal, Connection connection) throws SQLException {
        String query = "delete from "+Constantes.TABLA_ANIMALES+" where "+Constantes.TABLA_ANIMALES+" =?";
        PreparedStatement pstm = connection.prepareStatement(query);
        pstm.setInt(1, animal.getId());

        return pstm.executeUpdate() == 1;

    }

    public boolean updateAnimal (Animal animal,Connection connection) throws SQLException {
        String query = "update "+Constantes.TABLA_ANIMALES +" set " +
                Constantes.TIPO+"=?," +
                Constantes.NOMBRE+"=?," +
                Constantes.COLOR+"=?," +
                Constantes.EDAD+"=?," +
                Constantes.NUM_ENFERMEDADES+"=?"+
                " where "+Constantes.ID_ANIMAL+"=?;";
        PreparedStatement pstm = connection.prepareStatement(query);
        pstm.setString(1,animal.getTipo());
        pstm.setString(2, animal.getNombre());
        pstm.setString(3, animal.getColor());
        pstm.setInt(4, animal.getEdad());
        pstm.setInt(5, animal.getEnfermedades());
        pstm.setInt(6, animal.getId());

        return pstm.executeUpdate()==1;
    }

    public int updateEdades(int incremento, Connection connection) throws SQLException {
        String query = "update "+Constantes.TABLA_ANIMALES+" set "+Constantes.EDAD+" = "+Constantes.EDAD +"?;";
        PreparedStatement pstm = connection.prepareStatement(query);
        pstm.setInt(1, incremento);
        //dos maneras distintas de devolver la cantidad de filas
        int filas = pstm.executeUpdate();
        int otrasFilas = pstm.getUpdateCount();

        return filas;
    }

    //EJERCICIO

    public int addEmpleado (Empleado empleado, Connection connection) throws SQLException {
        String query = "insert into "+Constantes.TABLA_EMPLEADOS + " values(?,?,?,?);";
        PreparedStatement pstm = connection.prepareStatement(query);

        pstm.setString(1,empleado.getDni());
        pstm.setString(2,empleado.getEmpleo());
        pstm.setString(3,empleado.getNombre());
        pstm.setInt(4,empleado.getHorasSemanales());

        return pstm.executeUpdate();
    }

    

}
