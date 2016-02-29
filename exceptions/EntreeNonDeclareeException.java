package plic.exceptions;

@SuppressWarnings("serial")
public class EntreeNonDeclareeException extends AnalyseException {

	public EntreeNonDeclareeException(String m) {
		super("Entree non declaree : " + m + "\n");
	}

}
