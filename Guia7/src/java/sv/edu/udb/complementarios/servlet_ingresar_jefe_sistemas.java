/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.complementarios;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sv.edu.udb.servlet.Conexion;

/**
 *
 * @author Rick
 */
public class servlet_ingresar_jefe_sistemas extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        ResultSet rs = null;
        Conexion con = null;

        try {

            String nombres = request.getParameter("nombres");
            String apellidos = request.getParameter("apellidos");
            String edad = request.getParameter("edad");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String tipoUsuario = request.getParameter("tipoUsuario");

            con = new Conexion();
            //buscará una coincidencia (count usuario), si es correcto
            //podrá loguearse
            String sql = "INSERT INTO `guia7_java`.`usuarios`\n"
                    + "(`nombres`,\n"
                    + "`apellidos`,\n"
                    + "`edad`,\n"
                    + "`id_tipo_usuario`,\n"
                    + "`usuario`,\n"
                    + "`password`)\n"
                    + "VALUES ('" + nombres + "', '" + apellidos + "', '"
                    + edad + "', '" + tipoUsuario + "','" + username + "', '" + password + "');";

            System.out.println(sql);

            con.setQuery(sql);

            con.setRs("SELECT * FROM `guia7_java`.`usuarios`;");
            rs = con.getResultSet();

            out.println("<html>");
            out.println("<link href=\"//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" rel=\"stylesheet\" id=\"bootstrap-css\">");
            out.println("<script src=\"//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\"></script>");
            out.println("<script src=\"//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"web_style.css\">");
            out.println("<body class=\"text-center\">");
            out.println("<h2>Datos Ingresados Exitosamente</h2>");
            out.println("</br>");
            out.println("<table class=\"table\">");
            out.println("<tr><th>Codigo</th><th>Nombres</th><th>Apellidos"
                    + "</th><th>Edad</th><th>Tipo Usuario</th><th>Username</th><th>Password</th></tr>");
            while (rs.next()) {
                out.println("<tr><td>" + rs.getInt("id_usuario") + "</td><td>"
                        + rs.getString("nombres") + "</td><td>"
                        + rs.getString("apellidos") + "</td><td>"
                        + rs.getString("edad") + "</td><td>"
                        + rs.getString("id_tipo_usuario") + "</td><td>"
                        + rs.getString("usuario") + "</td><td>"
                        + rs.getString("password") + "</td></tr>");
            }
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
            con.cerrarConexion();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
