package com.analiseinfo.springBoot.utils;

import java.io.Serializable;

import org.springframework.data.jpa.domain.AbstractPersistable;

public abstract class BaseEntity<ID extends Serializable> extends AbstractPersistable<ID> implements Serializable {

	private static final long serialVersionUID = 1L;


	@Override
	public void setId(ID id) {
		super.setId(id);
	}

	@Override
	public boolean isNew() {
		return super.isNew();
	}

}