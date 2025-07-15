package br.com.rv.algafood.domain.repository;

import java.util.List;

import br.com.rv.algafood.domain.model.Estado;

public interface EstadoRepository {
	
	List<Estado> listar();
	List<Estado> consultarPorNome(String nome);
	Estado buscar(Long id);
	Estado salvar(Estado estado);
	void remover(Long id);
	
	
}
