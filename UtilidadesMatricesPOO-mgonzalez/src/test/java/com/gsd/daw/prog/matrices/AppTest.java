
package com.gsd.daw.prog.matrices;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
 
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
 
@TestMethodOrder(MethodOrderer.DisplayName.class)
public class AppTest {
	@Test
    public void testSumarMatricesConMismasDimensiones() {
        int[][] a = {
            {1, 2, 3},
            {4, 5, 6}
        };
        int[][] b = {
            {7, 8, 9},
            {10, 11, 12}
        };
        int[][] expected = {
            {8, 10, 12},
            {14, 16, 18}
        };
 
        Matriz.sumar(a, b);
 
        assertArrayEquals(expected, a);
    }
 
    @Test
    public void testSumarMatricesConDimensionesDiferentes() {
        int[][] a = {
            {1, 2},
            {3, 4}
        };
        int[][] b = {
            {5, 6, 7},
            {8, 9, 10}
        };
 
        Matriz.sumar(a, b);
 
        // La matriz a no debe cambiar
        int[][] expected = {
            {1, 2},
            {3, 4}
        };
        assertArrayEquals(expected, a);
    }
 
    @Test
    public void testSumarMatricesConUnaMatrizNula() {
        int[][] a = {
            {1, 2},
            {3, 4}
        };
        int[][] b = null;
 
        Matriz.sumar(a, b);
 
        // La matriz a no debe cambiar
        int[][] expected = {
            {1, 2},
            {3, 4}
        };
        assertArrayEquals(expected, a);
    }
 
    @Test
    public void testSumarMatricesConAmbasMatricesNulas() {
        int[][] a = null;
        int[][] b = null;
 
        Matriz.sumar(a, b);
 
        // No hay nada que cambiar, así que no hay matriz a que verificar
        // Esta prueba solo asegura que no se lance una excepción
    }
 
    @Test
    public void testSumarMatricesConUnaMatrizVacia() {
        int[][] a = {
            {},
            {}
        };
        int[][] b = {
            {},
            {}
        };
 
        Matriz.sumar(a, b);
 
        // Ambas matrices son vacías, así que a debe permanecer vacío
        int[][] expected = {
            {},
            {}
        };
        assertArrayEquals(expected, a);
    }
	// Test para crearSuma
	@Test
	public void testCrearSuma_Valida11() {
		int[][] a = { { 1, 2 }, { 3, 4 } };
		int[][] b = { { 5, 6 }, { 7, 8 } };
		int[][] resultadoEsperado = { { 6, 8 }, { 10, 12 } };
		assertArrayEquals(resultadoEsperado, Matriz.crearSuma(a, b));
	}
 
	@Test
	public void testCrearSuma_MatrizInvalida_Nula() {
		assertNull(Matriz.crearSuma(null, new int[][] { { 1, 2 }, { 3, 4 } })); // Matriz nula
	}
 
	@Test
	public void testCrearSuma_DimensionesDistintas() {
		int[][] a = { { 1, 2 } };
		int[][] b = { { 1, 2 }, { 3, 4 } };
		assertNull(Matriz.crearSuma(a, b)); // Dimensiones diferentes
	}
 
	// Test para sumar (modifica la primera matriz)
	@Test
	public void testSumar_Vali1da() {
		int[][] a = { { 1, 2 }, { 3, 4 } };
		int[][] b = { { 5, 6 }, { 7, 8 } };
		Matriz.sumar(a, b);
		int[][] resultadoEsperado = { { 6, 8 }, { 10, 12 } };
		assertArrayEquals(resultadoEsperado, a); // La matriz a debería ser modificada
	}
 
	@Test
	public void testSumar_MatrizInvalida_Nula() {
		int[][] a = { { 1, 2 }, { 3, 4 } };
		Matriz.sumar(null, a); // No debería hacer nada si la matriz a es nula
		assertArrayEquals(new int[][] { { 1, 2 }, { 3, 4 } }, a);
	}
 
	@Test
	public void testSumar_DimensionesDistintas() {
		int[][] a = { { 1, 2 } };
		int[][] b = { { 1, 2 }, { 3, 4 } };
		Matriz.sumar(a, b); // No debería hacer nada por dimensiones distintas
		assertArrayEquals(new int[][] { { 1, 2 } }, a);
	}
 
	// Test para toString
	@Test
	public void testToString_Valida() {
		int[][] a = { { 1, 2 }, { 3, 4 } };
		assertEquals("1 2\n3 4\n", Matriz.toString(a));
	}
 
	@Test
	public void testToString_MatrizInvalida_Nula() {
		assertNull(Matriz.toString(null)); // Matriz nula
	}
 
	@Test
	public void testToString_MatrizInvalida_FilaNula() {
		int[][] a = { { 1, 2 }, null };
		assertNull(Matriz.toString(a)); // Fila nula
	}
 
