package com.tvid.crudTiendaVideojuego.controller;

import com.tvid.crudTiendaVideojuego.model.BeanVideoGame;
import com.tvid.crudTiendaVideojuego.model.DaoVideoGame;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;


@WebServlet(name = "ServletVideogame", value = "/readVideogame")
public class ServletVideogame extends HttpServlet {
    Logger logger = LoggerFactory.getLogger(ServletVideogame.class);

    BeanVideoGame game = new BeanVideoGame();
    DaoVideoGame gamedao = new DaoVideoGame();
    int id;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException {
      //  List<BeanVideoGame> listgames = gamedao.findAll();
        request.setAttribute("listgames", new DaoVideoGame().findAll());
        request.getRequestDispatcher("/views/game/game.jsp").forward(request,response);
        //processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String action = request.getParameter("action");

        switch(action){
            case "Registrar":
                String nombre = request.getParameter("txtnombre");
                String descripion = request.getParameter("txtdescripcion");
                String fecha = request.getParameter("txtfecha");

                game.setName(nombre);
                game.setDescription(descripion);
                game.setDate_reg(fecha);

                gamedao.agregar(game);
               // request.getRequestDispatcher("ServletVideogame?action=Listar").forward(request,response);
               doGet(request,response);
               break;
            case "Actualizar":
                id = Integer.parseInt(request.getParameter("id"));
                String nombre1 = request.getParameter("txtnombre");
                String descripion1 = request.getParameter("txtdescripcion");
                String fecha1 = request.getParameter("txtfecha");

                game.setId(id);
                game.setName(nombre1);
                game.setDescription(descripion1);
                game.setDate_reg(fecha1);

                gamedao.modificar(game);
               // request.getRequestDispatcher("ServletVideogame?action=Listar").forward(request,response);
                doGet(request,response);
              break;
            case "Eliminar":
                id = Integer.parseInt(request.getParameter("id"));
                gamedao = new DaoVideoGame();
                gamedao.eliminar(id);
              //request.getRequestDispatcher("ServletVideogame?action=Listar").forward(request,response);
                doGet(request,response);
               break;
            /*case "EliminarTemporal":
                id = Integer.parseInt(request.getParameter("id"));
                gamedao = new DaoVideoGame();
                gamedao.eliminartemporal(id);
              // request.getRequestDispatcher("ServletVideogame?action=Listar").forward(request,response);
                doGet(request,response);
                break;*/
            case "Cargar":
                id = Integer.parseInt(request.getParameter("id"));
               // game = gamedao.listarporid(id);
                request.setAttribute("juegoseleccionado",new DaoVideoGame().listarporid(id));
              request.getRequestDispatcher("/views/game/update.jsp").forward(request,response);
               // doGet(request,response);
                break;
            case "Consultar":
                id = Integer.parseInt(request.getParameter("id"));
                // game = gamedao.listarporid(id);
                request.setAttribute("juegoseleccionado",new DaoVideoGame().listarporid(id));
                request.getRequestDispatcher("/views/game/consulta.jsp").forward(request,response);
                break;
            case "Cancelar":
                doGet(request,response);
                break;
        }

        // processRequest(request, response);
    }
}
