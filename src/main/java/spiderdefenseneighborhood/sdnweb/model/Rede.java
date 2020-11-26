package spiderdefenseneighborhood.sdnweb.model;

public class Rede {
	private Integer download;
	private Integer upload;
	
	
	public Rede() {
		super();
	}

	public Rede(Integer download, Integer upload) {
		super();
		this.download = download;
		this.upload = upload;
	}

	public Integer getDownload() {
		return download;
	}

	public void setDownload(Integer download) {
		this.download = download;
	}

	public Integer getUpload() {
		return upload;
	}

	public void setUpload(Integer upload) {
		this.upload = upload;
	}

	@Override
	public String toString() {
		return "Rede [download=" + download + ", upload=" + upload + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rede other = (Rede) obj;
		if (download == null) {
			if (other.download != null)
				return false;
		} else if (!download.equals(other.download))
			return false;
		if (upload == null) {
			if (other.upload != null)
				return false;
		} else if (!upload.equals(other.upload))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((download == null) ? 0 : download.hashCode());
		result = prime * result + ((upload == null) ? 0 : upload.hashCode());
		return result;
	}

	
}
