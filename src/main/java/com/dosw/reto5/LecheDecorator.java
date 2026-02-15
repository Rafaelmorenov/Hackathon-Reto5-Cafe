package com.dosw.reto5;

public class LecheDecorator extends CafeDecorator {
    public LecheDecorator(Cafe cafe) {
        super(cafe);
    }

    @Override
    public String getDescripcion() {
        return cafeDecorado.getDescripcion() + " + Leche";
    }

    @Override
    public double getPrecio() {
        return cafeDecorado.getPrecio() + 1000.0;
    }
}
