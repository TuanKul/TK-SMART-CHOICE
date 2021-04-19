package net.kuleasycode.tksmartchoice.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.Data;

@Data
@MappedSuperclass
public class BaseEntity {

	@Column(name = "created_date")
	protected Date createdDate;
	
	@Column(name = "updated_date")
	protected Date updatedDate;
}
