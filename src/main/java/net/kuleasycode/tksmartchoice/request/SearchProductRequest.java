package net.kuleasycode.tksmartchoice.request;

import java.util.Date;

import org.springframework.util.StringUtils;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.kuleasycode.tksmartchoice.common.Constant;
import net.kuleasycode.tksmartchoice.common.HttpStatusCode;
import net.kuleasycode.tksmartchoice.response.ProductResponse;
import net.kuleasycode.tksmartchoice.utils.ValidationUtils;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchProductRequest {

	@JsonProperty("search_value")
	private String searchValue;
	
	@JsonProperty("start_date")
	private String startDate;
	
	@JsonProperty("end_date")
	private String endDate;
	
	public ProductResponse validation() {
		Date start = ValidationUtils.parseDate(startDate);
		Date end = ValidationUtils.parseDate(endDate);
		if (StringUtils.isEmpty(this.startDate)) {
			return new ProductResponse(HttpStatusCode._400.getCode(), Constant.INPUT_EMPTY.replace(Constant.KEY, "start_date"));
		} else if (StringUtils.isEmpty(this.endDate)) {
			return new ProductResponse(HttpStatusCode._400.getCode(), Constant.INPUT_EMPTY.replace(Constant.KEY, "end_date"));
		} else if (!ValidationUtils.checkMatch(ValidationUtils.PATTERN_TYPE_DATE, this.startDate)) {
			return new ProductResponse(HttpStatusCode._400.getCode(), Constant.INPUT_INVALID.replace(Constant.KEY, "start_date"));
		} else if (!ValidationUtils.checkMatch(ValidationUtils.PATTERN_TYPE_DATE, this.endDate)) {
			return new ProductResponse(HttpStatusCode._400.getCode(), Constant.INPUT_INVALID.replace(Constant.KEY, "end_date"));
		} else if (start.after(end)) {
			return new ProductResponse(HttpStatusCode._400.getCode(), Constant.START_DATE_INVALID);
		}
		return null;
	}
}
