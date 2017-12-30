package br.eduprivate.concurrency;

/**
 * UnsafeStates
 * <p/>
 * Allowing internal mutable state to escape
 *
 */
class UnsafeStates {
    private String[] states = new String[]{
        "AK", "AL" /*...*/
    };

    public String[] getStates() {
        return states;
    }
}