	// Test para crearTraspuesta
	@Test
	public void testCrearTraspuesta_Valida() {
		int[][] a = { { 1, 2, 3 }, { 4, 5, 6 } };
		int[][] resultadoEsperado = { { 1, 4 }, { 2, 5 }, { 3, 6 } };
		assertArrayEquals(resultadoEsperado, Matriz.crearTraspuesta(a));
	}
 
	@Test
	public void testCrearTraspuesta_MatrizInvalida_FilaNula() {
		int[][] a = { { 1, 2 }, null };
		assertNull(Matriz.crearTraspuesta(a)); // Fila nula
	}
 
	// Test para incrementar
	@Test
	public void testIncrementar_Valida() {
		int[][] a = { { 1, 2 }, { 3, 4 } };
		Matriz.incrementar(a, 2);
		int[][] resultadoEsperado = { { 3, 4 }, { 5, 6 } };
		assertArrayEquals(resultadoEsperado, a);
	}
 
	@Test
	public void testIncrementar_MatrizInvalida_Nula() {
		int[][] a = null;
		Matriz.incrementar(a, 2); // No debería alterar nada
		assertNull(a);
	}
 
	// Test para crearIncrementada
	@Test
	public void testCrearIncrementada_Valida() {
		int[][] a = { { 1, 2 }, { 3, 4 } };
		int[][] resultadoEsperado = { { 3, 4 }, { 5, 6 } };
		assertArrayEquals(resultadoEsperado, Matriz.crearIncrementada(a, 2));
	}
 
	@Test
	public void testCrearIncrementada_MatrizInvalida_FilaNula() {
		int[][] a = { { 1, 2 }, null };
		assertNull(Matriz.crearIncrementada(a, 2)); // Fila nula
	}
 
	// Test para getMaximoElemento
	@Test
	public void testGetMaximoElemento_Valida() {
		int[][] a = { { 1, 2 }, { 3, 4 } };
		assertEquals(4, Matriz.getMaximoElemento(a));
	}
 
	@Test
	public void testGetMaximoElemento_MatrizInvalida_FilaNula() {
		int[][] a = { { 1, 2 }, null };
		assertEquals(Integer.MIN_VALUE, Matriz.getMaximoElemento(a)); // Fila nula
	}
 
	 //Test para getPosicionMaximoElemento
	@Test
	public void testGetPosicionMaximoElemento_Valida() {
		int[][] a = { { 1, 2 }, { 3, 4 } };
		int[] resultadoEsperado = { 1, 1 };
		assertArrayEquals(resultadoEsperado, Matriz.getPosicionMaximoElemento(a));
	}
 
	@Test
	public void testGetPosicionMaximoElemento_MatrizInvalida_FilaNula() {
		int[][] a = { { 1, 2 }, null };
		assertNull(Matriz.getPosicionMaximoElemento(a)); // Fila nula
	}
 
	 //Test para isMatrizValida
	@Test
	public void testIsMatrizValida_Valida() {
		int[][] a = { { 1, 2 }, { 3, 4 } };
		assertTrue(Matriz.isMatrizValida(a));
	}
 
	@Test
	public void testIsMatrizValida_MatrizInvalida_FilaNula() {
		int[][] a = { { 1, 2 }, null };
		assertFalse(Matriz.isMatrizValida(a)); // Fila nula
	}
 
	@Test
	public void testIsMatrizValida_MatrizNula() {
		assertFalse(Matriz.isMatrizValida(null)); // Matriz nula
	}
 

 

 
    @Test
    public void testCrearSuma() {
        // Caso normal: matrices válidas y del mismo tamaño
        int[][] a = {
            {1, 2},
            {3, 4}
        };
        int[][] b = {
            {5, 6},
            {7, 8}
        };
        int[][] resultadoEsperado = {
            {6, 8},
            {10, 12}
        };
        assertArrayEquals(resultadoEsperado, Matriz.crearSuma(a, b));
 
        // Caso: dimensiones diferentes (debe devolver null)
        int[][] c = {
            {1, 2, 3},
            {4, 5, 6}
        };
        assertNull(Matriz.crearSuma(a, c));
 
        // Caso: matrices nulas
        assertNull(Matriz.crearSuma(null, b));
        assertNull(Matriz.crearSuma(a, null));
        assertNull(Matriz.crearSuma(null, null));
    }
 
    @Test
    public void testSumar() {
        // Caso normal: matrices válidas y del mismo tamaño
        int[][] a = {
            {1, 2},
            {3, 4}
        };
        int[][] b = {
            {5, 6},
            {7, 8}
        };
        int[][] resultadoEsperado = {
            {6, 8},
            {10, 12}
        };
        Matriz.sumar(a, b);
        assertArrayEquals(resultadoEsperado, a);
 
        // Caso: dimensiones diferentes (no debe alterar 'a')
        int[][] c = {
            {1, 2, 3},
            {4, 5, 6}
        };
        int[][] copiaOriginal = {
            {6, 8},
            {10, 12}
        };
        Matriz.sumar(a, c);
        assertArrayEquals(copiaOriginal, a);
 
        // Caso: matrices nulas
        int[][] matrizNull = null;
        Matriz.sumar(matrizNull, b);
        assertNull(matrizNull);
    }
    @Test
    public void testSumarMatricesValidas() {
        int[][] a = {
            {1, 2, 3},
            {4, 5, 6}
        };
        int[][] b = {
            {7, 8, 9},
            {10, 11, 12}
        };
        Matriz.sumar(a, b);
        int[][] expected = {
            {8, 10, 12},
            {14, 16, 18}
        };
        assertArrayEquals(expected, a);
    }
 
