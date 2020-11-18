package com.api.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.rest.DTO.UsuarioDTO;
import com.api.rest.DTO.UsuarioRespostaDTO;
import com.api.rest.model.Usuario;
import com.api.rest.service.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {

	private final UsuarioService usuarioService;

	@Autowired
	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	@PostMapping
	public ResponseEntity<UsuarioRespostaDTO> salvar(@RequestBody UsuarioDTO usuarioDTO) {
		Usuario usuarioSalvo = usuarioService.salvar(usuarioDTO.transformaParaObjeto());
		return new ResponseEntity<>(UsuarioRespostaDTO.transformaEmDTO(usuarioSalvo), HttpStatus.CREATED);
	}

	/*
	 * TODO
	 *
	 * Realizar busca sem retornar senha
	 *
	 */
	// Consultar pelo id.
	@GetMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<Usuario> consultarPorId(@PathVariable(value = "id") Long id) {

		Optional<Usuario> usuario = usuarioService.consultarPorId(id);

		return new ResponseEntity<Usuario>(usuario.get(), HttpStatus.OK);
	}

	/*
	 * TODO
	 *
	 * Realizar busca sem retornar senha
	 *
	 */
	// Consultar todos.
	@GetMapping(value = "/", produces = "application/json")
	public ResponseEntity<List<Usuario>> consultar() {
		List<Usuario> lista = (List<Usuario>) usuarioService.consultar();

		return new ResponseEntity<List<Usuario>>(lista, HttpStatus.OK);
	}

	// Remover pelo id
	@DeleteMapping(value = "/{id}")
	public void deletar(@PathVariable("id") Long id) {

		usuarioService.deletar(id);

	}

	@PutMapping("/{id}")
	public ResponseEntity<Usuario> atualizar(@PathVariable Long id, @RequestBody Usuario usuario) {
		Usuario usuarioExistente = usuarioService.consultarPorId(id).get();
		if (usuarioExistente == null) {
			return ResponseEntity.notFound().build();
		}

		BeanUtils.copyProperties(usuario, usuarioExistente, "id");
		usuarioExistente = usuarioService.salvar(usuarioExistente);
		return ResponseEntity.ok(usuarioExistente);

	}

}
