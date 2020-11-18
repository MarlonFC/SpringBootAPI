package com.api.rest.controller;

import java.util.List;


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


import com.api.rest.model.Usuario;
import com.api.rest.repository.UsuarioRepository;



	
@RestController
@RequestMapping(value = "/usuario")
public class IndexController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	//Salvando um objeto
	@PostMapping(value = "/", produces = "application/json")
	public ResponseEntity<Usuario> cadastrar(@RequestBody Usuario usuario){
		Usuario usuarioSalvo = usuarioRepository.save(usuario);
		return new ResponseEntity<Usuario>(usuarioSalvo, HttpStatus.OK);
	}

	//Consultar pelo id.
	@GetMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<Usuario> init (@PathVariable(value = "id") Long id) {
		
		
		java.util.Optional<Usuario> usuario = usuarioRepository.findById(id);
		
		return new ResponseEntity<Usuario>(usuario.get(), HttpStatus.OK);
	}
	
	//Consultar todos.
	@GetMapping(value = "/", produces = "application/json")
	public ResponseEntity<List<Usuario>> usuarios(){
		List<Usuario> lista = (List<Usuario>) usuarioRepository.findAll();
		
		return new ResponseEntity<List<Usuario>>(lista, HttpStatus.OK);
	}
	
	//Remover pelo id
	@DeleteMapping(value = "/{id}")
	public void deletar(@PathVariable("id") Long id){
		
		usuarioRepository.deleteById(id);
		
		
	}
	

	
	@PutMapping("/{id}") public ResponseEntity<Usuario> atualizar(@PathVariable Long id,  @RequestBody Usuario usuario)
	{ 
		Usuario usuarioExistente = usuarioRepository.findById(id).get();
		if(usuarioExistente == null){
			return ResponseEntity.notFound().build();
		}
		
		BeanUtils.copyProperties(usuario, usuarioExistente, "id");
		usuarioExistente = usuarioRepository.save(usuarioExistente);
		return ResponseEntity.ok(usuarioExistente); 
		
	}
	

	
	
	
}
