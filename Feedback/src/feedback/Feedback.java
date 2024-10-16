
package feedback;

import java.util.Scanner;

public class Feedback {

     public void addFeedback() {
        
        Scanner sc = new Scanner(System.in);
        config cf = new config();
        
        System.out.print("Text: ");
        String fbt = sc.next();
        sc.nextLine();
        System.out.print("Date (YYYY-MM-DD): ");
        String fbd = sc.next();
        System.out.print("Rating: ");
        String rtg = sc.next();
        
        String sql = "INSERT INTO  Feedback (feedback_text, feedback_date, rating) VALUES ( ?, ?, ?)";
        cf.addFeedback (sql, fbt, fbd, rtg);
    }
    
    private void viewFeedback() {
        String qry = "SELECT * FROM Feedback";
        String[] hdrs = {"ID", "Text", "Date", "Rating"};
        String[] clms = {"id", "feedback_text", "feedback_date", "rating"};
        config cf = new config();
        cf.viewFeedback(qry, hdrs, clms);
    }
     
    private void updateFeedback(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Feedback ID: ");
        int id = sc.nextInt();
        
        System.out.print("Enter Text: ");
        String fbt = sc.next();
        
        System.out.print("Enter Date: ");
        String fbd = sc.next();
        
        System.out.print("Enter Rating: ");
        String rtg = sc.next();


        String qry = "UPDATE books SET feedback_text = ?, feedback_date = ?, rating = ? WHERE id = ?";


        config cf = new config();
        cf.updateFeedback(qry, fbt, fbd, rtg, id);
    }
      
    private void deleteFeedback() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Feedback ID to Delete: ");
        int id = sc.nextInt();
        
        String sqlDelete = "Delete from Feedback WHERE id = ?";
        config cf = new config();
        cf.deleteFeedback(sqlDelete, id);
    }
    
    public static void main  (String[] args){
        
        Scanner sc = new Scanner (System.in);
        String response;
        
        do{
            
            System.out.println("---------------------------------------");
            System.out.println("1. ADD");
            System.out.println("2. VIEW");
            System.out.println("3. UPDATE");
            System.out.println("4. DELETE");
            System.out.println("5. EXIT");
            System.out.println("---------------------------------------");

            System.out.print("Enter Action: ");
            int action = sc.nextInt();
            
            Feedback fb = new Feedback();
            switch (action){
            
                case 1:
                    fb.addFeedback();
                break;
                
                case 2:
                    fb.viewFeedback();
                break;
                
                case 3:
                    fb.viewFeedback();
                    fb.updateFeedback();
                break;
                
                case 4:
                    fb.viewFeedback();
                    fb.deleteFeedback();
                    fb.viewFeedback();
                break;
                
                case 5:
                    System.out.println("Exiting...");
                break;
                default:
                    System.out.println("Invalid action, Please Try Again.");
            }
            
            System.out.println("Continue? (yes/no): ");
            response = sc.next();
        }while(response.equalsIgnoreCase("yes"));
        System.out.println("Thank You, See you again!");
    }
}
