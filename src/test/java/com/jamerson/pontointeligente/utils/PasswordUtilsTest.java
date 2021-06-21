package com.jamerson.pontointeligente.utils;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtilsTest {
	private static final String SENHA = "123456";
	private static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	
	@Test
	public void testSenhaNula() throws Exception {
		assertNull(PasswordUtils.gerarBCrypt(null));
	}
	
	@Test
	public void testGerarHashSenha() {
		String encoded = PasswordUtils.gerarBCrypt(SENHA);
		assertTrue(encoder.matches(SENHA, encoded));
	}
}
