package com.example.clinicaodontologica.DAO;

import com.example.clinicaodontologica.domain.Domicilio;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DomicilioDaoH2 extends DAOabstract implements IDAO<Domicilio>{
    private Connection connection = null;

    private PreparedStatement preparedStatement = null;
    @Override
    public Domicilio guardar(Domicilio domicilio) {
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            preparedStatement = connection.prepareStatement("INSERT INTO DOMICILIO (calle,numero,localidad,provincia) VALUES(?,?,?,?)");

            preparedStatement.setString(1, domicilio.getCalle());

            preparedStatement.setInt(2, domicilio.getNumero());

            preparedStatement.setString(3, domicilio.getLocalidad());

            preparedStatement.setString(4, domicilio.getProvincia());

            preparedStatement.executeUpdate();

            preparedStatement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return domicilio;
    }

    @Override
    public void eliminar(int id) {
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            preparedStatement = connection.prepareStatement("DELETE FROM DOMICILIO where id = ?");

            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Domicilio buscar(int id) {
        Domicilio domicilio = null;

        try {

            Class.forName(DB_JDBC_DRIVER);

            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);



            preparedStatement = connection.prepareStatement("SELECT id,calle,numero,localidad,provincia FROM DOMICILIO where id = ?");

            preparedStatement.setInt(1,id);


            ResultSet result = preparedStatement.executeQuery();


            while (result.next()) {

                int idDomicilio = result.getInt("id");

                String calle = result.getString("calle");

                int numero = result.getInt("numero");

                String localidad = result.getString("localidad");

                String provincia = result.getString("provincia");

                domicilio = new Domicilio(calle, numero, localidad, provincia);

            }

            preparedStatement.close();

        } catch (SQLException | ClassNotFoundException throwables) {

            throwables.printStackTrace();

        }



        return domicilio;
    }

    @Override
    public List<Domicilio> buscarTodos() {
        List<Domicilio> domicilio = new ArrayList<>();

        try {

            Class.forName(DB_JDBC_DRIVER);

            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            preparedStatement = connection.prepareStatement("SELECT *  FROM DOMICILIO");


            ResultSet result = preparedStatement.executeQuery();


            while (result.next()) {

                int idDomicilio = result.getInt("id");

                String calle = result.getString("calle");

                int numero = result.getInt("numero");

                String localidad = result.getString("localidad");

                String provincia = result.getString("provincia");

                domicilio.add(new Domicilio(calle, numero, localidad, provincia));

            }



            preparedStatement.close();

        } catch (SQLException | ClassNotFoundException throwables) {

            throwables.printStackTrace();

        }



        return domicilio;
    }
}
