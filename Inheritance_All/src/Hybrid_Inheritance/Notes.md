## Demonstrated:

1. **Hybrid Inheritance Structure:**
    - `ElectricAutonomousCar` extends `Vehicle` (Single Inheritance)
    - `ElectricAutonomousCar` implements `ElectricPowered` and `AutonomousDriving` (Multiple Inheritance via interfaces)
2. **Proper Naming Conventions:**
    - Class names use PascalCase: `Vehicle`, `ElectricAutonomousCar`
    - Method names use camelCase: `startEngine()`, `chargeBattery()`
    - Interface names use adjective-like PascalCase: `ElectricPowered`, `AutonomousDriving`
3. **Inheritance Features:**
    - Method overriding: `startEngine()` is overridden in the subclass
    - Interface implementation: All abstract interface methods are implemented
    - Default interface methods: `displayEcoFriendlyMessage()` and `safetyCheck()`
    - Polymorphism: Using parent class and interface references
4. **Code Organization:**
    - Clear separation of concerns with different interfaces
    - Logical method names that describe their functionality
    - Proper use of access modifiers (protected for inherited fields)