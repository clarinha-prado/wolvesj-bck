package com.amais.wolves.repositories;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AnimalQueryParameters {
	List<Short> sizes = new ArrayList<Short>();
	List<Short> genders = new ArrayList<Short>();
	HashMap<String, LocalDate> ranges = new HashMap<String, LocalDate>();
	
	// calcular datas p usar com intervalo de busca
	private LocalDate today = LocalDate.now();
	private LocalDate oneYearAgo = LocalDate.now().minusYears(1);
	private LocalDate fiveYearsAgo = LocalDate.now().minusYears(5);
	private LocalDate tenYearsAgo = LocalDate.now().minusYears(10);
	private LocalDate aLongTimeAgo = LocalDate.now().minusYears(100);
	
	// todas as combinações possíveis
	private LocalDate[][] combination = {
			{today, aLongTimeAgo, null, null},
			{tenYearsAgo, aLongTimeAgo, null, null},
			{fiveYearsAgo, tenYearsAgo, null, null},
			{fiveYearsAgo, aLongTimeAgo, null, null},
			{oneYearAgo, fiveYearsAgo, null, null},
			{oneYearAgo, fiveYearsAgo, tenYearsAgo, aLongTimeAgo},
			{oneYearAgo, tenYearsAgo, null, null},
			{oneYearAgo, aLongTimeAgo, null, null},
			{today, oneYearAgo, null, null},
			{today, oneYearAgo, tenYearsAgo, aLongTimeAgo},
			{today, oneYearAgo, fiveYearsAgo, tenYearsAgo},
			{today, oneYearAgo, fiveYearsAgo, aLongTimeAgo},
			{today, fiveYearsAgo, null, null},
			{today, fiveYearsAgo, tenYearsAgo, aLongTimeAgo},
			{today, tenYearsAgo, null, null},
			{today, aLongTimeAgo, null, null}
	};
	
	public AnimalQueryParameters(Integer sizes, Integer genders, Integer ages) {
		super();
		
		// se nenhum tamanho tiver sido selecionado, procurar em todos os tamanhos
		if (sizes == 0)
			sizes = 7;
		
		// tamanhos representados em binário com 3 posições, representando, da esquerda para a direita
		// p, m e g
		// se foi selecionado tamanho p: (1** & 100), pois 4 em decimal = 100 em binário
		if ((sizes & 4) == 4)
			this.sizes.add(Integer.valueOf(0).shortValue());
		if ((sizes & 2) == 2)
			this.sizes.add(Integer.valueOf(1).shortValue());
		if ((sizes & 1) == 1)
			this.sizes.add(Integer.valueOf(2).shortValue());

		// se nenhum gênero tiver sido selecionado, procurar em todos os gêneros
		if (genders == 0)
			genders = 3;
		
		// binário com suas posições 1*2^1=female  1*2^0=male
		if ((genders & 2) == 2)
			this.genders.add(Integer.valueOf(0).shortValue());
		if ((genders & 1) == 1)
			this.genders.add(Integer.valueOf(1).shortValue());

		// se nenhum gênero tiver sido selecionado, procurar em todos os gêneros
		if (ages == 0)
			ages = 15;
		
		// binário com 4 posições para representar as faixas de idade
		// get date(s) interval(s) that should be searched in
		ranges.put("from1", combination[ages][1]);
		ranges.put("to1", combination[ages][0]);
		ranges.put("from2", combination[ages][3]);
		ranges.put("to2", combination[ages][2]);
	}
	
	public List<Short> getSizes() {
		return sizes;
	}
	
	public List<Short> getGenders() {
		return genders;
	}
	
	public HashMap<String, LocalDate> getAges() {
		return ranges;
	}
}
