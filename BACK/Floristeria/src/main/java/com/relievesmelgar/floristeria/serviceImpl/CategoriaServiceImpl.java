package com.relievesmelgar.floristeria.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.relievesmelgar.floristeria.dto.CategoriaDto;
import com.relievesmelgar.floristeria.repository.CategoriaRepository;
import com.relievesmelgar.floristeria.service.ICategoriaService;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
public class CategoriaServiceImpl implements ICategoriaService{
	
	private final CategoriaRepository categoriaRepo;
	

	@Override
	public List<CategoriaDto> findAll() {
		return categoriaRepo.findAll()
				.stream()
				.map(CategoriaDto::toDto)
                .collect(Collectors.toList());
	}

}
