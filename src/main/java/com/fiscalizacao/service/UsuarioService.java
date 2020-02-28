package com.fiscalizacao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiscalizacao.models.Usuario;
import com.fiscalizacao.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	public Usuario findById(Integer id) {
		Usuario usuario = new Usuario();
		try {
			usuario = usuarioRepository.findById(id).orElse(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuario;
	}
	
	public Usuario SalvarUsuario(Usuario user) {
	   Usuario novoUser = new Usuario();
	   try {
		   novoUser = usuarioRepository.save(user);
	} catch (Exception e) {
		e.printStackTrace();
	}
	   return novoUser;
	}
	
	public void deletaUser(Integer id) {
		usuarioRepository.deleteById(id);
		
	}
}
