package USES_A_Dependency;

class Engine {
	private String type;
	
    Engine(String type) { this.type = type; }
    
    void start() {
        System.out.println(type + " engine started.");
    }
}
