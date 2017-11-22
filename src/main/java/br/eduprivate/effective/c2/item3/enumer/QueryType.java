package br.eduprivate.effective.c2.item3.enumer;

public enum QueryType {
	PRODUCT("product");
	
	public String type;
	
	QueryType(String type) {
		this.type = type;
	}
	
	public void getQueryType() {
		System.out.println(this.type);
	}
	
	public static void main(String[] args) {
		QueryType.PRODUCT.getQueryType();
	}
}
