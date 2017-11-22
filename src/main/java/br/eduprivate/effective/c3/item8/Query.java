package br.eduprivate.effective.c3.item8;

class Query {
	
	private String query;
	private String index;
	
	public Query(String query, String index) {
		super();
		this.query = query;
		this.index = index;
	}

	public String getIndex() {
		return index;
	}
	
	public String getQuery() {
		return query;
	}
	
	/*@Override // Liskov Substitution violation
	public boolean equals(Object obj) {
		if (obj == null || obj.getClass()  != getClass()) {
			return false;
		}
		Query q = (Query) obj;
		return q.getIndex().equals(index) && q.getQuery().equals(getQuery());
		
	}*/
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((index == null) ? 0 : index.hashCode());
		result = prime * result + ((query == null) ? 0 : query.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		Query other = (Query) obj;
		if (index == null) {
			if (other.index != null)
				return false;
		} else if (!index.equals(other.index))
			return false;
		if (query == null) {
			if (other.query != null)
				return false;
		} else if (!query.equals(other.query))
			return false;
		return true;
	}
	
	
	
	@Override
	public String toString() {
		return "Query[" + query + "], [" + index + "]"; 
	}
}
