package br.eduprivate.concurrency;


/**
 * EagerInitialization
 * <p/>
 * Eager initialization
 *
 */
@ThreadSafe
        public class EagerInitialization {
    private static Resource resource = new Resource();

    public static Resource getResource() {
        return resource;
    }

    static class Resource {
    }
}
