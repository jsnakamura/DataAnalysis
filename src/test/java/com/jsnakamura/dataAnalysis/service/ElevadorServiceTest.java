package com.jsnakamura.dataAnalysis.service;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.collect.Lists;
import com.jsnakamura.dataAnalysis.entity.Answer;

public class ElevadorServiceTest {

	List<Answer> data;
	IElevadorService service;

	@BeforeMethod
	public void setUp() {

		data = Lists.newArrayList(new Answer(1, 'A', 'M'), new Answer(1, 'B', 'M'), new Answer(1, 'A', 'N'),
				new Answer(2, 'A', 'M'), new Answer(2, 'B', 'M'), new Answer(2, 'C', 'N'), new Answer(1, 'D', 'M'),
				new Answer(1, 'A', 'V'), new Answer(3, 'B', 'N'), new Answer(3, 'E', 'M'), new Answer(2, 'C', 'N'),
				new Answer(3, 'E', 'M'), new Answer(1, 'D', 'V'));

		service = new ElevadorService(data);
	}

	@Test
	public void assert_Andar_Menos_utilizado_Expected_Behavior() {

		ArrayList<Integer> expected = Lists.newArrayList(3);

		List<Integer> actual = service.andarMenosUtilizado();

		assertThat(actual, is(expected));
	}

	@Test
	public void assert_Elevador_Mais_Frequentado_Expected_Behavior() {

		ArrayList<Character> expected = Lists.newArrayList('A');

		List<Character> actual = service.elevadorMaisFrequentado();

		assertThat(actual, is(expected));
	}

	@Test
	public void assert_Elevador_Menor_Frequentado_Expected_Behavior() {

		ArrayList<Character> expected = Lists.newArrayList('C', 'D', 'E');

		List<Character> actual = service.elevadorMenosFrequentado();

		assertThat(actual, is(expected));
	}

	@Test
	public void assert_Percentual_De_Uso_elevador_A_Expected_Behavior() {

		float expected = (float) 0.31;

		float actual = service.percentualDeUsoElevadorA();

		assertThat(actual, is(expected));
	}

	@Test
	public void assert_Percentual_De_Uso_Elevador_B_Expected_Behavior() {

		float expected = (float) 0.23;

		float actual = service.percentualDeUsoElevadorB();

		assertThat(actual, is(expected));
	}

	@Test
	public void assert_Percentual_De_Uso_Elevador_C_Expected_Behavior() {

		float expected = (float) 0.15;

		float actual = service.percentualDeUsoElevadorC();

		assertThat(actual, is(expected));
	}

	@Test
	public void assert_Percentual_De_Uso_Elevador_D_Expected_Behavior() {

		float expected = (float) 0.15;

		float actual = service.percentualDeUsoElevadorD();

		assertThat(actual, is(expected));
	}

	@Test
	public void assert_Percentual_De_Uso_Elevador_E_Expected_Behavior() {

		float expected = (float) 0.15;

		float actual = service.percentualDeUsoElevadorE();

		assertThat(actual, is(expected));
	}

	@Test
	public void assert_Periodo_Maior_Fluxo_Elevador_Mais_Frequentado_Expected_Behavior() {

		ArrayList<Character> expected = Lists.newArrayList('M');

		List<Character> actual = service.periodoMaiorFluxoElevadorMaisFrequentado();

		assertThat(actual, is(expected));
	}

	@Test
	public void assert_Periodo_Maior_Utilizacao_Conjunto_Elevadores_Expected_Behavior() {

		ArrayList<Character> expected = Lists.newArrayList('M');

		List<Character> actual = service.periodoMaiorUtilizacaoConjuntoElevadores();

		assertThat(actual, is(expected));
	}

	@Test
	public void assert_Periodo_Menor_Fluxo_Elevador_Menos_Frequentado_Expected_Behavior() {

		ArrayList<Character> expected = Lists.newArrayList('M', 'N', 'V');

		List<Character> actual = service.periodoMenorFluxoElevadorMenosFrequentado();

		assertThat(actual, is(expected));
	}
}
