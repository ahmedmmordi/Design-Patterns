# Template Method Design Pattern

## What is Template Method?

The **Template Method Pattern** is a **GoF behavioral design pattern** that defines the **skeleton of an algorithm** in a base class, allowing **subclasses to override certain steps** without changing the overall structure.

- The **template method** defines the algorithm sequence.
- **Concrete subclasses** implement or override specific steps (abstract or optional).
- The base class may provide **default implementations** or **hooks** for optional steps.
- Clients use the algorithm **through the base class** without knowing the subclass details.

---

## The Problem Template Method Solves

When multiple classes implement **similar algorithms with slight variations**, developers often write code like:

```java
class CreditCardPayment {
    void process() {
        validate();
        fraudCheck();
        charge();
        sendReceipt();
    }
}

class PayPalPayment {
    void process() {
        validate();
        fraudCheck();
        charge();
        sendReceipt();
    }
}
```

### Problems with this approach:

- Code duplication across classes
- Hard to maintain if the algorithm changes
- Risk of breaking client expectations
- Mixing **invariant steps** with **variant steps**


### The Template Method pattern **solves this** by:

- Centralizing the **algorithm skeleton** in a base class
- Letting subclasses **implement only the variable parts**
- Providing **optional steps and hooks** to extend behavior safely

---

## Why Use Template Method?

Use Template Method when:

- You have **common algorithms** across multiple classes with **small variations**
- You want to **enforce the algorithm structure** while allowing flexibility
- You want to **reduce code duplication**
- You want to **control the execution flow** centrally

---

## Class Diagram

![Template Method Class Diagram](https://media.geeksforgeeks.org/wp-content/uploads/20260121145126981428/class_diagram_of_template_method_design_pattern-2.webp)  
*Source:* [GeeksForGeeks](https://www.geeksforgeeks.org/system-design/template-method-design-pattern/)

1. **Abstract Class** defines the **template method** and abstract steps
2. **Concrete Subclasses** implement the abstract steps and optionally override default steps
3. **Hooks** allow conditional or optional behavior without forcing changes
4. **Client** uses the abstract class interface to execute the algorithm

---

## Real-World Example: Payment Processing

Consider an application supporting multiple payment methods:

- **Credit Card**
- **PayPal**
- **Bank Transfer**

Each payment follows **the same algorithm**:

1. Validate input
2. Run fraud check (optional)
3. Charge the account
4. Send receipt
5. Log transaction

Instead of duplicating this logic, we define a **base class `PaymentProcessor`** with the template method `processPayment()`.

- **Abstract steps:** `validate()`, `charge()`
- **Optional step:** `performFraudChecking()` with default implementation
- **Hook:** `requiresFraudChecking()`
- **Concrete subclasses:** `CreditCardPayment`, `PayPalPayment`, `BankTransferPayment`

The client code:

```java
PaymentProcessor payment = new CreditCardPayment();
payment.processPayment(250.00);
```

- The **same template method** runs for all payment types
- Subclasses customize only the steps that vary
- Algorithm structure is guaranteed

---

## Pros and Cons

### Pros

- **Reduces code duplication**: Common algorithm steps are centralized
- **Ensures algorithm consistency**: Template method controls flow
- **Flexible extension points**: Subclasses override only the parts they need
- **Supports hooks**: Optional steps without modifying base class

### Cons

- Can become **hard to maintain** if the algorithm has too many steps
- Overriding hooks incorrectly may **break algorithm invariants**
- Less flexible than **Strategy** for runtime changes, since Template Method works at the class level

---

## Relations with Other Patterns

- **Strategy:** Allows runtime selection of behavior; Template Method is **compile-time, class-level**
- **Factory Method:** Can be used as a step inside a template method
- **Hook Methods:** Provide optional extension points
- **Decorator / Visitor:** Often combined for extending behavior over hierarchical structures

---

## Notes for Learning

- Focus on **abstract steps**, **optional steps**, and **hooks**
- Keep the **template method `final`** to preserve algorithm structure
- Helps enforce **OCP compliance**: adding new subclasses does not change existing code
- Useful in **workflows, payment systems, parsers, and games**
