package com.bolsadeideas.springboot.web.app.controllers;

import java.security.KeyStore.Entry.Attribute;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.springboot.web.app.models.Usuario;


@Controller
@RequestMapping("/app")
public class IndexController {
	
	@GetMapping({"/index", "","/", "/home"})
	public String index(Model model) {
		model.addAttribute("titulo", "Hola Spring Framework");		
		return "index";
	}
	
	@RequestMapping("/perfil")
	public String perfil(Model model) {
		
		Usuario usuario = new Usuario();
		usuario.setNombre("David");
		usuario.setApellido("Rodriguez");
		usuario.setEmail("david@correo.com");
		
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", "Perfil del usuario: ".concat(usuario.getNombre()));	
		
		return "prefil";
	}
	
	@RequestMapping("/listar")
	public String listar(Model model) {
		
		
		model.addAttribute("titulo", "Listado usuarios");
		
		
		return "listar";
		
	}
	
	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuarios(){
		List<Usuario> usuarios = Arrays.asList(
				new Usuario("David", "Rodriguez","david@correo.com"),
				new Usuario("Jose", "Cardenas","jose@correo.com"),
				new Usuario("Moises", "Cardenas","moises@correo.com"),	
				new Usuario("Ana", "Quispe","ana@correo.com")
				);
		return usuarios;
		
	}
}


