package br.com.rv.algafood.infrastructure.repository;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.rv.algafood.domain.model.Restaurante;
import br.com.rv.algafood.domain.repository.RestauranteRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Component
public class RestauranteRepositoryImpl implements RestauranteRepository{

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Restaurante> listar(){
		//TypedQuery<Restaurante> query = manager.createQuery("from Restaurante", Restaurante.class);
		//return query.getResultList();
		
		return manager.createQuery("from Restaurante", Restaurante.class)
				.getResultList();
	}
	
	@Override
	public List<Restaurante> consultarPorNome(String nome) {
		return manager.createQuery("from Restaurante where nome like :nome", Restaurante.class)
				.setParameter("nome", "%" + nome + "%")
				.getResultList();
	}
	
	@Override
	public Restaurante buscar(Long id) {
		return manager.find(Restaurante.class, id);
	}
	
	@Transactional
	@Override
	public Restaurante salvar(Restaurante Restaurante) {
		return manager.merge(Restaurante);
	}
	
	@Transactional
	@Override
	public void remover(Long id) {
		
		Restaurante Restaurante = buscar(id);
		
		if (Restaurante == null) {
			throw new EmptyResultDataAccessException(1); //esperava que tivesse uma Restaurante
		}
		
		manager.remove(Restaurante);
		
	}
	

}
