package edu.eci.cvds.servlet;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import java.util.*;

@ManagedBean(name="Game")
@ApplicationScoped
public class Juego{
	private int numero;
	private int intentos;
	private int premio;
	private String estado;
	private ArrayList<Integer> listIntentos;
	
	public Juego(){
		restart();
	}
	public int getNumero(){
		return numero;
	}
	public int getIntentos(){
		return intentos;
	}
	public int getPremio(){
		return premio;
	}
	public String getEstado(){
		return estado;
	}
	public ArrayList<Integer> getListIntentos(){
		return listIntentos;
	}
	public void setNumero(int i){
		numero = i;
	}
	public void setIntentos(int i){
		intentos = i;
	}
	public void setPremio(int i){
		premio = i;
	}
	public void setEstado(String i){
		estado = i;
	}
	public void setListIntentos(ArrayList<Integer> i){
		listIntentos = i;
	}
	
	public void guess(int i){
		if(i == numero) {
			estado = "Ganaste";
		}
		else{
			intentos++;
			premio-=10000;
			estado = "Fallaste.\n Ingresa otro numero";
		}
		listIntentos.add(i);
	}
	
	public void restart(){
		intentos = 0;
		premio = 100000;
		estado = "Ingrese un numero";
		numero = (int)(Math.random() * 10000) + 1;
		listIntentos = new ArrayList<Integer>();
	}
}
