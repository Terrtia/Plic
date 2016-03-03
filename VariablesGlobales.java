package plic;

import java.util.ArrayList;

import plic.tds.TDS;

public class VariablesGlobales {

	private static VariablesGlobales instance = new VariablesGlobales();
	
	private int numeroBloc;
	private ArrayList<String> dataString;
	
	private VariablesGlobales() {
		numeroBloc = -1;
		dataString = new ArrayList<>();
	}
	
	public static VariablesGlobales getInstance() {
		return instance;
	}
	
	public int getNumeroBloc() {
		return this.numeroBloc;
	}
	
	public void IncrNumeroBloc() {
		this.numeroBloc++;
	}
	
	public void addData(String str){
		dataString.add(str);
	}
	public String getData(int i){
		return dataString.get(i);
	}

	public int getDataSize() {
		return dataString.size();
	}
	
}
