package com.jwebmp.plugins.jqlayout.options;

import org.junit.jupiter.api.Test;

class JQLayoutDefaultOptionsTest
{

	@Test
	public void testDefault()
	{
		JQLayoutDefaultOptions options = new JQLayoutDefaultOptions();
		options.getResponsive();
		System.out.println(options.toString());
	}
}
