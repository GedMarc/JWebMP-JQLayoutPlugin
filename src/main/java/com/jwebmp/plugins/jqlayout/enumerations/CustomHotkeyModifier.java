package com.jwebmp.plugins.jqlayout.enumerations;

import static com.guicedee.guicedinjection.json.StaticStrings.CHAR_PLUS;
import static com.guicedee.guicedinjection.json.StaticStrings.CHAR_UNDERSCORE;
import static com.jwebmp.core.utilities.StaticStrings.*;

/**
 * Specifies HotKey Entries specific to the layout
 */
public enum CustomHotkeyModifier
{

	/**
	 * Control Key
	 */
	CNTRL,
	/**
	 * Shift Key
	 */
	SHIFT,
	/**
	 * Control and Shift Key
	 */
	CNTRL_SHIFT;

	/**
	 * Returns the name of the enumerator replacing all underscores with +
	 *
	 * @return
	 */
	@Override
	public String toString()
	{
		return name().replace(CHAR_UNDERSCORE, CHAR_PLUS);
	}
}
