package com.madhav.ecommerce.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity(name = "Product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productid;
	private String name;
	private String description;
	private Integer price;
	private boolean availabilty;
	
	@OneToOne
	@JoinColumn(
			name = "category_id",
			referencedColumnName = "categoryid"
			)
	private Category category;
}
