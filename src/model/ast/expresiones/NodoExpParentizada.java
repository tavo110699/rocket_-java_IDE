package model.ast.expresiones;

import exceptions.semanticas.ExcepcionExpParentizadaPrimitiva;
import exceptions.semanticas.ExcepcionSemantica;
import model.Token;
import model.ast.encadenados.NodoEncadenado;
import model.ts.tipos.TipoMetodo;


public class NodoExpParentizada extends NodoPrimario {
	
	private Token identificador;
	private NodoExpresion expresion;
	
	public NodoExpParentizada (Token id, NodoExpresion expr, NodoEncadenado cad) {
		super(cad);
		identificador = id;
		expresion = expr;
	}

	public NodoExpresion getExpresion() {
		return expresion;
	}

	public void setExpresion(NodoExpresion expresion) {
		this.expresion = expresion;
	}

	@Override
	public TipoMetodo chequear() throws ExcepcionSemantica {
		TipoMetodo tipo = expresion.chequear();
		if (this.getCadena()!=null) {
			if (tipo.esTipoPrimitivo())
				throw new ExcepcionExpParentizadaPrimitiva(identificador.getLinea());
			else {
				this.getCadena().setEsLadoIzq(this.getEsLadoIzq());
				return this.getCadena().chequear(tipo);				
			}
		} else return tipo;
	}

	@Override
	public boolean terminaEnVar() {
		if (this.getCadena()!=null)
			return this.getCadena().terminaEnVar();
		else return false;
	}

	@Override
	public boolean terminaEnLlamada() {
		if (this.getCadena()!=null)
			return this.getCadena().terminaEnLlamada();
		else return false;
	}

}
