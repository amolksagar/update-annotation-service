package com.byo.springbootmicroservices.updateannotation.domain.model;

import java.io.Serializable;
import java.util.Date;

public class Annotation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long adjustmentValue;
	private String adjustmentType;
	private Date createdDate;
	private Date expiredDate;
	private Long currentValue;
	private String spId;
	private String spcId;

	public Annotation() {
		super();
	}

	public Annotation(Long id, Long adjustmentValue, String adjustmentType, Date createdDate, Date expiredDate,
			Long currentValue) {
		super();
		this.id = id;
		this.adjustmentValue = adjustmentValue;
		this.adjustmentType = adjustmentType;
		this.createdDate = createdDate;
		this.expiredDate = expiredDate;
		this.currentValue = currentValue;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAdjustmentValue() {
		return adjustmentValue;
	}

	public void setAdjustmentValue(Long adjustmentValue) {
		this.adjustmentValue = adjustmentValue;
	}

	public String getAdjustmentType() {
		return adjustmentType;
	}

	public void setAdjustmentType(String adjustmentType) {
		this.adjustmentType = adjustmentType;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getExpiredDate() {
		return expiredDate;
	}

	public void setExpiredDate(Date expiredDate) {
		this.expiredDate = expiredDate;
	}

	public Long getCurrentValue() {
		return currentValue;
	}

	public void setCurrentValue(Long currentValue) {
		this.currentValue = currentValue;
	}

	public String getSpId() {
		return spId;
	}

	public void setSpId(String spId) {
		this.spId = spId;
	}

	public String getSpcId() {
		return spcId;
	}

	public void setSpcId(String spcId) {
		this.spcId = spcId;
	}
}
