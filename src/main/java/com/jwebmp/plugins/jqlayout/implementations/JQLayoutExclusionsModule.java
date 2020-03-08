package com.jwebmp.plugins.jqlayout.implementations;

import com.guicedee.guicedinjection.interfaces.IGuiceScanModuleExclusions;

import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

public class JQLayoutExclusionsModule
		implements IGuiceScanModuleExclusions<JQLayoutExclusionsModule>
{
	@Override
	public @NotNull Set<String> excludeModules()
	{
		Set<String> strings = new HashSet<>();
		strings.add("com.jwebmp.plugins.jqlayout");
		return strings;
	}
}
