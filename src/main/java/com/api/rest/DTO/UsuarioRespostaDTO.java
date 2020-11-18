package com.api.rest.DTO;

import com.api.rest.model.Usuario;

public class UsuarioRespostaDTO {

	private Long id;
	private String nome;
	private String email;
	private Boolean admin;

	public UsuarioRespostaDTO(Long id, String nome, String email, boolean admin) {

		this.id = id;
		this.nome = nome;
		this.email = email;
		this.admin = admin;
	}

	public UsuarioRespostaDTO() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean isAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

	public static UsuarioRespostaDTO transformaEmDTO(Usuario usuario) {
		return new UsuarioRespostaDTO(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.isAdmin());
	}

}
