package com.example.managed_beans;


import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.List;

import com.example.model.Beer;
import com.example.model.BeerAdvisor;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped; 


@ManagedBean
@SessionScoped
public class BeerSelect implements Serializable {
	private static final long serialVersionUID = 1L;
	private String color;
	private List<Beer> beers;
	
	public String getcolor() {
		return this.color;
	}
	
	public void setColor(String color) {		
		this.color = color;		
	}

    /**
     * Default constructor. 
     */
    public BeerSelect() {
        // TODO Auto-generated constructor stub
    }


	private void adviseBeers() {
		BeerAdvisor ba = new BeerAdvisor();		
		beers = ba.getBeers(color);
	}
	
	public List<Beer> getBeers() {
		adviseBeers();
		return this.beers;
	}
	
	public void setBeers(List<Beer> beers) {
		this.beers = beers;
	}

}
