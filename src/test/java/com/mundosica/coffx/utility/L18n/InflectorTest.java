package com.mundosica.coffx.utility.L18n;

import static org.junit.Assert.*;
import org.junit.Test;

public class InflectorTest {

	/*
	public void test() {
		plural();
                singular();
		irregularPlural();
	}*/
	
        @Test
	public void plural() {
            assertEquals("amigos", Inflector.toPlural("amigo"));
	}
 
	@Test
	public void singular() {
		assertEquals(Inflector.toSingular("Libros"),"Libro");
	}
 
        @Test
	public void irregularPlural() {
		Inflector.addIrregular("precuario", "precuarites");
		assertEquals(Inflector.toPlural("precuario"),"precuarites");
                //Inflector.addIrregular("user", "users");
                assertEquals(Inflector.toPlural("user"), "users");
                assertEquals(Inflector.toSingular("users"), "user");
	}

}
