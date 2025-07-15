package br.com.rv.algafood.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rv.algafood.domain.model.Cozinha;
import br.com.rv.algafood.domain.repository.CozinhaRepository;

//GET /cozinhas HTTP/1.1

@RestController
@RequestMapping("/cozinhas")
public class CozinhaController {
	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	@GetMapping
	public List<Cozinha> Listar(){
		return cozinhaRepository.listar();
	}
}
