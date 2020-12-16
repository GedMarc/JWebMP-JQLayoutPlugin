package com.jwebmp.plugins.jqlayout;

import com.jwebmp.core.base.html.DivSimple;
import com.jwebmp.core.base.interfaces.IComponentHierarchyBase;
import com.jwebmp.plugins.jqlayout.enumerations.JQLayoutCSSThemeBlockNames;
import com.jwebmp.plugins.jqlayout.interfaces.JQLayoutDivChildren;

public class JQLayoutHeaderDiv<J extends JQLayoutHeaderDiv<J>>
		extends DivSimple<J>
		implements JQLayoutDivChildren
{
	public JQLayoutHeaderDiv()
	{
		addClass(JQLayoutCSSThemeBlockNames.UI_Layout_Header);
	}

	public JQLayoutHeaderDiv(String text)
	{
		super(text);
		addClass(JQLayoutCSSThemeBlockNames.UI_Layout_Header);
	}
}
