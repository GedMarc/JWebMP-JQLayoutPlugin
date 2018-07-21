/*
 * Copyright (C) 2016 ged_m
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
package com.jwebmp.components.jqueryLayout.layout;

import com.jwebmp.core.Page;
import com.jwebmp.core.base.ajax.AjaxResponse;
import com.jwebmp.core.base.angular.AngularPageConfigurator;
import com.jwebmp.core.base.html.Button;
import com.jwebmp.core.base.html.Div;
import com.jwebmp.core.generics.Direction;
import com.jwebmp.core.htmlbuilder.css.displays.Cursors;
import com.jwebmp.core.plugins.jquery.JQueryPageConfigurator;
import com.jwebmp.plugins.easingeffects.JQEasingAnimationEffectsPart;
import com.jwebmp.plugins.easingeffects.JQEasingEffects;
import com.jwebmp.plugins.jqlayout.components.BorderLayout;
import com.jwebmp.plugins.jqlayout.enumerations.CustomHotkeyModifier;
import com.jwebmp.plugins.jqlayout.enumerations.LayoutResponsiveSize;
import com.jwebmp.plugins.jqlayout.events.*;
import com.jwebmp.plugins.jqlayout.options.JQLayoutResponsiveOptions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.jwebmp.plugins.jqlayout.enumerations.JQLayoutArea.*;

/**
 * @author ged_m
 */
public class JQLayoutTest

{

	public JQLayoutTest()
	{
	}

	@Test
	public void testJQLayout()
	{
		JQueryPageConfigurator.setRequired(false);
		AngularPageConfigurator.setRequired(false);
		Page p = new Page();
		BorderLayout layout = new BorderLayout();
		p.getOptions()
		 .setDynamicRender(true);
		p.add(layout);
		System.out.println(p.toString(true));

		System.out.println(layout.renderJavascript());

		BorderLayout bl = new BorderLayout();
		System.out.println(bl.toString());
	}

	@Test
	public void testResponsive()
	{
		JQueryPageConfigurator.setRequired(false);
		AngularPageConfigurator.setRequired(false);
		Page p = new Page();
		BorderLayout<?> layout = new BorderLayout<>();

		layout.getOptions()
		      .getDefaults()
		      .getResponsive()
		      .setEnabled(true);
		System.out.println(layout.renderJavascript());
	}

	@Test
	public void testResponsiveSizes()
	{
		JQueryPageConfigurator.setRequired(false);
		AngularPageConfigurator.setRequired(false);
		Page p = new Page();
		BorderLayout<?> layout = new BorderLayout<>();
		layout.getOptions()
		      .getDefaults()
		      .getResponsive()
		      .getSizes()
		      .put(LayoutResponsiveSize.ExtraLarge, 500);

		System.out.println(layout.renderJavascript());
	}

	@Test
	public void testAjaxResponseAdditions()
	{

		JQueryPageConfigurator.setRequired(false);
		AngularPageConfigurator.setRequired(false);
		Page p = new Page();
		BorderLayout<?> layout = new BorderLayout<>();

		Button pin = new Button();
		Button toggle = new Button();

		AjaxResponse<?> ar = new AjaxResponse();
		ar.getFeatures()
		  .add(layout.createPinButton(pin, West));
		System.out.println("Feature Size : " + ar.getFeatures()
		                                         .size());
		ar.getFeatures()
		  .add(layout.createToggleButton(toggle, West));
		System.out.println("Feature Size : " + ar.getFeatures()
		                                         .size());

		System.out.println(ar.toString());

		ar.getFeatures()
		  .add(layout.createPinButton(pin, East));
		ar.getFeatures()
		  .add(layout.createToggleButton(toggle, East));

		System.out.println("Feature Size : " + ar.getFeatures()
		                                         .size());
		System.out.println(ar.toString());

		Assertions.assertEquals(4, ar.getFeatures()
		                             .size());
	}

	@Test
	public void testLayoutStructure()
	{
		Page p = new Page();
		BorderLayout<?> layout = new BorderLayout<>();

		layout.asMe()
		      .getCenter()
		      .getContentDiv()
		      .add("Center Content");
		layout.asMe()
		      .getEast()
		      .getContentDiv()
		      .add("East Content");
		layout.asMe()
		      .getNorth()
		      .getContentDiv()
		      .add("North Content");
		layout.asMe()
		      .getWest()
		      .getContentDiv()
		      .add("West Content");
		layout.asMe()
		      .getSouth()
		      .getContentDiv()
		      .add("South Content");
		p.add(layout);

		System.out.println(p.toString(0));
	}

