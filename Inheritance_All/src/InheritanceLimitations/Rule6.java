package InheritanceLimitations;

//Hard to follow deep inheritance
class A { void doA() {} }
class B extends A { void doB() {} }
class C extends B { void doC() {} }
class D extends C { void doD() {} }
class E extends D {
    void doSomething() {
        doA(); // Where is this defined?
        doB(); // Where is this defined?
        doC(); // Where is this defined?
        doD(); // Where is this defined?
    }
}

//Often better to use composition for better readability
class BetterE {
 private A a = new A();
 private B b = new B();
 private C c = new C();
 private D d = new D();

 void doSomething() {
     a.doA();
     b.doB();
     c.doC();
     d.doD();
 }
}












public class Rule6 {

}
