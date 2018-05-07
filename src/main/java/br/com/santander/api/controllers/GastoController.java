package br.com.santander.api.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.santander.api.documents.Gasto;
import br.com.santander.api.responses.Response;
import br.com.santander.api.services.GastoService;

@RestController
@RequestMapping(path = "/api/gastos")
public class GastoController {
	
	@Autowired
	private GastoService gastoService;
	
	@PostMapping
	public ResponseEntity<Response<Gasto>> cadastrar(@Valid @RequestBody Gasto gasto, BindingResult result) {
		if (result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Response<Gasto>(erros));
		}
		
		return ResponseEntity.ok(new Response<Gasto>(this.gastoService.cadastrar(gasto)));
	}

}
