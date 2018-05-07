package br.com.ambientinformatica.onzevencedor.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;

import br.com.ambientinformatica.onzevencedor.entity.Usuario;
import br.com.ambientinformatica.onzevencedor.service.UsuarioService;

@ManagedBean(name = "usuarioBean")
@ViewScoped
public class UsuarioBean extends BaseBean {

	private static final long serialVersionUID = 1L;
	@ManagedProperty("#{usuarioService}")
	private UsuarioService model;
	private Usuario usuario;
	private List<Usuario> usuarios;
	private String nomeUsuario;
	private boolean editMode;

	public Usuario getUsuario() {
		if (usuario == null) {
			usuario = new Usuario();
		}
		return usuario;
	}

	public void salvar() {
		System.out.println("id clube " + usuario.getId());
		if (usuario.getId() == null || usuario.getId().intValue() == 0) {
			usuario = model.createUsuario(usuario);
			usuario = new Usuario();
			addInfoMessage("Usuario criado com sucesso.");
		} else {
			model.updateUsuario(usuario);
			addInfoMessage("Usuario alterado com sucesso.");
		}
	}

	public void delete() {
		model.deleteUsuario(usuario);
		if (nomeUsuario != null && !nomeUsuario.isEmpty())
			usuario = (Usuario) model.getUsuariosByName(nomeUsuario);
		else
			usuarios = model.getAllUsuarios();
	}

	public void create() {
		this.usuario = new Usuario();
		this.editMode = true;
	}

	public void update() {
		this.editMode = true;
	}

	public void cancel() {
		this.editMode = false;
	}

	public void filtrarUsuario(AjaxBehaviorEvent event) {
		if (nomeUsuario != null && !nomeUsuario.isEmpty()) {
			usuarios = model.getUsuariosByName(nomeUsuario);
		} else {
			usuarios = model.getAllUsuarios();
		}
	}

	public List<Usuario> getUsuarios() {
		if (usuarios == null) {
			usuarios = model.getAllUsuarios();
		}
		return usuarios;
	}

	public UsuarioService getModel() {
		return model;
	}

	public void setModel(UsuarioService model) {
		this.model = model;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public boolean isEditMode() {
		return editMode;
	}

	public void setEditMode(boolean editMode) {
		this.editMode = editMode;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void setUsuario(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
}
