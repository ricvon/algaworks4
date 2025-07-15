package br.com.rv.algafood.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import br.com.rv.algafood.AlgafoodApi3Application;
import br.com.rv.algafood.domain.model.Estado;
import br.com.rv.algafood.domain.repository.EstadoRepository;


public class ConsultaEstadoMain {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApi3Application.class)
				.web(WebApplicationType.NONE)
				.run(args);
		EstadoRepository estadoRepository = applicationContext.getBean(EstadoRepository.class);
		List<Estado> estados = estadoRepository.listar();
		for (Estado estado : estados) {
			System.out.printf("%s - %s\n", estado.getId(), estado.getNome());
		}
	}
}
