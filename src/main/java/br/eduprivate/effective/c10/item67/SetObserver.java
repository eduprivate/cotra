package br.eduprivate.effective.c10.item67;
// Set obeserver callback interface - Page 266

public interface SetObserver<E> {
    // Invoked when an element is added to the observable set
    void added(ObservableSet<E> set, E element);
}
