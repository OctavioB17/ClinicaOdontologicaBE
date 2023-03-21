package com.example.clinicaodontologica.DAO;

import com.example.clinicaodontologica.domain.Domicilio;
import com.example.clinicaodontologica.domain.Paciente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PacienteDaoH2 extends DAOabstract implements IDAO<Paciente>{

    private Connection connection = null;

    private PreparedStatement preparedStatement = null;
    @Override
    public Paciente guardar(Paciente paciente) {
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            preparedStatement = connection.prepareStatement("INSERT INTO PACIENTE(apellido,nombre,mail,dni,fechaIngreso,domicilio) VALUES(?,?,?,?,?,?)");

            preparedStatement.setString(1, paciente.getApellido());

            preparedStatement.setString(2, paciente.getNombre());

            preparedStatement.setString(3, paciente.getMail());

            preparedStatement.setInt(4, paciente.getDni());

            preparedStatement.setDate(5, paciente.getFechaIngreso());

            preparedStatement.setObject(6, paciente.getDomicilio());


            preparedStatement.executeUpdate();

            preparedStatement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return paciente;
    }

    @Override
    public void eliminar(int id) {
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            preparedStatement = connection.prepareStatement("DELETE FROM PACIENTE where id = ?");

            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Paciente buscar(int id) {
        Paciente paciente = null;

        try {

            Class.forName(DB_JDBC_DRIVER);

            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);



            preparedStatement = connection.prepareStatement("SELECT id,apellido,nombre,mail,dni,fechaIngreso,domicilio FROM PACIENTE where id = ?");

            preparedStatement.setInt(1,id);


            ResultSet result = preparedStatement.executeQuery();


            while (result.next()) {

                int idPaciente = result.getInt("id");

                String apellido = result.getString("apellido");

                String nombre = result.getString("nombre");

                String mail = result.getString("mail");

                int dni = result.getInt("dni");

                Date fechaIngreso = result.getDate("fechaIngreso");

                int domicilio = result.getInt("domicilio");

                paciente = new Paciente(apellido, nombre, mail, dni, fechaIngreso, domicilio);

            }

            preparedStatement.close();

        } catch (SQLException | ClassNotFoundException throwables) {

            throwables.printStackTrace();

        }



        return paciente;
    }

    @Override
    public List<Paciente> buscarTodos() {
        List<Paciente> paciente = new ArrayList<>();

        try {

            //1 Levantar el driver y Conectarnos

            Class.forName(DB_JDBC_DRIVER);

            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);



            //2 Crear una sentencia

            preparedStatement = connection.prepareStatement("SELECT *  FROM PACIENTE");



            //3 Ejecutar una sentencia SQL

            ResultSet result = preparedStatement.executeQuery();



            //4 Obtener resultados

            while (result.next()) {

                int idPaciente = result.getInt("id");

                String apellido = result.getString("apellido");

                String nombre = result.getString("nombre");

                String mail = result.getString("mail");

                int dni = result.getInt("dni");

                Date fechaIngreso = result.getDate("fechaIngreso");

                int domicilio = result.getInt("domicilio");

                paciente.add(new Paciente(apellido, nombre, mail, dni, fechaIngreso, domicilio));



            }



            preparedStatement.close();

        } catch (SQLException | ClassNotFoundException throwables) {

            throwables.printStackTrace();

        }



        return paciente;
    }
}
