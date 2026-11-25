package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

/* JADX INFO: loaded from: classes3.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<Method, t<?, ?>> f40234a = new ConcurrentHashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Call.Factory f40235b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final HttpUrl f40236c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final List<e.a> f40237d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final List<c.a> f40238e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    final Executor f40239f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final boolean f40240g;

    class a implements InvocationHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final k f40241a = k.d();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Class f40242b;

        a(Class cls) {
            this.f40242b = cls;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, @Nullable Object[] objArr) throws Throwable {
            if (method.getDeclaringClass() == Object.class) {
                return method.invoke(this, objArr);
            }
            if (this.f40241a.f(method)) {
                return this.f40241a.e(method, this.f40242b, obj, objArr);
            }
            t<?, ?> tVarI = s.this.i(method);
            return tVarI.f40255b.b(new i(tVarI, objArr));
        }
    }

    s(Call.Factory factory, HttpUrl httpUrl, List<e.a> list, List<c.a> list2, @Nullable Executor executor, boolean z7) {
        this.f40235b = factory;
        this.f40236c = httpUrl;
        this.f40237d = Collections.unmodifiableList(list);
        this.f40238e = Collections.unmodifiableList(list2);
        this.f40239f = executor;
        this.f40240g = z7;
    }

    private void h(Class<?> cls) {
        k kVarD = k.d();
        for (Method method : cls.getDeclaredMethods()) {
            if (!kVarD.f(method)) {
                i(method);
            }
        }
    }

    public HttpUrl a() {
        return this.f40236c;
    }

    public c<?, ?> b(Type type, Annotation[] annotationArr) {
        return k(null, type, annotationArr);
    }

    public List<c.a> c() {
        return this.f40238e;
    }

    public Call.Factory d() {
        return this.f40235b;
    }

    @Nullable
    public Executor e() {
        return this.f40239f;
    }

    public List<e.a> f() {
        return this.f40237d;
    }

    public <T> T g(Class<T> cls) {
        u.s(cls);
        if (this.f40240g) {
            h(cls);
        }
        return (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new a(cls));
    }

    t<?, ?> i(Method method) {
        t tVarA;
        t<?, ?> tVar = this.f40234a.get(method);
        if (tVar != null) {
            return tVar;
        }
        synchronized (this.f40234a) {
            tVarA = this.f40234a.get(method);
            if (tVarA == null) {
                tVarA = new t.a(this, method).a();
                this.f40234a.put(method, tVarA);
            }
        }
        return tVarA;
    }

    public b j() {
        return new b(this);
    }

    public c<?, ?> k(@Nullable c.a aVar, Type type, Annotation[] annotationArr) {
        u.b(type, "returnType == null");
        u.b(annotationArr, "annotations == null");
        int iIndexOf = this.f40238e.indexOf(aVar) + 1;
        int size = this.f40238e.size();
        for (int i7 = iIndexOf; i7 < size; i7++) {
            c<?, ?> cVarA = this.f40238e.get(i7).a(type, annotationArr, this);
            if (cVarA != null) {
                return cVarA;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate call adapter for ");
        sb.append(type);
        sb.append(".\n");
        if (aVar != null) {
            sb.append("  Skipped:");
            for (int i8 = 0; i8 < iIndexOf; i8++) {
                sb.append("\n   * ");
                sb.append(this.f40238e.get(i8).getClass().getName());
            }
            sb.append('\n');
        }
        sb.append("  Tried:");
        int size2 = this.f40238e.size();
        while (iIndexOf < size2) {
            sb.append("\n   * ");
            sb.append(this.f40238e.get(iIndexOf).getClass().getName());
            iIndexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }

    public <T> e<T, RequestBody> l(@Nullable e.a aVar, Type type, Annotation[] annotationArr, Annotation[] annotationArr2) {
        u.b(type, "type == null");
        u.b(annotationArr, "parameterAnnotations == null");
        u.b(annotationArr2, "methodAnnotations == null");
        int iIndexOf = this.f40237d.indexOf(aVar) + 1;
        int size = this.f40237d.size();
        for (int i7 = iIndexOf; i7 < size; i7++) {
            e<T, RequestBody> eVar = (e<T, RequestBody>) this.f40237d.get(i7).c(type, annotationArr, annotationArr2, this);
            if (eVar != null) {
                return eVar;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate RequestBody converter for ");
        sb.append(type);
        sb.append(".\n");
        if (aVar != null) {
            sb.append("  Skipped:");
            for (int i8 = 0; i8 < iIndexOf; i8++) {
                sb.append("\n   * ");
                sb.append(this.f40237d.get(i8).getClass().getName());
            }
            sb.append('\n');
        }
        sb.append("  Tried:");
        int size2 = this.f40237d.size();
        while (iIndexOf < size2) {
            sb.append("\n   * ");
            sb.append(this.f40237d.get(iIndexOf).getClass().getName());
            iIndexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }

    public <T> e<ResponseBody, T> m(@Nullable e.a aVar, Type type, Annotation[] annotationArr) {
        u.b(type, "type == null");
        u.b(annotationArr, "annotations == null");
        int iIndexOf = this.f40237d.indexOf(aVar) + 1;
        int size = this.f40237d.size();
        for (int i7 = iIndexOf; i7 < size; i7++) {
            e<ResponseBody, T> eVar = (e<ResponseBody, T>) this.f40237d.get(i7).d(type, annotationArr, this);
            if (eVar != null) {
                return eVar;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate ResponseBody converter for ");
        sb.append(type);
        sb.append(".\n");
        if (aVar != null) {
            sb.append("  Skipped:");
            for (int i8 = 0; i8 < iIndexOf; i8++) {
                sb.append("\n   * ");
                sb.append(this.f40237d.get(i8).getClass().getName());
            }
            sb.append('\n');
        }
        sb.append("  Tried:");
        int size2 = this.f40237d.size();
        while (iIndexOf < size2) {
            sb.append("\n   * ");
            sb.append(this.f40237d.get(iIndexOf).getClass().getName());
            iIndexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }

    public <T> e<T, RequestBody> n(Type type, Annotation[] annotationArr, Annotation[] annotationArr2) {
        return l(null, type, annotationArr, annotationArr2);
    }

    public <T> e<ResponseBody, T> o(Type type, Annotation[] annotationArr) {
        return m(null, type, annotationArr);
    }

    public <T> e<T, String> p(Type type, Annotation[] annotationArr) {
        u.b(type, "type == null");
        u.b(annotationArr, "annotations == null");
        int size = this.f40237d.size();
        for (int i7 = 0; i7 < size; i7++) {
            e<T, String> eVar = (e<T, String>) this.f40237d.get(i7).e(type, annotationArr, this);
            if (eVar != null) {
                return eVar;
            }
        }
        return retrofit2.a.d.f40150a;
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final k f40244a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        private Call.Factory f40245b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private HttpUrl f40246c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final List<e.a> f40247d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final List<c.a> f40248e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @Nullable
        private Executor f40249f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f40250g;

        b(k kVar) {
            ArrayList arrayList = new ArrayList();
            this.f40247d = arrayList;
            this.f40248e = new ArrayList();
            this.f40244a = kVar;
            arrayList.add(new retrofit2.a());
        }

        public b a(c.a aVar) {
            this.f40248e.add((c.a) u.b(aVar, "factory == null"));
            return this;
        }

        public b b(e.a aVar) {
            this.f40247d.add((e.a) u.b(aVar, "factory == null"));
            return this;
        }

        public b c(String str) {
            u.b(str, "baseUrl == null");
            HttpUrl httpUrl = HttpUrl.parse(str);
            if (httpUrl != null) {
                return d(httpUrl);
            }
            throw new IllegalArgumentException("Illegal URL: " + str);
        }

        public b d(HttpUrl httpUrl) {
            u.b(httpUrl, "baseUrl == null");
            List<String> listPathSegments = httpUrl.pathSegments();
            if ("".equals(listPathSegments.get(listPathSegments.size() - 1))) {
                this.f40246c = httpUrl;
                return this;
            }
            throw new IllegalArgumentException("baseUrl must end in /: " + httpUrl);
        }

        public s e() {
            if (this.f40246c == null) {
                throw new IllegalStateException("Base URL required.");
            }
            Call.Factory okHttpClient = this.f40245b;
            if (okHttpClient == null) {
                okHttpClient = new OkHttpClient();
            }
            Call.Factory factory = okHttpClient;
            Executor executorB = this.f40249f;
            if (executorB == null) {
                executorB = this.f40244a.b();
            }
            Executor executor = executorB;
            ArrayList arrayList = new ArrayList(this.f40248e);
            arrayList.add(this.f40244a.a(executor));
            return new s(factory, this.f40246c, new ArrayList(this.f40247d), arrayList, executor, this.f40250g);
        }

        public b f(Call.Factory factory) {
            this.f40245b = (Call.Factory) u.b(factory, "factory == null");
            return this;
        }

        public b g(Executor executor) {
            this.f40249f = (Executor) u.b(executor, "executor == null");
            return this;
        }

        public b h(OkHttpClient okHttpClient) {
            return f((Call.Factory) u.b(okHttpClient, "client == null"));
        }

        public b i(boolean z7) {
            this.f40250g = z7;
            return this;
        }

        public b() {
            this(k.d());
        }

        b(s sVar) {
            ArrayList arrayList = new ArrayList();
            this.f40247d = arrayList;
            ArrayList arrayList2 = new ArrayList();
            this.f40248e = arrayList2;
            this.f40244a = k.d();
            this.f40245b = sVar.f40235b;
            this.f40246c = sVar.f40236c;
            arrayList.addAll(sVar.f40237d);
            arrayList2.addAll(sVar.f40238e);
            arrayList2.remove(arrayList2.size() - 1);
            this.f40249f = sVar.f40239f;
            this.f40250g = sVar.f40240g;
        }
    }
}
