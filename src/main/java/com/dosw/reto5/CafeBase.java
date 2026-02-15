package com.dosw.reto5;

public class CafeBase implements Cafe {
    @Override
    public String getDescripcion() {
        return "Café base";
    }

    @Override
    public double getPrecio() {
        return 2000.0;
    }
}
