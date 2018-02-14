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
        generate3();
        generate2();
        //generate1();
    }

    private void generate2()
    {
        Random random = new Random();
        for(int i = 0; i < 3; i ++)
        {

            int orentation = random.nextInt(2);

            ArrayList<Point> variantPoint = searchTruePositionShips(2,orentation);
            System.out.println("Доступные точки - "+(orentation != VERTICAL? "HORIZONTAL" : "VERTICAL"));
            printTruePoint(variantPoint);

            if(variantPoint.size()==0)
            {
                variantPoint = searchTruePositionShips(2, orentation == VERTICAL? HORIZONTAL : VERTICAL);
                System.out.println("Доступные точки - "+(orentation != VERTICAL? "HORIZONTAL" : "VERTICAL"));
                printTruePoint(variantPoint);
            }


            int numberPoint = random.nextInt(variantPoint.size());

            Point point = ships.get(numberPoint);
            System.out.println("Выбранная точка"+point+" "+(orentation != VERTICAL? "HORIZONTAL" : "VERTICAL"));
            recordShips(3,orentation, point.getX(), point.getY());
            //ships.remove(numberPoint);

            System.out.println("Тест: ");
            print();
            System.out.println();
        }
    }


    private void generate3()
    {
        Random random = new Random();
        for(int i = 0; i < 2; i ++)
        {

            int orentation = random.nextInt(2);

            ArrayList<Point> variantPoint = searchTruePositionShips(3,orentation);
            System.out.println("Доступные точки - "+(orentation != VERTICAL? "HORIZONTAL" : "VERTICAL"));
            printTruePoint(variantPoint);

            if(variantPoint.size()==0)
            {
                variantPoint = searchTruePositionShips(3, orentation == VERTICAL? HORIZONTAL : VERTICAL);
                System.out.println("Доступные точки - "+(orentation != VERTICAL? "HORIZONTAL" : "VERTICAL"));
                printTruePoint(variantPoint);
            }


            int numberPoint = random.nextInt(variantPoint.size());

            Point point = ships.get(numberPoint);
            System.out.println("Выбранная точка"+point+" "+(orentation != VERTICAL? "HORIZONTAL" : "VERTICAL"));
            recordShips(3,orentation, point.getX(), point.getY());
            //ships.remove(numberPoint);

            System.out.println("Тест: ");
            print();
            System.out.println();
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

    private void generate4()
    {
        Random random = new Random();

        int orentation = random.nextInt(2);
        if(orentation != VERTICAL)
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
            if(orentation != VERTICAL)
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
