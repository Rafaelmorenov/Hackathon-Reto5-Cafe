package com.dosw.reto5;

public class CremaBatidaDecorator extends CafeDecorator {
    public CremaBatidaDecorator(Cafe cafe) {
        super(cafe);
    }

    @Override
    public String getDescripcion() {
        return cafeDecorado.getDescripcion() + " + Crema Batida";
    }

    @Override
    public double getPrecio() {
        return cafeDecorado.getPrecio() + 2000.0;
    }
}
