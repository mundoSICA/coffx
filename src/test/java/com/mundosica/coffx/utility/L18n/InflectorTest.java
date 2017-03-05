package com.mundosica.coffx.utility.L18n;

import static org.junit.Assert.*;
import com.mundosica.coffx.utility.L18n.EsLanguage;

import org.junit.Test;

public class InflectorTest {

	@Test
	public void test() {
		singular();
		plural();
		irregularPlural();
		irregularSingular();
	}
	
	public void plural() {
		System.out.println(Inflector.plural("amigo"));
		//assertEquals(Inflector.plural("amigo"),"amigos");
	}
	
	public void singular() {
		assertEquals(Inflector.singular("Libros"),"Libro");
	}
	
	public void irregularPlural() {
		Inflector.addIregularPlural("precuario", "precuarites");
		assertEquals(Inflector.plural("precuario"),"precuarites");
	}
	
	public void irregularSingular() {
		Inflector.addIregularSingular("precuarites","precuario");
		assertEquals(Inflector.singular("precuarites"),"precuario");
		
	}

}
