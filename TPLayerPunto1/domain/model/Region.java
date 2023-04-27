package model;

import portsout.ErrorException;

class Region {
	private String region;
	
	Region(String region)
	{
		if(region.isEmpty())
			throw new ErrorException("Debe cargar una region");
		if(!validarRegion(region))
			throw new ErrorException("Region desconocida. Las conocidas son: China, US, Europa");
	
		this.region = region;
	}
	
	String obtenerRegion()
	{
		return this.region;
	}
	private Boolean validarRegion(String region)
	{
		 return (region.equals("China") || region.equals("US") || region.equals("Europa"));
	}
}
