package server;

public class GameLogic
{
    private ShipGeneration shipsField;
    private int[][] field;

    public GameLogic(ShipGeneration shipsField, int[][] field)
    {
        this.shipsField = shipsField;
        this.field = field;
    }

    public int[][] getField()
    {
        return field;
    }

    public void setField(int[][] field)
    {
        this.field = field;
    }

    public ShipGeneration getShipsField()
    {
        return shipsField;
    }

    public void setShipsField(ShipGeneration shipsField)
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
        }
    }

    private int getColumn(int id)
    {
        return id < shipsField.getShips().length ? id : id % shipsField.getShips().length;
    }

    private int getRow(int id)
    {
        return id / shipsField.getShips().length;
    }
}
