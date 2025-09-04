Method overriding occurs in **inheritance** when a **subclass (child class)** provides a **specific implementation** of a method that is already defined in its **superclass (parent class)** with the **same name, return type, and parameters**.

Method overriding occurs when:

- A **subclass** has a ***method*** with the same name, return type, and parameters as a method in its superclass
- The **subclass** provides its own implementation of that method
- The **overridden** method in the subclass is invoked instead of the parent class method when called on a subclass object


## **Points of Method Overriding**

1. **Inheritance Required** – The child class must inherit from the parent class.
2. **Same Method Signature** – The overridden method must have the **same name, return type, and parameters**.
3. **Access Modifier** – Cannot be more restrictive than the parent’s method (but can be more permissive).
    - Example: `public` method in parent cannot be overridden as `private` in child.
4. **Annotations** – We generally use `@Override` annotation to make code clearer and avoid mistakes.
5. **Dynamic Method Dispatch (Runtime Polymorphism)** – The method to be executed is decided at **runtime** (not compile time).


## **Rules for Method Overriding**

1. Must have **same method signature** (name + parameters).
2. Return type must be **same or covariant** (subclass type of original return type).
3. Only **inherited methods** can be overridden (i.e., not `static`, not `final`, not `private`).
4. Child class cannot throw **broader checked exceptions** than the parent method.
5. **Constructors cannot be overridden**.






## **Same Method Signature**:

### The overriding method must have the same name, parameters, and return type as the parent method.

# **Access Modifier Rules**:

### The overriding method cannot be more restrictive than the parent method.

# **Return Type Compatibility**:

### The return type must be the same or a covariant (subtype) of the parent's return type.



# The @Override Annotation

The `@Override` annotation is recommended because it:

- Ensures you're actually overriding (catches typos)
- Makes code more readable and maintainable
- Provides compile-time checking




Runtime Polymorphism in Action

Polymorphic behavior:

Using super in Overridden Methods:


Methods That Cannot Be Overridden
## **Static Methods**:

### Static methods cannot be overridden, only hidden.

# **Final Methods**:

## Methods marked `final` cannot be overridden.

# **Private Methods**:

## Private methods are not inherited, so cannot be overridden.


