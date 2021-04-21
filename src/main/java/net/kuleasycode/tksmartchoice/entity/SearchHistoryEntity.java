package net.kuleasycode.tksmartchoice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "ms_search_history")
@Data
public class SearchHistoryEntity extends BaseEntity{

	@Id
	@Column(name ="id")
	private String id;
	
	@Column(name ="request_body")
	private String requestBody;
	
	@Column(name ="user_request")
	private String userRequest;
}
