package org.cwie.blog.validation.model;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class SimpleDtoIdParam implements Serializable {
	private static final long serialVersionUID = -8165488655725668928L;
	
	@Min(value = 1)
	@Max(999999)
	private int simpleDtoId;

	public int getSimpleDtoId() {
		return simpleDtoId;
	}

	public void setSimpleDtoId(int simpleDtoId) {
		this.simpleDtoId = simpleDtoId;
	}

}
