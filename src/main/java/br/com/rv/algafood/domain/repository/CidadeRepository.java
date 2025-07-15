package br.com.rv.algafood.domain.repository;

import java.util.List;

import br.com.rv.algafood.domain.model.Cidade;

public interface CidadeRepository {
	
	List<Cidade> listar();
	List<Cidade> consultarPorNome(String nome);
	Cidade buscar(Long id);
	Cidade salvar(Cidade cidade);
	void remover(Long id);
	
	
}
