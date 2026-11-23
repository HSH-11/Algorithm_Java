import java.util.Scanner;

class Product {
    String name;
    int code;

    public Product() {
        this.name = "codetree";
        this.code = 50;
    }

    public Product(String name, int code) {
        this.name = name;
        this.code = code;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String id2 = sc.next();
        int code2 = sc.nextInt();
        
        Product p1 = new Product();
        Product p2 = new Product(id2, code2);

        System.out.println("product " + p1.code + " is " + p1.name);
        System.out.println("product " + p2.code + " is " + p2.name);
    }
}