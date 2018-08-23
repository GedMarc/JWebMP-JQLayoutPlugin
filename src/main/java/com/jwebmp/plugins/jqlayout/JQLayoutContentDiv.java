package com.jwebmp.plugins.jqlayout;

import com.jwebmp.core.base.html.DivSimple;
import com.jwebmp.core.base.interfaces.IComponentHierarchyBase;
import com.jwebmp.plugins.jqlayout.enumerations.JQLayoutCSSThemeBlockNames;
import com.jwebmp.plugins.jqlayout.interfaces.JQLayoutDivChildren;

public class JQLayoutContentDiv<J extends JQLayoutContentDiv<J>>
		extends DivSimple<J>
		implements JQLayoutDivChildren<IComponentHierarchyBase, J>
{
	public JQLayoutContentDiv()
	{
		this(null);
	}

	public JQLayoutContentDiv(String text)
	{
		super(text);
		addClass(JQLayoutCSSThemeBlockNames.UI_Layout_Content);
	}
}
