package br.eduprivate.effective.c3.item8;

class ProductQuery extends Query {
	
	ProductQuery(String query, String index) {
		super(query, index);
	}

	@Override
	public String toString() {
		return "ProductQuery: " + super.toString();
	}	
}
