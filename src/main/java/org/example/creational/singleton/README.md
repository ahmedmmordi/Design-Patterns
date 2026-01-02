# Singleton Design Pattern

## **What is Singleton?**

The **Singleton Pattern** is a **creational design pattern** that ensures:

- A class has **only one instance**.
- It provides a **global point of access** to that instance.

In other words, no matter how many times you try to instantiate the class, you always get the **same object**.

---

## **Why Use Singleton?**

Singleton is useful for:

- **Controlling access to shared resources:**  
  Example: database connections, logging services, configuration managers.
- **Reducing memory footprint:** Only **one instance exists**, even if multiple parts of the program need it.
- **Providing a global point of access:** Useful for configuration, caching, or shared services.
- **Ensuring consistency:** All clients use the same instance and therefore the same state.

---

## **The Problem Singleton Solves**

- Multiple parts of a program need to share the same resource or service.
- Without Singleton, creating multiple instances can lead to:
    - **Inconsistent state**
    - **Redundant memory usage**
    - **Difficult access and management**

**Solution:** Singleton ensures **only one instance exists** and provides a **global access point** for all clients.

---

## **How to Implement It**

**Steps to implement a Singleton:**

1. **Private Constructor:** Prevents external instantiation.
2. **Static Instance Holder:** Holds the **single instance**.
3. **Public Accessor Method:** Provides global access to the instance.
4. **Optional Lazy Initialization:** Create the instance **only when needed** to improve efficiency.

**Common Implementation Techniques:**

| Technique                           | Description                                  | Pros                                                | Cons                                  |
|-------------------------------------|----------------------------------------------|-----------------------------------------------------|---------------------------------------|
| Eager Initialization                | Instance created at class load time          | Simple, thread-safe                                 | Instance created even if unused       |
| Lazy Initialization                 | Instance created when first requested        | Saves memory                                        | Not thread-safe by default            |
| Static Inner Class (Holder Pattern) | Instance created inside a static inner class | Thread-safe, lazy-loaded                            | Slightly advanced                     |
| Enum Singleton                      | Uses Enum to implement singleton             | Simple, thread-safe, protects against serialization | Enum may feel unnatural in some cases |

> In this guide, we implement the **full Singleton** using the **Static Inner Class (Holder Pattern)**, which is named **Logger** and solves all these problems by providing lazy initialization, thread safety, and a single global instance.

---

## **Pros and Cons**

**Pros:**

- Guarantees a **single instance** of a class.
- Provides a **global access point** to that instance.
- Instance can be **lazily initialized** when needed.

**Cons:**

- **Violates the Single Responsibility Principle**: The pattern solves two problems at the time.
- Can **mask poor design** by encouraging global state and tight coupling.
- **Hard to unit test**: private constructor and static access make mocking difficult.
- Can lead to **hidden dependencies** if overused.
