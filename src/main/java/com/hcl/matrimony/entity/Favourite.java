package com.hcl.matrimony.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity 
@IdClass(FavouriteIdKey.class)
@Table(name="favourite")
public class Favourite {
	
	@Id
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="user_id")
	private User userId;
	
	@Id
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="favorite_user_id")
	private User favoriteUserId;
	
	@Column(name="updated_date")
	private LocalDate updatedDate;

}
