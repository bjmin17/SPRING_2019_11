package com.biz.memo.domain;

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
public class HobbyDTO {

    private String h_code;//	VARCHAR2(5)	NOT NULL PRIMARY KEY,
    private String h_name;//	nVARCHAR2(125)	NOT NULL,
    private String h_rem;//	nVARCHAR2(125)		
	
	
}
