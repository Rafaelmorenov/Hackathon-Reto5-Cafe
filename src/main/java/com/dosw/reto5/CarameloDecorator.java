package com.dosw.reto5;

public class CarameloDecorator extends CafeDecorator {
    public CarameloDecorator(Cafe cafe) {
        super(cafe);
    }

    @Override
    public String getDescripcion() {
        return cafeDecorado.getDescripcion() + " + Caramelo";
    }

    @Override
    public double getPrecio() {
        return cafeDecorado.getPrecio() + 1200.0;
    }
}
