package com.jwebmp.plugins.jquerylayout.layout.options;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JQLayoutDefaultOptionsTest {

	@Test
	public void testDefault()
	{
		JQLayoutDefaultOptions options = new JQLayoutDefaultOptions();
		options.getResponsive();
		System.out.println(options.toString());
	}
}