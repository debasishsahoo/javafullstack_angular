### 1. Tight Coupling

Inheritance creates tight coupling between parent and child classes.


### 2. Single Inheritance Restriction

Java's single inheritance limitation can sometimes be restrictive.


### 3. Constructor Dependency

Subclasses depend on parent class constructors.

### 4. Private Members Limitation

Private members of parent classes are not accessible in subclasses.


### 5. Performance Overhead

Deep inheritance hierarchies can introduce performance overhead.

### 6. Readability Issues

Deep inheritance can make code harder to understand and maintain.



## Best Practices

1. **Favor composition over inheritance** when possible to reduce coupling
2. **Keep inheritance hierarchies shallow** to maintain code readability
3. **Use interfaces** to achieve multiple inheritance of type
4. **Make classes final** when they shouldn't be extended
5. **Make methods final** when they shouldn't be overridden
6. **Design for extension** by carefully considering what should be protected vs private