import model.Cart;
import view.ConsoleView;
import controller.ProductController;
public class Main{
    public static void main(String[] args) {
        Cart cart = new Cart();
        ConsoleView.login();

        while (true) {
            ConsoleView.showMenu();
            int choice = ConsoleView.getValidInt("Enter your choice: ");

            switch (choice) {
                case 1 -> ProductController.showProduct();
                case 2 -> ProductController.addToCart();
                case 3 -> cart.showCart();
                case 4 -> ProductController.removeFromCart();
                case 5 -> cart.placeOrder();
                case 6 -> {
                    ConsoleView.showMessage("Exiting... Thank you!");
                    System.exit(0);
                }
                default -> ConsoleView.showMessage("Invalid option! Try again.");
            }
        }
    }




}