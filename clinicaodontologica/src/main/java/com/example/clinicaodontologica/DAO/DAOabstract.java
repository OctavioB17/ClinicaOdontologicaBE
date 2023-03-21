package com.example.clinicaodontologica.DAO;

import com.example.clinicaodontologica.domain.Paciente;

public abstract class DAOabstract{

    protected final static String DB_JDBC_DRIVER = "org.h2.Driver";

    protected final static String DB_URL = "jdbc:h2:~/clinicaOdontologica;INIT=RUNSCRIPT FROM 'src/main/resources/script.sql'";

    protected final static String DB_USER ="sa";

    protected final static String DB_PASSWORD = "";
}
