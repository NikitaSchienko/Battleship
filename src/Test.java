import panel.ShipGeneration;

public class Test
{
    public static void main(String[] args)
    {
        ShipGeneration shipGeneration = new ShipGeneration(80);

        int[][] ships = shipGeneration.getShips();

        for (int i = 0; i < 10; i++)
        {
            for(int j =0; j < 10; j++)
            {
                System.out.print(ships[i][j] +" ");
            }
            System.out.println();
        }

    }
}
