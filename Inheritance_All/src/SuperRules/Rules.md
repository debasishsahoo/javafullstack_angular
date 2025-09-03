## Explanation of Each Rule:

1. **Must be first statement**: The `super()` call must be the first statement in a constructor. If you try to place any statement before it, you'll get a compilation error.
2. **Cannot access private members**: The `super` keyword cannot access private members of the parent class, as demonstrated by the commented line that would cause an error.
3. **Cannot use in static context**: The `super` keyword cannot be used in static methods or static blocks, as it relies on instance-specific context.
4. **Refers to immediate parent only**: The `super` keyword always refers to the immediate parent class, not any higher ancestors in the inheritance hierarchy.
5. **Must call super() if no default parent constructor**: When a parent class doesn't have a no-argument constructor, the child class must explicitly call `super(...)` with the appropriate arguments.
6. **Cannot chain both super() and this()**: You cannot have both `super()` and `this()` in the same constructor. A constructor can call either another constructor in the same class using `this()` or a parent constructor using `super()`, but not both.