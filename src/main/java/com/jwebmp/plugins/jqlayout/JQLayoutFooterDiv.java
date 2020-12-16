package com.jwebmp.plugins.jqlayout;

import com.jwebmp.core.base.html.DivSimple;
import com.jwebmp.core.base.interfaces.IComponentHierarchyBase;
import com.jwebmp.plugins.jqlayout.enumerations.JQLayoutCSSThemeBlockNames;
import com.jwebmp.plugins.jqlayout.interfaces.JQLayoutDivChildren;

public class JQLayoutFooterDiv<J extends JQLayoutFooterDiv<J>>
		extends DivSimple<J>
		implements JQLayoutDivChildren
{
	public JQLayoutFooterDiv()
	{
		addClass(JQLayoutCSSThemeBlockNames.UI_Layout_Footer);
	}

	public JQLayoutFooterDiv(String text)
	{
		super(text);
		addClass(JQLayoutCSSThemeBlockNames.UI_Layout_Footer);
	}
}