    @Test
    public void testSumarMatricesNulas() {
        int[][] a = null;
        int[][] b = {
            {1, 2, 3},
            {4, 5, 6}
        };
        Matriz.sumar(a, b);
        assertNull(a); // a sigue siendo nulo
 
        a = new int[2][3];
        b = null;
        Matriz.sumar(a, b);
        assertNotNull(a); // a no es nulo
    }
 
    @Test
    public void testSumarMatricesDiferentesDimensiones() {
        int[][] a = {
            {1, 2},
            {3, 4}
        };
        int[][] b = {
            {1, 2, 3},
            {4, 5, 6}
        };
        Matriz.sumar(a, b);
        int[][] expected = {
            {1, 2},
            {3, 4}
        };
        assertArrayEquals(expected, a); // a no debe cambiar
    }
 
    @Test
    public void testSumarMatrizVacia() {
        int[][] a = {
            {},
            {}
        };
        int[][] b = {
            {},
            {}
        };
        Matriz.sumar(a, b);
        assertArrayEquals(a, new int[][]{{}, {}}); // a debe seguir siendo vacío
    }
 
    @Test
    public void testSumarMatricesConElementosNegativos() {
        int[][] a = {
            {-1, -2, -3},
            {-4, -5, -6}
        };
        int[][] b = {
            {7, 8, 9},
            {10, 11, 12}
        };
        Matriz.sumar(a, b);
        int[][] expected = {
            {6, 6, 6},
            {6, 6, 6}
        };
        assertArrayEquals(expected, a);
    }
 
    @Test
    public void testSumarMatricesConElementosCero() {
        int[][] a = {
            {0, 0, 0},
            {0, 0, 0}
        };
        int[][] b = {
            {0, 0, 0},
            {0, 0, 0}
        };
        Matriz.sumar(a, b);
        int[][] expected = {
            {0, 0, 0},
            {0, 0, 0}
        };
        assertArrayEquals(expected, a);
    }
    @Test
    public void testToString() {
        // Caso normal: matriz válida
        int[][] a = {
            {1, 2},
            {3, 4}
        };
        String resultadoEsperado = "1 2\n3 4\n";
        assertEquals(resultadoEsperado, Matriz.toString(a));
 
        // Caso: matriz nula
        assertNull(Matriz.toString(null));
 
        // Caso: matriz con una fila nula
        int[][] matrizConFilaNula = {
            {1, 2},
            null
        };
        assertNull(Matriz.toString(matrizConFilaNula));
    }
 
    @Test
    public void testCrearTraspuesta() {
        // Caso normal: matriz rectangular
        int[][] a = {
            {1, 2, 3},
            {4, 5, 6}
        };
        int[][] resultadoEsperado = {
            {1, 4},
            {2, 5},
            {3, 6}
        };
        assertArrayEquals(resultadoEsperado, Matriz.crearTraspuesta(a));
 
        // Caso: matriz cuadrada
        int[][] b = {
            {1, 2},
            {3, 4}
        };
        int[][] resultadoEsperadoB = {
            {1, 3},
            {2, 4}
        };
        assertArrayEquals(resultadoEsperadoB, Matriz.crearTraspuesta(b));
 
        // Caso: matriz nula
        assertNull(Matriz.crearTraspuesta(null));
    }
 
    @Test
    public void testIncrementar() {
        // Caso normal: incremento positivo
        int[][] a = {
            {1, 2},
            {3, 4}
        };
        int[][] resultadoEsperado = {
            {2, 3},
            {4, 5}
        };
        Matriz.incrementar(a, 1);
        assertArrayEquals(resultadoEsperado, a);
 
        // Caso: decremento negativo
        int[][] b = {
            {1, 2},
            {3, 4}
        };
        int[][] resultadoEsperadoDecremento = {
            {0, 1},
            {2, 3}
        };
        Matriz.incrementar(b, -1);
        assertArrayEquals(resultadoEsperadoDecremento, b);
 
        // Caso: matriz nula
        Matriz.incrementar(null, 1); // no debe lanzar error
    }
 
