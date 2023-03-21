package com.example.clinicaodontologica.services;

import com.example.clinicaodontologica.DAO.IDAO;
import com.example.clinicaodontologica.domain.Paciente;

import java.util.List;

public class PacienteServices {
    private IDAO<Paciente> pacienteDao;



    public PacienteServices(IDAO<Paciente> pacienteDao) {
        this.pacienteDao = pacienteDao;
    }

    public void setPacienteDao(IDAO<Paciente> pacienteDao) {
        this.pacienteDao = pacienteDao;

    }



    public Paciente guardarPaciente(Paciente paciente){

        pacienteDao.guardar(paciente);

        return paciente;

    }



    public void eliminarPaciente(int id){

        pacienteDao.eliminar(id);

    }

    public Paciente buscar(int id){

        return pacienteDao.buscar(id);

    }



    public List<Paciente> buscarTodos(){

        return pacienteDao.buscarTodos();

    }
}
