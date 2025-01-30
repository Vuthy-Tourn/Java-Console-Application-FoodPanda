package model;

import javazoom.jl.decoder.Bitstream;
import javazoom.jl.player.Player;
import lombok.Data;
import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.Table;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

@Data
public class Cart {
    private static List<Product> products = new ArrayList<>();
    public static final String RESET = "\033[0m";
    public static final String YELLOW = "\033[0;33m";
    public void addProduct(Product product){
        products.add(product);
        System.out.println(product.getName() + " added to cart.");
    }

    public void removeProduct(int productId){
        products.removeIf(p -> p.getId() == productId);
        System.out.println("Product have been removed from cart.");
    }
    public void showCart(){
        if (products.isEmpty()){
            System.out.println("Cart is Empty.");
            return;
        }
        System.out.println(YELLOW+"\n==================== Your Cart ===================="+RESET);
        Table table = getTable();
        System.out.println(table.render());
    }
    public void placeOrder(){
        if (products.isEmpty()){
            System.out.println("Cart is Empty! Cannot place order.");
        }
        System.out.println(playStartOrder()); // sound
        System.out.println(YELLOW+"==================== Place Order ===================="+RESET);
        Table table = getTable();
        System.out.println(table.render());
        System.out.println("Total: $" + products.stream().mapToDouble(Product::getPrice).sum());
        System.out.println("Order Date: " + java.time.LocalDate.now());
        products.clear();
    }

    public static Table getTable() {
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
        return table;
    }
    public static String playStartOrder() {
        try {
            // Path to the MP3 file
            File mp3File = new File("src/start-order.mp3");
            if (!mp3File.exists()) {
                System.out.println("File not found.");
            }

            // Use JLayer's Bitstream class to play the MP3 file
            Bitstream bitstream = new Bitstream(new FileInputStream(mp3File));
            Player player = new Player(new FileInputStream(mp3File));

            // Start playing the sound
            player.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
    public boolean isEmpty() { return products.isEmpty(); }
    
    
}
