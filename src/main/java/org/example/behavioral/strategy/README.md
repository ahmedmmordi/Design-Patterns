# Strategy Design Pattern

## What is Strategy?

The **Strategy Pattern** is a **GoF behavioral design pattern** that allows you to **define a family of algorithms, encapsulate each one, and make them interchangeable**.

- It lets a class **delegate behavior** to one of many strategy objects.
- The **context class** doesn’t know the details of the algorithms — it just interacts with the **strategy interface**.
- You can **switch behaviors at runtime** without modifying the context.

---

## The Problem Strategy Solves

When a class has multiple ways of performing the same task, you might write:

```java
if (mode.equals("FASTEST")) {
    // calculate fastest route
}
else if (mode.equals("SHORTEST")) {
    // calculate shortest route
}
else if (mode.equals("NO_HIGHWAYS")) {
    // calculate no-highways route
}
```

Problems with this approach:

- Code becomes **messy and hard to maintain**
- Violates **Open/Closed Principle (OCP)**
- Adding a new algorithm requires modifying the context
- Testing individual algorithms is harder

The Strategy Pattern **solves this** by introducing a **common interface**:

- Each algorithm is in its own class implementing the **Strategy interface**
- The context **delegates execution** to the strategy
- Clients can **switch algorithms at runtime** without changing the context
- Code is **clean, modular, and testable**

---

## Why Use Strategy?

Use Strategy when you want to:

- **Switch algorithms dynamically at runtime**
- Avoid **large conditional statements**
- Encapsulate **algorithm variations** into separate classes
- Reduce code duplication
- Keep **context class simple and focused**

---

### Class Diagram

![Strategy Pattern](https://media.geeksforgeeks.org/wp-content/uploads/20260121161105607331/class_diagram_of_strategy_design_pattern_2.webp)  
*Source:* [GeeksForGeeks](https://www.geeksforgeeks.org/system-design/strategy-pattern-set-1/)

1. **Strategy interface (`SortingStrategy`)** defines a common method `sort(int[])`.
2. **Concrete Strategies** implement different sorting algorithms:
    - `BubbleSortStrategy` → Bubble sort algorithm
    - `QuickSortStrategy` → Quick sort algorithm
    - `MergeSortStrategy` → Merge sort algorithm
3. **Context class (`SortingContext`)** maintains a reference to a `SortingStrategy` object and delegates the sorting operation to it.
    - Methods:
        - `setSortingStrategy(SortingStrategy strategy)` → change strategy at runtime
        - `performSort(int[] array)` → executes the selected strategy
4. **Client (`main` method)** selects a sorting strategy and calls the context to perform sorting.

> The context delegates the sorting task to the selected strategy. The client can switch algorithms at runtime without modifying the `SortingContext` class.

---

## Real-World Example: Navigation App

Imagine a navigation app like Google Maps:

- **Fastest Route:** Calculates the quickest route, considering traffic.
- **Shortest Route:** Calculates the route with the least distance.
- **No Highways Route:** Calculates the best route avoiding highways.

With the Strategy Pattern:

- The `NavigationApp` context delegates route calculation to a **RouteStrategy** object.
- The client can **change the strategy at runtime**:

```java
NavigationApp app = new NavigationApp();
app.setRouteStrategy(new FastestRouteStrategy());
app.navigate("Cairo", "Giza");

app.setRouteStrategy(new NoHighwaysRouteStrategy());
app.navigate("Cairo", "Giza");
```

Each strategy handles its own algorithm internally, **keeping the context clean**.

---

## Core Participants

| Role                 | Description                                               | Example from Navigation App                                                |
|----------------------|-----------------------------------------------------------|----------------------------------------------------------------------------|
| **Strategy**         | Interface for a family of algorithms                      | `RouteStrategy`                                                            |
| **ConcreteStrategy** | Implements a specific algorithm                           | `FastestRouteStrategy`, `ShortestRouteStrategy`, `NoHighwaysRouteStrategy` |
| **Context**          | Uses a strategy object and delegates work                 | `NavigationApp`                                                            |
| **Client**           | Configures the context with a chosen strategy and uses it | `Main`                                                                     |

---

## Benefits of Strategy

- **Flexibility:** Swap algorithms at runtime without changing the context.
- **Encapsulation:** Isolates each algorithm into its own class.
- **Open/Closed Principle:** Add new strategies without modifying existing code.
- **Cleaner code:** Eliminates large conditional statements.
- **Testable:** Each algorithm can be tested independently.

---

## Pros and Cons

### Pros

- Dynamic behavior changes at runtime
- Improves code maintainability and readability
- Reduces duplication
- Works well with **Dependency Injection** and **Composition**
- Makes the system **OCP-compliant**

### Cons

- More classes and interfaces than a simple conditional
- Client must understand which strategy to select
- Overkill if there are only 1–2 rarely changing algorithms

---

## Relations with Other Patterns

| Pattern              | Relation                                                                      |
|----------------------|-------------------------------------------------------------------------------|
| **State**            | Similar structure; State changes behavior based on object state.              |
| **Template Method**  | Template Method uses inheritance; Strategy uses composition.                  |
| **Command**          | Command encapsulates a request; Strategy encapsulates a family of algorithms. |
| **Decorator**        | Decorator adds responsibilities; Strategy swaps internal behavior.            |
| **Bridge / Adapter** | Uses composition like Strategy but solves different problems.                 |

---

## Notes for Learning

- Strategy is ideal when **behavior changes dynamically**.
- Focus on **interface abstraction** and **delegation**.
- Can be combined with **Factory or Dependency Injection** for flexible runtime selection.
- Makes code easier to maintain, extend, and test.