    @Test
    public void testCrearIncrementada() {
        // Caso normal: incremento positivo
        int[][] a = {
            {1, 2},
            {3, 4}
        };
        int[][] resultadoEsperado = {
            {2, 3},
            {4, 5}
        };
        assertArrayEquals(resultadoEsperado, Matriz.crearIncrementada(a, 1));
 
        // Caso: decremento negativo
        int[][] resultadoEsperadoDecremento = {
            {0, 1},
            {2, 3}
        };
        assertArrayEquals(resultadoEsperadoDecremento, Matriz.crearIncrementada(a, -1));
 
        // Caso: matriz nula
        assertNull(Matriz.crearIncrementada(null, 1));
    }
 
    @Test
    public void testGetMaximoElemento() {
        // Caso normal: encontrar el mayor valor
        int[][] a = {
            {1, 9},
            {3, 4}
        };
        assertEquals(9, Matriz.getMaximoElemento(a));
 
        // Caso: matriz con números negativos
        int[][] b = {
            {-1, -5},
            {-3, -2}
        };
        assertEquals(-1, Matriz.getMaximoElemento(b));
 
        // Caso: matriz nula
        assertEquals(Integer.MIN_VALUE, Matriz.getMaximoElemento(null));
    }
 
    @Test
    public void testGetPosicionMaximoElemento() {
        // Caso normal: encontrar la posición del mayor valor
        int[][] a = {
            {1, 9},
            {3, 4}
        };
        int[] resultadoEsperado = {0, 1};
        assertArrayEquals(resultadoEsperado, Matriz.getPosicionMaximoElemento(a));
 
        // Caso: matriz con números negativos
        int[][] b = {
            {-1, -5},
            {-3, -2}
        };
        int[] resultadoEsperadoNegativo = {0, 0};
        assertArrayEquals(resultadoEsperadoNegativo, Matriz.getPosicionMaximoElemento(b));
 
        // Caso: matriz nula
        assertNull(Matriz.getPosicionMaximoElemento(null));
    }
 
    @Test
    public void testIsMatrizValida() {
        // Caso normal: matriz válida
        int[][] a = {
            {1, 2},
            {3, 4}
        };
        assertTrue(Matriz.isMatrizValida(a));
 
        // Caso: matriz nula
        assertFalse(Matriz.isMatrizValida(null));
 
        // Caso: matriz con filas nulas
        int[][] b = {
            {1, 2},
            null
        };
        assertFalse(Matriz.isMatrizValida(b));
 
        // Caso: matriz con columnas inconsistentes
        int[][] c = {
            {1, 2},
            {3}
        };
        assertFalse(Matriz.isMatrizValida(c));
 
        // Caso: matriz vacía
        int[][] d = new int[0][0];
        assertFalse(Matriz.isMatrizValida(d));
    }
    @Test
	public void testSumar1_Valida() {
		int[][] a = { { 1, 2 }, { 3, 4 } };
		int[][] b = { { 5, 6 }, { 7, 8 } };
		Matriz.sumar(a, b);
		int[][] resultadoEsperado = { { 6, 8 }, { 10, 12 } };
		assertArrayEquals(resultadoEsperado, a); // La matriz a debería ser modificada
	}
 
	@Test
	public void testSumar1_MatrizInvalida_Nula() {
		int[][] a = { { 1, 2 }, { 3, 4 } };
		Matriz.sumar(null, a); // No debería hacer nada si la matriz a es nula
		assertArrayEquals(new int[][] { { 1, 2 }, { 3, 4 } }, a);
	}
 
	  public void testSumar1() {
	        // Caso normal: matrices válidas y del mismo tamaño
	        int[][] a = {
	            {1, 2},
	            {3, 4}
	        };
	        int[][] b = {
	            {5, 6},
	            {7, 8}
	        };
	        int[][] resultadoEsperado = {
	            {6, 8},
	            {10, 12}
	        };
	        Matriz.sumar(a, b);
	        assertArrayEquals(resultadoEsperado, a);
	 
	        // Caso: dimensiones diferentes (no debe alterar 'a')
	        int[][] c = {
	            {1, 2, 3},
	            {4, 5, 6}
	        };
	        int[][] copiaOriginal = {
	            {6, 8},
	            {10, 12}
	        };
	        Matriz.sumar(a, c);
	        assertArrayEquals(copiaOriginal, a);
	 
	        // Caso: matrices nulas
	        int[][] matrizNull = null;
	        Matriz.sumar(matrizNull, b);
	        assertNull(matrizNull);
	    }
	 
	    @Test
	    public void testToString1() {
	        // Caso normal: matriz válida
	        int[][] a = {
	            {1, 2},
	            {3, 4}
	        };
	        String resultadoEsperado = "1 2\n3 4\n";
	        assertEquals(resultadoEsperado, Matriz.toString(a));
	 
	        // Caso: matriz nula
	        assertNull(Matriz.toString(null));
	 
	        // Caso: matriz con una fila nula
	        int[][] matrizConFilaNula = {
	            {1, 2},
	            null
	        };
	        assertNull(Matriz.toString(matrizConFilaNula));
	    }
	 
