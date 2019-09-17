
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
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.util.*;

/**
 *
 * @author Carlos Murillo - Yeisson Gualdron
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
		
		try{
			Todo tod = Service.getTodo(Integer.parseInt(id));
			ArrayList<Todo> todos=new ArrayList<Todo>();
			todos.add(tod);
			responseWriter.write(Service.todosToHTMLTable(todos));
		}catch(MalformedURLException e){
			resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			responseWriter.write("error interno en el servidor \n");
		}catch(FileNotFoundException f){
			resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
			responseWriter.write("No existe un item con el identificador dado \n");
		}
		catch(Exception num){
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			responseWriter.write("Requerimiento invalido \n");
		}
		responseWriter.flush();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Writer responseWriter = resp.getWriter();
		Optional<String> optName = Optional.ofNullable(req.getParameter("id"));
		String id = optName.isPresent() && !optName.get().isEmpty() ? optName.get() : "";
		
		try{
			Todo tod = Service.getTodo(Integer.parseInt(id));
			ArrayList<Todo> todos=new ArrayList<Todo>();
			todos.add(tod);
			responseWriter.write(Service.todosToHTMLTable(todos));
		}catch(MalformedURLException e){
			resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			responseWriter.write("error interno en el servidor \n");
		}catch(FileNotFoundException f){
			resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
			responseWriter.write("No existe un item con el identificador dado \n");
		}
		catch(Exception num){
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			responseWriter.write("Requerimiento invalido \n");
		}
		responseWriter.flush();
	}
}
