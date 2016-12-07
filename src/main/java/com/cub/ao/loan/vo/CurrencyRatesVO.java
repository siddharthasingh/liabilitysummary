package com.cub.ao.loan.vo;

import java.io.Serializable;
import java.math.BigDecimal;

public class CurrencyRatesVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8104473068425462527L;
	private String baseCcy;
	private String ccy;
	private BigDecimal exrateFixed;
    private String lastUpdateTime;
	public String getBaseCcy() {
		return baseCcy;
	}
	public void setBaseCcy(String baseCcy) {
		this.baseCcy = baseCcy;
	}
	public String getCcy() {
		return ccy;
	}
	public void setCcy(String ccy) {
		this.ccy = ccy;
	}
	public BigDecimal getExrateFixed() {
		return exrateFixed;
	}
	public void setExrateFixed(BigDecimal exrateFixed) {
		this.exrateFixed = exrateFixed;
	}
	public String getLastUpdateTime() {
		return lastUpdateTime;
	}
	public void setLastUpdateTime(String lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	
    
    
    
	
}
