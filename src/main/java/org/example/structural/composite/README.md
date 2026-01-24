# Composite Design Pattern

## What is Composite?

The **Composite Pattern** is a **GoF structural design pattern** that allows you to **treat individual objects and compositions of objects uniformly**.

- It lets you build **tree-like hierarchical structures** of objects.
- Both **leaves (simple objects)** and **composites (objects containing other objects)** implement a **common interface**.
- Clients can interact with all objects through this interface without worrying about their concrete types.

---

## The Problem Composite Solves

When working with hierarchical structures, like:

- **Products and Boxes** in an ordering system
- **Files and Folders** in a file system
- **UI components** like panels containing buttons and labels

Without Composite, developers must write:

```java
if (item instanceof Product) {
    total += ((Product)item).getPrice();
}
else if (item instanceof Box) {
    total += ((Box)item).getTotalPrice();
}
```

Problems with this approach:

- Code becomes **messy and tightly coupled** to concrete types
- Violates **Open/Closed Principle (OCP)**
- Hard to extend or maintain
- Recursion and aggregation logic must be repeated

The Composite Pattern **solves this** by introducing a **common interface**:

- Both simple and composite objects implement the interface
- Clients call the same methods (e.g., `getPrice()`) on **all objects**, leaving recursion to the composites
- Tree structures can be **nested arbitrarily** without changing client code

---

## Why Use Composite?

Composite is useful when you want to:

- Work with **hierarchical or tree-like structures**
- Treat **individual objects and groups of objects uniformly**
- **Simplify client code** by removing type checks
- Make your system **flexible, maintainable, and OCP-compliant**

---

### Class Diagram

![Composite Class Diagram](https://media.geeksforgeeks.org/wp-content/uploads/20260121151900631209/composite_pattern.webp)  
*Source:* [GeeksForGeeks](https://www.geeksforgeeks.org/system-design/composite-method-software-design-pattern/)

1. **Component interface** defines common operations (`getPrice()`, `print()`).
2. **Leaf classes** implement the interface for simple objects (`Product`).
3. **Composite classes** implement the same interface and maintain a collection of Components (`Box`).
4. **Client code** uses the interface uniformly, unaware of whether it is interacting with a leaf or a composite.

> Recursion happens naturally in the composite: each composite delegates the operation to its children.

---

## Real-World Example: Products and Boxes

Ordering a gift in this system can be represented with **Products and Boxes**:

<img src="https://refactoring.guru/images/patterns/diagrams/composite/problem-en-1.5x.png?id=4e1e6d2b8d6c7aefeead44809bb1aa6a" width="60%" height="80%"  alt="Products and Boxes Image"/>  

*Source:* [Refactoring Guru](https://refactoring.guru/design-patterns/composite)

- A **Product** is a single item, like a phone, charger, or USB cable.
- A **Box** can contain multiple products or even smaller boxes.
- You can **calculate the total price** or **print the order contents** without caring if an item is a product or a box.
- Each box handles the aggregation internally.

**Components in this demo:**

- **Component:** `OrderItem` interface
- **Leaf:** `Product` with a price and a name
- **Composite:** `Box` containing products or other boxes
- **Client:** `Main` class, calculating total price and printing order contents

**Key Feature:** The client calls `getPrice()` and `print()` on all objects, **regardless of whether they are simple products or nested boxes**, thanks to the Composite pattern.

---

## Core Participants

| Role          | Description                                          | Example from this demo |
|---------------|------------------------------------------------------|------------------------|
| **Component** | Defines the interface for objects in the composition | `OrderItem`            |
| **Leaf**      | Represents simple objects with no children           | `Product`              |
| **Composite** | Represents complex objects that hold children        | `Box`                  |
| **Client**    | Uses the Component interface uniformly               | `Main`                 |

---

## Benefits of Composite

- **Uniformity:** Clients treat leaves and composites the same.
- **Recursive structures:** Supports arbitrarily deep trees.
- **Open/Closed Principle:** Adding new leaves or composites does not require modifying existing code.
- **Cleaner client code:** No need for type checks or branching logic.

---

## Pros and Cons

### Pros

- Simplifies **tree-based hierarchical code**
- Supports **recursive composition naturally**
- Promotes **polymorphism and uniformity**
- Makes the system **flexible and maintainable**
- Works well with other patterns like **Iterator, Visitor, and Decorator**

### Cons

- Can be difficult to define a **common interface** if components are very different
- Overgeneralizing the interface may make it harder to understand
- Some operations may not make sense for all components (e.g., `addItem()` for leaves)

---

## Relations with Other Patterns

- **Builder:** Can help construct complex composite trees recursively.
- **Chain of Responsibility:** Leaf components may pass requests along the tree hierarchy.
- **Iterator:** Traverses composite trees efficiently.
- **Visitor:** Executes operations over the entire tree without modifying classes.
- **Decorator:** Similar recursive structure, but Decorator adds behavior to a single child, while Composite aggregates children.

---

## Notes for Learning

- Composite is ideal for **tree-like or hierarchical data**
- Focus on **uniform interfaces** and **recursion**
- Works best when operations make sense for both leaves and composites
- Can be combined with **Visitor, Iterator, Decorator, Flyweight** for more complex behaviors
- Ensures **OCP compliance**: adding new leaves or composites requires **no client code changes**
