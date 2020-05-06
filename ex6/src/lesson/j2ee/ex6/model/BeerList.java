package lesson.j2ee.ex6.model;

import java.util.ArrayList;
import java.util.List;

public class BeerList {
	private List<Beer> beerList=new ArrayList<>();

	public BeerList(List<Beer> beerList) {
		super();
		this.beerList = beerList;
	}

	public BeerList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<Beer> getBeerList() {
		return beerList;
	}

	public void setBeerList(List<Beer> beerList) {
		this.beerList = beerList;
	}
	
}
