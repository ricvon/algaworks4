package br.com.rv.algafood.domain.repository;

import java.util.List;

import br.com.rv.algafood.domain.model.FormaPagamento;

public interface FormaPagamentoRepository {
	
	List<FormaPagamento> listar();
	List<FormaPagamento> consultarPorNome(String descricao);
	FormaPagamento buscar(Long id);
	FormaPagamento salvar(FormaPagamento formaPagamento);
	void remover(Long id);
	
	
}
