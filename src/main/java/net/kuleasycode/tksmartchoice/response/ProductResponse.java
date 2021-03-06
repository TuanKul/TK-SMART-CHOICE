package net.kuleasycode.tksmartchoice.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=true)
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_EMPTY)
public class ProductResponse extends BaseResponse{

	@JsonProperty("data")
	private List<ProductDetailsResponse> listProductDetail;
	
	@JsonProperty("paging")
	private Pagination pagination;
	
	public ProductResponse(String code, String message) {
		super(code, message);
	}
	
	public ProductResponse(String code, String message, List<ProductDetailsResponse> listProductDetail, Pagination pagination) {
		super(code, message);
		this.listProductDetail = listProductDetail;
		this.pagination = pagination;
	}
}
