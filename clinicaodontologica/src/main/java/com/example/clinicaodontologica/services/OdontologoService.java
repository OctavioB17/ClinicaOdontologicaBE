package com.example.clinicaodontologica.services;

import com.example.clinicaodontologica.DAO.IDAO;
import com.example.clinicaodontologica.domain.Odontologo;

import java.util.List;

public class OdontologoService {
    private IDAO<Odontologo> odontologoDao;


    public OdontologoService() {



    }



    public OdontologoService( IDAO<Odontologo> odontologoDao) {

        this.odontologoDao = odontologoDao;

    }



    public void setOdontologoDao( IDAO<Odontologo> odontologoDao) {

        this.odontologoDao = odontologoDao;

    }



    public Odontologo guardarOdontologo(Odontologo odontologo){

        odontologoDao.guardar(odontologo);

        return odontologo;

    }



    public void eliminarOdontologo(int id){

        odontologoDao.eliminar(id);

    }

    public Odontologo buscar(int id){

        return odontologoDao.buscar(id);

    }



    public List<Odontologo> buscarTodos(){

        return odontologoDao.buscarTodos();

    }
}
