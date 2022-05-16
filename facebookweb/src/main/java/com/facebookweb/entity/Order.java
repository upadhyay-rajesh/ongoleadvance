package com.facebookweb.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="facebookorder")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long order_id;
	
	@ManyToOne
	private FacebookUser fb;

	public long getOrder_id() {
		return order_id;
	}

	public void setOrder_id(long order_id) {
		this.order_id = order_id;
	}

	public FacebookUser getFb() {
		return fb;
	}

	public void setFb(FacebookUser fb) {
		this.fb = fb;
	}
	
	

}
