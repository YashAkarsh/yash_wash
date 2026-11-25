package com.alibaba.fastjson.support.spring;

import com.alibaba.fastjson.serializer.h1;
import com.alibaba.fastjson.serializer.k1;
import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.view.AbstractView;

/* JADX INFO: loaded from: classes.dex */
public class d extends AbstractView {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f13229k = "application/json;charset=UTF-8";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f13230l = "application/javascript";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final Pattern f13231m = Pattern.compile("[0-9A-Za-z_\\.]*");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Deprecated
    protected String f13235d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Set<String> f13236e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Deprecated
    protected Charset f13232a = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Deprecated
    protected k1[] f13233b = new k1[0];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Deprecated
    protected h1[] f13234c = new h1[0];

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f13237f = true;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f13238g = true;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f13239h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private com.alibaba.fastjson.support.config.a f13240i = new com.alibaba.fastjson.support.config.a();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String[] f13241j = {"jsonp", "callback"};

    public d() {
        setContentType("application/json;charset=UTF-8");
        setExposePathVariables(false);
    }

    private String g(HttpServletRequest httpServletRequest) {
        String[] strArr = this.f13241j;
        if (strArr == null) {
            return null;
        }
        for (String str : strArr) {
            String parameter = httpServletRequest.getParameter(str);
            if (com.alibaba.fastjson.util.f.n(parameter)) {
                return parameter;
            }
            if (this.logger.isDebugEnabled()) {
                this.logger.debug("Ignoring invalid jsonp parameter value: " + parameter);
            }
        }
        return null;
    }

    protected Object a(Map<String, Object> map) {
        HashMap map2 = new HashMap(map.size());
        Set<String> setKeySet = !CollectionUtils.isEmpty(this.f13236e) ? this.f13236e : map.keySet();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (!(entry.getValue() instanceof BindingResult) && setKeySet.contains(entry.getKey())) {
                map2.put(entry.getKey(), entry.getValue());
            }
        }
        if (this.f13239h && map2.size() == 1) {
            Iterator it = map2.entrySet().iterator();
            if (it.hasNext()) {
                return ((Map.Entry) it.next()).getValue();
            }
        }
        return map2;
    }

    @Deprecated
    public Charset b() {
        return this.f13240i.a();
    }

    @Deprecated
    public String c() {
        return this.f13240i.c();
    }

    public com.alibaba.fastjson.support.config.a d() {
        return this.f13240i;
    }

    @Deprecated
    public k1[] e() {
        return this.f13240i.h();
    }

    @Deprecated
    public h1[] f() {
        return this.f13240i.g();
    }

    public boolean h() {
        return this.f13239h;
    }

    protected void i(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        t(httpServletRequest, httpServletResponse);
        httpServletResponse.setCharacterEncoding(this.f13240i.a().name());
        if (this.f13237f) {
            httpServletResponse.addHeader(com.google.common.net.c.f22140e, "no-cache");
            httpServletResponse.addHeader(com.google.common.net.c.f22132a, "no-cache, no-store, max-age=0");
            httpServletResponse.addDateHeader(com.google.common.net.c.f22151j0, 1L);
        }
    }

    protected void j(Map<String, Object> map, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        Object obj;
        Object objA = a(map);
        String strG = g(httpServletRequest);
        if (strG != null) {
            com.alibaba.fastjson.f fVar = new com.alibaba.fastjson.f(strG);
            fVar.b(objA);
            obj = fVar;
        } else {
            obj = objA;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int iQ0 = com.alibaba.fastjson.a.Q0(byteArrayOutputStream, this.f13240i.a(), obj, this.f13240i.f(), this.f13240i.g(), this.f13240i.c(), com.alibaba.fastjson.a.f12533g, this.f13240i.h());
        if (this.f13238g) {
            httpServletResponse.setContentLength(iQ0);
        }
        ServletOutputStream outputStream = httpServletResponse.getOutputStream();
        byteArrayOutputStream.writeTo(outputStream);
        byteArrayOutputStream.close();
        outputStream.flush();
    }

    @Deprecated
    public void k(Charset charset) {
        this.f13240i.j(charset);
    }

    @Deprecated
    public void l(String str) {
        this.f13240i.l(str);
    }

    public void m(boolean z7) {
        this.f13237f = z7;
    }

    public void n(boolean z7) {
        this.f13239h = z7;
    }

    public void o(com.alibaba.fastjson.support.config.a aVar) {
        this.f13240i = aVar;
    }

    @Deprecated
    public void p(k1... k1VarArr) {
        this.f13240i.q(k1VarArr);
    }

    @Deprecated
    public void q(h1... h1VarArr) {
        this.f13240i.p(h1VarArr);
    }

    public void r(Set<String> set) {
        Assert.notEmpty(set, "jsonpParameterName cannot be empty");
        this.f13241j = (String[]) set.toArray(new String[set.size()]);
    }

    public void s(Set<String> set) {
        this.f13236e = set;
    }

    protected void t(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        if (g(httpServletRequest) != null) {
            httpServletResponse.setContentType(f13230l);
        } else {
            super.setResponseContentType(httpServletRequest, httpServletResponse);
        }
    }

    @Deprecated
    public void u(k1... k1VarArr) {
        this.f13240i.q(k1VarArr);
    }

    public void v(boolean z7) {
        this.f13238g = z7;
    }
}
