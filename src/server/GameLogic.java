package server;

import java.util.ArrayList;

public class GameLogic
{
    private ShipClassicsGenerate shipsField;
    private int[][] field;
    private ArrayList<Ship> shipArrayList;

    public GameLogic(ShipClassicsGenerate shipsField, int[][] field, ArrayList<Ship> shipArrayList)
    {
        this.shipArrayList = shipArrayList;
        this.shipsField = shipsField;
        this.field = field;
    }

    public ArrayList<Ship> getShipArrayList()
    {
        return shipArrayList;
    }

    public int[][] getField()
    {
        return field;
    }

    public void setField(int[][] field)
    {
        this.field = field;
    }

    public ShipClassicsGenerate getShipsField()
    {
        return shipsField;
    }

    public void setShipsField(ShipClassicsGenerate shipsField)
    {
        this.shipsField = shipsField;
    }

    public void shot(int id)
    {
        if(shipsField.getShips()[getRow(id)][getColumn(id)] == 0)
        {
            field[getRow(id)][getColumn(id)] = 1;
        }
        if(shipsField.getShips()[getRow(id)][getColumn(id)] == 2)
        {
            field[getRow(id)][getColumn(id)] = 2;
            System.out.println("Корабль подбит: "+id);
            System.out.println(toStringField());
            searchDeadShip(getRow(id), getColumn(id));
        }

    }

    private String toStringField()
    {
        String s = "";
        for (int i =0; i< 10; i++) {
            for (int j = 0; j < 10; j++) {
                s = s+field[i][j]+" ";
            }
            s = s+"\n";
        }
        return  s;
    }

    private int getColumn(int id)
    {
        return id < shipsField.getShips().length ? id : id % shipsField.getShips().length;
    }

    private int getRow(int id)
    {
        return id / shipsField.getShips().length;
    }

    private void searchDeadShip(int x, int y)
    {
        for (Ship ship : shipArrayList)
        {
            if(ship.checkPointOnShip(x,y))
            {
                if(checkDeadAllBlockShip(ship))
                {
                    System.out.println("Корабль убит - "+ship.getPoint());
                    recordBorderShips(ship);
                    shipArrayList.remove(ship);
                }
            }
        }
    }

    private boolean checkDeadAllBlockShip(Ship ship)
    {
        for(int i = 0; i < ship.getLengthShip(); i++)
        {
            switch (ship.getOrentation())
            {
                case Constants.VERTICAL:
                {
                    if(field[ship.getPoint().getX()+i][ship.getPoint().getY()] == 0)
                    {
                        return false;
                    }
                }
                break;
                case Constants.HORIZONTAL:
                {
                    if(field[ship.getPoint().getX()][ship.getPoint().getY()+i] == 0)
                    {
                        return false;
                    }
                }
                break;
            }
        }
        return true;
    }

    private void recordBorderShips(Ship ship)
    {
        for(int i = 0; i < ship.getLengthShip(); i++)
        {
            switch (ship.getOrentation())
            {
                case Constants.VERTICAL:
                {
                    recordBorderBlockShips(ship.getPoint().getX()+i, ship.getPoint().getY());
                }
                break;
                case Constants.HORIZONTAL:
                {
                    recordBorderBlockShips(ship.getPoint().getX(), ship.getPoint().getY()+i);
                }
                break;
            }

        }
    }

    private void recordBorderBlockShips(int x, int y)
    {
        for(int i = -1; i < 2; i++)
        {
            for(int j = -1; j < 2; j++)
            {
                if((y+j) >= 0
                        && (x+i) >= 0
                        && (x+i) < field.length
                        && (y+j) < field.length
                        && field[x+i][y+j] != 2)
                {
                    field[x+i][y+j] = 1;
                    //ships.remove(new Point(x+i,y+j));
                }
            }
        }
    }
}
