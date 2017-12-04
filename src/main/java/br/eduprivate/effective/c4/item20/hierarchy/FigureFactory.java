package br.eduprivate.effective.c4.item20.hierarchy;

public enum FigureFactory {
	
	RECTANGLE(new Rectangle(0.0, 0.0)),
	SQUARE(new Square(0.0));
	
	private Figure figure;
	
	FigureFactory(Figure figure){
		this.figure = figure;
	}
	
	public Figure getFigure() {
		return figure;
	}
}
