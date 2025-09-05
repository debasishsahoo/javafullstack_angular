- Members with default access are inherited only if the subclass is in the **same package**
- If the subclass is in a different package, these members are not accessible


## Package Boundary Determines Inheritance

Default access members are **only inherited when the subclass is in the same package** as the parent class. If the subclass is in a different package, these members are effectively not part of the inheritance.