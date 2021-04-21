package net.kuleasycode.tksmartchoice.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class BaseDto {

	protected LocalDate createdDate;
	
	protected LocalDate updatedDate;
}
