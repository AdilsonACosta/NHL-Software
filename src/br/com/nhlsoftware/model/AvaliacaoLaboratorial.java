package br.com.nhlsoftware.model;

import java.util.Date;

public class AvaliacaoLaboratorial {

	private Long id;
	private Date dataAvaliacaoLaboratorial;
	private String hemoglobina;
	private String trigliceridios;
	private String colesterolTotal;
	private String ldl;
	private String hdl;
	private String vldl;
	private String glicemiaDeJejum;
	private String glicemiaPosPrandial;
	private String pressaoArterial;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataAvaliacaoLaboratorial() {
		return dataAvaliacaoLaboratorial;
	}

	public void setDataAvaliacaoLaboratorial(Date dataAvaliacaoLaboratorial) {
		this.dataAvaliacaoLaboratorial = dataAvaliacaoLaboratorial;
	}

	public String getHemoglobina() {
		return hemoglobina;
	}

	public void setHemoglobina(String hemoglobina) {
		this.hemoglobina = hemoglobina;
	}

	public String getTrigliceridios() {
		return trigliceridios;
	}

	public void setTrigliceridios(String trigliceridios) {
		this.trigliceridios = trigliceridios;
	}

	public String getColesterolTotal() {
		return colesterolTotal;
	}

	public void setColesterolTotal(String colesterolTotal) {
		this.colesterolTotal = colesterolTotal;
	}

	public String getLdl() {
		return ldl;
	}

	public void setLdl(String ldl) {
		this.ldl = ldl;
	}

	public String getHdl() {
		return hdl;
	}

	public void setHdl(String hdl) {
		this.hdl = hdl;
	}

	public String getVldl() {
		return vldl;
	}

	public void setVldl(String vldl) {
		this.vldl = vldl;
	}

	public String getGlicemiaDeJejum() {
		return glicemiaDeJejum;
	}

	public void setGlicemiaDeJejum(String glicemiaDeJejum) {
		this.glicemiaDeJejum = glicemiaDeJejum;
	}

	public String getGlicemiaPosPrandial() {
		return glicemiaPosPrandial;
	}

	public void setGlicemiaPosPrandial(String glicemiaPosPrandial) {
		this.glicemiaPosPrandial = glicemiaPosPrandial;
	}

	public String getPressaoArterial() {
		return pressaoArterial;
	}

	public void setPressaoArterial(String pressaoArterial) {
		this.pressaoArterial = pressaoArterial;
	}

}
