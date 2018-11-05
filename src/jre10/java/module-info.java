import com.jwebmp.core.services.IPageConfigurator;
import com.jwebmp.guicedinjection.interfaces.IGuiceScanJarExclusions;
import com.jwebmp.guicedinjection.interfaces.IGuiceScanModuleExclusions;
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
	requires com.jwebmp.guicedinjection;

	provides IPageConfigurator with JQLayoutPageConfigurator;

	provides IGuiceScanModuleExclusions with com.jwebmp.plugins.jqlayout.implementations.JQLayoutExclusionsModule;
	provides IGuiceScanJarExclusions with com.jwebmp.plugins.jqlayout.implementations.JQLayoutExclusionsModule;

	opens com.jwebmp.plugins.jqlayout to com.fasterxml.jackson.databind, com.jwebmp.core;
	opens com.jwebmp.plugins.jqlayout.interfaces to com.fasterxml.jackson.databind, com.jwebmp.core;
	opens com.jwebmp.plugins.jqlayout.components to com.fasterxml.jackson.databind, com.jwebmp.core;
	opens com.jwebmp.plugins.jqlayout.enumerations to com.fasterxml.jackson.databind, com.jwebmp.core;
	opens com.jwebmp.plugins.jqlayout.events to com.fasterxml.jackson.databind, com.jwebmp.core;
	opens com.jwebmp.plugins.jqlayout.options to com.fasterxml.jackson.databind, com.jwebmp.core;

}
