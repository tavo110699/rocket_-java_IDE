package model.ast.sentencias;

import Utils.GenCod;
import exceptions.semanticas.ExcepcionSemantica;
import exceptions.semanticas.ExcepcionSemanticaPersonalizada;
import model.Token;
import model.ast.expresiones.NodoExpresion;
import model.ts.tipos.TipoMetodo;


public class NodoWhile extends NodoSentencia {

	private Token identificador;
	private NodoExpresion condicion;
	private NodoSentencia sentencia;
	
	public NodoWhile(Token id, NodoExpresion expr, NodoSentencia sent) {
		identificador = id;
		condicion = expr;
		sentencia = sent;
	}

	public NodoExpresion getCondicion() {
		return condicion;
	}

	public void setCondicion(NodoExpresion condicion) {
		this.condicion = condicion;
	}

	public NodoSentencia getSentencia() {
		return sentencia;
	}

	public void setSentencia(NodoSentencia sentencia) {
		this.sentencia = sentencia;
	}

	public void chequear() throws ExcepcionSemantica {
		String str = GenCod.generarEtiqueta();
		GenCod.comment("Comienzo del WHILE_"+str);
		GenCod.gen("WHILE_L1_"+str,"NOP","");
		TipoMetodo tc = condicion.chequear();		// Traduccion de E
		GenCod.gen("BF WHILE_L2_"+str);
		if (!tc.getNombreClase().equals("boolean"))
			throw new ExcepcionSemanticaPersonalizada(identificador.getLinea(),"La condicion del While no es una expresion logica");
		sentencia.chequear();						// Traduccion de S
		GenCod.gen("JUMP WHILE_L1_"+str);
		GenCod.gen("WHILE_L2_"+str,"NOP","");
		GenCod.comment("Fin del WHILE_"+str);
	}

}
