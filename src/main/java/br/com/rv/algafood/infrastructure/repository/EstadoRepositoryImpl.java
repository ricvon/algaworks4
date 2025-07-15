package br.com.rv.algafood.infrastructure.repository;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.rv.algafood.domain.model.Estado;
import br.com.rv.algafood.domain.repository.EstadoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Component
public class EstadoRepositoryImpl implements EstadoRepository{

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Estado> listar(){
		//TypedQuery<Estado> query = manager.createQuery("from Estado", Estado.class);
		//return query.getResultList();
		
		return manager.createQuery("from Estado", Estado.class)
				.getResultList();
	}
	
	@Override
	public List<Estado> consultarPorNome(String nome) {
		return manager.createQuery("from Estado where nome like :nome", Estado.class)
				.setParameter("nome", "%" + nome + "%")
				.getResultList();
	}
	
	@Override
	public Estado buscar(Long id) {
		return manager.find(Estado.class, id);
	}
	
	@Transactional
	@Override
	public Estado salvar(Estado estado) {
		return manager.merge(estado);
	}
	
	@Transactional
	@Override
	public void remover(Long id) {
		
		Estado estado = buscar(id);
		
		if (estado == null) {
			throw new EmptyResultDataAccessException(1); //esperava que tivesse uma Estado
		}
		
		manager.remove(estado);
		
	}
	

}
