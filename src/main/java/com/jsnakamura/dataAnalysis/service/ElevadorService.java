package com.jsnakamura.dataAnalysis.service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

		int count = 0;

		for (List<Answer> floor : listByFloors) {
			if (lessUsedFloor.isEmpty()) {
				lessUsedFloor.add(floor.get(0).getAndar());
				count = floor.size();

			} else if (floor.size() < count) {
				lessUsedFloor.clear();
				lessUsedFloor.add(floor.get(0).getAndar());
				count = floor.size();

			} else if (floor.size() == count) {
				lessUsedFloor.add(floor.get(0).getAndar());
			}
		}

		return lessUsedFloor;
	}

	public List<Character> elevadorMaisFrequentado() {

		List<Character> mostUsedElevator = new ArrayList<Character>();

		List<ArrayList<Answer>> listByElevator = dataHelper.getListByElevators(answers);

		int count = 0;

		for (List<Answer> elevator : listByElevator) {
			if (mostUsedElevator.isEmpty()) {
				mostUsedElevator.add(elevator.get(0).getElevador());
				count = elevator.size();

			} else if (elevator.size() > count) {
				mostUsedElevator.clear();
				mostUsedElevator.add(elevator.get(0).getElevador());
				count = elevator.size();

			} else if (elevator.size() == count) {
				mostUsedElevator.add(elevator.get(0).getElevador());
			}
		}

		return mostUsedElevator;
	}

	public List<Character> periodoMaiorFluxoElevadorMaisFrequentado() {

		List<Character> mostUsedElevatorBiggestFlow = new ArrayList<Character>();

		List<Character> mostUsedElevators = elevadorMaisFrequentado();

		for (Character elevator : mostUsedElevators) {

			List<Answer> completeMostUsedElevators;

			int morningShift = 0;
			int afternoonShift = 0;
			int eveningShift = 0;

			completeMostUsedElevators = answers.stream().filter(answer -> answer.getElevador() == elevator)
					.collect(Collectors.toList());

			for (Answer answer : completeMostUsedElevators) {

				if (answer.getTurno() == 'M') {
					morningShift++;
				} else if (answer.getTurno() == 'V') {
					afternoonShift++;
				} else if (answer.getTurno() == 'N') {
					eveningShift++;
				}
			}

			if ((morningShift >= afternoonShift) && (morningShift >= eveningShift)) {
				mostUsedElevatorBiggestFlow.add('M');

			} else if ((afternoonShift >= morningShift) && (afternoonShift >= eveningShift)) {
				mostUsedElevatorBiggestFlow.add('V');

			} else if ((eveningShift >= morningShift) && (eveningShift >= afternoonShift)) {
				mostUsedElevatorBiggestFlow.add('N');
			}
		}

		return mostUsedElevatorBiggestFlow;
	}

	public List<Character> elevadorMenosFrequentado() {

		List<Character> leastUsedElevator = new ArrayList<Character>();

		List<ArrayList<Answer>> listByElevator = dataHelper.getListByElevators(answers);

		int count = 0;

		for (List<Answer> elevator : listByElevator) {
			if (leastUsedElevator.isEmpty()) {
				leastUsedElevator.add(elevator.get(0).getElevador());
				count = elevator.size();

			} else if (elevator.size() < count) {
				leastUsedElevator.clear();
				leastUsedElevator.add(elevator.get(0).getElevador());
				count = elevator.size();

			} else if (elevator.size() == count) {
				leastUsedElevator.add(elevator.get(0).getElevador());
			}
		}

		return leastUsedElevator;
	}

	public List<Character> periodoMenorFluxoElevadorMenosFrequentado() {

		List<Character> leastUsedElevatorLowestFlow = new ArrayList<Character>();

		List<Character> leastUsedElevators = elevadorMenosFrequentado();

		for (Character elevator : leastUsedElevators) {

			List<Answer> completeLeastUsedElevators;

			int morningShift = 0;
			int afternoonShift = 0;
			int eveningShift = 0;

			completeLeastUsedElevators = answers.stream().filter(answer -> answer.getElevador() == elevator)
					.collect(Collectors.toList());

			for (Answer answer : completeLeastUsedElevators) {

				if (answer.getTurno() == 'M') {
					morningShift--;
				} else if (answer.getTurno() == 'V') {
					afternoonShift--;
				} else if (answer.getTurno() == 'N') {
					eveningShift--;
				}
			}

			if ((morningShift >= afternoonShift) && (morningShift >= eveningShift)) {
				leastUsedElevatorLowestFlow.add('M');

			} else if ((afternoonShift >= morningShift) && (afternoonShift >= eveningShift)) {
				leastUsedElevatorLowestFlow.add('V');

			} else if ((eveningShift >= morningShift) && (eveningShift >= afternoonShift)) {
				leastUsedElevatorLowestFlow.add('N');
			}

		}

		return leastUsedElevatorLowestFlow;
	}

	public List<Character> periodoMaiorUtilizacaoConjuntoElevadores() {

		List<Character> elevatorsBiggestFlow = new ArrayList<Character>();

		List<ArrayList<Answer>> listByShifts = dataHelper.getListByShifts(answers);
		
		int count = 0;

		for (List<Answer> shifts : listByShifts) {
			if (elevatorsBiggestFlow.isEmpty()) {
				elevatorsBiggestFlow.add(shifts.get(0).getTurno());
				count = shifts.size();

			} else if (shifts.size() > count) {
				elevatorsBiggestFlow.clear();
				elevatorsBiggestFlow.add(shifts.get(0).getTurno());
				count = shifts.size();

			} else if (shifts.size() == count) {
				elevatorsBiggestFlow.add(shifts.get(0).getTurno());
			}
		}
		
		return elevatorsBiggestFlow;
	}

	public float percentualDeUsoElevadorA() {

		float total;
		float elevatorAUsage;
		
		total = answers.size();
		
		elevatorAUsage = answers.stream().filter(answer -> answer.getElevador() == 'A').count();
		
		return Float.parseFloat(new DecimalFormat("#,##0.00").format(elevatorAUsage/total));
	}

	public float percentualDeUsoElevadorB() {
		
		float total;
		float elevatorBUsage;
		
		total = answers.size();
		
		elevatorBUsage = answers.stream().filter(answer -> answer.getElevador() == 'B').count();
		
		return Float.parseFloat(new DecimalFormat("#,##0.00").format(elevatorBUsage/total));
	}

	public float percentualDeUsoElevadorC() {
		
		float total;
		float elevatorCUsage;
		
		total = answers.size();
		
		elevatorCUsage = answers.stream().filter(answer -> answer.getElevador() == 'C').count();
		
		return Float.parseFloat(new DecimalFormat("#,##0.00").format(elevatorCUsage/total));
	}

	public float percentualDeUsoElevadorD() {
		
		float total;
		float elevatorDUsage;
		
		total = answers.size();
		
		elevatorDUsage = answers.stream().filter(answer -> answer.getElevador() == 'D').count();
		
		return Float.parseFloat(new DecimalFormat("#,##0.00").format(elevatorDUsage/total));
	}

	public float percentualDeUsoElevadorE() {
		
		float total;
		float elevatorEUsage;
		
		total = answers.size();
		
		elevatorEUsage = answers.stream().filter(answer -> answer.getElevador() == 'E').count();
		
		return Float.parseFloat(new DecimalFormat("#,##0.00").format(elevatorEUsage/total));
	}
}
