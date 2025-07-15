package br.com.rv.algafood.infrastructure.repository;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.rv.algafood.domain.model.FormaPagamento;
import br.com.rv.algafood.domain.repository.FormaPagamentoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Component
public class FormaPagamentoRepositoryImpl implements FormaPagamentoRepository{

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<FormaPagamento> listar(){
		//TypedQuery<FormaPagamento> query = manager.createQuery("from FormaPagamento", FormaPagamento.class);
		//return query.getResultList();
		
		return manager.createQuery("from FormaPagamento", FormaPagamento.class)
				.getResultList();
	}
	
	@Override
	public List<FormaPagamento> consultarPorNome(String descricao) {
		return manager.createQuery("from FormaPagamento where descricao like :descricao", FormaPagamento.class)
				.setParameter("descricao", "%" + descricao + "%")
				.getResultList();
	}
	
	@Override
	public FormaPagamento buscar(Long id) {
		return manager.find(FormaPagamento.class, id);
	}
	
	@Transactional
	@Override
	public FormaPagamento salvar(FormaPagamento formaPagamento) {
		return manager.merge(formaPagamento);
	}
	
	@Transactional
	@Override
	public void remover(Long id) {
		
		FormaPagamento formaPagamento = buscar(id);
		
		if (formaPagamento == null) {
			throw new EmptyResultDataAccessException(1); //esperava que tivesse uma FormaPagamento
		}
		
		manager.remove(formaPagamento);
		
	}
	

}
