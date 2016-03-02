package plic.tds.entrees;

public abstract class Entree {
	
	protected String idf;
	protected int ligne;
	
	public Entree(String nom) {
		idf = nom;
	}
	
	public Entree(String nom, int l) {
		idf = nom;
		ligne = l;
	}

	public String getIdf() {
		return idf;
	}

	public int getLigne() {
		return ligne;
	}
	
	public void setIdf(String idf) {
		this.idf = idf;
	}

	public void setLigne(int ligne) {
		this.ligne = ligne;
	}

	@Override
	public String toString() {
		return "Entree [idf=" + idf + ", ligne=" + ligne + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entree other = (Entree) obj;
		if (idf == null) {
			if (other.idf != null)
				return false;
		} else if (!idf.equals(other.idf))
			return false;
		return true;
	}
	

}
