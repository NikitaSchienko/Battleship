package server;

import java.util.ArrayList;
import java.util.Random;

public class ShipClassicsGenerate
{

    private static final int VERTICAL = 0;
    private static final int HORIZONTAL = 1;

    private int[][] shipsField;
    private ArrayList<Point> ships;
    private Random random;

    private ArrayList<Ship> shipArrayList;

    public int[][] getShips()
    {
        return shipsField;
    }


    public ArrayList<Ship> getShipArrayList() {
        return shipArrayList;
    }

    public ShipClassicsGenerate()
    {
        shipArrayList = new ArrayList<Ship>();
        random = new Random();
        shipsField = new int[10][10];
        ships = new ArrayList<Point>();

        for (int x = 0; x < 10; x++)
        {
            for (int y = 0; y < 10; y++)
            {
                ships.add(new Point(x, y));
            }
        }

        for (int i = 1; i < 5; i++)
        {
            generateShipForLenrth(5-i,i);
        }

        for (int x = 0; x < 10; x++)
        {
            for (int y = 0; y < 10; y++)
            {
                if(shipsField[x][y] == 1)
                {
                    shipsField[x][y] = 0;
                }
            }
        }
    }

    private void generateShipForLenrth(int lengthShip, int countShip)
    {
        for(int i = 0; i < countShip; i++)
        {

            int orentation = random.nextInt(2);

            ArrayList<Point> variantPoint = searchTruePositionShips(lengthShip,orentation);


            if(variantPoint.size() == 0)
            {
                try
                {
                    throw new NullPointerException();
                }
                catch (NullPointerException e)
                {
                    e.getStackTrace();
                    return;
                }
            }

            int numberPoint = random.nextInt(variantPoint.size());

            Point point = variantPoint.get(numberPoint);
            try
            {
                recordShips(lengthShip, orentation, point.getX(), point.getY());
                Ship ship = new Ship(point, orentation,lengthShip);
                shipArrayList.add(ship);
            }
            catch (ArrayIndexOutOfBoundsException e)
            {
                e.getStackTrace();
            }
        }
    }






    private void printTruePoint(ArrayList<Point> points)
    {

        for (Point point: points)
        {
            System.out.println(point);
        }
        System.out.println();
    }



    private void recordShips(int lengthShips, int orentation, int x, int y)
    {
        for(int i = 0; i < lengthShips; i++)
        {
            if(orentation == HORIZONTAL)
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
                if((y+j) >= 0
                        && (x+i) >= 0
                        && (x+i) < shipsField.length
                        && (y+j) < shipsField.length
                        && shipsField[x+i][y+j] != 2)
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


    private ArrayList<Point> searchTruePositionShips(int lengthShip, int orentation)
    {
        ArrayList<Point> truePositionShips = new ArrayList<Point>();

        for (Point currentPoint: ships)
        {
               if(checkOnPositionShip(currentPoint, lengthShip, orentation))
               {
                   truePositionShips.add(currentPoint);
               }
        }
        return truePositionShips;
    }


    private boolean checkOnPositionShip(Point point, int lengthShip, int orentation)
    {

        int x = point.getX();
        int y = point.getY();

            switch (orentation)
            {
                case HORIZONTAL:
                {
                    for(int i = 0; i < lengthShip; i++)
                    {
                        if((y+i) >= shipsField.length)
                        {
                            return false;
                        }
                        else if(shipsField[x][y+i] > 0)
                        {
                            return false;
                        }
                    }
                }
                break;
                case VERTICAL:
                {
                    for(int i = 0; i < lengthShip; i++)
                    {
                        if((x+i) >= shipsField.length)
                        {

                            return false;
                        }
                        else if(shipsField[x+i][y] > 0)
                        {
                            return false;
                        }
                    }
                }
                break;
            }
            return true;
    }

    private void print()
    {
        for(int i = 0; i < shipsField.length; i++)
        {
            for(int j = 0; j < shipsField[i].length; j++)
            {
                System.out.print(shipsField[i][j]+" ");
            }
            System.out.println();
        }
    }
}
