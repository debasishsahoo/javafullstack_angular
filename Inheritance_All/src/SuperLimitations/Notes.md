1. **Static Context**: Cannot use `super` in static methods or static blocks.
2. **Private Members**: Cannot use `super` to access private members of the parent class.
3. **Grandparent Access**: Cannot use `super` to access members of grandparent classes (only immediate parent).
4. **Constructor Position**: `super()` must be the first statement in a constructor.
5. **Constructor Chaining**: Cannot use both `super()` and `this()` in the same constructor.
6. **Static Methods**: Should not use `super` to call static methods (use the class name instead).
7. **Interface Limitations**: Cannot use `super` in interface default methods to access Object methods.