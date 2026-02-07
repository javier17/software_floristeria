package com.relievesmelgar.floristeria.service;

import java.util.List;

import com.relievesmelgar.floristeria.dto.ProductoDto;

public interface IProductoService {
	
	List<ProductoDto> findAll();

}
