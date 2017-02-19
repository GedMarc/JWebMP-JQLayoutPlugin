/* 
 * Copyright (C) 2017 Marc Magon
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package za.co.mmagon.jwebswing.plugins.jquerylayout.layout.events;

import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.Feature;
import za.co.mmagon.jwebswing.plugins.jquerylayout.layout.JQLayoutDiv;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

/**
 * Adds a pin button for the layout side to the given component
 *
 * @author MMagon
 * @since 23 Sep 2013
 * @version 1.0
 */
public class AddPinButtonFeature extends Feature<JavaScriptPart, Feature>
{

    private static final long serialVersionUID = 1L;
    /**
     * The layout div to open
     */
    private final JQLayoutDiv divToOpen;
    /**
     * The component to make a pin button
     */
    private final Component pinButton;

    /**
     * Adds a pin button for the layout side to the given component
     *
     * @param layoutDiv
     * @param pinButton
     */
    public AddPinButtonFeature(JQLayoutDiv layoutDiv, Component pinButton)
    {
        super("JWLayoutPinButtonFeature");
        this.pinButton = pinButton;
        divToOpen = layoutDiv;

    }

    @Override
    public void assignFunctionsToComponent()
    {
        String openDivFunction = divToOpen.getLayout().getVariableID() + ".addPinBtn('#" + pinButton.getID() + "',\"" + divToOpen.getArea().toString().toLowerCase() + "\");" + getNewLine();
        addQuery(openDivFunction);
    }
}
