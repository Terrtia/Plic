package plic.tds.entrees;

public abstract class Entree {
	
	protected String idf;
	protected int ligne;
	
	public Entree(String nom) {
		this.idf = nom;
	}

	public String getIdf() {
		return idf;
	}
	
	public void setIdf(String idf) {
		this.idf = idf;
	}

	@Override
	public String toString() {
		return "Entree [idf=" + idf + "]";
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
