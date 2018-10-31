package org.cwie.blog.validation.model;


import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.cwie.blog.validation.validators.ValidCategory;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SimpleDto implements Serializable {
	private static final long serialVersionUID = 7860506206722471520L;

	@Min(value = 1, message = "Id can't be less than 1 or bigger than 999999")
	@Max(999999)
	private int id;
	
	@Size(max = 100)
	private String name;
	
	@NotNull
	private Boolean active;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	@NotNull
	private Date createdDatetime;
	
    @Pattern(regexp = "^asc|desc$")
    private String order = "asc";
    
    
    @ValidCategory(categoryType="simpleDto")
    private String category;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
	
	public Date getCreatedDatetime() {
		return createdDatetime;
	}

	public void setCreatedDatetime(Date createdDatetime) {
		this.createdDatetime = createdDatetime;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}


}
