# Cafetería Creativa - Sistema de Personalización de Café

## Descripción del Problema
La Cafetería Creativa permite a los clientes personalizar su café agregando toppings, salsas y complementos. Cada topping tiene un precio adicional y puede combinarse con otros. El sistema actual es deficiente y requiere mejoras para la producción de cafés.

## Solución Implementada

### Patrón de Diseño
**Estructural**

### Patrón Utilizado
**Decorator**

### Justificación
El patrón Decorator permite añadir responsabilidades (toppings) a un objeto (café base) de manera dinámica y transparente, sin alterar la clase original. Este patrón es ideal porque:

- Permite agregar funcionalidades de forma dinámica sin modificar el código existente
- Facilita la combinación de múltiples toppings de manera flexible
- Cumple con el principio Open/Closed (abierto para extensión, cerrado para modificación)
- Permite agregar nuevos toppings sin modificar la base del café

### Cómo Lo Aplico
1. **Interfaz Cafe**: Define el contrato con los métodos `getDescripcion()` y `getPrecio()`
2. **CafeBase**: Implementación concreta del café sin toppings (precio base: $2.000)
3. **CafeDecorator**: Clase abstracta que implementa Cafe y contiene una referencia al café decorado
4. **Decoradores Concretos**: Cada topping es un decorador que:
   - Extiende CafeDecorator
   - Agrega su descripción al café decorado
   - Suma su precio al precio del café decorado

## Estructura del Proyecto

```
src/main/java/com/dosw/reto5/
├── Cafe.java                    # Interfaz principal
├── CafeBase.java                # Componente concreto (café base)
├── CafeDecorator.java           # Decorador abstracto
├── LecheDecorator.java          # Decorador: Leche ($1.000)
├── ChocolateDecorator.java      # Decorador: Chocolate ($1.500)
├── CarameloDecorator.java       # Decorador: Caramelo ($1.200)
├── CremaBatidaDecorator.java    # Decorador: Crema Batida ($2.000)
├── MentaDecorator.java          # Decorador: Menta ($1.300)
└── Reto5Cafe.java               # Clase principal con lógica de ejecución
```

## Toppings Disponibles

| Opción | Topping       | Precio  |
|--------|---------------|---------|
| 1      | Leche         | $1.000  |
| 2      | Chocolate     | $1.500  |
| 3      | Caramelo      | $1.200  |
| 4      | Crema Batida  | $2.000  |
| 5      | Menta         | $1.300  |

## Funcionalidades

El usuario puede elegir X toppings por café  
Muestra la descripción final y precio total después del pago  
Usa Streams para calcular el total general de varios cafés  
Permite agregar nuevos toppings sin modificar la base  

## Uso de Streams

El sistema utiliza Java Streams para calcular el total general de todos los cafés pedidos:

```java
double totalGeneral = pedidos.stream()
    .mapToDouble(Cafe::getPrecio)
    .sum();
```

## Cómo Ejecutar

```bash
# Compilar
javac src/main/java/com/dosw/reto5/*.java

# Ejecutar
java com.dosw.reto5.Reto5Cafe
```

## Ejemplo de Uso

```
=== CAFETERÍA CREATIVA ===

--- Nuevo Café ---
Café base: $2000.0

--- Lista de toppings disponibles ---
1. Leche - $1.000
2. Chocolate - $1.500
3. Caramelo - $1.200
4. Crema Batida - $2.000
5. Menta - $1.300
0. Finalizar este café

Seleccione un topping: 1
✓ Leche agregada

Seleccione un topping: 2
✓ Chocolate agregado

Seleccione un topping: 0

--- Café completado ---
Descripción: Café base + Leche + Chocolate
Precio: $4500.0

=== RESUMEN DEL PEDIDO ===

Café base + Leche + Chocolate
Precio: $4500.0

=================================
Total a pagar por todos los cafés: $4500.0
=================================
```

## Ventajas de la Solución

1. **Extensibilidad**: Agregar nuevos toppings solo requiere crear una nueva clase decoradora
2. **Flexibilidad**: Los toppings se pueden combinar en cualquier orden y cantidad
3. **Mantenibilidad**: Cada topping está encapsulado en su propia clase
4. **Sin modificación de código existente**: Cumple con el principio Open/Closed

## Autor
Desarrollado como solución al Reto 5 - Cafetería Creativa
