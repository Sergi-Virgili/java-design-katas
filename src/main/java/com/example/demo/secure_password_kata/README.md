# 🛡️ Secure Password Kata

## Descripción

El objetivo de esta kata es implementar un validador de contraseñas seguras utilizando buenas prácticas de diseño y desarrollo, como Clean Code, TDD y principios SOLID.

Esta es una kata ideal para practicar:

- Red-Green-Refactor (TDD)
- Diseño orientado al comportamiento
- Principio de responsabilidad única (SRP)
- Código expresivo y mantenible
- Posible uso de patrones como Strategy o Chain of Responsibility

## Reglas iniciales

Una contraseña se considera segura si cumple todas las siguientes reglas:

1. Tiene al menos **8 caracteres**.
2. Contiene al menos **una letra mayúscula**.
3. Contiene al menos **una letra minúscula**.
4. Contiene al menos **un número**.
5. Contiene al menos **un carácter especial** (`!@#$%^&*()` u otros).

> Puedes añadir o modificar reglas según el contexto que quieras simular (empresa, cliente, sistema legacy, etc.)

## Requisitos técnicos

- Lenguaje: Java
- Testing: JUnit (u otro framework si prefieres)
- Nivel: Medio
- Estilo: Diseño progresivo guiado por tests

## Sugerencia de diseño (opcional)

```java
interface PasswordRule {
    boolean isValid(String password);
    String reason(); // opcional, para feedback en tests o UI
}
```

```java
class PasswordValidator {
    private List<PasswordRule> rules;

    public PasswordValidator(List<PasswordRule> rules) {
        this.rules = rules;
    }

    public boolean isSecure(String password) {
        return rules.stream().allMatch(rule -> rule.isValid(password));
    }
}
```

## Ejemplo de test inicial

```java
@Test
void shouldRejectPasswordThatIsTooShort() {
    var validator = PasswordValidatorFactory.defaultValidator();
    assertFalse(validator.isSecure("Ab1!"));
}
```

## Buenas prácticas a aplicar

- ✔ Escribe primero los tests
- ✔ Refactoriza en cada paso
- ✔ Nombra las clases y métodos con intención
- ✔ Evita lógica duplicada o anidada
- ✔ Haz pequeñas mejoras continuas

## Extensiones posibles

- Mostrar razones por las que la contraseña ha fallado
- Permitir contraseñas “aceptables” pero no “seguras”
- Internacionalización del feedback
- Adaptar las reglas a políticas reales de empresas

---

¡Disfrútala! Esta kata es perfecta para preparar el curso de **Pilares del Software** y entrenar tu criterio técnico desde el primer test.
