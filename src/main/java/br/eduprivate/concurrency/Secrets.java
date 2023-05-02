package br.eduprivate.concurrency;

import java.util.HashSet;
import java.util.Set;

/**
 * Secrets
 *
 * Publishing an object
 *
 */
class Secrets {
    public static Set<Secret> knownSecrets;

    public void initialize() {
        knownSecrets = new HashSet<Secret>();
    }
}


class Secret {
}
