package br.eduprivate.effective.c6.item34;

public enum ExtendedQuery implements Query {
	PRODUCT("product"){
		
		public String parseParams(String params) {
			return this.name();
		}
		
		public String search(String query) {
			return this.name();
		}
	}, 
	CATEGORY("category"){
		public String parseParams(String params) {
			return this.name();
		}
	
		public String search(String query) {
			return this.name();
		}
	};
	
	private String query;
	
	private ExtendedQuery(String query) {
		this.query = query;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
