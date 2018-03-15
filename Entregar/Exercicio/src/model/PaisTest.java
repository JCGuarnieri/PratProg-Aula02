package model;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import model.Pais;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PaisTest {
	Pais pais, copia;
	static int id = 0;

	@Before
	public void setUp() throws Exception {
		pais = 	new Pais(id, "Pais1", 205002000, 8512000 );
		copia = new Pais(id, "Pais1", 205002000, 8512000 );
		System.out.println(pais);
		System.out.println(copia);
		System.out.println(id);
		if (pais.toString() == copia.toString()) System.out.println("NICE");
		
	}
	
	
	@Test
	public void test00Load() {
		Pais fixture = new Pais(1, "Brasil", 205002000, 8512000 );
		Pais novo = new Pais(1, null, 0, 0);
		novo.carregarPais();
		assertEquals("teste load", novo, fixture);
	}
	
	@Test
	public void test01Create() {
		System.out.println("-- create");
		pais.criarPais();
		id = pais.getId();
		System.out.println(id);
		copia.setId(id);
		assertEquals("teste create", pais, copia);
	}
	

	@Test
	public void test02Update() {
		System.out.println("-- update");
		pais.setPopulacao(999999);
		copia.setPopulacao(999999);		
		pais.atualizaPais();
		pais.carregarPais();
		assertEquals("teste update", pais, copia);
	}
	@Test
	public void test03Exclude() {
		System.out.println("-- delete");
		copia.setId(-1);
		copia.setNome(null);
		copia.setPopulacao(0);
		copia.setArea(0);
		pais.apagaPais();
		pais.carregarPais();
		assertEquals("teste delete", pais, copia);
	}
	
	@Test
	public void test04MaiorPop(){
		System.out.println("-- maior pupulacao");
		String maiorPop = pais.maiorPopulacao();
		assertEquals("teste maiorpop", "China", maiorPop);
		
	}
	
	@Test
	public void test05MenorArea(){
		System.out.println("-- menor area");
		String menorArea = pais.menorArea();
		assertEquals("teste menorarea", "India", menorArea);
		
	}
	
	@Test
	public void test06vetTreeCountries(){
		System.out.println("-- vetor paises");
		Pais[] vet = pais.tresPaises();
		vet[0].criarPais();
		vet[1].criarPais();
		vet[2].criarPais();
		
	}
}