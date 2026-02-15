package com.dosw.reto5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reto5Cafe {
    public static void ejecutar() {
        Scanner scanner = new Scanner(System.in);
        List<Cafe> pedidos = new ArrayList<>();
        
        System.out.println("=== CAFETERÍA CREATIVA ===\n");
        
        boolean continuarPidiendo = true;
        
        while (continuarPidiendo) {
            Cafe cafe = new CafeBase();
            System.out.println("\n--- Nuevo Café ---");
            System.out.println("Café base: $" + cafe.getPrecio());
            
            boolean agregarToppings = true;
            
            while (agregarToppings) {
                System.out.println("\n--- Lista de toppings disponibles ---");
                System.out.println("1. Leche - $1.000");
                System.out.println("2. Chocolate - $1.500");
                System.out.println("3. Caramelo - $1.200");
                System.out.println("4. Crema Batida - $2.000");
                System.out.println("5. Menta - $1.300");
                System.out.println("0. Finalizar este café");
                System.out.print("\nSeleccione un topping: ");
                
                int opcion = scanner.nextInt();
                
                switch (opcion) {
                    case 1:
                        cafe = new LecheDecorator(cafe);
                        System.out.println("✓ Leche agregada");
                        break;
                    case 2:
                        cafe = new ChocolateDecorator(cafe);
                        System.out.println("✓ Chocolate agregado");
                        break;
                    case 3:
                        cafe = new CarameloDecorator(cafe);
                        System.out.println("✓ Caramelo agregado");
                        break;
                    case 4:
                        cafe = new CremaBatidaDecorator(cafe);
                        System.out.println("✓ Crema Batida agregada");
                        break;
                    case 5:
                        cafe = new MentaDecorator(cafe);
                        System.out.println("✓ Menta agregada");
                        break;
                    case 0:
                        agregarToppings = false;
                        break;
                    default:
                        System.out.println("Opción inválida");
                }
            }
            
            pedidos.add(cafe);
            System.out.println("\n--- Café completado ---");
            System.out.println("Descripción: " + cafe.getDescripcion());
            System.out.println("Precio: $" + cafe.getPrecio());
            
            System.out.print("\n¿Desea pedir otro café? (1=Sí, 0=No): ");
            int continuar = scanner.nextInt();
            continuarPidiendo = (continuar == 1);
        }
        
        System.out.println("\n=== RESUMEN DEL PEDIDO ===");
        pedidos.forEach(cafe -> {
            System.out.println("\n" + cafe.getDescripcion());
            System.out.println("Precio: $" + cafe.getPrecio());
        });
        
        // REQUISITO: Uso de Streams para calcular el total general
        double totalGeneral = pedidos.stream()
            .mapToDouble(Cafe::getPrecio)
            .sum();
        
        System.out.println("\n=================================");
        System.out.println("Total a pagar por todos los cafés: $" + totalGeneral);
        System.out.println("=================================");
        
        scanner.close();
    }
    
    public static void main(String[] args) {
        ejecutar();
    }
}
