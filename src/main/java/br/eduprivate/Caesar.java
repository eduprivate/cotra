package br.eduprivate;

public class Caesar {
    public static final int ALPHASIZE = 26;
    public static final char[] alpha = {'A', 'B','C', 'D','E', 'F','G', 'H','I',
            'J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    protected char[] encrypt = new char[ALPHASIZE];
    protected char[] decrypt = new char[ALPHASIZE];
    
    public Caesar() {
        for (int i = 0; i < ALPHASIZE; i++) {
            encrypt[i] = alpha[(i+3)%ALPHASIZE];
        }
        for (int i = 0; i < ALPHASIZE; i++) {
            decrypt[encrypt[i] - 'A'] = alpha[i];
        }
    }

    public String encrypt(String secret) {
        char[] mess = secret.toCharArray();
        for (int i = 0; i < mess.length; i++) {
            if (Character.isUpperCase(mess[i])){
                mess[i] = encrypt[mess[i] - 'A'];
            }
        }
        return new String(mess);
    }

    public String decrypt(String secret) {
        char[] mess = secret.toCharArray();
        for (int i = 0; i < mess.length; i++) {
            if (Character.isUpperCase(mess[i])){
                mess[i] = decrypt[mess[i] - 'A'];
            }
        }
        return new String(mess);
    }

    public static void main(String[] args) {
        Caesar cipher = new Caesar();
        System.out.println("Encryption order = " + new String(cipher.encrypt));
        System.out.println("Decryption order = " + new String(cipher.decrypt));
        String secret = "THE EAGLE IS IN PLAY; MEET AT JOE'S";
        secret = cipher.encrypt(secret);
        System.out.println(secret);
        secret = cipher.decrypt(secret);
        System.out.println(secret);

    }

}
