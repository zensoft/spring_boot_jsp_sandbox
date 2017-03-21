package com.tomek.domain.priceformating.impl;

import com.tomek.domain.priceformating.PriceFormatter;
import com.tomek.domain.priceformating.PriceHandler;

/**
 * Created by tomek on 12.03.17.
 */
public class DefaultPriceFormatter implements PriceFormatter {


    private final PriceHandler priceHandler;

    public DefaultPriceFormatter(PriceHandler priceHandler) {
        this.priceHandler = priceHandler;
    }

    @Override
    public String getFormattedPrice(Object price) {
        return priceHandler.getFormattedPrice(price);
    }

}
