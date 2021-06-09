package com.amais.wolves.repositories;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AnimalQueryParameters {
	private String p; 
	private String m; 
	private String g; 
	private String female; 
	private String male; 
	private String ate1; 
	private String de1a5; 
	private String de5a10; 
	private String acima10;
	
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
	
	public AnimalQueryParameters(String p, String m, String g, String female, String male, String ate1, String de1a5,
			String de5a10, String acima10) {
		super();
		this.p = p;
		this.m = m;
		this.g = g;
		this.female = female;
		this.male = male;
		this.ate1 = ate1;
		this.de1a5 = de1a5;
		this.de5a10 = de5a10;
		this.acima10 = acima10;
	}
	
	public List<Short> getSizes() {
		List<Short> sizes = new ArrayList<Short>();

		if (p.equals("1"))
			sizes.add(Integer.valueOf(0).shortValue());
		if (m.equals("1"))
			sizes.add(Integer.valueOf(1).shortValue());
		if (g.equals("1"))
			sizes.add(Integer.valueOf(2).shortValue());
		
		// se nenhum tamanho foi selecionado, deve-se procurar em todos os tamanhos
		if (sizes.size() == 0) {
			sizes.add(Integer.valueOf(0).shortValue());
			sizes.add(Integer.valueOf(1).shortValue());
			sizes.add(Integer.valueOf(2).shortValue());
		}
		
		return sizes;
	}
	
	public List<Short> getGenders() {
		List<Short> genders = new ArrayList<Short>();

		if (female.equals("1"))
			genders.add(Integer.valueOf(0).shortValue());
		if (male.equals("1"))
			genders.add(Integer.valueOf(1).shortValue());
		
		// se nenhum gênero foi selecionado, deve-se procurar em todos os gêneros
		if (genders.size() == 0) {
			genders.add(Integer.valueOf(0).shortValue());
			genders.add(Integer.valueOf(1).shortValue());
		}
		
		return genders;
	}
	
	public HashMap<String, LocalDate> getAges() {
		// get the ages selected and converts as if it was a binary number of 4 positions
		int selection = 0;
		if (acima10.equals("1"))
			selection +=1;
		if (de5a10.equals("1"))
			selection +=2;
		if (de1a5.equals("1"))
			selection +=4;
		if (ate1.equals("1"))
			selection +=8;
		
		// get date(s) interval(s) that should be searched in
		HashMap<String, LocalDate> ranges = new HashMap<String, LocalDate>();
		ranges.put("from1", combination[selection][1]);
		ranges.put("to1", combination[selection][0]);
		ranges.put("from2", combination[selection][3]);
		ranges.put("to2", combination[selection][2]);
		
		return ranges;
	}

	public String getP() {
		return p;
	}

	public void setP(String p) {
		this.p = p;
	}

	public String getM() {
		return m;
	}

	public void setM(String m) {
		this.m = m;
	}

	public String getG() {
		return g;
	}

	public void setG(String g) {
		this.g = g;
	}

	public String getFemale() {
		return female;
	}

	public void setFemale(String female) {
		this.female = female;
	}

	public String getMale() {
		return male;
	}

	public void setMale(String male) {
		this.male = male;
	}

	public String getAte1() {
		return ate1;
	}

	public void setAte1(String ate1) {
		this.ate1 = ate1;
	}

	public String getDe1a5() {
		return de1a5;
	}

	public void setDe1a5(String de1a5) {
		this.de1a5 = de1a5;
	}

	public String getDe5a10() {
		return de5a10;
	}

	public void setDe5a10(String de5a10) {
		this.de5a10 = de5a10;
	}

	public String getAcima10() {
		return acima10;
	}

	public void setAcima10(String acima10) {
		this.acima10 = acima10;
	} 
}
