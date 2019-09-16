
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.servlet;

import java.io.IOException;
import java.io.Writer;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import edu.eci.cvds.servlet.model.Todo;
/**
 *
 * @author 2152972
 */

@WebServlet(
    urlPatterns = "/laboratorio"
)

public class MiniServlet extends HttpServlet{
    static final long serialVersionUID = 35L;

    @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       Writer responseWriter = resp.getWriter();
       Optional<String> optName = Optional.ofNullable(req.getParameter("id"));
       String id = optName.isPresent() && !optName.get().isEmpty() ? optName.get() : "";
        
       //resp.setStatus(HttpServletResponse.SC_OK);
       //responseWriter.write("Hello " + id + "!");
       //responseWriter.flush();
       Service ser = new Service();
       Todo tod = ser.getTodo(Integer.parseInt(id));
       if(true){
           responseWriter.write("{\n");
           resp.setStatus(HttpServletResponse.SC_OK);
           responseWriter.write("UserId : "+tod.getUserId()+",\n");
           responseWriter.write("id : "+tod.getId()+",\n");
           responseWriter.write("title : "+tod.getTitle()+",\n");
           responseWriter.write("conplete : " + tod.getCompleted()+"\n");
           responseWriter.write("}");
       }
   }
}
