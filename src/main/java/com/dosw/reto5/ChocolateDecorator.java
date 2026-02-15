package com.dosw.reto5;

public class ChocolateDecorator extends CafeDecorator {
    public ChocolateDecorator(Cafe cafe) {
        super(cafe);
    }

    @Override
    public String getDescripcion() {
        return cafeDecorado.getDescripcion() + " + Chocolate";
    }

    @Override
    public double getPrecio() {
        return cafeDecorado.getPrecio() + 1500.0;
    }
}
