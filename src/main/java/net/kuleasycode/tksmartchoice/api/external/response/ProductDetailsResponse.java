package net.kuleasycode.tksmartchoice.api.external.response;

import java.time.ZoneId;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.kuleasycode.tksmartchoice.dto.ProductDto;
import net.kuleasycode.tksmartchoice.utils.ValidationUtils;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetailsResponse {

	@JsonProperty("id")
	private String id;
	
	@JsonProperty("product_name")
	private String productName;
	
	@JsonProperty("current_price")
	private String currentPrice;
	
	@JsonProperty("discount_rate")
	private String discountRate;
	
	@JsonProperty("rate")
	private String rate;
	
	@JsonProperty("image_name")
	private String imageName;
	
	@JsonProperty("created_date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss", timezone = ValidationUtils.MY_TIME_ZONE)
	private Date createdDate;
	
	public ProductDetailsResponse(ProductDto dto) {
		this.id = dto.getId();
		this.productName = dto.getProductName();
		this.currentPrice = String.valueOf(dto.getCurrentPrice());
		this.discountRate = String.valueOf(dto.getDiscountRate());
		this.rate = String.valueOf(dto.getRate());
		this.createdDate = Date.from(dto.getCreatedDate().atStartOfDay(ZoneId.systemDefault()).toInstant());
	}
}
