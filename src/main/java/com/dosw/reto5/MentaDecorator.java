package com.dosw.reto5;

public class MentaDecorator extends CafeDecorator {
    public MentaDecorator(Cafe cafe) {
        super(cafe);
    }

    @Override
    public String getDescripcion() {
        return cafeDecorado.getDescripcion() + " + Menta";
    }

    @Override
    public double getPrecio() {
        return cafeDecorado.getPrecio() + 1300.0;
    }
}
