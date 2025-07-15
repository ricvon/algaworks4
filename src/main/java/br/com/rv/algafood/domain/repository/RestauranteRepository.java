package br.com.rv.algafood.domain.repository;

import java.util.List;

import br.com.rv.algafood.domain.model.Restaurante;



public interface RestauranteRepository {
	
	List<Restaurante> listar();
	List<Restaurante> consultarPorNome(String nome);
	Restaurante buscar(Long id);
	Restaurante salvar(Restaurante restaurante);
	void remover(Long id);
	
	
}
