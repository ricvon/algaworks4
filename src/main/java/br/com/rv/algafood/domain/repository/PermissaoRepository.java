package br.com.rv.algafood.domain.repository;

import java.util.List;

import br.com.rv.algafood.domain.model.Permissao;

public interface PermissaoRepository {
	
	List<Permissao> listar();
	List<Permissao> consultarPorNome(String nome);
	Permissao buscar(Long id);
	Permissao salvar(Permissao permissao);
	void remover(Long id);
	
	
}
