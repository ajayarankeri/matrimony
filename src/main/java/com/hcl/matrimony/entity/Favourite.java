package com.hcl.matrimony.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="favourite")
public class Favourite {
	
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="user_id")
	private Long userId;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinColumn(name="favourite_user_id")
	private User favouriteUserId;
	
	@Column(name="updated_date")
	private LocalDate updatedDate;

}
