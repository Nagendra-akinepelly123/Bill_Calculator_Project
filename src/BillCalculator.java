
import java.util.*;
public class BillCalculator {

    public class BillProject {
        public static void main(String[] args) {

            int num = askOrder();

            if(validOrder(num)){
                if(num == 1){
                    displayVeg();
                }else{
                    displayNonVeg();
                }
            }else{
                errorMessage();
                askOrder();
            }
        }
        public static int askOrder(){
            System.out.println();
            Scanner sc = new Scanner(System.in);
            System.out.println("VEG --> 1 , NON-VEG --> 2");
            System.out.print("Enter any number for order : ");
            return sc.nextInt();
        }

        public static boolean validOrder(int num){
            if(num == 1 || num == 2){
                return true;
            }
            return false;
        }

        public static void errorMessage(){
            System.out.println();
            System.out.println("INVALID ORDER NUMBER");
            System.out.println("PLEASE SELECT GIVEN NUMBERS ONLY");
//            System.out.println("VEG --> 1 , NON-VEG --> 2");
        }

        public static void displayVeg(){
            System.out.println();
            System.out.println("VEG-BIRYANI --> 1 , PANEER-BIRYANI --> 2 , CORN-BIRYANI --> 3");
            takeOrderAndGiveBill();
        }

        public static void displayNonVeg(){
            System.out.println();
            System.out.println("CHICKEN-BIRYANI --> 4 , FISH-BIRYANI --> 5 , MUTTON-BIRYANI --> 6");
            takeOrderAndGiveBill();
        }

        public static void takeOrderAndGiveBill(){
            System.out.println();
            System.out.println("SELECT -1 TO STOP ORDER AND PRINT BILL ");
            System.out.println("DISCOUNT OF 10% IF BILL GREATER THAN 1000rs");

            Scanner sc = new Scanner(System.in);
            System.out.println("GIVE TOTAL NUMBER OF YOU ITEMS YOU WANT");
            int n = sc.nextInt();
            System.out.println("PRINT THE ALL ITEM NUMBERS ONE BY ONE THAT YOU WANT");

            int[] order = new int[n+1];
            for(int i = 0;i < order.length;i++){
                order[i] = sc.nextInt();
                if(order[i] == -1){
                    break;
                }
            }

            //map to store the items and its prices
            Map<Integer,Integer> itemPrices = new HashMap<>();

            itemPrices.put(1,320);
            itemPrices.put(2,340);
            itemPrices.put(3,380);
            itemPrices.put(4,240);
            itemPrices.put(5,350);
            itemPrices.put(6,420);

            //map to store the items and its prices
            Map<Integer,String> itemNameAndNumber = new HashMap<>();

            itemNameAndNumber.put(1,"VEG-BIRYANI");
            itemNameAndNumber.put(2,"PANEER-BIRYANI");
            itemNameAndNumber.put(3,"CORN-BIRYANI");
            itemNameAndNumber.put(4,"CHICKEN-BIRYANI");
            itemNameAndNumber.put(5,"FISH-BIRYANI");
            itemNameAndNumber.put(6,"MUTTON-BIRYANI");

            float totalAmount = 0.0f;

            for(int num : order){
                if(num != -1){
                    totalAmount = totalAmount+itemPrices.get(num);
                }
            }

            float discountAmount = discount(totalAmount);

            for (int j : order) {
                if (j != -1) {
                    System.out.println(itemNameAndNumber.get(j) + " ------ " + itemPrices.get(j) + "rs");
                }
            }

            float bill = totalAmount-discountAmount;

            System.out.println("-------------------------");
            System.out.println("Total Amount = "+totalAmount);
            System.out.println("Discount Amount = "+discountAmount);
            System.out.println("-------------------------");
            System.out.println("Bill = "+bill);
            System.out.println("-------------------------");
            System.out.println();
            System.out.println("Thanks! Come Again");
        }

        public static float discount(float billAmount){
            float value = 0.0f;
            if(billAmount > 1000){
                return billAmount*((float) 1 /10);
            }
            return value;
        }
    }


}
