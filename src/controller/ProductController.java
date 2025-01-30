package controller;

import model.Product;
import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.Table;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import model.Cart;
import view.ConsoleView;

public class ProductController {
    private static Cart cart = new Cart();
    public static final String RESET = "\033[0m";
    public static final String YELLOW = "\033[0;33m";
    private static Scanner scanner = new Scanner(System.in);
    private static List<Product> products = Arrays.asList(
            new Product(1, "Pizza", 12.99),
            new Product(2, "Burger", 5.99),
            new Product(3, "Pasta", 8.49),
            new Product(4, "Sushi", 15.99),
            new Product(5, "Salad", 6.99)
    );
    public static void showProduct(){
        System.out.println(YELLOW+"\n==================== Food Menu ===================="+RESET);
        Table table = new Table(3, BorderStyle.UNICODE_BOX);
        table.setColumnWidth(0, 5, 10);
        table.setColumnWidth(1, 15, 30);
        table.setColumnWidth(2, 8, 20);

        CellStyle headerStyle = new CellStyle(CellStyle.HorizontalAlign.center);
        table.addCell("ID", headerStyle);
        table.addCell("Name", headerStyle);
        table.addCell("Price", headerStyle);

        for (Product product : products) {
            table.addCell(String.valueOf(product.getId()));
            table.addCell(product.getName());
            table.addCell(String.valueOf(product.getPrice()));

        }
        System.out.println(table.render());
    }
    public static void addToCart() {
        int productId = ConsoleView.getValidInt("Enter Product ID to add: ");
        Product product = ProductController.getProductById(productId);
        if (product != null) {
            cart.addProduct(product);
        } else {
            ConsoleView.showMessage("Invalid Product ID!");
        }
    }

    public static void removeFromCart() {
        int productId = ConsoleView.getValidInt("Enter Product ID to remove: ");
        Product product = ProductController.getProductById(productId);
        if (product != null) {
            cart.removeProduct(productId);
        } else {
            ConsoleView.showMessage("Invalid Product ID!");
        }
    }

    public static Product getProductById(int id) {
        return products.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

}
