package server;

public class Ship
{
    private Point point;
    private int orentation;
    private int lengthShip;

    public Ship(Point point, int orentation, int lengthShip)
    {
        this.point = point;
        this.orentation = orentation;
        this.lengthShip = lengthShip;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public int getOrentation() {
        return orentation;
    }

    public void setOrentation(int orentation) {
        this.orentation = orentation;
    }

    public int getLengthShip() {
        return lengthShip;
    }

    public void setLengthShip(int lengthShip) {
        this.lengthShip = lengthShip;
    }

    public boolean checkPointOnShip(int x, int y)
    {
        for (int i = 0; i < lengthShip; i++)
        {
            switch (orentation)
            {
                case Constants.VERTICAL:
                {
                    if(x == (point.getX()+i) && y == point.getY())
                    {
                        return true;
                    }
                }
                break;
                case Constants.HORIZONTAL:
                {
                    if(x == (point.getX()) && y == (point.getY()+i))
                    {
                        return true;
                    }
                }
                break;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ship ship = (Ship) o;

        if (orentation != ship.orentation) return false;
        if (lengthShip != ship.lengthShip) return false;
        return point != null ? point.equals(ship.point) : ship.point == null;
    }

    @Override
    public int hashCode() {
        int result = point != null ? point.hashCode() : 0;
        result = 31 * result + orentation;
        result = 31 * result + lengthShip;
        return result;
    }
}
