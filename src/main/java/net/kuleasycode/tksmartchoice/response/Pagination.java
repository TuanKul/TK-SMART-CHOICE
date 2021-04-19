package net.kuleasycode.tksmartchoice.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pagination implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("page_num")
	private int pageNum;

	@JsonProperty("page_size")
	private int pageSize;

	@JsonProperty("total_page")
	private int totalPageCount;

	@JsonProperty("total_item")
	private long totalItemCount;
	
}
