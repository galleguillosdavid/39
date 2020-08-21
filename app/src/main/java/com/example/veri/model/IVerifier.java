package com.example.veri.model;

public interface IVerifier {
    boolean evaluateLength(String password);
    boolean evaluateUpper(String password);
}
