package com.tomek.domain.priceformating.handlers;

import com.tomek.domain.priceformating.PriceHandler;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.stereotype.Component;

/**
 * Created by tomek on 12.03.17.
 */
public class StringPriceHandler extends AbstractPriceHandler {

    public StringPriceHandler(PriceHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    protected String handlePrice(Object price) {
        String stringPrice = String.class.cast(price);
        boolean isNumber = NumberUtils.isNumber(stringPrice);
        if (isNumber) {
            Number number = NumberUtils.createNumber(stringPrice);
            return number + " num " + number.intValue() + " " + number.floatValue() * 2;
        }

        return "String price: " + stringPrice + " " + isNumber;
    }

    @Override
    protected boolean isProperPriceType(Object price) {
        return price instanceof String;
    }

}
