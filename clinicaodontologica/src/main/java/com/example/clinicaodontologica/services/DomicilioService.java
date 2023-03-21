package com.example.clinicaodontologica.services;

import com.example.clinicaodontologica.DAO.IDAO;
import com.example.clinicaodontologica.domain.Domicilio;

import java.util.List;

public class DomicilioService {
    private IDAO<Domicilio> domicilioDao;


    public DomicilioService() {



    }



    public DomicilioService( IDAO<Domicilio> domicilioDao) {

        this.domicilioDao = domicilioDao;

    }



    public void setDomicilioDao( IDAO<Domicilio> domicilioDao) {

        this.domicilioDao = domicilioDao;

    }



    public Domicilio guardarDomicilio(Domicilio domicilio){

        domicilioDao.guardar(domicilio);

        return domicilio;

    }



    public void eliminarDomicilio(int id){

        domicilioDao.eliminar(id);

    }

    public Domicilio buscar(int id){

        return domicilioDao.buscar(id);

    }



    public List<Domicilio> buscarTodos(){

        return domicilioDao.buscarTodos();

    }
}
