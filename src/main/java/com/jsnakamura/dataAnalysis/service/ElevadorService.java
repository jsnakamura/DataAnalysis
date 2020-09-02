package com.jsnakamura.dataAnalysis.service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.jsnakamura.dataAnalysis.entity.Answer;

public class ElevadorService implements IElevadorService {

	private List<Answer> answers;

	List<ArrayList<Answer>> getListByFloors() {

		List<ArrayList<Answer>> result = new ArrayList<ArrayList<Answer>>();

		ArrayList<Answer> floor0, floor1, floor2, floor3, floor4, floor5, floor6, floor7, floor8, floor9, floor10,
				floor11, floor12, floor13, floor14, floor15;

		floor0 = (ArrayList<Answer>) answers.stream().filter(answer -> answer.getAndar() == 0)
				.collect(Collectors.toList());

		floor1 = (ArrayList<Answer>) answers.stream().filter(answer -> answer.getAndar() == 1)
				.collect(Collectors.toList());

		floor2 = (ArrayList<Answer>) answers.stream().filter(answer -> answer.getAndar() == 2)
				.collect(Collectors.toList());

		floor3 = (ArrayList<Answer>) answers.stream().filter(answer -> answer.getAndar() == 3)
				.collect(Collectors.toList());

		floor4 = (ArrayList<Answer>) answers.stream().filter(answer -> answer.getAndar() == 4)
				.collect(Collectors.toList());

		floor5 = (ArrayList<Answer>) answers.stream().filter(answer -> answer.getAndar() == 5)
				.collect(Collectors.toList());

		floor6 = (ArrayList<Answer>) answers.stream().filter(answer -> answer.getAndar() == 6)
				.collect(Collectors.toList());

		floor7 = (ArrayList<Answer>) answers.stream().filter(answer -> answer.getAndar() == 7)
				.collect(Collectors.toList());

		floor8 = (ArrayList<Answer>) answers.stream().filter(answer -> answer.getAndar() == 8)
				.collect(Collectors.toList());

		floor9 = (ArrayList<Answer>) answers.stream().filter(answer -> answer.getAndar() == 9)
				.collect(Collectors.toList());

		floor10 = (ArrayList<Answer>) answers.stream().filter(answer -> answer.getAndar() == 10)
				.collect(Collectors.toList());

		floor11 = (ArrayList<Answer>) answers.stream().filter(answer -> answer.getAndar() == 11)
				.collect(Collectors.toList());

		floor12 = (ArrayList<Answer>) answers.stream().filter(answer -> answer.getAndar() == 12)
				.collect(Collectors.toList());

		floor13 = (ArrayList<Answer>) answers.stream().filter(answer -> answer.getAndar() == 13)
				.collect(Collectors.toList());

		floor14 = (ArrayList<Answer>) answers.stream().filter(answer -> answer.getAndar() == 14)
				.collect(Collectors.toList());

		floor15 = (ArrayList<Answer>) answers.stream().filter(answer -> answer.getAndar() == 15)
				.collect(Collectors.toList());

		result.add(floor0);
		result.add(floor1);
		result.add(floor2);
		result.add(floor3);
		result.add(floor4);
		result.add(floor5);
		result.add(floor6);
		result.add(floor7);
		result.add(floor8);
		result.add(floor9);
		result.add(floor10);
		result.add(floor11);
		result.add(floor12);
		result.add(floor13);
		result.add(floor14);
		result.add(floor15);

		return result.stream().filter(list -> !list.isEmpty()).collect(Collectors.toList());
	}

