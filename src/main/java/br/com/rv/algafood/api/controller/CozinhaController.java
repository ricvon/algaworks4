package br.com.rv.algafood.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rv.algafood.api.model.CozinhasXmlWrapper;
import br.com.rv.algafood.domain.model.Cozinha;
import br.com.rv.algafood.domain.repository.CozinhaRepository;

//GET /cozinhas HTTP/1.1

@RestController
@RequestMapping("/cozinhas")
//@RequestMapping(value="/cozinhas", produces=MediaType.APPLICATION_JSON_VALUE)
public class CozinhaController {
	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	@GetMapping //(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})//produces="application/XML"
	public List<Cozinha> listar(){
		return cozinhaRepository.listar();
	}
	
	@GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
	public CozinhasXmlWrapper listarXml(){
		return new CozinhasXmlWrapper(cozinhaRepository.listar());
	}
	
//	@GetMapping("/{cozinhaId}")
//	public Cozinha buscar(@PathVariable("cozinhaId") Long id) {
//		return cozinhaRepository.buscar(id);
//	}
	
	@GetMapping("/{cozinhaId}")
	public ResponseEntity<Cozinha> buscar(@PathVariable("cozinhaId") Long id) {
		Cozinha cozinha = cozinhaRepository.buscar(id);
		//return ResponseEntity.status(HttpStatus.OK).body(cozinha);//com corpo
		//return ResponseEntity.status(HttpStatus.OK).build();//sem com corpo
		//return ResponseEntity.ok(cozinha);//com corpo shortcut
		//return ResponseEntity.ok();//sem corpo
		
//		HttpHeaders headers = new HttpHeaders();//retorno um local para redirecionamento
//		headers.add(HttpHeaders.LOCATION, "http://localhost:8090/cozinhas");
//		return ResponseEntity
//				.status(HttpStatus.FOUND)
//				.headers(headers)
//				.build();
		if (cozinha!=null) {
			return ResponseEntity.ok(cozinha);
		}
		return ResponseEntity.notFound().build();
	}
}
