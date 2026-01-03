# Factory Design Pattern

## 1. Simple Factory

### What is Simple Factory?

The **Simple Factory** is **not a GoF official pattern**, but a commonly used creational approach.

- It centralizes object creation in a single **factory class**.
- Clients request objects from the factory, usually via a **static method**, without knowing the **concrete implementation**.

In other words, **Simple Factory hides the creation logic** from clients, letting them work with **abstract types or interfaces**.

---

### Why Use Simple Factory?

Simple Factory is useful for:

- **Reducing client dependency on concrete classes:** Clients work with interfaces or abstract types.
- **Centralizing creation logic:** All object creation is handled in one place.
- **Simplifying client code:** Clients don’t need `new` statements for every concrete class.

---

### How It Works

1. Client calls `ReaderFactory.createReader(fileName)`
2. Factory examines the input (e.g., file extension)
3. Factory returns the appropriate concrete object implementing `Reader`
4. Client uses `Reader.read()` without knowing the concrete type

---

### Pros and Cons

**Pros:**

- Easy to understand and implement
- Centralizes creation logic
- Works well when the number of products is small and unlikely to change

**Cons:**

- **Violates Open/Closed Principle (OCP):** Adding a new product type requires modifying the factory method
- Can become **monolithic** if many types are added
- **Limited extensibility:** Clients remain dependent on a single factory method

---

### Example in This Project

**Scenario:** Reading different file types (`JSON`, `CSV`, `XML`) using one static factory method.

- **Product interface:** `Reader`
- **Concrete products:** `JSONReader`, `CSVReader`, `XMLReader`
- **Factory:** `ReaderFactory` with `createReader(String fileName)`

The factory method determines the correct product based on the file name and returns it to the client.

---

## 2. Factory Method (GoF)

### What is Factory Method?

The **Factory Method Pattern** is a **GoF creational pattern** that defines:

- An **abstract creator class** with a **method for creating objects** (`createReader()`)
- **Concrete subclasses (factories)** that decide which **concrete product** to instantiate

> Unlike Simple Factory, the Factory Method **follows the Open/Closed Principle (OCP)** and leverages **polymorphism** to allow extensibility without modifying existing code.

---

### Why Use Factory Method?

Factory Method is useful when:

- **Clients should be decoupled from concrete implementations**
- The **system may grow with new types** over time
- You want **flexible, extensible object creation**
- **Polymorphism** in creation logic is desired

---

### How It Works

1. Client calls `ReadingService.read(fileName)`
2. `FileTypeResolver` determines the file type
3. `ReaderFactoryProvider` returns the **appropriate concrete factory**
4. Factory creates the correct `Reader` instance
5. Client calls `Reader.read()`

> Each concrete factory handles the creation of **only one product type**, keeping responsibilities clear.

---

### Pros and Cons

**Pros:**

- **Open/Closed Principle compliant:** Adding new products does not require modifying existing factories or client code
- **Decouples client and concrete products:** Client code depends only on interfaces/abstract classes
- **Maintains SRP:** Resolver handles detection, factory handles creation, service handles orchestration
- **Testable and maintainable:** Factories, resolver, and services can be tested independently

**Cons:**

- Slightly more **complex than Simple Factory**
- Requires more **classes and files**
- Can be **overkill** for very small projects or when only a few product types exist

---

### Simple Factory vs Factory Method

| Aspect             | Simple Factory                        | Factory Method                                        |
|--------------------|---------------------------------------|-------------------------------------------------------|
| **Definition**     | Central static method creates objects | Abstract creator + concrete factories decide creation |
| **OCP compliance** | No, Adding new types modifies factory | Yes, Adding new types only adds new classes           |
| **Polymorphism**   | No                                    | Yes                                                   |
| **Flexibility**    | Low                                   | High                                                  |
| **Complexity**     | Simple, fewer classes                 | More classes, more structured                         |
| **Use case**       | Few product types, unlikely to change | Many product types, frequent extension expected       |

---

### Example in This Project

**Scenario:** Reading files (`JSON`, `CSV`, `XML`) with **extensible factories**.

- **Product interface:** `Reader`
- **Concrete products:** `JSONReader`, `CSVReader`, `XMLReader`
- **Abstract factory:** `ReaderFactory`
- **Concrete factories:** `JSONReaderFactory`, `CSVReaderFactory`, `XMLReaderFactory`
- **Factory provider:** `ReaderFactoryProvider` (maps `FileType` → concrete factory)
- **Resolver:** `FileTypeResolver` (determines file type)
- **Service / manager:** `ReadingService` orchestrates reading

> Adding a new file type (e.g., `YAMLReader`) only requires:
> 1. Adding `YAMLReader` (product)
> 2. Adding `YAMLReaderFactory` (concrete factory)
> 3. Adding `YAML` to `FileType` enum

No existing classes need modification — fully OCP-compliant.

---

### Notes for Learning

- **Simple Factory** is easier but less extensible. Good for learning and small projects.
- **Factory Method** is scalable and follows **GoF principles** — recommended for larger, extensible systems.
- Consider **lazy loading / caching** in factories if creation is expensive.
- Keep **factories stateless** when possible to simplify reuse and testing.  
