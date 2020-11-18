package com.api.rest.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.rest.model.Usuario;
import com.api.rest.repository.UsuarioRepository;

@Service
public class UsuarioService {

	private final UsuarioRepository usuarioRepository;

	@Autowired
	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	public Usuario salvar(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	public Iterable<Usuario> consultar() {
		return usuarioRepository.findAll();
	}

	public Optional<Usuario> consultarPorId(Long id) {
		return usuarioRepository.findById(id);
	}

	public void deletar(Long id) {
		usuarioRepository.deleteById(id);
	}
}