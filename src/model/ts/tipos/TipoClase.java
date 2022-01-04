/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.ts.tipos;

import model.Token;
import model.ts.Clase;
import model.ts.TablaSimbolos;

/**
 *
 * @author Hugo Luna
 */
public class TipoClase extends Tipo {

	private Token nombre;
	
	public TipoClase(Token id) {
		nombre = id;
	}

	public String getNombreClase() {
		return nombre.getLexema();
	}

	public boolean esTipoPrimitivo() {
		return false;
	}

	@Override
	public boolean conforma(TipoMetodo t) {
		if (t.getNombreClase().equals("null"))
			return true;
		if (this.getNombreClase().equals(t.getNombreClase()))
			return true;
		boolean esSubtipo = false;
		String nombrePadre = this.getNombreClase();
		Clase claseActual;
		while ((!esSubtipo) && (nombrePadre!=null)) {
			claseActual = TablaSimbolos.clases.get(nombrePadre);
			if (claseActual==null)	// fix para object
				break;
			nombrePadre = claseActual.getNombreClasePadre();
			if (nombrePadre!=null) {
				if (nombrePadre.equals(t.getNombreClase()))
					esSubtipo = true;
			}
		}
		return esSubtipo;
	}
	
	public boolean esValido() {
		return TablaSimbolos.clases.containsKey(nombre.getLexema());
	}
	
	public boolean esTipoClase() {
		return true;
	}
	
}