	    @Test
	    public void testCrearTraspuesta1() {
	        // Caso normal: matriz rectangular
	        int[][] a = {
	            {1, 2, 3},
	            {4, 5, 6}
	        };
	        int[][] resultadoEsperado = {
	            {1, 4},
	            {2, 5},
	            {3, 6}
	        };
	        assertArrayEquals(resultadoEsperado, Matriz.crearTraspuesta(a));
	 
	        // Caso: matriz cuadrada
	        int[][] b = {
	            {1, 2},
	            {3, 4}
	        };
	        int[][] resultadoEsperadoB = {
	            {1, 3},
	            {2, 4}
	        };
	        assertArrayEquals(resultadoEsperadoB, Matriz.crearTraspuesta(b));
	 
	        // Caso: matriz nula
	        assertNull(Matriz.crearTraspuesta(null));
	    }
	@Test
	public void testSumar1_DimensionesDistintas() {
		int[][] a = { { 1, 2 } };
		int[][] b = { { 1, 2 }, { 3, 4 } };
		Matriz.sumar(a, b); // No debería hacer nada por dimensiones distintas
		assertArrayEquals(new int[][] { { 1, 2 } }, a);
	}@Test
	public void testSumar2_DimensionesDistintas() {
		int[][] a = { { 1, 2,4 }, { 3, 4 ,8} };
		int[][] b = { { 1, 2 }, { 3, 4 } };
		Matriz.sumar(a, b); // No debería hacer nada por dimensiones distintas
		assertArrayEquals(new int[][] { { 1, 2,4 } ,{3,4,8}}, a);
	}
	// Test para crearSuma
		@Test
		public void testCrearSuma_Valida() {
			int[][] a = { { 1, 2 }, { 3, 4 } };
			int[][] b = { { 5, 6 }, { 7, 8 } };
			int[][] resultadoEsperado = { { 6, 8 }, { 10, 12 } };
			assertArrayEquals(resultadoEsperado, Matriz.crearSuma(a, b));
		}

		@Test
		public void testCrearSuma_Valida1() {
			int[][] a = { { 1, 2, 4 }, { 5, 6, 7 } };
			int[][] b = { { 8, 9, 10 }, { 11, 12, 13 } };
			int[][] resultadoEsperado = { { 9, 11, 14 }, { 16, 18, 20 } };
			assertArrayEquals(resultadoEsperado, Matriz.crearSuma(a, b));
		}

		@Test
		public void testCrearSuma_Valida2() {
			int[][] a = { { 1, -2, 4 }, { 5, 6, 7 } };
			int[][] b = { { 8, 9, 10 }, { 11, -12, 13 } };
			int[][] resultadoEsperado = { { 9, 7, 14 }, { 16, -6, 20 } };
			assertArrayEquals(resultadoEsperado, Matriz.crearSuma(a, b));
		}

		@Test
		public void testCrearSuma_MatrizInvalida_Nula11() {
			assertNull(Matriz.crearSuma(null, new int[][] { { 1, 2 }, { 3, 4 } })); // Matriz nula
		}

		@Test
		public void testCrearSuma_DimensionesDistintas11() {
			int[][] a = { { 1, 2 } };
			int[][] b = { { 1, 2 }, { 3, 4 } };
			assertNull(Matriz.crearSuma(a, b)); // Dimensiones diferentes
		}

		@Test
		public void testCrearSuma_DimensionesDistintas1() {
			int[][] a = { { 1, 2 }, { 3, 4 }, { 5, 6 } };
			int[][] b = { { 1, 2 }, { 3, 4 } };
			assertNull(Matriz.crearSuma(a, b)); // Dimensiones diferentes
		}

		@Test
		public void testCrearSuma_DimensionesDistintas2() {
			int[][] a = { { 1, 2, 3 }, { 4, 5, 6 } };
			int[][] b = { { 1, 2 }, { 3, 4 } };
			assertNull(Matriz.crearSuma(a, b)); // Dimensiones diferentes
		}

		// Test para sumar (modifica la primera matriz)
		@Test
		public void testSumar_Valida() {
			int[][] a = { { 1, 2 }, { 3, 4 } };
			int[][] b = { { 5, 6 }, { 7, 8 } };
			Matriz.sumar(a, b);
			int[][] resultadoEsperado = { { 6, 8 }, { 10, 12 } };
			assertArrayEquals(resultadoEsperado, a); // La matriz a debería ser modificada
		}

		@Test
		public void testSumar_Valida1() {
			int[][] a = { { 1, -2 }, { 3, 4 } };
			int[][] b = { { 5, 6 }, { 7, -8 } };
			Matriz.sumar(a, b);
			int[][] resultadoEsperado = { { 6, 4 }, { 10, -4 } };
			assertArrayEquals(resultadoEsperado, a); // La matriz a debería ser modificada
		}

