# Adapter Design Pattern

## What is Adapter?

The **Adapter Pattern** is a **GoF structural design pattern** that allows **incompatible interfaces to work together**.

- It acts as a **bridge** between two interfaces.
- Converts the interface of an existing class (**Adaptee**) into another interface (**Target**) expected by the client.
- Enables **reuse of existing code** without modification.

---

## The Problem Adapter Solves

When integrating:

- **Legacy systems**
- **Third-party libraries**
- **Modules with different interfaces**

Developers often write:
```
if (legacyType) {
    legacy.process();
}
else {
    modern.process();
}
```

Problems with this approach:

- Code becomes **messy and tightly coupled**
- Violates **Open/Closed Principle (OCP)**
- Hard to scale or maintain
- Mixing logic of multiple implementations in client code

The Adapter Pattern **solves this** by introducing a wrapper class that:

- Implements the **Target interface**
- Holds a reference to the **Adaptee**
- Translates client calls into the adaptee’s methods

---

## Why Use Adapter?

Adapter is useful when you want to:

- Integrate a **legacy or third-party system** without changing its code
- Make **incompatible interfaces work together**
- **Decouple client code** from implementation details
- Maintain **flexibility and scalability** in your system

---

## How Adapter Works

1. **Target Interface** defines the methods the client expects.
2. **Adaptee** is the existing class with an incompatible interface.
3. **Adapter** implements the Target interface and translates calls to the Adaptee.
4. **Client** uses the Target interface, unaware of the underlying Adaptee.

---

## Real-World Analogy

Traveling from the US to Europe:

- Your laptop charger uses **Type A plug**
- European sockets use **Type C plug**
- You use a **travel plug adapter**:

    - Adapter converts Type A → Type C
    - **You don’t modify the charger**
    - **You don’t modify the wall socket**
    - Adapter bridges the two incompatible interfaces

---

## Core Participants

| Role        | Description                                   | Example from this demo     |
|-------------|-----------------------------------------------|----------------------------|
| **Target**  | Interface expected by the client              | `JsonData` (`toJson()`)    |
| **Adaptee** | Existing incompatible class                   | `XmlData` (`getXmlData()`) |
| **Adapter** | Wraps Adaptee and implements Target           | `XmlToJsonAdapter`         |
| **Client**  | Uses Target interface without knowing Adaptee | `ReportGenerator`          |

---

## Types of Adapters

### 1. Object Adapter (Preferred in Java)

- Uses **composition**: Adapter holds a reference to the Adaptee
- **Flexible and loosely coupled**
- Can adapt multiple Adaptees without inheritance

### 2. Class Adapter (Rare in Java)

- Uses **inheritance**: Adapter inherits from Adaptee and implements Target
- Requires **multiple inheritance**, which Java doesn’t support for classes
- More common in **C++ or languages with multiple inheritance**

> This demo uses an **Object Adapter** (implemented via composition).

---

## Benefits of Adapter

- **Decouples client and legacy code**
- **Allows reuse** of existing classes
- **Supports Open/Closed Principle**: adding new adapters doesn’t modify client
- **Improves maintainability**: translation logic is encapsulated in one place
- **Supports multiple conversions**: XML → JSON, CSV → JSON, etc.

---

## Pros and Cons

### Pros

- Enables **integration of incompatible systems**
- Shields clients from complex or legacy code
- Encourages **composition over inheritance**
- Supports **polymorphism** through the Target interface
- Can handle **method renaming, parameter mapping, and type conversion**

### Cons

- Introduces an **extra layer** of abstraction
- Adapter may contain **non-trivial translation logic**
- Overhead for **simple cases** where interfaces already match

---

## Adapter vs Other Structural Patterns

| Pattern       | Focus / Purpose                            | Notes                                                                    |
|---------------|--------------------------------------------|--------------------------------------------------------------------------|
| **Adapter**   | Make incompatible interfaces work together | Converts Adaptee → Target for clients                                    |
| **Facade**    | Simplify complex subsystem APIs            | Provides a unified interface, not necessarily adapting incompatible APIs |
| **Decorator** | Add responsibilities dynamically           | Wraps object for behavior, not interface translation                     |

> **Adapter** → interface translation  
> **Facade** → API simplification  
> **Decorator** → behavior enhancement

---

## Notes for Learning

- Adapter is **all about decoupling and flexibility**
- Always favor **object composition** in Java
- Keep translation logic in Adapter; **don’t modify client or Adaptee**
- Can combine with other patterns:
    - Adapter + Factory: create adapters dynamically
    - Adapter + Builder: convert legacy objects to complex target objects
