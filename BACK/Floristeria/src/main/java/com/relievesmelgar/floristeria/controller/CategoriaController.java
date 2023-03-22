package com.relievesmelgar.floristeria.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.relievesmelgar.floristeria.model.Categoria;
import com.relievesmelgar.floristeria.service.ICategoriaService;
import com.relievesmelgar.floristeria.util.Constantes;

@CrossOrigin(origins = {"*"} , maxAge = 3600)
@RestController
@RequestMapping("/category")
public class CategoriaController {
	
	@Autowired
	private ICategoriaService categoriaService;
	
	
	@GetMapping("/findAll")
	public ResponseEntity<Map<String, Object>> findAll(){
		Map<String, Object> response = new HashMap<>();
		List<Categoria> categorias;
		try {
			categorias = categoriaService.findAll();
		}catch (Exception e) {
			response.put(Constantes.STATUS, HttpStatus.INTERNAL_SERVER_ERROR);
			response.put(Constantes.RESPONSE, "Error al consultas las categorias");
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put(Constantes.STATUS, HttpStatus.OK);
		response.put(Constantes.RESPONSE, categorias);
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
	}

}
