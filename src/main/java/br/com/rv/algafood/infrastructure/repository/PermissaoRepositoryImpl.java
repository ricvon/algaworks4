package br.com.rv.algafood.infrastructure.repository;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.rv.algafood.domain.model.Permissao;
import br.com.rv.algafood.domain.repository.PermissaoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Component
public class PermissaoRepositoryImpl implements PermissaoRepository{

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Permissao> listar(){
		//TypedQuery<Permissao> query = manager.createQuery("from Permissao", Permissao.class);
		//return query.getResultList();
		
		return manager.createQuery("from Permissao", Permissao.class)
				.getResultList();
	}
	
	@Override
	public List<Permissao> consultarPorNome(String nome) {
		return manager.createQuery("from Permissao where nome like :nome", Permissao.class)
				.setParameter("nome", "%" + nome + "%")
				.getResultList();
	}
	
	@Override
	public Permissao buscar(Long id) {
		return manager.find(Permissao.class, id);
	}
	
	@Transactional
	@Override
	public Permissao salvar(Permissao permissao) {
		return manager.merge(permissao);
	}
	
	@Transactional
	@Override
	public void remover(Long id) {
		
		Permissao permissao = buscar(id);
		
		if (permissao == null) {
			throw new EmptyResultDataAccessException(1); //esperava que tivesse uma Permissao
		}
		
		manager.remove(permissao);
		
	}
	

}
