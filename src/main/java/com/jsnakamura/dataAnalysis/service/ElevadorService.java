package com.jsnakamura.dataAnalysis.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jsnakamura.dataAnalysis.entity.Answer;
import com.jsnakamura.dataAnalysis.helper.DataHelper;

public class ElevadorService implements IElevadorService {

	private List<Answer> answers;
	private DataHelper dataHelper = new DataHelper();

	public ElevadorService(List<Answer> answers) {
		this.answers = answers;
	}

	public List<Integer> andarMenosUtilizado() {

		List<Integer> lessUsedFloor = new ArrayList<Integer>();

		List<ArrayList<Answer>> listByFloors = dataHelper.getListByFloors(answers);

		int size = 0;
		
		for (List<Answer> floor : listByFloors) {
			if(lessUsedFloor.isEmpty()) {
				lessUsedFloor.add(floor.get(0).getAndar());
				size = floor.size();
				
			} else if(floor.size() < size) {
				lessUsedFloor.clear();
				lessUsedFloor.add(floor.get(0).getAndar());
				size = floor.size();
				
			} else if(floor.size() == size) {
				lessUsedFloor.add(floor.get(0).getAndar());
			}
		}
		
		return lessUsedFloor;
	}

	public List<Character> elevadorMaisFrequentado() {

		

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
