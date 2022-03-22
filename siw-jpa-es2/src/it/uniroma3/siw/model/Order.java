package it.uniroma3.siw.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "orders")

public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private LocalDateTime creationTime;
	
	@OneToMany
	@JoinColumn(name = "orders_id")
	private List<OrderLine> orderLines;
	
	@OneToMany
	private Customer customer;

	public LocalDateTime getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(LocalDateTime creationTime) {
		this.creationTime = creationTime;
	}
	
}
