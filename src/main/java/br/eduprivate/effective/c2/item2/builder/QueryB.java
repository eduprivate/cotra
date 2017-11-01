package br.eduprivate.effective.c2.item2.builder;

public class QueryB {
	
	private Long id;
	private String name;
	private String value;
	private String filter;
	private String sortBy;
	
	public static class Builder {
		private final String name;
		private final String value;
		
		private String filter = "length > 0";
		private String sortBy = "length";
		
		public Builder(String name, String value) {
			this.name = name;
			this.value = value;
		}
		
		public Builder withFilter(String filter) {
			this.filter = filter;
			return this;
		}
		
		public Builder withSortBy(String sortBy) {
			this.sortBy = sortBy;
			return this;
		}
		
		public QueryB build(){
			return new QueryB(this);
		}
	}
	
	private QueryB(Builder builder) {
		this.name = builder.name;
		this.value = builder.value;
		this.filter = builder.filter;
		this.sortBy = builder.sortBy;
	}
	
	public static void main(String[] args) {
		QueryB query = new QueryB.Builder("default", "select")
		    .withFilter("length>0")
		    .withSortBy("price")
		    .build();
	}

}
