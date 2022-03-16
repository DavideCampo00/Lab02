package it.polito.tdp.model;

import java.util.*;

public class Model {
	private TreeMap<String,String>dizionario=new TreeMap<String,String>();
	
	public void aggiungiTraduzione(String str) {
		String campi[]=str.split(" ");
		dizionario.put(campi[0],campi[1]);
		

	}

	public String fornisciTraduzione(String str) {
		if (dizionario.get(str)!=null)
			return dizionario.get(str);
		else 
			return "Traduzione non presente nel dizionario";
	}
	
	
	public void clearText() {
		dizionario.clear();
	}
	
	
	public boolean inputOk(String s) {
		char arraycaratteri[]=s.toCharArray();

		for(int i=0;i<arraycaratteri.length;i++) {
			if(Character.isDigit(arraycaratteri[i])==true) {
				return false;				 
			}

		}
		return true;
	}
}


