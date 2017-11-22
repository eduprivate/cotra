package br.eduprivate.effective.c3.item8;

class FeedbackQuery extends Query {

	FeedbackQuery(String query, String index) {
		super(query, index);
	}
	
	@Override
	public String toString() {
		return "FeedbackQuery: " + super.toString();
	}	
}
