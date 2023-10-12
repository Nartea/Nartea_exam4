/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package final_exam;
import java.util.Scanner;
import java.util.Stack;
/**
 *
 * @author Acer
 */
class Product {
    private String name;
    private int quantity;

    public Product(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
public class tindahan_ni_scissar {

    private Stack<Product> inventoryStack;

    public tindahan_ni_scissar() {
        inventoryStack = new Stack<>();
    }

    public void addProduct(String productName, int quantity) {
        Product product = new Product(productName, quantity);
        inventoryStack.push(product);
    }

    public void sellProduct(String productName, int quantity) {
        Product product = inventoryStack.pop();
        if (product != null && product.getName().equals(productName)) {
            product.setQuantity(product.getQuantity() - quantity);
            if (product.getQuantity() > 0) {
                inventoryStack.push(product);
            }
        } else {
            throw new IllegalArgumentException("Product not found in inventory: " + productName);
        }
    }

    public void displayInventory() {
        System.out.println("Inventory:");
        for (Product product:  inventoryStack) {
            System.out.println(product.getName() + "\t\t\t" + product.getQuantity());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        tindahan_ni_scissar sulod = new tindahan_ni_scissar();
        sulod.addProduct("milo", 10);
         sulod.addProduct("royal", 20);
          sulod.addProduct("Nescafe", 10);
           sulod.addProduct("tinapa", 20);
            sulod.addProduct("Bear brand", 20);
        while(true){
            
            System.out.println("**********Tindahan Ni Manong Scissar!!!!!!**********");
        System.out.println("1. Add product");
        System.out.println("2. Sell product");
        System.out.println("3. Display inventory");
            System.out.println("4. Never Mind!!");

      
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
               
                System.out.println("Unsa imo i dungag???!: ");
                String productName = scanner.next();
                System.out.println("Pila kabouk?!!!: ");
                int quantity = scanner.nextInt();
                sulod.addProduct(productName, quantity);
                break;
            case 2:             
                System.out.println("Onsa imo!!??: ");
                productName = scanner.next();
                System.out.println("pila man?!!!: ");
                quantity = scanner.nextInt();
                sulod.sellProduct(productName, quantity);
                break;
            case 3:            
                sulod.displayInventory();
                break;
            case 4:
                System.out.println("K!");
                break;
        }
    }
}

}

