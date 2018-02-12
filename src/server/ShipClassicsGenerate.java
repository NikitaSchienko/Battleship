package server;

import java.util.ArrayList;
import java.util.Random;

public class ShipClassicsGenerate
{
    private int[][] shipsField;
    private ArrayList<Point> ships;

    public ArrayList<Point> getShips()
    {
        return ships;
    }

    private static final int VERTICAL = 1;
    private static final int HORIZONTAL = 2;

    public ShipClassicsGenerate()
    {
        shipsField = new int[10][10];
        ships = new ArrayList<Point>();

        for (int x = 0; x < 10; x++)
        {
            for (int y = 0; y < 10; y++)
            {
                ships.add(new Point(x, y));
            }
        }

        generate4();
       // generate3();
    }

    private void generate3()
    {
        Random random = new Random();
        for(int i = 0; i < 2; i ++)
        {
            int numberPoint = random.nextInt(ships.size());
            int orentation = random.nextInt(2);
            Point point = ships.get(numberPoint);

            recordShips(3,orentation, point.getX(), point.getY());
            ships.remove(numberPoint);
        }
    }

    private void generate4()
    {
        Random random = new Random();

        int orentation = random.nextInt(2);
        if(orentation == VERTICAL)
        {
            recordShips(4, orentation, random.nextInt(10), random.nextInt(7));
        }
        else
        {
            recordShips(4, orentation, random.nextInt(7), random.nextInt(10));
        }

    }

    private void recordShips(int lengthShips, int orentation, int x, int y)
    {
        for(int i = 0; i < lengthShips; i++)
        {
            if(orentation == VERTICAL)
            {
                shipsField[x][y+i] = 2;
                recordBorderShips(x,y+i);
                ships.remove(new Point(x,y));
            }
            else
            {
                shipsField[x+i][y] = 2;
                recordBorderShips(x+i,y);
                ships.remove(new Point(x,y));
            }
        }

    }

    private void recordBorderShips(int x, int y)
    {
        for(int i = -1; i < 2; i++)
        {
            for(int j = -1; j < 2; j++)
            {
                if((y+j) >= 0 && (x+i) >= 0 && (x+i) < shipsField.length && (y+j) < shipsField.length && shipsField[x+i][y+j] != 2)
                {
                    shipsField[x+i][y+j] = 1;
                    ships.remove(new Point(x+i,y+j));
                }
            }
        }
    }

    public int[][] getShipsField()
    {
        return shipsField;
    }
}
