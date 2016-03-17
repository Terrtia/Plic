package plic;

import java.util.ArrayList;

public class VariablesGlobales {

	private static VariablesGlobales instance = new VariablesGlobales();
	
	private int numeroBloc;
	private ArrayList<String> dataString;
	private int si;
	private StringBuilder condition;
	private int boucle;
	
	private VariablesGlobales() {
		numeroBloc = -1;
		dataString = new ArrayList<>();
		si = 0;
		boucle = 0;
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

	public void addSi() {
		si++;		
	}
	
	public int getSi(){
		return si;
	}
	
	public void addCondition(String Condition) {
		this.condition.append(Condition);
	}
	
	public String getCondition() {
		return this.condition.toString();
	}
	
	public void addBoucle() {
		boucle++;		
	}
	public int getBoucle(){
		return boucle;
	}
}
