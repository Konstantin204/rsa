package org.example;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static boolean isPrime(int n){
        boolean flag = false;
        for (int i = 2; i <= n / 2; ++i) {
            if (n % i == 0) {
                flag = true;
                break;
            }
        }
        return flag;
    }
    static int gcd(int e, int z) {
        if (e == 0)
            return z;
        else
            return gcd(z % e, e);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter prime number p:");
        int p = scanner.nextInt();
        System.out.println("Enter prime number q:");
        int q = scanner.nextInt();
        if(isPrime(p)) System.out.println("Your number p is not prime!");
        if(isPrime(q)) System.out.println("Your number q is not prime!");
        int n = p*q;
        System.out.println("the value of n: " + n);
        int phiN = (p-1)*(q-1);
        System.out.println("the value of phiN: " + phiN);
        int e;
        for(e = 2 ; e<phiN ; e++){
            if(gcd(e , phiN) == 1)
                break;
        }
        System.out.println("the value of e: " + e);
        int d = 0;
        for(int i = 0 ; i <= 9 ; i++){
            int x = 1 + (i * phiN);
            if(x % e == 0)
            {
                d = x / e;
                break;
            }
        }
        System.out.println("the value of d: " + d);
        Scanner scannerMsg = new Scanner(System.in);
        System.out.println("Enter message to be encrypted: ");
        String cipher = scannerMsg.nextLine();
        BigInteger[] cipherAscii = new BigInteger[cipher.length()];
        for(int i = 0; i < cipher.length(); i++){
            cipherAscii[i] = BigInteger.valueOf(cipher.charAt(i));
        }
        BigDecimal[] c = new BigDecimal[cipherAscii.length];
        BigInteger N = BigInteger.valueOf(n);
        for(int i = 0; i < cipherAscii.length; i++){
            c[i] = new BigDecimal(cipherAscii[i].pow(e).mod(N), 0);
            System.out.println(c[i]);
        }
        BigInteger[] decryptedAscii = new BigInteger[c.length];
        for(int i = 0; i < c.length; i++){
            decryptedAscii[i] = c[i].toBigInteger().pow(d).mod(N);
        }
        char[] decrypted = new char[decryptedAscii.length];
        for(int i = 0; i < decryptedAscii.length; i++){
            decrypted[i] = (char)(decryptedAscii[i]).intValueExact();
        }
        for(int i = 0; i < decrypted.length; i++){
            System.out.println(decrypted[i]);
        }
    }

}