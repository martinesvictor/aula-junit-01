package com.ada.aulajunit.modelo;

import java.math.BigDecimal;
import java.util.Date;

public class DollarQuotation {
    private Date date;

    private BigDecimal purchaseQuotation;

    private BigDecimal saleQuotation;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getPurchaseQuotation() {
        return purchaseQuotation;
    }

    public void setPurchaseQuotation(BigDecimal purchaseQuotation) {
        this.purchaseQuotation = purchaseQuotation;
    }

    public BigDecimal getSaleQuotation() {
        return saleQuotation;
    }

    public void setSaleQuotation(BigDecimal saleQuotation) {
        this.saleQuotation = saleQuotation;
    }
}


