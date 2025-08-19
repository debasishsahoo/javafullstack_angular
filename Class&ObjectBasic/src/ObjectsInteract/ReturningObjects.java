package ObjectsInteract;

class Factory {
    Product createProduct(String name) {
        return new Product(name); // Returns an object
    }
}

class Product {
    String name;
    Product(String name) {
        this.name = name;
    }
}

public class ReturningObjects {
	public static void main(String[] args) {
        Factory factory = new Factory();
        
        
        
        Product product = factory.createProduct("Laptop"); // Interaction via return object
        System.out.println("Product created: " + product.name);
    }
}
