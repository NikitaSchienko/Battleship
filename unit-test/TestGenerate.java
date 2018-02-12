import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import server.ShipGeneration;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TestGenerate
{
    private static final Integer COUNT_SHIPS = 10;

    private Integer currentCountShips = 0;

    @Mock
    private ShipGeneration shipGeneration = mock(ShipGeneration.class);
    @Test
    public void test()
    {

        shipGeneration.generate();
        int[][] ships = shipGeneration.getShips();

        for (int i = 0; i < 10; i++)
        {
            for (int j = 0; j < 10; j++)
            {
                if(ships[i][j] == 1)
                {
                    currentCountShips++;
                }
            }
        }

        when(shipGeneration.getShips().length).thenReturn(COUNT_SHIPS);

    }
}
