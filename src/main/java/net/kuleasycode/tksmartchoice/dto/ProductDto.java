package net.kuleasycode.tksmartchoice.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class ProductDto extends BaseDto {

	private String id;
	
	private String productId;
	
	private String productName;
	
	private Double currentPrice;
	
	private Double discountRate;
	
	private Double rate;
	
	private String imageName;
	
	private String supplier;
}
