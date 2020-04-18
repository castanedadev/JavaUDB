/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rick
 */
public class servlet_ingresar_empleado extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        ResultSet rs = null;
        Connection conexion = null;
        String ids = request.getParameter("codigo");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String telefono = request.getParameter("telefono");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/guia7_java?characterEncoding=latin1&useConfigs=maxPerformance", "root", "This#is#4#MySQL");
            Statement s = conexion.createStatement();

            System.out.println("Conexion Exitosa");

            s.executeUpdate("INSERT INTO empleados "
                    + "values(" + ids + ",\"" + nombre + "\",\""
                    + apellido + "\",\"" + telefono + "\")");
            rs = s.executeQuery("SELECT * FROM empleados");

            out.println("<html>");
            out.println("<body>");
            out.println("<h1>Datos Ingresados Exitosamente</h1>");
            out.println("<table align='center' with='75%' border=1>");
            out.println("<tr><th>Codigo</th><th>Nombres</th><th>Apellidos"
                    + "</th><th>Telefono</th></tr>");
            while (rs.next()) {
                out.println("<tr><td>" + rs.getInt("Codigo") + "</td><td>"
                        + rs.getString("Nombre") + "</td><td>" + rs.getString("Apellidos") + "</td><td>"
                        + rs.getString("Telefono") + "</td></tr>");
            }
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
            conexion.close();
        } catch (Exception ex) {
            ex.printStackTrace();
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(servlet_ingresar_empleado.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(servlet_ingresar_empleado.class.getName()).log(Level.SEVERE, null, ex);
        }
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
