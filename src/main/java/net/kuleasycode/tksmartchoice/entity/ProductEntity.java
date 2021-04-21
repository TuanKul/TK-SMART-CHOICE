package net.kuleasycode.tksmartchoice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "ms_product")
@Data
public class ProductEntity extends BaseEntity{

	@Column(name = "id")
	@Id
	private String id;
	
	@Column(name = "product_id")
	private String productId;
	
	@Column(name = "product_name")
	private String productName;
	
	@Column(name = "current_price")
	private Double currentPrice;
	
	@Column(name = "discount_rate")
	private Double discountRate;
	
	@Column(name = "rate")
	private Double rate;
	
	@Column(name = "image_name")
	private String imageName;
	
	@Column(name = "supplier")
	private String supplier;
}
