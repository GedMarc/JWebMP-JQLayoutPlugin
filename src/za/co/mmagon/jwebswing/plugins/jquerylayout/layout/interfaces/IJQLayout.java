package za.co.mmagon.jwebswing.plugins.jquerylayout.layout.interfaces;

import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.plugins.jquerylayout.layout.JQLayout;
import za.co.mmagon.jwebswing.plugins.jquerylayout.layout.JQLayoutArea;
import za.co.mmagon.jwebswing.plugins.jquerylayout.layout.JQLayoutDiv;
import za.co.mmagon.jwebswing.plugins.jquerylayout.layout.JQLayoutOptions;
import za.co.mmagon.jwebswing.plugins.jquerylayout.layout.events.JQLayoutAddPinButtonFeature;
import za.co.mmagon.jwebswing.plugins.jquerylayout.layout.events.JQLayoutAddToggleButtonFeature;
import za.co.mmagon.jwebswing.plugins.jquerylayout.layout.events.JQLayoutCloseLayoutDivFeature;
import za.co.mmagon.jwebswing.plugins.jquerylayout.layout.events.JQLayoutOpenLayoutDivFeature;

import javax.validation.constraints.NotNull;

public interface IJQLayout<J extends JQLayout<J>>
{
	/**
	 * Returns the center pane
	 *
	 * @return A Layout pane on the center div
	 */

	@SuppressWarnings("unchecked")
	@NotNull
	JQLayoutDiv getCenter();

	/**
	 * Sets the center pane
	 *
	 * @param centerDiv
	 * 		The new center panel
	 */

	@SuppressWarnings("unchecked")
	@NotNull
	J setCenter(JQLayoutDiv centerDiv);

	/**
	 * Creates a toggle button for the given pane on the component.
	 * <p>
	 * The feature is added to the component
	 *
	 * @param component
	 * @param pane
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	JQLayoutAddToggleButtonFeature createToggleButton(Component component, JQLayoutArea pane);

	/**
	 * Gets the layout div for a pane
	 *
	 * @param area
	 *
	 * @return
	 */
	JQLayoutDiv getPane(JQLayoutArea area);

	/**
	 * Returns the center pane
	 *
	 * @return A Layout pane on the center div
	 */

	JQLayoutDiv getNorth();

	/**
	 * Sets the north pane
	 *
	 * @param centerDiv
	 * 		The new center panel
	 */

	@SuppressWarnings("unchecked")
	@NotNull
	J setNorth(JQLayoutDiv centerDiv);

	/**
	 * Returns the center pane
	 *
	 * @return A Layout pane on the center div
	 */
	@NotNull
	JQLayoutDiv getWest();

	/**
	 * Returns the south pane
	 *
	 * @return A Layout pane on the center div
	 */

	JQLayoutDiv getSouth();

	/**
	 * Returns the center pane
	 *
	 * @return A Layout pane on the center div
	 */

	@NotNull
	JQLayoutDiv getEast();

	/**
	 * Sets the center pane
	 *
	 * @param eastDiv
	 * 		The new center panel
	 */

	@SuppressWarnings("unchecked")
	J setEast(JQLayoutDiv eastDiv);

	/**
	 * Sets the south pane
	 *
	 * @param southDiv
	 * 		The new center panel
	 */

	@SuppressWarnings("unchecked")
	@NotNull
	J setSouth(JQLayoutDiv southDiv);

	/**
	 * Sets the center pane
	 *
	 * @param westDiv
	 * 		The new center panel
	 */

	@SuppressWarnings("unchecked")
	@NotNull
	J setWest(JQLayoutDiv westDiv);

	/**
	 * Returns the layout options
	 * <p>
	 *
	 * @return
	 */

	@NotNull
	JQLayoutOptions getOptions();

	/**
	 * Creates a toggle button for the given pane on the component.
	 * <p>
	 * The feature is added to the component
	 *
	 * @param component
	 * @param pane
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	JQLayoutAddPinButtonFeature createPinButton(Component component, JQLayoutArea pane);

	/**
	 * Creates a toggle button for the given pane on the component.
	 * <p>
	 * The feature is added to the component
	 *
	 * @param component
	 * @param pane
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	JQLayoutCloseLayoutDivFeature createCloseButton(Component component, JQLayoutArea pane);

	/**
	 * Creates a toggle button for the given pane on the component.
	 * <p>
	 * The feature is added to the component
	 *
	 * @param component
	 * @param pane
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	JQLayoutOpenLayoutDivFeature createOpenButton(Component component, JQLayoutArea pane);

	/**
	 * Returns the variable ID
	 *
	 * @return
	 */
	@NotNull
	String getVariableID();

	/**
	 * Sets the variable ID. Adds 'lay_' in front and takes all hyphens (-) into underscores (_)
	 *
	 * @param variableID
	 */
	@SuppressWarnings("unchecked")
	J setVariableID(@NotNull String variableID);
}
