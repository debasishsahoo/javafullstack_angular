## **Concepts**

1. **Multiple Interface Implementation**: The **`MultiFunctionMachine`** class implements both **`Printer`** and **`Scanner`** interfaces.
2. **Default Methods**: Both interfaces define a **`powerOn()`** default method, creating a potential conflict.
3. **Conflict Resolution**: The class resolves the conflict by overriding **`powerOn()`** and explicitly calling both interface implementations using **`InterfaceName.super.methodName()`** syntax.
4. **Private Interface Methods**: Both interfaces use private helper methods (**`warmUp()`** and **`calibrate()`**).
5. **Static Interface Methods**: The interfaces define static methods that can be called without an instance.
6. **Interface Inheritance**: The **`Fax`** interface extends the **`Printer`** interface and overrides its default method.
7. **Class Inheritance**: **`AdvancedMultiFunctionMachine`** extends **`MultiFunctionMachine`** and implements **`Fax`**.
8. **Polymorphism**: Demonstrates using interface references to access implementing objects.