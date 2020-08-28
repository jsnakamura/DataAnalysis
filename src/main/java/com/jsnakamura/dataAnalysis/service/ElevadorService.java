package com.jsnakamura.dataAnalysis.service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jsnakamura.dataAnalysis.entity.Answer;

public class ElevadorService implements IElevadorService {

	private List<Answer> answers;

	public ElevadorService(List<Answer> answers) {
		this.answers = answers;
	}

	public List<Integer> andarMenosUtilizado() {

		List<Integer> lessUsedFloor;
		Map<Integer, Integer> counter = new HashMap<Integer, Integer>();

		answers
			.stream()
			.sorted(Comparator.comparingInt(Answer::getAndar))
			.forEach(answer -> {

				if (counter.containsKey(answer.getAndar())) {
	
					counter.replace(answer.getAndar(), counter.get(answer.getAndar()) + 1);
				} else {
					counter.put(answer.getAndar(), 1);
				}
		});
		
		
		
		
		
		return null;
	}

	public List<Character> elevadorMaisFrequentado() {

		List<Character> mostUsedElevator;
		Map<Character, Integer> counter = new HashMap<Character, Integer>();

		answers
		.stream()
		.sorted(Comparator.comparingInt(Answer::getElevador))
		.forEach(answer -> {

			if (counter.containsKey(answer.getElevador())) {

				counter.replace(answer.getElevador(), counter.get(answer.getElevador()) + 1);
			} else {
				counter.put(answer.getElevador(), 1);
			}
	});
		
		
		
		
		return null;
	}

	public List<Character> periodoMaiorFluxoElevadorMaisFrequentado() {

		List<Character> mostUsedElevatorBiggestFlow;
		Map<Character, Integer> counter = new HashMap<Character, Integer>();
		
		return null;
	}

	public List<Character> elevadorMenosFrequentado() {

		List<Character> leastUsedElevator;
		Map<Character, Integer> counter = new HashMap<Character, Integer>();
		
		return null;
	}

	public List<Character> periodoMenorFluxoElevadorMenosFrequentado() {

		List<Character> leastUsedElevatorLowestFlow;
		Map<Character, Integer> counter = new HashMap<Character, Integer>();
		
		return null;
	}

	public List<Character> periodoMaiorUtilizacaoConjuntoElevadores() {

		List<Character> BiggestFlowElevatorSet;
		Map<Character, Integer> counter = new HashMap<Character, Integer>();
		
		return null;
	}

	public float percentualDeUsoElevadorA() {

		return 0;
	}

	public float percentualDeUsoElevadorB() {
		// TODO Auto-generated method stub
		return 0;
	}

	public float percentualDeUsoElevadorC() {
		// TODO Auto-generated method stub
		return 0;
	}

	public float percentualDeUsoElevadorD() {
		// TODO Auto-generated method stub
		return 0;
	}

	public float percentualDeUsoElevadorE() {
		// TODO Auto-generated method stub
		return 0;
	}

}
