package br.com.ambientinformatica.onzevencedor.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.ambientinformatica.onzevencedor.entity.Usuario;

@Repository("usuarioDao")
public class UsuarioDAO {
	@PersistenceContext
	protected EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Usuario> findAll() {
		String jpql = " SELECT c from Usuario c order by c.nome";
		Query query = entityManager.createQuery(jpql);
		List<Usuario> usuarios = (List<Usuario>) query.getResultList();
		return usuarios;
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Usuario> findByName(String nomeUsuario) {
		String jpql = " SELECT c from Usuario c where nome like :nome order by c.nome";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("nome", nomeUsuario + "%");
		List<Usuario> usuarios = (List<Usuario>) query.getResultList();
		return usuarios;
	}

	@Transactional
	public Usuario create(Usuario usuario) {
		entityManager.persist(usuario);
		return usuario;
	}

	@Transactional
	public void update(Usuario usuario) {
		entityManager.merge(usuario);
	}

	@Transactional
	public void delete(Usuario usuario) {
		usuario = entityManager.find(Usuario.class, usuario.getId());
		entityManager.remove(usuario);
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
}
