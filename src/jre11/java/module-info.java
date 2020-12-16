import com.jwebmp.plugins.jqlayout.implementations.JQLayoutInclusionModule;

module com.jwebmp.plugins.jqlayout {

	exports com.jwebmp.plugins.jqlayout;
	exports com.jwebmp.plugins.jqlayout.events;
	exports com.jwebmp.plugins.jqlayout.components;
	exports com.jwebmp.plugins.jqlayout.enumerations;
	exports com.jwebmp.plugins.jqlayout.interfaces;
	exports com.jwebmp.plugins.jqlayout.options;

	requires transitive com.jwebmp.core;
	requires transitive com.guicedee.logmaster;
	requires transitive com.jwebmp.plugins.jqueryui;

	requires jakarta.validation;
	requires java.logging;

	requires com.jwebmp.plugins.easingeffects;
	requires com.guicedee.guicedinjection;

	provides com.jwebmp.core.services.IPageConfigurator with com.jwebmp.plugins.jqlayout.JQLayoutPageConfigurator;

	provides com.guicedee.guicedinjection.interfaces.IGuiceScanModuleExclusions with com.jwebmp.plugins.jqlayout.implementations.JQLayoutExclusionsModule;
	provides com.guicedee.guicedinjection.interfaces.IGuiceScanModuleInclusions with JQLayoutInclusionModule;
	
	opens com.jwebmp.plugins.jqlayout to com.fasterxml.jackson.databind, com.jwebmp.core;
	opens com.jwebmp.plugins.jqlayout.interfaces to com.fasterxml.jackson.databind, com.jwebmp.core;
	opens com.jwebmp.plugins.jqlayout.components to com.fasterxml.jackson.databind, com.jwebmp.core;
	opens com.jwebmp.plugins.jqlayout.enumerations to com.fasterxml.jackson.databind, com.jwebmp.core;
	opens com.jwebmp.plugins.jqlayout.events to com.fasterxml.jackson.databind, com.jwebmp.core;
	opens com.jwebmp.plugins.jqlayout.options to com.fasterxml.jackson.databind, com.jwebmp.core;

}
