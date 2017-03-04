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
package za.co.mmagon.jwebswing.plugins.jquerylayout.layout;

/**
 * All the panes of a border layout
 *
 * @author MMagon
 * @since 16 Jul 2013
 * @version 1.0
 */
public enum JQLayoutArea
{
    /**
     * The bottom pane Known issue with IOS 5 and a floating pane. Global issue, blame IOS
     */
    South(JQLayoutCSSThemeBlockNames.UI_Layout_South),
    /**
     * The north pane
     */
    North(JQLayoutCSSThemeBlockNames.UI_Layout_North),
    /**
     * The east pane
     */
    East(JQLayoutCSSThemeBlockNames.UI_Layout_East),
    /**
     * The west pane
     */
    West(JQLayoutCSSThemeBlockNames.UI_Layout_West),
    /**
     * The center pane
     */
    Center(JQLayoutCSSThemeBlockNames.UI_Layout_Center);

    /**
     * The area class
     */
    private JQLayoutCSSThemeBlockNames areaClass;

    /**
     * Constructs a new Layout Area
     *
     * @param areaClass
     */
    private JQLayoutArea(JQLayoutCSSThemeBlockNames areaClass)
    {
        this.areaClass = areaClass;
    }

    /**
     * Sets the class
     *
     * @param areaClass
     */
    public void setAreaClass(JQLayoutCSSThemeBlockNames areaClass)
    {
        this.areaClass = areaClass;
    }

    /**
     * Returns the actual class for the div
     *
     * @return
     */
    public JQLayoutCSSThemeBlockNames getAreaClass()
    {
        return areaClass;
    }

    /**
     * The north lowercase
     *
     * @return
     */
    @Override
    public String toString()
    {
        return name().toLowerCase();
    }
}
