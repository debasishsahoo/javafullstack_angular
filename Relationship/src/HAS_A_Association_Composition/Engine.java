package HAS_A_Association_Composition;

class Engine {
	private String type;
	
    Engine(String type) { this.type = type; }
    
    void start() {
        System.out.println(type + " engine started.");
    }
}
