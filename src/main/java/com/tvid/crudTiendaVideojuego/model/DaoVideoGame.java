package com.tvid.crudTiendaVideojuego.model;
import com.tvid.crudTiendaVideojuego.service.ConnectionMySQL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DaoVideoGame {
        Connection con;
        CallableStatement cstm;
        ResultSet rs;
        Logger logger = LoggerFactory.getLogger(DaoVideoGame.class);
        int r;

        public java.lang.Object findAll(){
            List<BeanVideoGame> listgames = new ArrayList<>();
            try {
                con = ConnectionMySQL.getConnection();
                cstm = con.prepareCall("{call buscarjuego}");
                rs = cstm.executeQuery();
                while (rs.next()) {
                    BeanVideoGame game = new BeanVideoGame();

                    game.setId(rs.getInt("id"));
                    game.setName(rs.getString("nombre"));
                    game.setDescription(rs.getString("descripcion"));
                    game.setDate_reg(rs.getString("fecharegistro"));
                    game.setStatus(rs.getInt("estado"));
                    listgames.add(game);
                }
            }catch (Exception e){
                logger.error("Ha ocurrido un error: " + e.getMessage());
            }finally {
                ConnectionMySQL.closeConnections(con,cstm,rs);
            }
            return listgames;
        }


        public BeanVideoGame listarporid(int id){
            BeanVideoGame game = null;
            try {
                con = ConnectionMySQL.getConnection();
                cstm = con.prepareCall("select *from videojuego where id=?");
                cstm.setInt(1,id);
                rs = cstm.executeQuery();

                while (rs.next()) {
                    game = new BeanVideoGame();

                    game.setId(rs.getInt("id"));
                    game.setName(rs.getString("nombre"));
                    game.setDescription(rs.getString("descripcion"));
                    game.setDate_reg(rs.getString("fecharegistro"));
                    game.setStatus(rs.getInt("estado"));

                }
            }catch(Exception e){
                logger.error("Ha ocurrido un error: " + e.getMessage());
            }finally{
                ConnectionMySQL.closeConnections(con,cstm,rs);
            }
            return game;
        }

        public int agregar(BeanVideoGame game){
            try{
                con = ConnectionMySQL.getConnection();
                cstm = con.prepareCall("{call agregarjuego(?,?,?)}");

                cstm.setString(1,game.getName());
                cstm.setString(2,game.getDescription());
                cstm.setString(3,game.getDate_reg());

                cstm.executeUpdate();
            }catch(Exception e){
                logger.error("Ha ocurrido un error: " + e.getMessage());
            }finally{
                ConnectionMySQL.closeConnections(con,cstm);
            }
            return r;
        }


    public int modificar(BeanVideoGame game){
        try{
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("{call modificarjuego(?,?,?,?)}");

            cstm.setInt(1,game.getId());
            cstm.setString(2,game.getName());
            cstm.setString(3,game.getDescription());
            cstm.setString(4,game.getDate_reg());

            cstm.executeUpdate();
        }catch(Exception e){
            logger.error("Ha ocurrido un error: " + e.getMessage());
        }finally{
            ConnectionMySQL.closeConnections(con,cstm);
        }
        return r;
    }

    public void eliminar(int id){
        try{
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("{call eliminarjuego(?)}");
            cstm.setInt(1,id);
            cstm.executeUpdate();
        }catch(Exception e){
            logger.error("Ha ocurrido un error: " + e.getMessage());
        }finally{
            ConnectionMySQL.closeConnections(con,cstm);
        }

    }

    public void eliminartemporal(int id){
        try{
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("{call bajatemporal(?)}");
            cstm.setInt(1,id);
            cstm.executeUpdate();
        }catch(Exception e){
            logger.error("Ha ocurrido un error: " + e.getMessage());
        }finally{
            ConnectionMySQL.closeConnections(con,cstm);
        }

    }
}
