package com.alibaba.android.arouter.compiler.processor;

import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.squareup.javapoet.j;
import com.squareup.javapoet.k;
import com.squareup.javapoet.m;
import com.squareup.javapoet.n;
import com.squareup.javapoet.p;
import com.squareup.javapoet.s;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedOptions;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.Elements;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: classes.dex */
@SupportedSourceVersion(SourceVersion.RELEASE_7)
@SupportedAnnotationTypes({com.alibaba.android.arouter.compiler.utils.a.S})
@r1.a(Processor.class)
@SupportedOptions({com.alibaba.android.arouter.compiler.utils.a.P})
public class b extends AbstractProcessor {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Filer f12388b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.alibaba.android.arouter.compiler.utils.b f12389c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Elements f12390d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<Integer, Element> f12387a = new TreeMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f12391e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private TypeMirror f12392f = null;

    private void b(Set<? extends Element> set) throws Exception {
        if (CollectionUtils.isNotEmpty(set)) {
            this.f12389c.d(">>> Found interceptors, size is " + set.size() + " <<<");
            for (Element element : set) {
                if (d(element)) {
                    this.f12389c.d("A interceptor verify over, its " + element.asType());
                    Interceptor interceptor = (Interceptor) element.getAnnotation(Interceptor.class);
                    Element element2 = this.f12387a.get(Integer.valueOf(interceptor.priority()));
                    if (element2 != null) {
                        throw new IllegalArgumentException(String.format(Locale.getDefault(), "More than one interceptors use same priority [%d], They are [%s] and [%s].", Integer.valueOf(interceptor.priority()), element2.getSimpleName(), element.getSimpleName()));
                    }
                    this.f12387a.put(Integer.valueOf(interceptor.priority()), element);
                } else {
                    this.f12389c.a("A interceptor verify failed, its " + element.asType());
                }
            }
            TypeElement typeElement = this.f12390d.getTypeElement(com.alibaba.android.arouter.compiler.utils.a.I);
            TypeElement typeElement2 = this.f12390d.getTypeElement(com.alibaba.android.arouter.compiler.utils.a.f12406J);
            k.b bVarA = k.f(com.alibaba.android.arouter.compiler.utils.a.f12411e).q(Override.class).z(Modifier.PUBLIC).A(m.a(n.t(com.squareup.javapoet.c.w(Map.class), com.squareup.javapoet.c.w(Integer.class), n.t(com.squareup.javapoet.c.w(Class.class), s.x(com.squareup.javapoet.c.y(typeElement)))), "interceptors", new Modifier[0]).j());
            Map<Integer, Element> map = this.f12387a;
            if (map != null && map.size() > 0) {
                for (Map.Entry<Integer, Element> entry : this.f12387a.entrySet()) {
                    bVarA.E("interceptors.put(" + entry.getKey() + ", $T.class)", com.squareup.javapoet.c.y(entry.getValue()));
                }
            }
            j.a("com.alibaba.android.arouter.routes", p.e("ARouter$$Interceptors$$" + this.f12391e).F(Modifier.PUBLIC).C(com.alibaba.android.arouter.compiler.utils.a.f12410d, new Object[0]).D(bVarA.I()).I(com.squareup.javapoet.c.y(typeElement2)).P()).m().h(this.f12388b);
            this.f12389c.d(">>> Interceptor group write over. <<<");
        }
    }

    private boolean d(Element element) {
        return ((Interceptor) element.getAnnotation(Interceptor.class)) != null && ((TypeElement) element).getInterfaces().contains(this.f12392f);
    }

    public synchronized void a(ProcessingEnvironment processingEnvironment) {
        super.init(processingEnvironment);
        this.f12388b = processingEnvironment.getFiler();
        this.f12390d = processingEnvironment.getElementUtils();
        this.f12389c = new com.alibaba.android.arouter.compiler.utils.b(processingEnvironment.getMessager());
        Map options = processingEnvironment.getOptions();
        if (MapUtils.isNotEmpty(options)) {
            this.f12391e = (String) options.get(com.alibaba.android.arouter.compiler.utils.a.P);
        }
        if (!StringUtils.isNotEmpty(this.f12391e)) {
            this.f12389c.a("These no module name, at 'build.gradle', like :\napt {\n    arguments {\n        moduleName project.getName();\n    }\n}\n");
            throw new RuntimeException("ARouter::Compiler >>> No module name, for more information, look at gradle log.");
        }
        this.f12391e = this.f12391e.replaceAll("[^0-9a-zA-Z_]+", "");
        this.f12389c.d("The user has configuration the module name, it was [" + this.f12391e + "]");
        this.f12392f = this.f12390d.getTypeElement(com.alibaba.android.arouter.compiler.utils.a.I).asType();
        this.f12389c.d(">>> InterceptorProcessor init. <<<");
    }

    public boolean c(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        if (!CollectionUtils.isNotEmpty(set)) {
            return false;
        }
        try {
            b(roundEnvironment.getElementsAnnotatedWith(Interceptor.class));
            return true;
        } catch (Exception e8) {
            this.f12389c.b(e8);
            return true;
        }
    }
}
