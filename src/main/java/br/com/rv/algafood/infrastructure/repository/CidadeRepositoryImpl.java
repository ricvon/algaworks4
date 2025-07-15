package br.com.rv.algafood.infrastructure.repository;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.rv.algafood.domain.model.Cidade;
import br.com.rv.algafood.domain.repository.CidadeRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Component
public class CidadeRepositoryImpl implements CidadeRepository{

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Cidade> listar(){
		//TypedQuery<Cidade> query = manager.createQuery("from Cidade", Cidade.class);
		//return query.getResultList();
		
		return manager.createQuery("from Cidade", Cidade.class)
				.getResultList();
	}
	
	@Override
	public List<Cidade> consultarPorNome(String nome) {
		return manager.createQuery("from Cidade where nome like :nome", Cidade.class)
				.setParameter("nome", "%" + nome + "%")
				.getResultList();
	}
	
	@Override
	public Cidade buscar(Long id) {
		return manager.find(Cidade.class, id);
	}
	
	@Transactional
	@Override
	public Cidade salvar(Cidade cidade) {
		return manager.merge(cidade);
	}
	
	@Transactional
	@Override
	public void remover(Long id) {
		
		Cidade cidade = buscar(id);
		
		if (cidade == null) {
			throw new EmptyResultDataAccessException(1); //esperava que tivesse uma Cidade
		}
		
		manager.remove(cidade);
		
	}
	

}
