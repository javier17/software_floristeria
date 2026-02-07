package com.relievesmelgar.floristeria.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.relievesmelgar.floristeria.dto.ProductoDto;
import com.relievesmelgar.floristeria.repository.ProductoRepository;
import com.relievesmelgar.floristeria.service.IProductoService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ProductoServiceImpl implements IProductoService{
	
	private final ProductoRepository productoRepo;

	@Override
	public List<ProductoDto> findAll() {
		return productoRepo.findAll()
				.stream()
				.filter(p -> !p.getPrecios().isEmpty())
				.map(ProductoDto::toDto)
				.collect(Collectors.toList());
	}

}