	List<ArrayList<Answer>> getListByElevators() {

		List<ArrayList<Answer>> result = new ArrayList<ArrayList<Answer>>();

		ArrayList<Answer> elevatorA, elevatorB, elevatorC, elevatorD, elevatorE;

		elevatorA = (ArrayList<Answer>) answers.stream().filter(answer -> answer.getElevador() == 'A')
				.collect(Collectors.toList());

		elevatorB = (ArrayList<Answer>) answers.stream().filter(answer -> answer.getElevador() == 'B')
				.collect(Collectors.toList());

		elevatorC = (ArrayList<Answer>) answers.stream().filter(answer -> answer.getElevador() == 'C')
				.collect(Collectors.toList());

		elevatorD = (ArrayList<Answer>) answers.stream().filter(answer -> answer.getElevador() == 'D')
				.collect(Collectors.toList());

		elevatorE = (ArrayList<Answer>) answers.stream().filter(answer -> answer.getElevador() == 'E')
				.collect(Collectors.toList());

		result.add(elevatorA);
		result.add(elevatorB);
		result.add(elevatorC);
		result.add(elevatorD);
		result.add(elevatorE);

		return result.stream().filter(list -> !list.isEmpty()).collect(Collectors.toList());
	}

	List<ArrayList<Answer>> getListByShifts() {

		List<ArrayList<Answer>> result = new ArrayList<ArrayList<Answer>>();

		ArrayList<Answer> morningShift, afternoonShift, eveningShift;

		morningShift = (ArrayList<Answer>) answers.stream().filter(answer -> answer.getTurno() == 'M')
				.collect(Collectors.toList());

		afternoonShift = (ArrayList<Answer>) answers.stream().filter(answer -> answer.getTurno() == 'V')
				.collect(Collectors.toList());

		eveningShift = (ArrayList<Answer>) answers.stream().filter(answer -> answer.getTurno() == 'N')
				.collect(Collectors.toList());

		result.add(morningShift);
		result.add(afternoonShift);
		result.add(eveningShift);

		return result.stream().filter(list -> !list.isEmpty()).collect(Collectors.toList());
	}

	public ElevadorService(List<Answer> answers) {
		this.answers = answers;
	}

	public List<Integer> andarMenosUtilizado() {

		List<Integer> lessUsedFloor = new ArrayList<Integer>();

		List<ArrayList<Answer>> listByFloors = this.getListByFloors();

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

		List<ArrayList<Answer>> listByElevator = getListByElevators();

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

		List<ArrayList<Answer>> listByElevator = getListByElevators();

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
					morningShift++;
				} else if (answer.getTurno() == 'V') {
					afternoonShift++;
				} else if (answer.getTurno() == 'N') {
					eveningShift++;
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

		List<ArrayList<Answer>> listByShifts = getListByShifts();

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

		return Float.parseFloat(new DecimalFormat("#,##0.00").format(elevatorAUsage / total));
	}

	public float percentualDeUsoElevadorB() {

		float total;
		float elevatorBUsage;

		total = answers.size();

		elevatorBUsage = answers.stream().filter(answer -> answer.getElevador() == 'B').count();

		return Float.parseFloat(new DecimalFormat("#,##0.00").format(elevatorBUsage / total));
	}

	public float percentualDeUsoElevadorC() {

		float total;
		float elevatorCUsage;

		total = answers.size();

		elevatorCUsage = answers.stream().filter(answer -> answer.getElevador() == 'C').count();

		return Float.parseFloat(new DecimalFormat("#,##0.00").format(elevatorCUsage / total));
	}

	public float percentualDeUsoElevadorD() {

		float total;
		float elevatorDUsage;

		total = answers.size();

		elevatorDUsage = answers.stream().filter(answer -> answer.getElevador() == 'D').count();

		return Float.parseFloat(new DecimalFormat("#,##0.00").format(elevatorDUsage / total));
	}

	public float percentualDeUsoElevadorE() {

		float total;
		float elevatorEUsage;

		total = answers.size();

		elevatorEUsage = answers.stream().filter(answer -> answer.getElevador() == 'E').count();

		return Float.parseFloat(new DecimalFormat("#,##0.00").format(elevatorEUsage / total));
	}
}
