package com.example.clinicaodontologica;

import com.example.clinicaodontologica.DAO.DomicilioDaoH2;
import com.example.clinicaodontologica.DAO.IDAO;
import com.example.clinicaodontologica.DAO.OdontologoDaoH2;
import com.example.clinicaodontologica.DAO.PacienteDaoH2;
import com.example.clinicaodontologica.domain.Domicilio;
import com.example.clinicaodontologica.domain.Odontologo;
import com.example.clinicaodontologica.domain.Paciente;
import com.example.clinicaodontologica.services.DomicilioService;
import com.example.clinicaodontologica.services.OdontologoService;
import com.example.clinicaodontologica.services.PacienteServices;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;
import java.util.Calendar;

@SpringBootApplication
public class ClinicaodontologicaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClinicaodontologicaApplication.class, args);

		IDAO<Paciente> pacienteDaoH2 = new PacienteDaoH2();

		PacienteServices pacienteServices = new PacienteServices(pacienteDaoH2);

		IDAO<Domicilio> domicilioDaoH2 = new DomicilioDaoH2();

		DomicilioService domicilioService = new DomicilioService(domicilioDaoH2);

		IDAO<Odontologo> odontologoDaoH2 = new OdontologoDaoH2();

		OdontologoService odontologoService = new OdontologoService(odontologoDaoH2);

		Domicilio domicilioUno = new Domicilio("New St", 919, "bismark", "otton");

		Paciente pacienteUno = new Paciente("Smith", "Carl", "carlsmith1@gmail.com", 4252552, new Date(1995, 2, 19), domicilioUno.getId());

		Odontologo odontologoUno = new Odontologo("Jackson", "James", 42425);

		domicilioService.guardarDomicilio(domicilioUno);
		pacienteServices.guardarPaciente(pacienteUno);
		odontologoService.guardarOdontologo(odontologoUno);
	}
}
