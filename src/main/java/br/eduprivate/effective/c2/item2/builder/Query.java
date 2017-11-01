package br.eduprivate.effective.c2.item2.builder;


public class Query {
	
	private Long id;
	private String name;
	private String value;
	private String filter;
	private String sortBy;
	
	public Query(String name, String value, String filter, String sortBy) {
		super();
		this.name = name;
		this.value = value;
		this.filter = filter;
		this.sortBy = sortBy;
	}

	public Query(Long id, String name, String value, String filter,
			String sortBy) {
		super();
		this.id = id;
		this.name = name;
		this.value = value;
		this.filter = filter;
		this.sortBy = sortBy;
	}
	
	
}
