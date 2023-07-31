import java.util.ArrayList;
import java.util.Scanner;

class ListmakerApp {
    private static ArrayList<String> itemList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            displayMenu();
            String choice = getValidMenuChoice();

            switch (choice.toUpperCase()) {
                case "A":
                    addItemToList();
                    break;
                case "D":
                    deleteItemFromList();
                    break;
                case "P":
                    printListWithNumbers();
                    break;
                case "Q":
                    if (confirmQuit()) {
                        System.out.println("Goodbye!");
                        return;
                    }
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("Menu:");
        System.out.println("A - Add an item to the list");
        System.out.println("D - Delete an item from the list");
        System.out.println("P - Print the list");
        System.out.println("Q - Quit the program");
    }

    private static String getValidMenuChoice() {
        String regex = "[AaDdPpQq]";
        String prompt = "Enter your choice (A/D/P/Q): ";
        return SafeInput.getRegExString(regex, prompt);
    }

    private static void addItemToList() {
        System.out.print("Enter item to add: ");
        String item = scanner.nextLine();
        itemList.add(item);
        System.out.println("Item added to the list.");
    }

    private static void deleteItemFromList() {
        if (itemList.isEmpty()) {
            System.out.println("The list is empty. Nothing to delete.");
            return;
        }

        printListWithNumbers();
        int itemNumber = SafeInput.getRangedInt(1, itemList.size(), "Enter the item number to delete: ");
        itemList.remove(itemNumber - 1);
        System.out.println("Item deleted from the list.");
    }

    private static void printList() {
        if (itemList.isEmpty()) {
            System.out.println("The list is empty.");
        } else {
            System.out.println("List items:");
            for (String item : itemList) {
                System.out.println(item);
            }
        }
    }

    private static void printListWithNumbers() {
        if (itemList.isEmpty()) {
            System.out.println("The list is empty.");
        } else {
            System.out.println("Numbered List:");
            for (int i = 0; i < itemList.size(); i++) {
                System.out.println((i + 1) + ". " + itemList.get(i));
            }
        }
    }

    private static boolean confirmQuit() {
        return SafeInput.getYNConfirm("Are you sure you want to quit? (Y/N): ");
    }
}




