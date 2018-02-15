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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        shipGeneration = new ShipClassicsGenerate();
        field = new int[10][10];
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
        GameLogic gameLogic = new GameLogic(shipGeneration,field,shipGeneration.getShipArrayList());

        int idCell = Integer.valueOf(request.getParameter("idCell"));
        gameLogic.shot(idCell);

        response.setContentType("text/plain");

        OutputStream outStream = response.getOutputStream();

        if(gameLogic.getShipArrayList().size()==0)
        {
            String congratulation = "Победа!";
            outStream.write(modalWindow().getBytes("UTF-8"));
        }

        outStream.write(getField(field).getBytes("UTF-8"));

        outStream.flush();
        outStream.close();
    }


    private String modalWindow()
    {
        String modal = "<div id=\"fixed\" class=\"modal fade\">\n" +
                "  <div class=\"modal-dialog\" role=\"document\">\n" +
                "    <div class=\"modal-content\">\n" +
                "      <div class=\"modal-header\">\n" +
                "        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n" +
                "          <span aria-hidden=\"true\">&times;</span>\n" +
                "        </button>\n" +
                "        <h4 class=\"modal-title\">Modal title</h4>\n" +
                "      </div>\n" +
                "      <div class=\"modal-body\">\n" +
                "        <p>One fine body&hellip;</p>\n" +
                "      </div>\n" +
                "      <div class=\"modal-footer\">\n" +
                "        <button type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\">Close</button>\n" +
                "        <button type=\"button\" class=\"btn btn-primary\">Save changes</button>\n" +
                "      </div>\n" +
                "    </div><!-- /.модальное окно-Содержание -->  \n" +
                "  </div><!-- /.модальное окно-диалог -->  \n" +
                "</div><!-- /.модальное окно -->  ";
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



}
