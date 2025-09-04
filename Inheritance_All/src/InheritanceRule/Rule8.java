package InheritanceRule;

final class President {
	 private String name;
	 
	 President(String name) {
	        this.name = name;
	    }

}
//This would cause a compilation error
class VicePresident extends President { } // ❌ ERROR: cannot extend final class



public class Rule8 {

}
