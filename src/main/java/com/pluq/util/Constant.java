package com.pluq.util;

public class Constant {
	
	public static final String METER_VALUES = "src/main/resources/data/meterValues.json";
	public static final String LOCATIONS = "src/main/resources/data/locations.json";
	public static final String ENERGY_PRICES = "src/main/resources/data/energyPrices.json";
	
	public static final String METER_VALUE_BY_PHYSICAL_REFERENCE= "/meter-value/{physicalReference}";
	public static final String METER_VALUE = "/meter-value";
	public static final String SAVE_METER_VALUES = "/meter-value/save";
	
	public static final String LOCATION = "/location";
	public static final String LOCATION_BY_ID = "/location/{id}";
	public static final String SAVE_OR_UPDATE_LOCATION = "/location/sava";
	
	public static final String REPORT = "/report";
	public static final String DETAIL_REPORT = "/charging_report";
}
