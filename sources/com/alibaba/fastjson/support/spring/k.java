package com.alibaba.fastjson.support.spring;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/* JADX INFO: loaded from: classes.dex */
@ControllerAdvice
@Order(Integer.MIN_VALUE)
public class k implements ResponseBodyAdvice<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Log f13248a = LogFactory.getLog(getClass());

    public Object a(Object obj, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> cls, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        f0.c cVar = (f0.c) methodParameter.getMethodAnnotation(f0.c.class);
        if (cVar == null) {
            cVar = (f0.c) methodParameter.getContainingClass().getAnnotation(f0.c.class);
        }
        String parameter = ((ServletServerHttpRequest) serverHttpRequest).getServletRequest().getParameter(cVar.callback());
        if (!com.alibaba.fastjson.util.f.n(parameter)) {
            if (this.f13248a.isDebugEnabled()) {
                this.f13248a.debug("Invalid jsonp parameter value:" + parameter);
            }
            parameter = null;
        }
        com.alibaba.fastjson.f fVar = new com.alibaba.fastjson.f(parameter);
        fVar.b(obj);
        b(fVar, mediaType, methodParameter, serverHttpRequest, serverHttpResponse);
        return fVar;
    }

    public void b(com.alibaba.fastjson.f fVar, MediaType mediaType, MethodParameter methodParameter, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
    }

    protected MediaType c(MediaType mediaType, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        return b.f13222f;
    }

    public boolean d(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> cls) {
        return b.class.isAssignableFrom(cls) && (methodParameter.getContainingClass().isAnnotationPresent(f0.c.class) || methodParameter.hasMethodAnnotation(f0.c.class));
    }
}
