package br.eduprivate.effective.c4.item20.hierarchy;

public class TestFactory {
	public static void main(String[] args) {
		
		Figure rectangle = FigureFactory.RECTANGLE.getFigure();
		Figure square = FigureFactory.SQUARE.getFigure();
		
		System.out.println(rectangle);
		System.out.println(square);
	}
}