		@Test
		public void testSumar_Valida2() {
			int[][] a = { { 1, -2 }, { 3, 4 }, { -12345, 1 } };
			int[][] b = { { 5, 6 }, { 7, -8 }, { 0, 0 } };
			Matriz.sumar(a, b);
			int[][] resultadoEsperado = { { 6, 4 }, { 10, -4 }, { -12345, 1 } };
			assertArrayEquals(resultadoEsperado, a); // La matriz a debería ser modificada
		}

		@Test
		public void testSumar_Valida3() {
			int[][] a = { { 0, 0 }, { 0, 0 } };
			int[][] b = { { 0, 0 }, { 0, 0 } };
			Matriz.sumar(a, b);
			int[][] resultadoEsperado = { { 0, 0 }, { 0, 0 } };
			assertArrayEquals(resultadoEsperado, a); // La matriz a debería ser modificada
		}

		@Test
		public void testSumar_MatrizInvalida_Nula11() {
			int[][] a = { { 1, 2 }, { 3, 4 } };
			Matriz.sumar(null, a); // No debería hacer nada si la matriz a es nula
			assertArrayEquals(new int[][] { { 1, 2 }, { 3, 4 } }, a);
		}

		@Test
		public void testSumar_DimensionesDistintas11() {
			int[][] a = { { 1, 2 } };
			int[][] b = { { 1, 2 }, { 3, 4 } };
			Matriz.sumar(a, b); // No debería hacer nada por dimensiones distintas
			assertArrayEquals(new int[][] { { 1, 2 } }, a);
		}

		@Test
		public void testSumar_DimensionesDistintas1() {
			int[][] a = { { 1, 2 }, { 3, 4 }, { 5, 6 } };
			int[][] b = { { 1, 2 }, { 3, 4 } };
			Matriz.sumar(a, b); // No debería hacer nada por dimensiones distintas
			assertArrayEquals(new int[][] { { 1, 2 }, { 3, 4 }, { 5, 6 } }, a);
		}

		@Test
		public void testSumar_DimensionesDistintas2() {
			int[][] a = { { 1, 2, 3 }, { 4, 5, 6 } };
			int[][] b = { { 1, 2 }, { 3, 4 } };
			Matriz.sumar(a, b); // No debería hacer nada por dimensiones distintas
			assertArrayEquals(new int[][] { { 1, 2, 3 }, { 4, 5, 6 } }, a);
		}

		// Test para toString
		@Test
		public void testToString_Valida11() {
			int[][] a = { { 1, 2 }, { 3, 4 } };
			assertEquals("1 2\n3 4\n", Matriz.toString(a));
		}

		@Test
		public void testToString_Valida1() {
			int[][] a = { { 1, 2 }, { 3, 4 }, { 5, 6 } };
			assertEquals("1 2\n3 4\n5 6\n", Matriz.toString(a));
		}
		@Test
		public void testToString_Valida2() {
			int[][] a = { { 1, 2 }, { 3, -4 }, { 5, 6 } };
			assertEquals("1 2\n3 -4\n5 6\n", Matriz.toString(a));
		}

		@Test
		public void testToString_MatrizInvalida_Nul1a() {
			assertNull(Matriz.toString(null)); // Matriz nula
		}

		@Test
		public void testToString_MatrizInvalida_FilaNula11() {
			int[][] a = { { 1, 2 }, null };
			assertNull(Matriz.toString(a)); // Fila nula
		}

		// Test para crearTraspuesta
		@Test
		public void testCrearTraspuesta_Va1lida() {
			int[][] a = { { 1, 2, 3 }, { 4, 5, 6 } };
			int[][] resultadoEsperado = { { 1, 4 }, { 2, 5 }, { 3, 6 } };
			assertArrayEquals(resultadoEsperado, Matriz.crearTraspuesta(a));
		}

		@Test
		public void testCrearTraspuesta_MatrizInvalida_Fi1laNula() {
			int[][] a = { { 1, 2 }, null };
			assertNull(Matriz.crearTraspuesta(a)); // Fila nula
		}

		// Test para incrementar
		@Test
		public void testIncrementar_Val1ida() {
			int[][] a = { { 1, 2 }, { 3, 4 } };
			Matriz.incrementar(a, 2);
			int[][] resultadoEsperado = { { 3, 4 }, { 5, 6 } };
			assertArrayEquals(resultadoEsperado, a);
		}

		@Test
		public void testIncrementar_Valida1() {
			int[][] a = { { 1, 2, 3 }, { 3, 4, 5 }, { 6, 7, 8 } };
			Matriz.incrementar(a, 2);
			int[][] resultadoEsperado = { { 3, 4, 5 }, { 5, 6, 7 }, { 8, 9, 10 } };
			assertArrayEquals(resultadoEsperado, a);
		}

		@Test
		public void testIncrementar_MatrizInvalida_1Nula() {
			int[][] a = null;
			Matriz.incrementar(a, 2); // No debería alterar nada
			assertNull(a);
		}

