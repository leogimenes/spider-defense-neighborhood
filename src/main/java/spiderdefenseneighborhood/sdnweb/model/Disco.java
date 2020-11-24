package spiderdefenseneighborhood.sdnweb.model;

public class Disco {
	private String partition;
	private String discoLivre;
	private String discoUsado;
	
	public Disco() {
		
	}
	
	public Disco(String partition, String discoLivre, String discoUsado) {
		super();
		this.partition = partition;
		this.discoLivre = discoLivre;
		this.discoUsado = discoUsado;
	}
	
	public String getPartition() {
		return partition;
	}
	public void setPartition(String partition) {
		this.partition = partition;
	}
	public String getDiscoLivre() {
		return discoLivre;
	}
	public void setDiscoLivre(String discoLivre) {
		this.discoLivre = discoLivre;
	}
	public String getDiscoUsado() {
		return discoUsado;
	}
	public void setDiscoUsado(String discoUsado) {
		this.discoUsado = discoUsado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((discoLivre == null) ? 0 : discoLivre.hashCode());
		result = prime * result + ((discoUsado == null) ? 0 : discoUsado.hashCode());
		result = prime * result + ((partition == null) ? 0 : partition.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Disco other = (Disco) obj;
		if (discoLivre == null) {
			if (other.discoLivre != null)
				return false;
		} else if (!discoLivre.equals(other.discoLivre))
			return false;
		if (discoUsado == null) {
			if (other.discoUsado != null)
				return false;
		} else if (!discoUsado.equals(other.discoUsado))
			return false;
		if (partition == null) {
			if (other.partition != null)
				return false;
		} else if (!partition.equals(other.partition))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Disco [partition=" + partition + ", discoLivre=" + discoLivre + ", discoUsado=" + discoUsado + "]";
	}
	
	
	
	
}
