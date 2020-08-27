package com.jsnakamura.dataAnalysis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Answer {

	private Integer andar;
	private Character elevador;
	private Character turno;
}
