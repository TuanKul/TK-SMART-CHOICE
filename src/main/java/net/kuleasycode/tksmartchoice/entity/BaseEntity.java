package net.kuleasycode.tksmartchoice.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.Data;

@Data
@MappedSuperclass
public class BaseEntity {

	@Column(name = "created_date")
	protected LocalDate createdDate;
	
	@Column(name = "updated_date")
	protected LocalDate updatedDate;
}
