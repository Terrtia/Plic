package plic.exceptions;

@SuppressWarnings("serial")
public class DoubleDeclarationException extends AnalyseException {

	public DoubleDeclarationException(String m) {
		super("Double declaration de l'entree : " + m + "\n");
	}

}
