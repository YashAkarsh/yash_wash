package com.alibaba.android.arouter.compiler.processor;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.enums.TypeKind;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.fastjson.serializer.k1;
import com.squareup.javapoet.j;
import com.squareup.javapoet.k;
import com.squareup.javapoet.m;
import com.squareup.javapoet.n;
import com.squareup.javapoet.p;
import com.squareup.javapoet.s;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
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
import javax.lang.model.util.Types;
import javax.tools.StandardLocation;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: classes.dex */
@SupportedSourceVersion(SourceVersion.RELEASE_7)
@SupportedAnnotationTypes({com.alibaba.android.arouter.compiler.utils.a.T, com.alibaba.android.arouter.compiler.utils.a.U})
@r1.a(Processor.class)
@SupportedOptions({com.alibaba.android.arouter.compiler.utils.a.P, com.alibaba.android.arouter.compiler.utils.a.Q})
public class c extends AbstractProcessor {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Filer f12395c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.alibaba.android.arouter.compiler.utils.b f12396d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Types f12397e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Elements f12398f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private com.alibaba.android.arouter.compiler.utils.c f12399g;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f12402j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Writer f12403k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, Set<RouteMeta>> f12393a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map<String, String> f12394b = new TreeMap();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f12400h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private TypeMirror f12401i = null;

    class a implements Comparator<RouteMeta> {
        a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(RouteMeta routeMeta, RouteMeta routeMeta2) {
            try {
                return routeMeta.getPath().compareTo(routeMeta2.getPath());
            } catch (NullPointerException e8) {
                c.this.f12396d.a(e8.getMessage());
                return 0;
            }
        }
    }

    static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f12405a;

