# Builder Design Pattern

## What is Builder?

The **Builder Pattern** is a **GoF creational design pattern** that separates:

- The **construction of a complex object**
- From its **final representation**

It allows objects to be created **step by step**, using a fluent and readable API, without exposing complex constructors or forcing clients to pass many parameters at once.

---

## The Problem Builder Solves

When a class has:
- Many parameters
- Optional fields
- Default values
- Different construction combinations

Using constructors leads to:
- Constructor telescoping
- Confusing parameter order
- Poor readability
- Hard-to-maintain code


  **Bad example (telescoping constructors)**

```
new HttpRequest(url, method, headers, queryParams, body, timeout);
```

In such cases:
- `null` values become ambiguous
- Parameter order becomes error-prone
- Adding a new optional field breaks existing constructors

---

## Why Use Builder?

Builder is useful when:
- An object has **many optional parameters**
- You want **readable and expressive object creation**
- You want to **avoid constructor explosion**
- You want to **enforce required fields**
- You want to build **immutable objects**

---

## How Builder Works

1. The client requests a **Builder**
2. The client configures the object step by step
3. The Builder stores all provided values
4. The `build()` method:
    - Validates required fields
    - Applies default values
    - Creates the final object
5. The resulting object is typically **immutable**

---

## Core Participants

- **Product**  
  The complex object being created.

- **Builder**  
  Collects construction parameters and creates the product.

- **Client**  
  Uses the builder to configure and create objects.

- **Director (optional)**  
  Encapsulates predefined construction steps for common object configurations.

> Important:  
> The **Director is optional**. Many modern Java builders do **not** use it.

---

## Builder Without Director (Most Common)

This is the **most common and practical usage** of Builder in modern Java.

Characteristics:
- Fluent API
- Optional parameters
- Defaults handled internally
- Required fields validated in one place

This approach is widely used in:
- Spring
- Lombok
- OkHttp
- JDK APIs

---

## Builder With Director (Optional)

### What is a Director?

A **Director** is a class that:
- Knows **how to build specific object configurations**
- Uses the builder internally
- Hides construction details from the client

Instead of repeating the same builder steps everywhere, the Director provides:
- Reusable construction recipes
- Consistent object creation
- Cleaner client code

---

## When to Use a Director?

Use a Director when:
- You repeatedly create **standard configurations**
- Construction logic is duplicated across the codebase
- You want to enforce consistency
- You want to hide object construction complexity

Avoid a Director when:
- Object creation is simple
- Each object is customized differently
- The builder alone is sufficient

---

## Validation and Default Values

One of the key strengths of Builder is **centralized validation**.

The `build()` method is responsible for:
- Checking required fields
- Applying default values
- Preventing invalid object creation

This guarantees:
- No partially constructed objects
- No invalid states
- A clean and safe API

---

## Pros and Cons

### Pros

- Eliminates constructor explosion
- Improves readability
- Handles optional parameters cleanly
- Encourages immutability
- Centralizes validation logic
- Easy to extend without breaking clients

### Cons

- Requires additional code (Builder class)
- Slight overhead for very simple objects
- Director can add unnecessary abstraction if misused

---

## Builder vs Other Creational Patterns

| Pattern              | Focus / Purpose                            | Key Idea / Notes                                                                                |
|----------------------|--------------------------------------------|-------------------------------------------------------------------------------------------------|
| **Builder**          | How to build a complex object step by step | Handles **construction complexity**; allows stepwise creation. Often used with optional parts.  |
| **Factory**          | Which object to create                     | Handles **type selection**; creates objects in **one step**.                                    |
| **Abstract Factory** | Create families of related objects         | Provides a **group of related objects** with a common interface; ensures objects work together. |

> **Builder** → construction complexity, **Factory** → type selection.  
