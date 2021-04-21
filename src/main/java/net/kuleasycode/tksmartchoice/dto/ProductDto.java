package net.kuleasycode.tksmartchoice.dto;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import net.kuleasycode.tksmartchoice.api.external.response.ProductDetailsResponse;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto extends BaseDto {

	private String id;
	
	private String productId;
	
	private String productName;
	
	private Double currentPrice;
	
	private Double discountRate;
	
	private Double rate;
	
	private String imageName;
	
	private String supplier;
	
	public ProductDto(ProductDetailsResponse response, String supplier) {
		this.id = UUID.randomUUID().toString();
		this.productId = response.getId();
		this.productName = response.getProductName();
		this.currentPrice = Double.valueOf(response.getCurrentPrice());
		this.discountRate = Double.valueOf(response.getDiscountRate());
		this.rate = Double.valueOf(response.getRate());
		this.createdDate = LocalDate.now();
		this.updatedDate = LocalDate.now();
		this.supplier = supplier;
	}
}
