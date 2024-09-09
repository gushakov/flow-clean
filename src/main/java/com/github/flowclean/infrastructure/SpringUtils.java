package com.github.flowclean.infrastructure;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * Spring utilities.
 */
public class SpringUtils {

    /**
     * Gets a bean of the given {@code type} from {@linkplain WebApplicationContext} of Spring.
     *
     * @param type type of the bean
     * @param args any arguments to be passed to the constructor of the bean
     * @param <T>  any type
     * @return instance of the bean looked up from {@linkplain WebApplicationContext}
     * @throws IllegalStateException                    if there is a problem getting
     *                                                  {@linkplain org.springframework.web.context.request.RequestAttributes}
     * @throws org.springframework.beans.BeansException if no bean could be looked up in the context
     */
    public static <T> T getBean(Class<T> type, Object... args) {
        // get the web application context
        final HttpServletRequest nativeRequest = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
                .getRequest();
        WebApplicationContext webAppContext = WebApplicationContextUtils
                .getRequiredWebApplicationContext(nativeRequest.getServletContext());
        // look up the bean from the context
        return webAppContext.getBean(type, args);
    }
}
