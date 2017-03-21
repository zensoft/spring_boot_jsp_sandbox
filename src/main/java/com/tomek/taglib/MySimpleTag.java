package com.tomek.taglib;

import com.tomek.domain.priceformating.PriceFormatter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

import static com.tomek.util.ServletContextUtil.getAttribute;


/**
 * Created by tomek on 14.03.17.
 */
public class MySimpleTag extends SimpleTagSupport {

    @Override
    public void doTag() throws JspException, IOException {
        getJspContext().getOut().write("?????");


        PriceFormatter priceFormatter = getAttribute("priceFormatter");

        //System.out.println(priceFormatter);

        //System.out.println(priceFormatter.getFormattedPrice("100"));
    }

}
