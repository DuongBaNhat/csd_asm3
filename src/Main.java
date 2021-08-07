
import java.util.Scanner;
import view.PersonView;

public class Main {
    
public static void main(String[] args) {
        PersonView personView = new PersonView();
        Scanner keyboardInput = new Scanner(System.in);
        boolean isPrint = true;
        while(true) {
            if (isPrint) 
                personView.showMenu();
            isPrint = true;
            System.out.print("YOUR CHOICE: ");
            String choice = keyboardInput.nextLine();
            switch (choice) {
                case "1":
                    personView.inputNewPerson();
                    break;
                case "2":
                    personView.inOrderView();
                    break;
                case "3":
                    personView.BFTView();
                    break;
                case "4":
                    personView.searchView();
                    break;
                case "5":
                    personView.deleteView();
                    break;
                case "6":
                    personView.balanceView();
                    break;
                case "7":
                    personView.DFSOfGraphView();
                    break;
                case "8":
                    personView.dijkstraView();
                    break;
                case "9":
                    personView.postOrderView();
                    break;
                case "10":
                    personView.preOrderView();
                    break;
                case "11":
                    personView.BFSOfGraphView();
                    break;
                case "0":
                    System.exit(0);
                default:
                    System.out.println("Your input is not supported, please try again");
                    isPrint = false;
                    break;
            }
        }
    }

}

