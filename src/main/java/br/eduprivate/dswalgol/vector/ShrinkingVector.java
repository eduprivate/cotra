package br.eduprivate.dswalgol.vector;

public class ShrinkingVector extends ArrayVector {

    private Object[] a;

    private int size = 0;
    private int capacity = 16;


    public ShrinkingVector(final Object original[], final int sizeOriginal) {
        this.a = original;
        this.size = sizeOriginal;
    }

    public void shrinkToFit() {
        Object[] b = new Object[size];
        for (int i = 0; i <= b.length; i++) {
            b[i] = a[i];
        }
        this.a = b;
        this.capacity = 16;
    }
}
