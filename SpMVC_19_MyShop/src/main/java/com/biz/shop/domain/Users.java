package com.biz.shop.domain;



import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import net.bytebuddy.implementation.bind.annotation.IgnoreForBinding;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
@Table(name="users",schema="emsDB")
public class Users {

	@Id
	private String username;
	private String password;
	private boolean enabled;
	
	
	
	
}
	