package com.byo.springbootmicroservices.updateannotation.domain.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ANNOTATION")
public class UpdateAnnotation implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private Long id;
	@Column(name = "ADJUSTMENTVALUE")
	private Long adjustmentValue;
	@Column(name = "ADJUSTMENTTYPE")
	private String adjustmentType;
	@Column(name = "CREATEDDATE")
	private Date createdDate;
	@Column(name = "EXPIREDDATE")
	private Date expiredDate;
	@Column(name = "CURRENTVALUE")
	private Long currentValue;
	@Column(name = "SPID")
	private String spId;
	@Column(name = "SPCID")
	private String spcId;

	public UpdateAnnotation() {
		super();
	}

	public UpdateAnnotation(Long id, Long adjustmentValue, String adjustmentType, Date createdDate, Date expiredDate,
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
