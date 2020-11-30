package spiderdefenseneighborhood.sdnweb.model;

import java.util.ArrayList;
import java.util.List;

public class Status {
	private String host;
	private List<String> ifName = new ArrayList<String>();
	private List<String> ifOperStatus = new ArrayList<String>();
			
	
	public Status(String host, List<String> ifName, List<String> ifOperStatus) {
		super();
		this.host = host;
		this.ifName = ifName;
		this.ifOperStatus = ifOperStatus;
	}

	public Status() {
		super();
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public List<String> getIfName() {
		return ifName;
	}

	public void setIfName(List<String> ifName) {
		this.ifName = ifName;
	}

	public List<String> getIfOperStatus() {
		return ifOperStatus;
	}

	public void setIfOperStatus(List<String> ifOperStatus) {
		this.ifOperStatus = ifOperStatus;
	}

	@Override
	public String toString() {
		return "Status [host=" + host + ", ifName=" + ifName + ", ifOperStatus=" + ifOperStatus + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ifName == null) ? 0 : ifName.hashCode());
		result = prime * result + ((ifOperStatus == null) ? 0 : ifOperStatus.hashCode());
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
		Status other = (Status) obj;
		if (ifName == null) {
			if (other.ifName != null)
				return false;
		} else if (!ifName.equals(other.ifName))
			return false;
		if (ifOperStatus == null) {
			if (other.ifOperStatus != null)
				return false;
		} else if (!ifOperStatus.equals(other.ifOperStatus))
			return false;
		return true;
	}

}