        static {
            int[] iArr = new int[RouteType.values().length];
            f12405a = iArr;
            try {
                iArr[RouteType.PROVIDER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    private void b(RouteMeta routeMeta) {
        if (!g(routeMeta)) {
            this.f12396d.e(">>> Route meta verify error, group is " + routeMeta.getGroup() + " <<<");
            return;
        }
        this.f12396d.d(">>> Start categories, group = " + routeMeta.getGroup() + ", path = " + routeMeta.getPath() + " <<<");
        Set<RouteMeta> set = this.f12393a.get(routeMeta.getGroup());
        if (!CollectionUtils.isEmpty(set)) {
            set.add(routeMeta);
            return;
        }
        TreeSet treeSet = new TreeSet(new a());
        treeSet.add(routeMeta);
        this.f12393a.put(routeMeta.getGroup(), treeSet);
    }

    private c0.a c(RouteMeta routeMeta) {
        c0.a aVar = new c0.a();
        aVar.l(routeMeta.getGroup());
        aVar.o(routeMeta.getPath());
        aVar.k(routeMeta.getName());
        aVar.q(routeMeta.getType().name().toLowerCase());
        aVar.m(routeMeta.getExtra());
        return aVar;
    }

    private void e(Set<? extends Element> set) throws Exception {
        String str;
        k.b bVar;
        TypeMirror typeMirror;
        m mVar;
        m mVar2;
        String str2;
        Class<Override> cls;
        RouteMeta routeMeta;
        Iterator it;
        String str3;
        Class<Override> cls2;
        if (CollectionUtils.isNotEmpty(set)) {
            com.alibaba.android.arouter.compiler.utils.b bVar2 = this.f12396d;
            StringBuilder sb = new StringBuilder();
            sb.append(">>> Found routes, size is ");
            sb.append(set.size());
            String str4 = " <<<";
            sb.append(" <<<");
            bVar2.d(sb.toString());
            this.f12394b.clear();
            TypeMirror typeMirrorAsType = this.f12398f.getTypeElement(com.alibaba.android.arouter.compiler.utils.a.f12420n).asType();
            TypeMirror typeMirrorAsType2 = this.f12398f.getTypeElement(com.alibaba.android.arouter.compiler.utils.a.f12423q).asType();
            TypeMirror typeMirrorAsType3 = this.f12398f.getTypeElement(com.alibaba.android.arouter.compiler.utils.a.f12421o).asType();
            TypeMirror typeMirrorAsType4 = this.f12398f.getTypeElement(com.alibaba.android.arouter.compiler.utils.a.f12422p).asType();
            TypeElement typeElement = this.f12398f.getTypeElement(com.alibaba.android.arouter.compiler.utils.a.L);
            TypeElement typeElement2 = this.f12398f.getTypeElement(com.alibaba.android.arouter.compiler.utils.a.H);
            com.squareup.javapoet.c cVarW = com.squareup.javapoet.c.w(RouteMeta.class);
            com.squareup.javapoet.c cVarW2 = com.squareup.javapoet.c.w(RouteType.class);
            n nVarT = n.t(com.squareup.javapoet.c.w(Map.class), com.squareup.javapoet.c.w(String.class), n.t(com.squareup.javapoet.c.w(Class.class), s.x(com.squareup.javapoet.c.y(typeElement))));
            n nVarT2 = n.t(com.squareup.javapoet.c.w(Map.class), com.squareup.javapoet.c.w(String.class), com.squareup.javapoet.c.w(RouteMeta.class));
            m mVarJ = m.a(nVarT, "routes", new Modifier[0]).j();
            m mVarJ2 = m.a(nVarT2, "atlas", new Modifier[0]).j();
            m mVarJ3 = m.a(nVarT2, "providers", new Modifier[0]).j();
            String str5 = com.alibaba.android.arouter.compiler.utils.a.f12411e;
            Class<Override> cls3 = Override.class;
            k.b bVarA = k.f(com.alibaba.android.arouter.compiler.utils.a.f12411e).q(cls3).z(Modifier.PUBLIC).A(mVarJ);
            Iterator<? extends Element> it2 = set.iterator();
            while (it2.hasNext()) {
                Element next = it2.next();
                TypeMirror typeMirrorAsType5 = next.asType();
                Iterator<? extends Element> it3 = it2;
                Route route = (Route) next.getAnnotation(Route.class);
                k.b bVar3 = bVarA;
                if (this.f12397e.isSubtype(typeMirrorAsType5, typeMirrorAsType)) {
                    com.alibaba.android.arouter.compiler.utils.b bVar4 = this.f12396d;
                    typeMirror = typeMirrorAsType;
                    StringBuilder sb2 = new StringBuilder();
                    mVar2 = mVarJ2;
                    sb2.append(">>> Found activity route: ");
                    sb2.append(typeMirrorAsType5.toString());
                    sb2.append(" <<<");
                    bVar4.d(sb2.toString());
                    HashMap map = new HashMap();
                    HashMap map2 = new HashMap();
                    Iterator it4 = next.getEnclosedElements().iterator();
                    while (it4.hasNext()) {
                        Element element = (Element) it4.next();
                        if (element.getKind().isField()) {
                            it = it4;
                            if (element.getAnnotation(Autowired.class) != null) {
                                mVarJ3 = mVarJ3;
                                cls2 = cls3;
                                str3 = str5;
                                if (!this.f12397e.isSubtype(element.asType(), this.f12401i)) {
                                    Autowired autowired = (Autowired) element.getAnnotation(Autowired.class);
                                    String string = StringUtils.isEmpty(autowired.name()) ? element.getSimpleName().toString() : autowired.name();
                                    map.put(string, Integer.valueOf(this.f12399g.a(element)));
                                    map2.put(string, autowired);
                                }
                            }
                            it4 = it;
                            mVarJ3 = mVarJ3;
                            cls3 = cls2;
                            str5 = str3;
                        } else {
                            it = it4;
                        }
                        str3 = str5;
                        cls2 = cls3;
                        it4 = it;
                        mVarJ3 = mVarJ3;
                        cls3 = cls2;
                        str5 = str3;
                    }
                    mVar = mVarJ3;
                    str2 = str5;
                    cls = cls3;
                    routeMeta = new RouteMeta(route, next, RouteType.ACTIVITY, map);
                    routeMeta.setInjectConfig(map2);
                } else {
                    typeMirror = typeMirrorAsType;
                    mVar = mVarJ3;
                    mVar2 = mVarJ2;
                    str2 = str5;
                    cls = cls3;
                    if (this.f12397e.isSubtype(typeMirrorAsType5, this.f12401i)) {
                        this.f12396d.d(">>> Found provider route: " + typeMirrorAsType5.toString() + " <<<");
                        routeMeta = new RouteMeta(route, next, RouteType.PROVIDER, null);
                    } else if (this.f12397e.isSubtype(typeMirrorAsType5, typeMirrorAsType2)) {
                        this.f12396d.d(">>> Found service route: " + typeMirrorAsType5.toString() + " <<<");
                        routeMeta = new RouteMeta(route, next, RouteType.parse(com.alibaba.android.arouter.compiler.utils.a.f12423q), null);
                    } else {
                        if (!this.f12397e.isSubtype(typeMirrorAsType5, typeMirrorAsType3) && !this.f12397e.isSubtype(typeMirrorAsType5, typeMirrorAsType4)) {
                            throw new RuntimeException("ARouter::Compiler >>> Found unsupported class type, type = [" + this.f12397e.toString() + "].");
                        }
                        this.f12396d.d(">>> Found fragment route: " + typeMirrorAsType5.toString() + " <<<");
                        routeMeta = new RouteMeta(route, next, RouteType.parse(com.alibaba.android.arouter.compiler.utils.a.f12421o), null);
                    }
                }
                b(routeMeta);
                it2 = it3;
                bVarA = bVar3;
                typeMirrorAsType = typeMirror;
                mVarJ2 = mVar2;
                mVarJ3 = mVar;
                cls3 = cls;
                str5 = str2;
            }
            k.b bVar5 = bVarA;
            m mVar3 = mVarJ2;
            String str6 = str5;
            Class<Override> cls4 = cls3;
            k.b bVarA2 = k.f(str6).q(cls4).z(Modifier.PUBLIC).A(mVarJ3);
            HashMap map3 = new HashMap();
            Iterator<Map.Entry<String, Set<RouteMeta>>> it5 = this.f12393a.entrySet().iterator();
            while (it5.hasNext()) {
                Map.Entry<String, Set<RouteMeta>> next2 = it5.next();
                String key = next2.getKey();
                m mVar4 = mVar3;
                k.b bVarA3 = k.f(str6).q(cls4).z(Modifier.PUBLIC).A(mVar4);
                ArrayList arrayList = new ArrayList();
                Iterator<RouteMeta> it6 = next2.getValue().iterator();
                while (it6.hasNext()) {
                    RouteMeta next3 = it6.next();
                    c0.a aVarC = c(next3);
                    com.squareup.javapoet.c cVarY = com.squareup.javapoet.c.y(next3.getRawType());
                    Class<Override> cls5 = cls4;
                    Iterator<Map.Entry<String, Set<RouteMeta>>> it7 = it5;
                    Iterator<RouteMeta> it8 = it6;
                    if (b.f12405a[next3.getType().ordinal()] == 1) {
                        Iterator it9 = next3.getRawType().getInterfaces().iterator();
                        while (it9.hasNext()) {
                            TypeMirror typeMirror2 = (TypeMirror) it9.next();
                            Iterator it10 = it9;
                            aVarC.a(typeMirror2.toString());
                            m mVar5 = mVar4;
                            if (this.f12397e.isSameType(typeMirror2, this.f12401i)) {
                                bVarA2.E("providers.put($S, $T.build($T." + next3.getType() + ", $T.class, $S, $S, null, " + next3.getPriority() + ", " + next3.getExtra() + "))", next3.getRawType().toString(), cVarW, cVarW2, cVarY, next3.getPath(), next3.getGroup());
                                str = str4;
                            } else {
                                str = str4;
                                if (this.f12397e.isSubtype(typeMirror2, this.f12401i)) {
                                    bVarA2.E("providers.put($S, $T.build($T." + next3.getType() + ", $T.class, $S, $S, null, " + next3.getPriority() + ", " + next3.getExtra() + "))", typeMirror2.toString(), cVarW, cVarW2, cVarY, next3.getPath(), next3.getGroup());
                                }
                            }
                            it9 = it10;
                            mVar4 = mVar5;
                            str4 = str;
                        }
                    }
                    String str7 = str4;
                    m mVar6 = mVar4;
                    StringBuilder sb3 = new StringBuilder();
                    Map<String, Integer> paramsType = next3.getParamsType();
                    Map<String, Autowired> injectConfig = next3.getInjectConfig();
                    if (MapUtils.isNotEmpty(paramsType)) {
                        ArrayList arrayList2 = new ArrayList();
                        Iterator<Map.Entry<String, Integer>> it11 = paramsType.entrySet().iterator();
                        while (it11.hasNext()) {
                            Map.Entry<String, Integer> next4 = it11.next();
                            Iterator<Map.Entry<String, Integer>> it12 = it11;
                            sb3.append("put(\"");
                            sb3.append(next4.getKey());
                            sb3.append("\", ");
                            sb3.append(next4.getValue());
                            sb3.append("); ");
                            c0.a.C0139a c0139a = new c0.a.C0139a();
                            k.b bVar6 = bVarA2;
                            Autowired autowired2 = injectConfig.get(next4.getKey());
                            c0139a.f(next4.getKey());
                            c0139a.h(TypeKind.values()[next4.getValue().intValue()].name().toLowerCase());
                            c0139a.e(autowired2.desc());
                            c0139a.g(autowired2.required());
                            arrayList2.add(c0139a);
                            it11 = it12;
                            bVarA2 = bVar6;
                            injectConfig = injectConfig;
                        }
                        bVar = bVarA2;
                        aVarC.n(arrayList2);
                    } else {
                        bVar = bVarA2;
                    }
                    String string2 = sb3.toString();
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("atlas.put($S, $T.build($T.");
                    sb4.append(next3.getType());
                    sb4.append(", $T.class, $S, $S, ");
                    sb4.append(StringUtils.isEmpty(string2) ? null : "new java.util.HashMap<String, Integer>(){{" + sb3.toString() + "}}");
                    sb4.append(", ");
                    sb4.append(next3.getPriority());
                    sb4.append(", ");
                    sb4.append(next3.getExtra());
                    sb4.append("))");
                    bVarA3.E(sb4.toString(), next3.getPath(), cVarW, cVarW2, cVarY, next3.getPath().toLowerCase(), next3.getGroup().toLowerCase());
                    aVarC.j(cVarY.toString());
                    arrayList.add(aVarC);
                    cls4 = cls5;
                    it5 = it7;
                    it6 = it8;
                    mVar4 = mVar6;
                    str4 = str7;
                    bVarA2 = bVar;
                }
                k.b bVar7 = bVarA2;
                String str8 = com.alibaba.android.arouter.compiler.utils.a.f12415i + key;
                j.a("com.alibaba.android.arouter.routes", p.e(str8).C(com.alibaba.android.arouter.compiler.utils.a.f12410d, new Object[0]).I(com.squareup.javapoet.c.y(typeElement)).F(Modifier.PUBLIC).D(bVarA3.I()).P()).m().h(this.f12395c);
                this.f12396d.d(">>> Generated group: " + key + "<<<");
                this.f12394b.put(key, str8);
                map3.put(key, arrayList);
                cls4 = cls4;
                it5 = it5;
                mVar3 = mVar4;
                str4 = str4;
                bVarA2 = bVar7;
            }
            k.b bVar8 = bVarA2;
            String str9 = str4;
            if (MapUtils.isNotEmpty(this.f12394b)) {
                for (Map.Entry<String, String> entry : this.f12394b.entrySet()) {
                    bVar5.E("routes.put($S, $T.class)", entry.getKey(), com.squareup.javapoet.c.x("com.alibaba.android.arouter.routes", entry.getValue(), new String[0]));
                }
            }
            if (this.f12402j) {
                this.f12403k.append((CharSequence) com.alibaba.fastjson.a.H0(map3, k1.PrettyFormat));
                this.f12403k.flush();
                this.f12403k.close();
            }
            String str10 = "ARouter$$Providers$$" + this.f12400h;
            j.a("com.alibaba.android.arouter.routes", p.e(str10).C(com.alibaba.android.arouter.compiler.utils.a.f12410d, new Object[0]).I(com.squareup.javapoet.c.y(typeElement2)).F(Modifier.PUBLIC).D(bVar8.I()).P()).m().h(this.f12395c);
            this.f12396d.d(">>> Generated provider map, name is " + str10 + str9);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("ARouter$$Root$$");
            sb5.append(this.f12400h);
            String string3 = sb5.toString();
            j.a("com.alibaba.android.arouter.routes", p.e(string3).C(com.alibaba.android.arouter.compiler.utils.a.f12410d, new Object[0]).I(com.squareup.javapoet.c.y(this.f12398f.getTypeElement(com.alibaba.android.arouter.compiler.utils.a.K))).F(Modifier.PUBLIC).D(bVar5.I()).P()).m().h(this.f12395c);
            this.f12396d.d(">>> Generated root, name is " + string3 + str9);
        }
    }

    private boolean g(RouteMeta routeMeta) {
        String path = routeMeta.getPath();
        if (StringUtils.isEmpty(path) || !path.startsWith("/")) {
            return false;
        }
        if (!StringUtils.isEmpty(routeMeta.getGroup())) {
            return true;
        }
        try {
            String strSubstring = path.substring(1, path.indexOf("/", 1));
            if (StringUtils.isEmpty(strSubstring)) {
                return false;
            }
            routeMeta.setGroup(strSubstring);
            return true;
        } catch (Exception e8) {
            this.f12396d.a("Failed to extract default group! " + e8.getMessage());
            return false;
        }
    }

    public synchronized void d(ProcessingEnvironment processingEnvironment) {
        super.init(processingEnvironment);
        this.f12395c = processingEnvironment.getFiler();
        this.f12397e = processingEnvironment.getTypeUtils();
        Elements elementUtils = processingEnvironment.getElementUtils();
        this.f12398f = elementUtils;
        this.f12399g = new com.alibaba.android.arouter.compiler.utils.c(this.f12397e, elementUtils);
        this.f12396d = new com.alibaba.android.arouter.compiler.utils.b(processingEnvironment.getMessager());
        Map options = processingEnvironment.getOptions();
        if (MapUtils.isNotEmpty(options)) {
            this.f12400h = (String) options.get(com.alibaba.android.arouter.compiler.utils.a.P);
            this.f12402j = com.alibaba.android.arouter.compiler.utils.a.R.equals(options.get(com.alibaba.android.arouter.compiler.utils.a.Q));
        }
        if (!StringUtils.isNotEmpty(this.f12400h)) {
            this.f12396d.a("These no module name, at 'build.gradle', like :\nandroid {\n    defaultConfig {\n        ...\n        javaCompileOptions {\n            annotationProcessorOptions {\n                arguments = [AROUTER_MODULE_NAME: project.getName()]\n            }\n        }\n    }\n}\n");
            throw new RuntimeException("ARouter::Compiler >>> No module name, for more information, look at gradle log.");
        }
        this.f12400h = this.f12400h.replaceAll("[^0-9a-zA-Z_]+", "");
        this.f12396d.d("The user has configuration the module name, it was [" + this.f12400h + "]");
        if (this.f12402j) {
            try {
                this.f12403k = this.f12395c.createResource(StandardLocation.SOURCE_OUTPUT, com.alibaba.android.arouter.compiler.utils.a.f12419m, "arouter-map-of-" + this.f12400h + ".json", new Element[0]).openWriter();
            } catch (IOException e8) {
                this.f12396d.a("Create doc writer failed, because " + e8.getMessage());
            }
        }
        this.f12401i = this.f12398f.getTypeElement(com.alibaba.android.arouter.compiler.utils.a.G).asType();
        this.f12396d.d(">>> RouteProcessor init. <<<");
    }

    public boolean f(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        if (!CollectionUtils.isNotEmpty(set)) {
            return false;
        }
        Set<? extends Element> elementsAnnotatedWith = roundEnvironment.getElementsAnnotatedWith(Route.class);
        try {
            this.f12396d.d(">>> Found routes, start... <<<");
            e(elementsAnnotatedWith);
            return true;
        } catch (Exception e8) {
            this.f12396d.b(e8);
            return true;
        }
    }
}
