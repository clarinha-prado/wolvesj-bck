package com.amais.wolves.repositories;

import java.util.ArrayList;
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
		
		return sizes;
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
