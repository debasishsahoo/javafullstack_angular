package InheritanceLimitations;

class Level1 { void method1() {} }
class Level2 extends Level1 { void method2() {} }
class Level3 extends Level2 { void method3() {} }
class Level4 extends Level3 { void method4() {} }
class Level5 extends Level4 { void method5() {} }

// Method calls in deep hierarchies may have slight performance impact
// due to the method lookup process in the JVM























public class Rule5 {

}
