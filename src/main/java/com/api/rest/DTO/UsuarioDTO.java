package com.api.rest.DTO;

import com.api.rest.model.Usuario;

public class UsuarioDTO {
	
	private String nome;
	private String email;
	
	public UsuarioDTO() {}
	
	public UsuarioDTO(Usuario usuario) {
		
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
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
	
	

}
