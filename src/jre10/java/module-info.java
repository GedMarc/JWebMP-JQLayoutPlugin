import com.jwebmp.core.services.IPageConfigurator;
import com.jwebmp.plugins.jqlayout.JQLayoutPageConfigurator;

module com.jwebmp.plugins.jqlayout {
	exports com.jwebmp.plugins.jqlayout;
	exports com.jwebmp.plugins.jqlayout.events;
	exports com.jwebmp.plugins.jqlayout.components;
	exports com.jwebmp.plugins.jqlayout.enumerations;
	exports com.jwebmp.plugins.jqlayout.interfaces;
	exports com.jwebmp.plugins.jqlayout.options;

	requires com.jwebmp.core;
	requires com.jwebmp.logmaster;
	requires com.fasterxml.jackson.annotation;

	requires java.validation;
	requires java.logging;
	requires com.jwebmp.plugins.easingeffects;

	provides IPageConfigurator with JQLayoutPageConfigurator;

}