	@Test
	public void testOptions()
	{
		Page p = new Page();
		BorderLayout<?> layout = new BorderLayout<>();

		layout.getOptions()
		      .getDefaults()
		      .setAnimatePaneSizing(true)
		      .setButtonClass("btn-class")
		      .setClosable(true)
		      .setContentIgnoreSelector(layout.getPane(West))
		      .setContentSelector(layout.getPane(East))
		      .setCustomHotkey('H')
		      .setCustomHotkeyModifier(CustomHotkeyModifier.CNTRL)
		      .setEnableCursorHotkey(true)
		      .setFxName(JQEasingEffects.easeInBack)
		      .setFxNameClose(JQEasingEffects.easeInBounce)
		      .setFxNameOpen(JQEasingEffects.easeInCirc)
		      .setFxSettings(new JQEasingAnimationEffectsPart<>().setDirection(Direction.Horizontal)
		                                                         .setDuration(500)
		                                                         .setEasing(JQEasingEffects.easeInElastic)
		                                                         .setRenderEmptyBraces(false))
		      .setFxSettingsClose(new JQEasingAnimationEffectsPart<>().setDirection(Direction.Horizontal)
		                                                              .setDuration(500)
		                                                              .setEasing(JQEasingEffects.easeInElastic)
		                                                              .setRenderEmptyBraces(false))
		      .setFxSettingsOpen(new JQEasingAnimationEffectsPart<>().setDirection(Direction.Horizontal)
		                                                             .setDuration(500)
		                                                             .setEasing(JQEasingEffects.easeInElastic)
		                                                             .setRenderEmptyBraces(false))
		      .setFxSpeed(200)
		      .setFxSpeedClose(300)
		      .setFxSpeedOpen(100)
		      .setHideTogglerOnSlide(false)
		      .setInitClosed(false)
		      .setInitHidden(true)
		      .setLivePaneResizing(true)
		      .setMaskIframesOnResize(true)
		      .setMinSize(50)
		      .setMaxSize(55)
		      .setOnResize("on-resize function")
		      .setPaneClass("pane-class")
		      .setPaneSelector(layout.getPane(North))
		      .setResizable(true)
		      .setResizerClass("resizer-class")
		      .setResizerCursor(Cursors.Pointer)
		      .setResizerDragOpacity(2.0)
		      .setResponsive(new JQLayoutResponsiveOptions<>().setEnabled(true)
		                                                      .setWhen(LayoutResponsiveSize.Large))
		      .setScrollToBookmarkOnLoad(true)
		      .setShowOverflowOnHover(true)
		      .setSize(600)
		      .setSlidable(false)
		      .setSliderCursor(Cursors.URL)
		      .setSlideTriggerClose("trigger-close")
		      .setSlideTriggerOpen("trigger-open")
		      .setSpacingClosed(2)
		      .setSpacingOpen(1)
		      .setTogglerAlignClosed("align-left")
		      .setTogglerAlignOpen("align-right")
		      .setTogglerClass("toggler-class")
		      .setTogglerContentClosed(new Div())
		      .setTogglerContentOpen(new Div())
		      .setTogglerLengthClosed(10)
		      .setTogglerLengthOpen(15);
		System.out.println(layout.renderJavascript());
	}

	@Test
	public void testFeatures()
	{
		Page p = new Page();
		BorderLayout<?> layout = new BorderLayout<>();

		Div b = new Div();

		String output = new JQLayoutAddPinButtonFeature(layout.getPane(North), b).renderJavascript()
		                                                                         .toString();
		System.out.println(output);

		b = new Div();
		output = new JQLayoutAddSlideToggleButtonFeature(layout.getPane(North), b).renderJavascript()
		                                                                          .toString();
		System.out.println(output);

		b = new Div();
		output = new JQLayoutAddToggleButtonFeature(layout.getPane(North), b).renderJavascript()
		                                                                     .toString();
		System.out.println(output);

		b = new Div();
		output = new JQLayoutCloseLayoutDivFeature(layout.getPane(North)).renderJavascript()
		                                                                 .toString();
		System.out.println(output);

		b = new Div();
		output = new JQLayoutDisableClosableFeature(layout.getPane(North)).renderJavascript()
		                                                                  .toString();
		System.out.println(output);

		b = new Div();
		output = new JQLayoutDisableResizableFeature(layout.getPane(North)).renderJavascript()
		                                                                   .toString();
		System.out.println(output);

		b = new Div();
		output = new JQLayoutDisableSlidableFeature(layout.getPane(North), b).renderJavascript()
		                                                                     .toString();
		System.out.println(output);

		b = new Div();
		output = new JQLayoutEnableClosableFeature(layout.getPane(North)).renderJavascript()
		                                                                 .toString();
		System.out.println(output);

		b = new Div();
		output = new JQLayoutEnableResizableFeature(layout.getPane(North)).renderJavascript()
		                                                                  .toString();
		System.out.println(output);

		b = new Div();
		output = new JQLayoutEnableSlidableFeature(layout.getPane(North), b).renderJavascript()
		                                                                    .toString();
		System.out.println(output);

		b = new Div();
		output = new JQLayoutOpenLayoutDivFeature(layout.getPane(North)).renderJavascript()
		                                                                .toString();
		System.out.println(output);

		b = new Div();
		output = new JQLayoutSlideCloseLayoutDivFeature(layout.getPane(North)).renderJavascript()
		                                                                      .toString();
		System.out.println(output);

		b = new Div();
		output = new JQLayoutSlideOpenLayoutDivFeature(layout.getPane(North)).renderJavascript()
		                                                                     .toString();
		System.out.println(output);

		b = new Div();
		output = new JQLayoutSlideToggleLayoutDivFeature(layout.getPane(North)).renderJavascript()
		                                                                       .toString();
		System.out.println(output);
	}
}
