import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program
{
    public static List<Point> parseList(String path) throws Exception
    {
        if (!new File(path).exists())
            return null;

        Scanner scan = new Scanner(new File(path));
        List<Point> list = new ArrayList<>();

        while (scan.hasNextLine())
        {
            String[] split = scan.nextLine().split(",");
            Double[] conv = new Double[split.length];

            for (int i = 0; i < split.length; i++)
                conv[i] = Double.parseDouble(split[i]);
			
			list.add(new SteelPoint(conv[3], conv[4]]));
        }

        scan.close();

        return list;
    }

    public static Point getYieldStrength(List<Point> plist)
    {
        final double elmod = plist.get(0).getRegression()[0];

        Point closest = plist.get(0);

        for (Point p : plist)
            if (Math.abs(closest.getYieldStressSlope() - elmod) > Math.abs(p
                    .getYieldStressSlope() - elmod))
                closest = p;

        return closest;
    }

    public static void main(String[] args) throws Exception
    {
        List<Point> steel = parseList("22615TruestresstruestrainAdrienBE.txt")

        System.out.println("--- Yield Strengths ---");
        System.out.println("A36: " + getYieldStrength(steel));
    }
}
