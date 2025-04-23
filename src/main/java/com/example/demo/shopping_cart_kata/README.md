# 🛒 Shopping Cart Kata

## Descripción

El objetivo de esta kata es implementar un **carrito de la compra** utilizando principios de diseño como Clean Code, TDD y SOLID. La idea es ir construyendo funcionalidades sobre un dominio realista, donde cada nueva regla representa una oportunidad para refactorizar y mejorar el diseño.

Esta kata te permite practicar:

- 🧪 TDD paso a paso
- 🧠 Modelado orientado al dominio
- 🔁 Refactor continuo
- 🧱 Uso de Value Objects y polimorfismo
- 🛠 Diseño extensible con principios SOLID

---

## Requisitos iniciales

1. Puedes **añadir** un producto al carrito.
2. Puedes **eliminar** un producto del carrito.
3. Puedes obtener el **total** del carrito.
4. Puedes aplicar un **descuento porcentual** sobre el total.
5. Un producto tiene **nombre**, **precio** y se añade con **cantidad**.

---

## Ejemplo de test inicial

```java
@Test
void shouldReturnTotalPriceForOneProduct() {
    ShoppingCart cart = new ShoppingCart();
    cart.add(new Product("Keyboard", BigDecimal.valueOf(50)), 1);
    assertEquals(BigDecimal.valueOf(50), cart.total());
}
```

---

## Diseño sugerido

```java
public class ShoppingCart {
    void add(Product product, int quantity) { ... }
    void remove(String productName) { ... }
    BigDecimal total() { ... }
    void applyDiscount(DiscountPolicy policy) { ... }
}
```

```java
public class Product {
    private final String name;
    private final BigDecimal price;
    // equals/hashCode by name
}
```

```java
public interface DiscountPolicy {
    BigDecimal apply(BigDecimal originalTotal);
}
```

---

## Reglas adicionales para extender la kata

- ✅ Si se añade un producto ya existente, se acumula la cantidad.
- ❌ No se pueden añadir productos con precio negativo o cantidad 0.
- 💵 Se pueden aplicar descuentos en porcentaje.
- 💰 Se pueden aplicar impuestos (IVA).
- 📦 Se pueden calcular totales por categoría.
- 🧾 Se puede generar un "ticket" como resumen del carrito.

---

## Buenas prácticas a seguir

- Empezar con un test simple y avanzar por pasos (Red-Green-Refactor)
- Nombrar con intención: `add`, `remove`, `applyDiscount`, `total`, etc.
- Refactorizar estructuras duplicadas o anidadas
- Delegar comportamientos a objetos pequeños y reutilizables
- Aplicar SRP: no mezclar reglas de negocio en estructuras de datos

---

## Nivel sugerido

**Intermedio/Avanzado** — Ideal para practicar diseño progresivo, testeo y refactorización realista.

---

¿Estás listo para llevar tu código a producción sin ansiedad?  
Empieza con un carrito sencillo y refactorízalo hasta que puedas estar orgulloso del diseño.

