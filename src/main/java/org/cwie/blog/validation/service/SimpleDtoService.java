package org.cwie.blog.validation.service;

import org.cwie.blog.validation.model.SimpleDto;

public interface SimpleDtoService {
	public SimpleDto findById(int id);
	public SimpleDto save(SimpleDto simpleDto);

}
