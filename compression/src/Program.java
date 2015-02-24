import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program
{
    public static List<Point> parseList(String path, String test)
            throws Exception
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

            switch (test)
            {
                case "p_wood":
                    list.add(new WoodParallelPoint(conv[3], conv[4]));
                    break;
                case "r_wood":
                    list.add(new WoodRadialPoint(conv[3], conv[4]));
                    break;
                case "a":
                    list.add(new AcrylicPoint(conv[3], conv[4]));
                    break;
            }
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
        List<Point> ac = parseList(
                "02192015 acrylicRocky  11;39 02-19-2015.txt", "a");
        List<Point> wp = parseList(
                "02192015 woodparallelRocky 09;44 02-19-2015.txt", "p_wood");
        List<Point> wr = parseList("02192015 woodradiallRocky.txt", "r_wood");

        System.out.println("--- Yield Strengths ---");
        System.out.println("Acrylic: " + getYieldStrength(ac));
        System.out.println("WP: " + getYieldStrength(wp));
        System.out.println("WR: " + getYieldStrength(wr));
    }
}
