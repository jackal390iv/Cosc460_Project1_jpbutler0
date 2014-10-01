package cosc460_project1_jpbutler0;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

/**
 *
 * @author Jonathan Butler
 */
public class Cosc460_Project1_jpbutler0 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Cosc460_Project1_jpbutler0();

    }

    @SuppressWarnings("empty-statement")
    public Cosc460_Project1_jpbutler0() {

        try {
            Scanner input = new Scanner(System.in);
            String from;
            String goingTo;
            File copyFile;
            File goingToFile;
            do {
                System.out.println("Please enter the location of the file you wish to copy: ");
                from = input.nextLine();

                System.out.println("Plese enter the distination where you wish to copy the file to: ");
                goingTo = input.nextLine();

                System.out.println("from: " + from + " goingTo: " + goingTo);

                copyFile = new File(from);
                if (!(copyFile.exists())) {
                    System.out.println("I'm sorry, but your file pathing was incorect; please try again.");
                    break;
                }

                goingToFile = new File(goingTo);
                if (goingToFile.exists()) {
                    System.out.println("I'm sorry, but your file already exists in the location you wish to copy it to; please try again.");
                    break;
                }

                if (!(copyFile.canRead())) {
                    System.out.println("I'm sorry, but the file you wish to copy is unreadable; please try again.");
                    break;
                }

                goingToFile.createNewFile();

                if (goingToFile.getFreeSpace() < copyFile.getTotalSpace()) {
                    System.out.println("I'm sorry, but there is not enough space to copy your file; please try again.");
                    goingToFile.delete();
                    break;
                }

                if (!(goingToFile.canWrite())) {
                    System.out.println("I'm sorry, but the file you wish to create is un-writeable; please try again.");
                    goingToFile.delete();
                    break;
                }

                Scanner scan = new Scanner(copyFile);
                FileWriter file_Location = new FileWriter(goingToFile.getAbsoluteFile());
                BufferedWriter writer = new BufferedWriter(file_Location);
                while (scan.hasNextLine()) {
                    writer.write(scan.nextLine());
                    writer.newLine();
                }
                writer.close();
                
                System.out.println("Your file has been copied sucessfully!");

            } while (true);
        } catch (Exception ex) {
            System.out.println("Cause: " + ex.getCause());
            System.out.println("Message: " + ex.getMessage());
            System.out.println("Local Message: " + ex.getLocalizedMessage());
            //ex.printStackTrace();*/
        }
    }
}
