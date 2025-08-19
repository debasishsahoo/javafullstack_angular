package ObjectsInteract;

class Printer {
    void print(Document doc) {  // doc is an object
        System.out.println("Printing: " + doc.content);
    }
}

class Document {// Only Assign the Value to the Content Variable
    String content;
    Document(String content) {
        this.content = content;
    }
}

public class MethodArguments {
	public static void main(String[] args) {
        Document doc = new Document("Hello World");
        
        Printer printer = new Printer();
        
        printer.print(doc); // Printer interacts with Document
    }
}

//Document object is passed to Printer object for printing.

//Object interaction happens via method arguments.