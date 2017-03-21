package com.tomek.domain.priceformating.handlers;

import com.tomek.domain.priceformating.PriceHandler;

/**
 * Created by tomek on 12.03.17.
 */
public class NumberPriceHandler extends AbstractPriceHandler {

    public NumberPriceHandler(PriceHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    protected String handlePrice(Object price) {
        return "Number price: " + price;
    }

    @Override
    protected boolean isProperPriceType(Object price) {
        return price instanceof Number;
    }

}
