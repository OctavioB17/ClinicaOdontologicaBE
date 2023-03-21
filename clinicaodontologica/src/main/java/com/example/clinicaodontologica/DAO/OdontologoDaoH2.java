package com.example.clinicaodontologica.DAO;

import com.example.clinicaodontologica.domain.Odontologo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDaoH2 extends DAOabstract implements IDAO<Odontologo>{
    private Connection connection = null;

    private PreparedStatement preparedStatement = null;
    @Override
    public Odontologo guardar(Odontologo odontologo) {
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            preparedStatement = connection.prepareStatement("INSERT INTO ODONTOLOGO (apellido,nombre,matricula) VALUES(?,?,?)");

            preparedStatement.setString(1, odontologo.getApellido());

            preparedStatement.setString(2, odontologo.getNombre());

            preparedStatement.setInt(3, odontologo.getMatricula());

            preparedStatement.executeUpdate();

            preparedStatement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return odontologo;
    }

    @Override
    public void eliminar(int id) {
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            preparedStatement = connection.prepareStatement("DELETE FROM ODONTOLOGO where id = ?");

            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Odontologo buscar(int id) {
        Odontologo odontologo = null;

        try {

            Class.forName(DB_JDBC_DRIVER);

            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);



            preparedStatement = connection.prepareStatement("SELECT id,nombre,apellido,matricula FROM ODONTOLOGO where id = ?");

            preparedStatement.setLong(1,id);


            ResultSet result = preparedStatement.executeQuery();


            while (result.next()) {

                int idOdontologo = result.getInt("id");

                String nombre = result.getString("nombre");

                String apellido = result.getString("apellido");

                int matricula = result.getInt("matricula");

                odontologo = new Odontologo(nombre, apellido, matricula);

            }

            preparedStatement.close();

        } catch (SQLException | ClassNotFoundException throwables) {

            throwables.printStackTrace();

        }



        return odontologo;
    }

    @Override
    public List<Odontologo> buscarTodos() {
        List<Odontologo> odontologo = new ArrayList<>();

        try {

            Class.forName(DB_JDBC_DRIVER);

            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            preparedStatement = connection.prepareStatement("SELECT *  FROM ODONTOLOGO");


            ResultSet result = preparedStatement.executeQuery();


            while (result.next()) {

                int idOdontologo = result.getInt("id");

                String nombre = result.getString("nombre");

                String apellido = result.getString("apellido");

                int matricula = result.getInt("matricula");

                odontologo.add(new Odontologo(nombre, apellido, matricula));

            }



            preparedStatement.close();

        } catch (SQLException | ClassNotFoundException throwables) {

            throwables.printStackTrace();

        }



        return odontologo;
    }
}
