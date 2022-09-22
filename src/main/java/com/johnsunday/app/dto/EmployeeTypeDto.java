package com.johnsunday.app.dto;

import com.johnsunday.app.entity.EmployeeType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class EmployeeTypeDto extends EmployeeType{

	private static final long serialVersionUID = 1L;
	private Integer id;
	@NonNull
	private String name;
}
