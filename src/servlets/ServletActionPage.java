package servlets;

import server.GameLogic;
import server.ShipClassicsGenerate;
import server.ShipGeneration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

public class ServletActionPage extends HttpServlet
{
    private ShipClassicsGenerate shipGeneration;
    private int[][] field;
    private GameLogic gameLogic;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        shipGeneration = new ShipClassicsGenerate();
        field = new int[10][10];
        gameLogic = new GameLogic(shipGeneration,field,shipGeneration.getShipArrayList());
        //String test = request.getParameter("ships");
        String content = getField(field);
        response.setContentType("text/plain");


        OutputStream outStream = response.getOutputStream();
        outStream.write(content.getBytes("UTF-8"));
        outStream.flush();
        outStream.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        int idCell = Integer.valueOf(request.getParameter("idCell"));

        gameLogic.shot(idCell);

        response.setContentType("text/plain");

        OutputStream outStream = response.getOutputStream();

        if(gameLogic.getShipArrayList().size()==0)
        {
            outStream.write(modalWindow().getBytes("UTF-8"));
        }
        if(gameLogic.getShipArrayList().size() == 0)
        {
            outStream.write(modalWindow().getBytes("UTF-8"));
        }

        System.out.println("Поле перед отправкой: ");
        print();
        System.out.println("HTML");
        System.out.println(getField(field));
        outStream.write(getField(field).getBytes("UTF-8"));

        outStream.flush();
        outStream.close();
    }


    private String modalWindow()
    {
        String modal = "<div id=\"overlay\">\n" +
                "    <div id=\"modal\">\n" +
                "        <div class=\"modal-body\">\n" +
                "            <p>Поздравляем!</p>\n" +
                "            <p>Ваш счет: </p>\n" +
                "            <div class=\"close\" onclick=\"showModalWindow('none'); return false\">x</div>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "</div>";
        return modal;
    }

    private String getField(int[][] field)
    {
        String table = "<table>\n";
        for (int i = 0; i < 10; i++)
        {
            table = table + "<tr>\n";
            for (int j = 0; j < 10; j++)
            {
                switch (field[i][j])
                {
                    case 0:
                    {
                        table = table + "<td id=\""+(i*10+j)+"\" class=\"td-color-blue\" onClick=\"actionClick1(this)\"></td>\n";
                    }
                    break;
                    case 1:
                    {
                        table = table + "<td class=\"td-color-gray\" onClick=\"cleanCell(this)\"></td>\n";
                    }
                    break;
                    case 2:
                    {
                        table = table + "<td class=\"td-color-red\" onClick=\"cleanCell(this)\"></td>\n";
                    }
                    break;
                }

            }
            table = table + "</tr>\n";
        }
        table = table + "</table>\n";


        return table;
    }

    private void print()
    {
        for(int i = 0; i < field.length; i++)
        {
            for(int j = 0; j < field[i].length; j++)
            {
                System.out.print(field[i][j]+" ");
            }
            System.out.println();
        }
    }

}
