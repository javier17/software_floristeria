package com.relievesmelgar.floristeria.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.relievesmelgar.floristeria.model.Categoria;
import com.relievesmelgar.floristeria.repository.CategoriaRepository;
import com.relievesmelgar.floristeria.service.ICategoriaService;

@Service
public class CategoriaServiceImpl implements ICategoriaService{
	
	@Autowired
	private CategoriaRepository categoriaRepo;

	@Override
	public List<Categoria> findAll() {
		return categoriaRepo.findAll();
	}

}
