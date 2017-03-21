package com.tomek.domain.priceformating.handlers;

import com.tomek.domain.priceformating.PriceHandler;

/**
 * Created by tomek on 12.03.17.
 */
public abstract class AbstractPriceHandler implements PriceHandler {

    private PriceHandler nextHandler;

    public AbstractPriceHandler(PriceHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public String getFormattedPrice(Object price) {
        if (isProperPriceType(price))
            return handlePrice(price);
        if (nextHandler == null) {
            return "Can't handle: " + price;
        } else {
            return nextHandler.getFormattedPrice(price);
        }
    }

    protected abstract String handlePrice(Object price);

    protected abstract boolean isProperPriceType(Object price);
}
