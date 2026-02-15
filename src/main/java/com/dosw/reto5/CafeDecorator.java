package com.dosw.reto5;

public abstract class CafeDecorator implements Cafe {
    protected Cafe cafeDecorado;

    public CafeDecorator(Cafe cafe) {
        this.cafeDecorado = cafe;
    }
}
