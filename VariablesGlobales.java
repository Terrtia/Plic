package plic;

public class VariablesGlobales {

	private static VariablesGlobales instance = new VariablesGlobales();
	
	private int numeroBloc;
	
	private VariablesGlobales() {
		numeroBloc = -1;
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
}
