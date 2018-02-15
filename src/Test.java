import server.ShipClassicsGenerate;
import server.ShipGeneration;

public class Test
{
    public static void main(String[] args)
    {
        ShipClassicsGenerate s = new ShipClassicsGenerate();

        for(int i = 0; i < s.getShipsField().length; i++)
        {
            for(int j = 0; j < s.getShipsField()[i].length; j++)
            {
                System.out.print(s.getShipsField()[i][j]+" ");
            }
            System.out.println();
        }
        //System.out.println("Count: "+ s.getShips().size());
    }
}
