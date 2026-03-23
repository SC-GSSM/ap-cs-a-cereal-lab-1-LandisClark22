import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class CerealRunner
{
    private ArrayList<Cereal> cereals;

    public CerealRunner(String fileName)
    {
        cereals = new ArrayList<Cereal>();

        try
        {
            FileReader fileRdr = new FileReader(fileName);
            Scanner scan = new Scanner(fileRdr);

            if (scan.hasNextLine())
            {
                scan.nextLine();
            }

            while (scan.hasNextLine())
            {
                String line = scan.nextLine();

                String[] data = line.split(",");

                String name = data[0].trim();
                int calories = Integer.parseInt(data[1].trim());
                double fiber = Double.parseDouble(data[2].trim());
                double carbs = Double.parseDouble(data[3].trim());
                double cups = Double.parseDouble(data[4].trim());

                Cereal cereal = new Cereal(name, calories, fiber, carbs, cups);

                cereals.add(cereal);
            }

            scan.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        int numCereals = cereals.size();
        System.out.println(numCereals + " records created.");
    }

    public static void main(String[] args)
    {
        String fileName = "src/data/cerealSubset.csv";
        new CerealRunner(fileName);
    }
}