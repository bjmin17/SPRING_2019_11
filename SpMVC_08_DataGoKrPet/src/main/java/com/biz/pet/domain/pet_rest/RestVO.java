package com.biz.pet.domain.pet_rest;

import javax.xml.bind.annotation.XmlRootElement;

// XML을 가져와서 JSON으로 바꿔주기 위함
/*
 * java 1.7 이상에서만 작동된다
 * jaxb dependency(pom.xml)에 추가해주면 된다.
 */
@XmlRootElement(name="rfcOpenApi")
public class RestVO {
	public RestBody body;
}
