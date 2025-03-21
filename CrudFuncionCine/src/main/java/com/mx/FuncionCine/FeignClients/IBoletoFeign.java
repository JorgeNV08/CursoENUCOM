package com.mx.FuncionCine.FeignClients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.mx.FuncionCine.Models.Sala;

@FeignClient(
		name = "CrudSalaCineBoleto",
		url = "http://localhost:8002",
		path = "/Sala"
		)

public interface IBoletoFeign {
	@GetMapping("/listar")
	public List<Sala> getSalaCine();
}
