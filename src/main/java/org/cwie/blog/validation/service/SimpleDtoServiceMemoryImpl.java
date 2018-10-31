package org.cwie.blog.validation.service;

import java.util.HashMap;
import java.util.Map;

import org.cwie.blog.validation.model.SimpleDto;
import org.springframework.stereotype.Service;

@Service("SimpleDtoService")
public class SimpleDtoServiceMemoryImpl implements SimpleDtoService {
	private Map<Integer, SimpleDto> storage;

	public SimpleDtoServiceMemoryImpl() {
		this.storage = new HashMap<>();
	}
	@Override
	public SimpleDto findById(int id) {
		return this.storage.get(id);
	}

	@Override
	public SimpleDto save(SimpleDto simpleDto) {
		this.storage.put(simpleDto.getId(), simpleDto);
		return simpleDto;
	}

}
