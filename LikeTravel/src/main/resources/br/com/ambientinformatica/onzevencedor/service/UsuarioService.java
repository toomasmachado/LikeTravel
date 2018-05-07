package br.com.ambientinformatica.onzevencedor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ambientinformatica.onzevencedor.dao.UsuarioDAO;
import br.com.ambientinformatica.onzevencedor.entity.Usuario;

@Service("usuarioService")
public class UsuarioService {
	
	@Autowired
	private UsuarioDAO dao;

	public List<Usuario> getAllUsuarios() {
		System.out.println(dao.findAll());
		return dao.findAll();
	}

	public List<Usuario> getUsuariosByName(String nomeUsuario) {
		return dao.findByName(nomeUsuario);
	}

	public Usuario createUsuario(Usuario usuario) {
		return dao.create(usuario);
	}

	public void updateUsuario(Usuario usuario) {
		dao.update(usuario);
	}

	public void deleteUsuario(Usuario usuario) {
		dao.delete(usuario);
	}

	public void setDao(UsuarioDAO dao) {
		this.dao = dao;
	}
	
}