		// Test para crearIncrementada
		@Test
		public void testCrearIncrementa1da_Valida() {
			int[][] a = { { 1, 2 }, { 3, 4 } };
			int[][] resultadoEsperado = { { 3, 4 }, { 5, 6 } };
			assertArrayEquals(resultadoEsperado, Matriz.crearIncrementada(a, 2));
		}

		@Test
		public void testCrearIncrementada_Valida1() {
			int[][] a = { { 1, 2, 3 }, { 4, 5, 6 } };
			int[][] resultadoEsperado = { { 3, 4, 5 }, { 6, 7, 8 } };
			assertArrayEquals(resultadoEsperado, Matriz.crearIncrementada(a, 2));
		}

		@Test
		public void testCrearIncrementada_Valida2() {
			int[][] a = { { 1, 2, 3 }, { 4, 5, 6 } };
			int[][] resultadoEsperado = { { 4, 5, 6 }, { 7, 8, 9 } };
			assertArrayEquals(resultadoEsperado, Matriz.crearIncrementada(a, 3));
		}

		@Test
		public void testCrearIncrementada_Ma1trizInvalida_FilaNula() {
			int[][] a = { { 1, 2 }, null };
			assertNull(Matriz.crearIncrementada(a, 2)); // Fila nula
		}

		// Test para getMaximoElemento
		@Test
		public void testGetMaximoElemento_V1alida() {
			int[][] a = { { 1, 2 }, { 3, 4 } };
			assertEquals(4, Matriz.getMaximoElemento(a));
		}

		@Test
		public void testGetMaximoElemento_Valida1() {
			int[][] a = { { 1, 2 }, { 3, 4 }, { 5, 6 } };
			assertEquals(6, Matriz.getMaximoElemento(a));
		}

