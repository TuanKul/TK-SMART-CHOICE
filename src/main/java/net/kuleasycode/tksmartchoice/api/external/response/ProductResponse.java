package net.kuleasycode.tksmartchoice.api.external.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=true)
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse extends BaseResponse{

	@JsonProperty("data")
	private List<ProductDetailsResponse> listProductDetail;
	
	public ProductResponse(String code, String message) {
		super(code, message);
	}
	
	public ProductResponse(String code, String message, List<ProductDetailsResponse> listProductDetail) {
		super(code, message);
		this.listProductDetail = listProductDetail;
	}
}
