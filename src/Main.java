import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the input file: ");
        String inputFile = scanner.nextLine();
        System.out.println("Enter the name of the output file: ");
        String outputFile = scanner.nextLine();

        CharCounter counter = new CharCounter(inputFile, outputFile);
        counter.readAndCount();
        counter.writeToFile();
    }
}