		@Test
		public void testGetMaximoElemento_Valida2() {
			int[][] a = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 } };
			assertEquals(15, Matriz.getMaximoElemento(a));
		}

		@Test
		public void testGetMaximoElemento_Valida3() {
			int[][] a = { { 1, 2, 3, 4, 5 }, { 6, 7, 800, 9, 10 }, { 11, 12, 13, 14, 15 } };
			assertEquals(800, Matriz.getMaximoElemento(a));
		}

		@Test
		public void testGetMaximoElemento_MatrizInval1ida_FilaNula() {
			int[][] a = { { 1, 2 }, null };
			assertEquals(Integer.MIN_VALUE, Matriz.getMaximoElemento(a)); // Fila nula
		}

		// Test para getPosicionMaximoElemento
		@Test
		public void testGetPosicion1MaximoElemento_Valida() {
			int[][] a = { { 5, 2 }, { 3, 4 } };
			int[] resultadoEsperado = { 0, 0 };
			assertArrayEquals(resultadoEsperado, Matriz.getPosicionMaximoElemento(a));
		}

		@Test
		public void testGetPosicionMaximoElemento_Valida1() {
			int[][] a = { { 1, 2, 3, 4 }, { 5, 6, 9, 8 } };
			int[] resultadoEsperado = { 1, 2 };
			assertArrayEquals(resultadoEsperado, Matriz.getPosicionMaximoElemento(a));
		}

		@Test
		public void testGetPosicionMaximoElemento_Valida2() {
			int[][] a = { { 1, 2, 3, 4 }, { 5, 6, 9, 8 }, { 9, 10, 150, 12 } };
			int[] resultadoEsperado = { 2, 2 };
			assertArrayEquals(resultadoEsperado, Matriz.getPosicionMaximoElemento(a));
		}

		@Test
		public void testGetPosicionMa1ximoElemento_MatrizInvalida_FilaNula() {
			int[][] a = { { 1, 2 }, null };
			assertNull(Matriz.getPosicionMaximoElemento(a)); // Fila nula
		}

		@Test
		public void testGetPosicionMaximoElemento_MatrizInvalida_FilaNula1() {
			int[][] a = { { 1, 2 }, null, { 5, 6 } };
			assertNull(Matriz.getPosicionMaximoElemento(a)); // Fila nula
		}

		@Test
		public void testGetPosicionMaximoElemento_MatrizInvalida_FilaNula2() {
			int[][] a = { { 1, 2, 3, 4, 5 }, null, { 11, 12, 13, 14, 15 } };
			assertNull(Matriz.getPosicionMaximoElemento(a)); // Fila nula
		}

		// Test para isMatrizValida
		@Test
		public void testIsMatriz1Valida_Valida() {
			int[][] a = { { 1, 2 }, { 3, 4 } };
			assertTrue(Matriz.isMatrizValida(a));
		}

		@Test
		public void testIsMatrizValida_Valida1() {
			int[][] a = { { 1, 2, 3 }, { 4, 5, 6 } };
			assertTrue(Matriz.isMatrizValida(a));
		}

		@Test
		public void testIsMatrizValida_Valida2() {
			int[][] a = { { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, { 10, 11, 12, 13, 14, 15, 16, 17, 18 } };
			assertTrue(Matriz.isMatrizValida(a));
		}

		@Test
		public void testIsMatrizValida_Valida3() {
			int[][] a = { { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, { 10, 11, 12, 13, 14, 15, 16, 17, 18 },
					{ 19, 20, 21, 22, 23, 24, 25, 26, 27 } };
			assertTrue(Matriz.isMatrizValida(a));
		}

		@Test
		public void testIsMatrizValida_Valida4() {
			int[][] a = { { 1, -2, 3, 4, -5, 6, 7, 8, 9 }, { 10, 11, 12, 13, 14, -15, 16, 17, -18 },
					{ 19, 20, 21, 22, 23, 24, 25, 26, 27 } };
			assertTrue(Matriz.isMatrizValida(a));
		}

		@Test
		public void testIsMatrizValida_Mat1rizInvalida_FilaNula() {
			int[][] a = { { 1, 2 }, null };
			assertFalse(Matriz.isMatrizValida(a)); // Fila nula
		}

		@Test
		public void testIsMatrizValida_MatrizInvalida_FilaNula1() {
			int[][] a = { { 1, 2 }, null, { 5, 6 } };
			assertFalse(Matriz.isMatrizValida(a)); // Fila nula
		}

		@Test
		public void testIsMatrizValida_MatrizInvalida_FilaNula2() {
			int[][] a = { null, null, null };
			assertFalse(Matriz.isMatrizValida(a)); // Fila nula
		}

		@Test
		public void testIsMatrizValida_MatrizInvalida_FilaNula3() {
			int[][] a = { null };
			assertFalse(Matriz.isMatrizValida(a)); // Fila nula
		}

		@Test
		public void testIsMatrizValida_MatrizInvalida_FilaNula4() {
			int[][] a = { {} };
			assertFalse(Matriz.isMatrizValida(a)); // Fila nula
		}

		@Test
		public void testIsMatrizValida_MatrizInvalida_FilaNula5() {
			int[][] a = { {}, {}, {} };
			assertFalse(Matriz.isMatrizValida(a)); // Fila nula
		}

		@Test
		public void testIsMatrizValida_M1atrizNula() {
			assertFalse(Matriz.isMatrizValida(null)); // Matriz nula
		}

		@Test
		public void testIsMatrizValida_MatrizDiferenteTamano() {
			int[][] a = { { 1, 2 }, { 3 } };
			assertFalse(Matriz.isMatrizValida(null)); // Matriz diferente tamaño
		}

		@Test
		public void testIsMatrizValida_MatrizDiferenteTamano1() {
			int[][] a = { { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, { 10, 12, 13, 14, 15, 16, 17, 18 },
					{ 19, 20, 21, 22, 23, 24, 25, 26, 27 } };
			assertFalse(Matriz.isMatrizValida(null)); // Matriz diferente tamaño
		}

		@Test
		public void testIsMatrizValida_MatrizDiferenteTamano2() {
			int[][] a = { { 1, 2 }, { 3, 4 }, { 5 } };
			assertFalse(Matriz.isMatrizValida(null)); // Matriz diferente tamaño
		}

		@Test
		public void testIsMatrizValida_MatrizDiferenteTamano3() {
			int[][] a = { { 1 }, { 3, 4 }, { 5 } };
			assertFalse(Matriz.isMatrizValida(null)); // Matriz diferente tamaño
		}

		@Test
		public void testIsMatrizValida_MatrizDiferenteTamano4() {
			int[][] a = { { 1, 2 }, { 3, 4 }, {} };
			assertFalse(Matriz.isMatrizValida(null)); // Matriz diferente tamaño
		}

		@Test
		public void testIsMatrizValida_MatrizDiferenteTamano5() {
			int[][] a = { {}, {}, {} };
			assertFalse(Matriz.isMatrizValida(null)); // Matriz diferente tamaño
		}

		// test mixtos crear suma + transpuesta
		@Test
		public void testCrearSumaMasTranspuesta_Valida() {
			int[][] a = { { 1, 2 }, { 3, 4 } };
			int[][] b = { { 5, 6 }, { 7, 8 } };
			int[][] resultadoEsperado = { { 6, 10 }, { 8, 12 } };
			int[][] respuestaOperacion = Matriz.crearTraspuesta(Matriz.crearSuma(a, b));
			assertArrayEquals(resultadoEsperado, respuestaOperacion);
		}

		@Test
		public void testCrearSumaMasTranspuesta_Valida1() {
			int[][] a = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
			int[][] b = { { 13, 14, 15, 16 }, { 17, 18, 19, 20 }, { 21, 22, 23, 24 } };
			int[][] resultadoEsperado = { { 14, 22, 30 }, { 16, 24, 32 }, { 18, 26, 34 }, { 20, 28, 36 } };
			int[][] respuestaOperacion = Matriz.crearTraspuesta(Matriz.crearSuma(a, b));
			assertArrayEquals(resultadoEsperado, respuestaOperacion);
		}
}