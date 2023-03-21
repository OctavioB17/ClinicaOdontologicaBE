package com.example.clinicaodontologica.DAO;

import com.example.clinicaodontologica.domain.Paciente;

import java.util.List;

public interface IDAO <T>{
    T guardar (T t);
    void eliminar (int t);
    T buscar(int id);
    List<T> buscarTodos();
}
