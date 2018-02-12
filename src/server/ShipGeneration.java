package server;

import java.util.ArrayList;
import java.util.Random;

public class ShipGeneration
{
    private int count;
    private int[][] ships;
    private ArrayList<Integer> positions;

    public ShipGeneration(int count)
    {
        this.count = count;
        ships = new int[10][10];
        positions = new ArrayList<Integer>();
        fillingInArrayList();
        generate();
    }

    private void fillingInArrayList()
    {
        for(int i = 0; i < ships.length*ships[0].length; i++)
        {
            positions.add(i);
        }
    }

    public int[][] getShips()
    {
        return ships;
    }

    public void generate()
    {
        try
        {
            throw new NullPointerException();
        }
        catch (Exception e)
        {
            e.getStackTrace();
        }
        Random random = new Random();

        for(int i = 0; i < count; i++)
        {
            int position = random.nextInt(positions.size());
            setShipsPosition(position);
            positions.remove(position);
        }
    }

    private void setShipsPosition(int position)
    {
        int x = positions.get(position)/ships.length;
        int y = positions.get(position)%ships.length;
        ships[x][y] = 1;
    }
}
