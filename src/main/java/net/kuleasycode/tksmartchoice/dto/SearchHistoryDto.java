package net.kuleasycode.tksmartchoice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchHistoryDto extends BaseDto{

	private String id;
	
	private String requestBody;
	
	private String userRequest;
}
