### 1. Single Inheritance for Classes

Java supports only single inheritance for classes - a class can extend only one parent class.

### 2. Multiple Interface Implementation

While a class can extend only one class, it can implement multiple interfaces.

### 3. Constructors Are Not Inherited

Subclasses don't inherit constructors from parent classes but must call them.

### 4. Private Members Are Not Inherited

Private fields and methods of a superclass are not accessible in the subclass.

### 5. Protected Members Are Inherited

Protected members of a superclass are accessible in subclasses.

### 6. Super Keyword Usage

The `super` keyword is used to access parent class members and constructors.


### 7. Method Overriding

Subclasses can override parent class methods with the same signature.


### 8. Final Classes Cannot Be Extended

Final classes cannot be subClassed.


### 9. Final Methods Cannot Be Overridden

Final methods cannot be overridden in subclasses.


### 10. Static Methods Are Hidden, Not Overridden

Static methods are not overridden but hidden in subclasses.
