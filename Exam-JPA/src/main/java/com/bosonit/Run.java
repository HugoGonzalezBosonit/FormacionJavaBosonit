package com.bosonit;

import com.bosonit.cabecera.controller.dto.CabeceraFraInputDto;
import com.bosonit.cabecera.domain.CabeceraFra;
import com.bosonit.cabecera.repository.CabeceraFraRepository;
import com.bosonit.cliente.controller.dto.ClienteInputDto;
import com.bosonit.cliente.domain.Cliente;
import com.bosonit.cliente.repository.ClienteRepository;
import com.bosonit.linea.controller.dto.LineaFraInputDto;
import com.bosonit.linea.domain.LineaFra;
import com.bosonit.linea.repository.LineaFraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Run {

	public static void main(String[] args) {
		ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(Run.class, args);

		ClienteRepository clienteRepository = configurableApplicationContext.getBean(ClienteRepository.class);
		Cliente cliente = new Cliente("Hugo González");
		clienteRepository.save(cliente);

		CabeceraFraRepository cabeceraFraRepository= configurableApplicationContext.getBean(CabeceraFraRepository.class);
		CabeceraFra cabecera = new CabeceraFra(2, cliente);
		cabeceraFraRepository.save(cabecera);

		LineaFraRepository lineaFraRepository = configurableApplicationContext.getBean(LineaFraRepository.class);
		LineaFra lineaFra1 = new LineaFra("Coche", 24962, 1, cabecera);
		LineaFra lineaFra2 = new LineaFra("Moto", 12336, 1, cabecera);

		List<LineaFra> lineasFra = Arrays.asList(lineaFra1, lineaFra2);
		lineaFraRepository.saveAll(lineasFra);
	}
}
