package com.jsnakamura.dataAnalysis.service;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.collect.Lists;
import com.jsnakamura.dataAnalysis.entity.Answer;

public class ElevadorServiceTest {

	ArrayList<Answer> mockData;
	ElevadorService service;

	@BeforeTest
	public void setUp() {

		mockData = Lists.newArrayList(new Answer(1, 'A', 'M'), new Answer(1, 'B', 'M'), new Answer(1, 'A', 'N'),
				new Answer(2, 'A', 'M'), new Answer(2, 'B', 'M'), new Answer(2, 'C', 'N'), new Answer(1, 'D', 'M'),
				new Answer(1, 'A', 'V'), new Answer(3, 'B', 'N'), new Answer(3, 'E', 'M'), new Answer(2, 'C', 'N'),
				new Answer(3, 'E', 'M'), new Answer(1, 'D', 'V'));

		service = new ElevadorService(mockData);
	}

	@Test
	public void andarMenosUtilizadoTest() {

		// GIVEN
		ArrayList<Integer> expected = Lists.newArrayList(3);

		// WHEN
		List<Integer> actual = service.andarMenosUtilizado();

		// THEN
		assertThat(actual, is(expected));
	}

	@Test
	public void elevadorMaisFrequentadoTest() {
		// GIVEN
		ArrayList<Character> expected = Lists.newArrayList('A');

		// WHEN
		List<Character> actual = service.elevadorMaisFrequentado();

		// THEN
		assertThat(actual, is(expected));
	}

	@Test
	public void elevadorMenosFrequentadoTest() {
		// GIVEN
		ArrayList<Character> expected = Lists.newArrayList('C', 'D', 'E');

		// WHEN
		List<Character> actual = service.elevadorMenosFrequentado();

		// THEN
		assertThat(actual, is(expected));
	}

	@Test
	public void percentualDeUsoElevadorATest() {
		// GIVEN
		// WHEN
		// THEN
	}

	@Test
	public void percentualDeUsoElevadorBTest() {
		// GIVEN
		// WHEN
		// THEN
	}

	@Test
	public void percentualDeUsoElevadorCTest() {
		// GIVEN
		// WHEN
		// THEN
	}

	@Test
	public void percentualDeUsoElevadorDTest() {
		// GIVEN
		// WHEN
		// THEN
	}

	@Test
	public void percentualDeUsoElevadorETest() {
		// GIVEN
		// WHEN
		// THEN
	}

	@Test
	public void periodoMaiorFluxoElevadorMaisFrequentadoTest() {
		// GIVEN
		ArrayList<Character> expected = Lists.newArrayList('M');

		// WHEN
		List<Character> actual = service.periodoMaiorFluxoElevadorMaisFrequentado();

		// THEN
		assertThat(actual, is(expected));
	}

	@Test
	public void periodoMaiorUtilizacaoConjuntoElevadoresTest() {
		// GIVEN
		ArrayList<Character> expected = Lists.newArrayList('M');

		// WHEN
		List<Character> actual = service.periodoMaiorUtilizacaoConjuntoElevadores();

		// THEN
		assertThat(actual, is(expected));
	}

	@Test
	public void periodoMenorFluxoElevadorMenosFrequentadoTest() {
		// GIVEN
		ArrayList<Character> expected = Lists.newArrayList('N', 'M', 'M');

		// WHEN
		List<Character> actual = service.periodoMenorFluxoElevadorMenosFrequentado();

		// THEN
		assertThat(actual, is(expected));
	}
}
