package br.eduprivate.effective.c3.item8;

public class QueryTester {
	
	public static void main(String[] args) {
		Query query = new Query("select", "product");
		System.out.println(query);
		
		Query productQuery = new ProductQuery("select", "product");
		System.out.println(productQuery);
		
		Query feedbackQuery = new FeedbackQuery("select", "feedback");
		System.out.println(feedbackQuery);
		
		System.out.println(query.equals(productQuery));
		System.out.println(query.equals(feedbackQuery));
		System.out.println(productQuery.equals(feedbackQuery));
	}
}
