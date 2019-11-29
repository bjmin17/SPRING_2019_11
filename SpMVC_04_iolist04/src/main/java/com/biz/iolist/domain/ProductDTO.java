package com.biz.iolist.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ProductDTO {
	private String p_code;//	number
	private String p_name;//	nvarchar2(25 char)
	private int p_iprice;//	nvarchar2(25 char)
	private int p_oprice;//	nvarchar2(25 char)
	private String p_vat;//	nvarchar2(2 char)
}
