package br.com.project.checkskills.utils;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.jpa.domain.AbstractPersistable;

public abstract class BaseEntity<ID  extends Serializable> extends AbstractPersistable<ID> implements Serializable {

	private static final long serialVersionUID = 1L;

	
	@Override
	public String toString() {	
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
	
	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this,  obj);
	}
	
	@Override
	public void setId(ID id) {
		super.setId(id);
	}
	
	
	@Override
	public boolean isNew() {
		return super.isNew();
	}
	
	
}
