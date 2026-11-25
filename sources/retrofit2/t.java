package retrofit2;

import com.haier.uhome.account.api.Const;
import f7.x;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import okhttp3.Call;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.apache.http.entity.mime.MIME;

/* JADX INFO: loaded from: classes3.dex */
final class t<R, T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Call.Factory f40254a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final c<R, T> f40255b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final HttpUrl f40256c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final e<ResponseBody, R> f40257d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f40258e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f40259f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Headers f40260g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final MediaType f40261h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f40262i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final boolean f40263j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final boolean f40264k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final j<?>[] f40265l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    static final Pattern f40252n = Pattern.compile("\\{([a-zA-Z][a-zA-Z0-9_-]*)\\}");

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    static final String f40251m = "[a-zA-Z][a-zA-Z0-9_-]*";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    static final Pattern f40253o = Pattern.compile(f40251m);

    static final class a<T, R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final s f40266a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Method f40267b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Annotation[] f40268c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Annotation[][] f40269d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final Type[] f40270e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Type f40271f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        boolean f40272g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        boolean f40273h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        boolean f40274i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        boolean f40275j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        boolean f40276k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        boolean f40277l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        String f40278m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        boolean f40279n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        boolean f40280o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        boolean f40281p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        String f40282q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        Headers f40283r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        MediaType f40284s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        Set<String> f40285t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        j<?>[] f40286u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        e<ResponseBody, T> f40287v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        c<T, R> f40288w;

        a(s sVar, Method method) {
            this.f40266a = sVar;
            this.f40267b = method;
            this.f40268c = method.getAnnotations();
            this.f40270e = method.getGenericParameterTypes();
            this.f40269d = method.getParameterAnnotations();
        }

        private c<T, R> b() {
            Type genericReturnType = this.f40267b.getGenericReturnType();
            if (u.l(genericReturnType)) {
                throw d("Method return type must not include a type variable or wildcard: %s", genericReturnType);
            }
            if (genericReturnType == Void.TYPE) {
                throw d("Service methods cannot return void.", new Object[0]);
            }
            try {
                return (c<T, R>) this.f40266a.b(genericReturnType, this.f40267b.getAnnotations());
            } catch (RuntimeException e8) {
                throw e(e8, "Unable to create call adapter for %s", genericReturnType);
            }
        }

        private e<ResponseBody, T> c() {
            try {
                return this.f40266a.o(this.f40271f, this.f40267b.getAnnotations());
            } catch (RuntimeException e8) {
                throw e(e8, "Unable to create converter for %s", this.f40271f);
            }
        }

        private RuntimeException d(String str, Object... objArr) {
            return e(null, str, objArr);
        }

        private RuntimeException e(Throwable th, String str, Object... objArr) {
            return new IllegalArgumentException(String.format(str, objArr) + "\n    for method " + this.f40267b.getDeclaringClass().getSimpleName() + com.alibaba.android.arouter.utils.b.f12515h + this.f40267b.getName(), th);
        }

        private RuntimeException f(int i7, String str, Object... objArr) {
            return d(str + " (parameter #" + (i7 + 1) + ")", objArr);
        }

        private RuntimeException g(Throwable th, int i7, String str, Object... objArr) {
            return e(th, str + " (parameter #" + (i7 + 1) + ")", objArr);
        }

        private Headers h(String[] strArr) {
            Headers.Builder builder = new Headers.Builder();
            for (String str : strArr) {
                int iIndexOf = str.indexOf(58);
                if (iIndexOf == -1 || iIndexOf == 0 || iIndexOf == str.length() - 1) {
                    throw d("@Headers value must be in the form \"Name: Value\". Found: \"%s\"", str);
                }
                String strSubstring = str.substring(0, iIndexOf);
                String strTrim = str.substring(iIndexOf + 1).trim();
                if ("Content-Type".equalsIgnoreCase(strSubstring)) {
                    MediaType mediaType = MediaType.parse(strTrim);
                    if (mediaType == null) {
                        throw d("Malformed content type: %s", strTrim);
                    }
                    this.f40284s = mediaType;
                } else {
                    builder.add(strSubstring, strTrim);
                }
            }
            return builder.build();
        }

        private void i(String str, String str2, boolean z7) {
            String str3 = this.f40278m;
            if (str3 != null) {
                throw d("Only one HTTP method is allowed. Found: %s and %s.", str3, str);
            }
            this.f40278m = str;
            this.f40279n = z7;
            if (str2.isEmpty()) {
                return;
            }
            int iIndexOf = str2.indexOf(63);
            if (iIndexOf != -1 && iIndexOf < str2.length() - 1) {
                String strSubstring = str2.substring(iIndexOf + 1);
                if (t.f40252n.matcher(strSubstring).find()) {
                    throw d("URL query string \"%s\" must not have replace block. For dynamic query parameters use @Query.", strSubstring);
                }
            }
            this.f40282q = str2;
            this.f40285t = t.b(str2);
        }

        private void j(Annotation annotation) {
            if (annotation instanceof f7.b) {
                i("DELETE", ((f7.b) annotation).value(), false);
                return;
            }
            if (annotation instanceof f7.f) {
                i(Const.HTTP_REQUEST_TYPE_GET, ((f7.f) annotation).value(), false);
                return;
            }
            if (annotation instanceof f7.g) {
                i("HEAD", ((f7.g) annotation).value(), false);
                if (!Void.class.equals(this.f40271f)) {
                    throw d("HEAD method must use Void as response type.", new Object[0]);
                }
                return;
            }
            if (annotation instanceof f7.n) {
                i(com.haier.globalwasher.mvp_api.volley.toolbox.h.a.f24990a, ((f7.n) annotation).value(), true);
                return;
            }
            if (annotation instanceof f7.o) {
                i(Const.HTTP_REQUEST_TYPE_POST, ((f7.o) annotation).value(), true);
                return;
            }
            if (annotation instanceof f7.p) {
                i("PUT", ((f7.p) annotation).value(), true);
                return;
            }
            if (annotation instanceof f7.m) {
                i("OPTIONS", ((f7.m) annotation).value(), false);
                return;
            }
            if (annotation instanceof f7.h) {
                f7.h hVar = (f7.h) annotation;
                i(hVar.method(), hVar.path(), hVar.hasBody());
                return;
            }
            if (annotation instanceof f7.k) {
                String[] strArrValue = ((f7.k) annotation).value();
                if (strArrValue.length == 0) {
                    throw d("@Headers annotation is empty.", new Object[0]);
                }
                this.f40283r = h(strArrValue);
                return;
            }
            if (annotation instanceof f7.l) {
                if (this.f40280o) {
                    throw d("Only one encoding annotation is allowed.", new Object[0]);
                }
                this.f40281p = true;
            } else if (annotation instanceof f7.e) {
                if (this.f40281p) {
                    throw d("Only one encoding annotation is allowed.", new Object[0]);
                }
                this.f40280o = true;
            }
        }

        private j<?> k(int i7, Type type, Annotation[] annotationArr) {
            j<?> jVar = null;
            for (Annotation annotation : annotationArr) {
                j<?> jVarL = l(i7, type, annotationArr, annotation);
                if (jVarL != null) {
                    if (jVar != null) {
                        throw f(i7, "Multiple Retrofit annotations found, only one allowed.", new Object[0]);
                    }
                    jVar = jVarL;
                }
            }
            if (jVar != null) {
                return jVar;
            }
            throw f(i7, "No Retrofit annotation found.", new Object[0]);
        }

        private j<?> l(int i7, Type type, Annotation[] annotationArr, Annotation annotation) {
            if (annotation instanceof x) {
                if (this.f40277l) {
                    throw f(i7, "Multiple @Url method annotations found.", new Object[0]);
                }
                if (this.f40275j) {
                    throw f(i7, "@Path parameters may not be used with @Url.", new Object[0]);
                }
                if (this.f40276k) {
                    throw f(i7, "A @Url parameter must not come after a @Query", new Object[0]);
                }
                if (this.f40282q != null) {
                    throw f(i7, "@Url cannot be used with @%s URL", this.f40278m);
                }
                this.f40277l = true;
                if (type == HttpUrl.class || type == String.class || type == URI.class || ((type instanceof Class) && "android.net.Uri".equals(((Class) type).getName()))) {
                    return new j.o();
                }
                throw f(i7, "@Url must be okhttp3.HttpUrl, String, java.net.URI, or android.net.Uri type.", new Object[0]);
            }
            if (annotation instanceof f7.s) {
                if (this.f40276k) {
                    throw f(i7, "A @Path parameter must not come after a @Query.", new Object[0]);
                }
                if (this.f40277l) {
                    throw f(i7, "@Path parameters may not be used with @Url.", new Object[0]);
                }
                if (this.f40282q == null) {
                    throw f(i7, "@Path can only be used with relative url on @%s", this.f40278m);
                }
                this.f40275j = true;
                f7.s sVar = (f7.s) annotation;
                String strValue = sVar.value();
                m(i7, strValue);
                return new j.C0547j(strValue, this.f40266a.p(type, annotationArr), sVar.encoded());
            }
            if (annotation instanceof f7.t) {
                f7.t tVar = (f7.t) annotation;
                String strValue2 = tVar.value();
                boolean zEncoded = tVar.encoded();
                Class<?> clsJ = u.j(type);
                this.f40276k = true;
                if (!Iterable.class.isAssignableFrom(clsJ)) {
                    return clsJ.isArray() ? new j.k(strValue2, this.f40266a.p(t.a(clsJ.getComponentType()), annotationArr), zEncoded).b() : new j.k(strValue2, this.f40266a.p(type, annotationArr), zEncoded);
                }
                if (type instanceof ParameterizedType) {
                    return new j.k(strValue2, this.f40266a.p(u.i(0, (ParameterizedType) type), annotationArr), zEncoded).c();
                }
                throw f(i7, clsJ.getSimpleName() + " must include generic type (e.g., " + clsJ.getSimpleName() + "<String>)", new Object[0]);
            }
            if (annotation instanceof f7.v) {
                boolean zEncoded2 = ((f7.v) annotation).encoded();
                Class<?> clsJ2 = u.j(type);
                this.f40276k = true;
                if (!Iterable.class.isAssignableFrom(clsJ2)) {
                    return clsJ2.isArray() ? new j.m(this.f40266a.p(t.a(clsJ2.getComponentType()), annotationArr), zEncoded2).b() : new j.m(this.f40266a.p(type, annotationArr), zEncoded2);
                }
                if (type instanceof ParameterizedType) {
                    return new j.m(this.f40266a.p(u.i(0, (ParameterizedType) type), annotationArr), zEncoded2).c();
                }
                throw f(i7, clsJ2.getSimpleName() + " must include generic type (e.g., " + clsJ2.getSimpleName() + "<String>)", new Object[0]);
            }
            if (annotation instanceof f7.u) {
                Class<?> clsJ3 = u.j(type);
                if (!Map.class.isAssignableFrom(clsJ3)) {
                    throw f(i7, "@QueryMap parameter type must be Map.", new Object[0]);
                }
                Type typeK = u.k(type, clsJ3, Map.class);
                if (!(typeK instanceof ParameterizedType)) {
                    throw f(i7, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                ParameterizedType parameterizedType = (ParameterizedType) typeK;
                Type typeI = u.i(0, parameterizedType);
                if (String.class == typeI) {
                    return new j.l(this.f40266a.p(u.i(1, parameterizedType), annotationArr), ((f7.u) annotation).encoded());
                }
                throw f(i7, "@QueryMap keys must be of type String: " + typeI, new Object[0]);
            }
            if (annotation instanceof f7.i) {
                String strValue3 = ((f7.i) annotation).value();
                Class<?> clsJ4 = u.j(type);
                if (!Iterable.class.isAssignableFrom(clsJ4)) {
                    return clsJ4.isArray() ? new j.f(strValue3, this.f40266a.p(t.a(clsJ4.getComponentType()), annotationArr)).b() : new j.f(strValue3, this.f40266a.p(type, annotationArr));
                }
                if (type instanceof ParameterizedType) {
                    return new j.f(strValue3, this.f40266a.p(u.i(0, (ParameterizedType) type), annotationArr)).c();
                }
                throw f(i7, clsJ4.getSimpleName() + " must include generic type (e.g., " + clsJ4.getSimpleName() + "<String>)", new Object[0]);
            }
            if (annotation instanceof f7.j) {
                Class<?> clsJ5 = u.j(type);
                if (!Map.class.isAssignableFrom(clsJ5)) {
                    throw f(i7, "@HeaderMap parameter type must be Map.", new Object[0]);
                }
                Type typeK2 = u.k(type, clsJ5, Map.class);
                if (!(typeK2 instanceof ParameterizedType)) {
                    throw f(i7, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                ParameterizedType parameterizedType2 = (ParameterizedType) typeK2;
                Type typeI2 = u.i(0, parameterizedType2);
                if (String.class == typeI2) {
                    return new j.g(this.f40266a.p(u.i(1, parameterizedType2), annotationArr));
                }
                throw f(i7, "@HeaderMap keys must be of type String: " + typeI2, new Object[0]);
            }
            if (annotation instanceof f7.c) {
                if (!this.f40280o) {
                    throw f(i7, "@Field parameters can only be used with form encoding.", new Object[0]);
                }
                f7.c cVar = (f7.c) annotation;
                String strValue4 = cVar.value();
                boolean zEncoded3 = cVar.encoded();
                this.f40272g = true;
                Class<?> clsJ6 = u.j(type);
                if (!Iterable.class.isAssignableFrom(clsJ6)) {
                    return clsJ6.isArray() ? new j.d(strValue4, this.f40266a.p(t.a(clsJ6.getComponentType()), annotationArr), zEncoded3).b() : new j.d(strValue4, this.f40266a.p(type, annotationArr), zEncoded3);
                }
                if (type instanceof ParameterizedType) {
                    return new j.d(strValue4, this.f40266a.p(u.i(0, (ParameterizedType) type), annotationArr), zEncoded3).c();
                }
                throw f(i7, clsJ6.getSimpleName() + " must include generic type (e.g., " + clsJ6.getSimpleName() + "<String>)", new Object[0]);
            }
            if (annotation instanceof f7.d) {
                if (!this.f40280o) {
                    throw f(i7, "@FieldMap parameters can only be used with form encoding.", new Object[0]);
                }
                Class<?> clsJ7 = u.j(type);
                if (!Map.class.isAssignableFrom(clsJ7)) {
                    throw f(i7, "@FieldMap parameter type must be Map.", new Object[0]);
                }
                Type typeK3 = u.k(type, clsJ7, Map.class);
                if (!(typeK3 instanceof ParameterizedType)) {
                    throw f(i7, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                ParameterizedType parameterizedType3 = (ParameterizedType) typeK3;
                Type typeI3 = u.i(0, parameterizedType3);
                if (String.class == typeI3) {
                    e<T, String> eVarP = this.f40266a.p(u.i(1, parameterizedType3), annotationArr);
                    this.f40272g = true;
                    return new j.e(eVarP, ((f7.d) annotation).encoded());
                }
                throw f(i7, "@FieldMap keys must be of type String: " + typeI3, new Object[0]);
            }
            if (!(annotation instanceof f7.q)) {
                if (!(annotation instanceof f7.r)) {
                    if (!(annotation instanceof f7.a)) {
                        return null;
                    }
                    if (this.f40280o || this.f40281p) {
                        throw f(i7, "@Body parameters cannot be used with form or multi-part encoding.", new Object[0]);
                    }
                    if (this.f40274i) {
                        throw f(i7, "Multiple @Body method annotations found.", new Object[0]);
                    }
                    try {
                        e<T, RequestBody> eVarN = this.f40266a.n(type, annotationArr, this.f40268c);
                        this.f40274i = true;
                        return new j.c(eVarN);
                    } catch (RuntimeException e8) {
                        throw g(e8, i7, "Unable to create @Body converter for %s", type);
                    }
                }
                if (!this.f40281p) {
                    throw f(i7, "@PartMap parameters can only be used with multipart encoding.", new Object[0]);
                }
                this.f40273h = true;
                Class<?> clsJ8 = u.j(type);
                if (!Map.class.isAssignableFrom(clsJ8)) {
                    throw f(i7, "@PartMap parameter type must be Map.", new Object[0]);
                }
                Type typeK4 = u.k(type, clsJ8, Map.class);
                if (!(typeK4 instanceof ParameterizedType)) {
                    throw f(i7, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                ParameterizedType parameterizedType4 = (ParameterizedType) typeK4;
                Type typeI4 = u.i(0, parameterizedType4);
                if (String.class == typeI4) {
                    Type typeI5 = u.i(1, parameterizedType4);
                    if (MultipartBody.Part.class.isAssignableFrom(u.j(typeI5))) {
                        throw f(i7, "@PartMap values cannot be MultipartBody.Part. Use @Part List<Part> or a different value type instead.", new Object[0]);
                    }
                    return new j.i(this.f40266a.n(typeI5, annotationArr, this.f40268c), ((f7.r) annotation).encoding());
                }
                throw f(i7, "@PartMap keys must be of type String: " + typeI4, new Object[0]);
            }
            if (!this.f40281p) {
                throw f(i7, "@Part parameters can only be used with multipart encoding.", new Object[0]);
            }
            f7.q qVar = (f7.q) annotation;
            this.f40273h = true;
            String strValue5 = qVar.value();
            Class<?> clsJ9 = u.j(type);
            if (strValue5.isEmpty()) {
                if (!Iterable.class.isAssignableFrom(clsJ9)) {
                    if (clsJ9.isArray()) {
                        if (MultipartBody.Part.class.isAssignableFrom(clsJ9.getComponentType())) {
                            return j.n.f40214a.b();
                        }
                        throw f(i7, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                    }
                    if (MultipartBody.Part.class.isAssignableFrom(clsJ9)) {
                        return j.n.f40214a;
                    }
                    throw f(i7, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                }
                if (type instanceof ParameterizedType) {
                    if (MultipartBody.Part.class.isAssignableFrom(u.j(u.i(0, (ParameterizedType) type)))) {
                        return j.n.f40214a.c();
                    }
                    throw f(i7, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                }
                throw f(i7, clsJ9.getSimpleName() + " must include generic type (e.g., " + clsJ9.getSimpleName() + "<String>)", new Object[0]);
            }
            Headers headersOf = Headers.of("Content-Disposition", "form-data; name=\"" + strValue5 + "\"", MIME.CONTENT_TRANSFER_ENC, qVar.encoding());
            if (!Iterable.class.isAssignableFrom(clsJ9)) {
                if (!clsJ9.isArray()) {
                    if (MultipartBody.Part.class.isAssignableFrom(clsJ9)) {
                        throw f(i7, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                    }
                    return new j.h(headersOf, this.f40266a.n(type, annotationArr, this.f40268c));
                }
                Class<?> clsA = t.a(clsJ9.getComponentType());
                if (MultipartBody.Part.class.isAssignableFrom(clsA)) {
                    throw f(i7, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                }
                return new j.h(headersOf, this.f40266a.n(clsA, annotationArr, this.f40268c)).b();
            }
            if (type instanceof ParameterizedType) {
                Type typeI6 = u.i(0, (ParameterizedType) type);
                if (MultipartBody.Part.class.isAssignableFrom(u.j(typeI6))) {
                    throw f(i7, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                }
                return new j.h(headersOf, this.f40266a.n(typeI6, annotationArr, this.f40268c)).c();
            }
            throw f(i7, clsJ9.getSimpleName() + " must include generic type (e.g., " + clsJ9.getSimpleName() + "<String>)", new Object[0]);
        }

        private void m(int i7, String str) {
            if (!t.f40253o.matcher(str).matches()) {
                throw f(i7, "@Path parameter name must match %s. Found: %s", t.f40252n.pattern(), str);
            }
            if (!this.f40285t.contains(str)) {
                throw f(i7, "URL \"%s\" does not contain \"{%s}\".", this.f40282q, str);
            }
        }

        public t a() {
            c<T, R> cVarB = b();
            this.f40288w = cVarB;
            Type typeA = cVarB.a();
            this.f40271f = typeA;
            if (typeA == r.class || typeA == Response.class) {
                throw d("'" + u.j(this.f40271f).getName() + "' is not a valid response body type. Did you mean ResponseBody?", new Object[0]);
            }
            this.f40287v = c();
            for (Annotation annotation : this.f40268c) {
                j(annotation);
            }
            if (this.f40278m == null) {
                throw d("HTTP method annotation is required (e.g., @GET, @POST, etc.).", new Object[0]);
            }
            if (!this.f40279n) {
                if (this.f40281p) {
                    throw d("Multipart can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                }
                if (this.f40280o) {
                    throw d("FormUrlEncoded can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                }
            }
            int length = this.f40269d.length;
            this.f40286u = new j[length];
            for (int i7 = 0; i7 < length; i7++) {
                Type type = this.f40270e[i7];
                if (u.l(type)) {
                    throw f(i7, "Parameter type must not include a type variable or wildcard: %s", type);
                }
                Annotation[] annotationArr = this.f40269d[i7];
                if (annotationArr == null) {
                    throw f(i7, "No Retrofit annotation found.", new Object[0]);
                }
                this.f40286u[i7] = k(i7, type, annotationArr);
            }
            if (this.f40282q == null && !this.f40277l) {
                throw d("Missing either @%s URL or @Url parameter.", this.f40278m);
            }
            boolean z7 = this.f40280o;
            if (!z7 && !this.f40281p && !this.f40279n && this.f40274i) {
                throw d("Non-body HTTP method cannot contain @Body.", new Object[0]);
            }
            if (z7 && !this.f40272g) {
                throw d("Form-encoded method must contain at least one @Field.", new Object[0]);
            }
            if (!this.f40281p || this.f40273h) {
                return new t(this);
            }
            throw d("Multipart method must contain at least one @Part.", new Object[0]);
        }
    }

    t(a<R, T> aVar) {
        this.f40254a = aVar.f40266a.d();
        this.f40255b = aVar.f40288w;
        this.f40256c = aVar.f40266a.a();
        this.f40257d = aVar.f40287v;
        this.f40258e = aVar.f40278m;
        this.f40259f = aVar.f40282q;
        this.f40260g = aVar.f40283r;
        this.f40261h = aVar.f40284s;
        this.f40262i = aVar.f40279n;
        this.f40263j = aVar.f40280o;
        this.f40264k = aVar.f40281p;
        this.f40265l = aVar.f40286u;
    }

    static Class<?> a(Class<?> cls) {
        if (Boolean.TYPE == cls) {
            return Boolean.class;
        }
        if (Byte.TYPE == cls) {
            return Byte.class;
        }
        if (Character.TYPE == cls) {
            return Character.class;
        }
        if (Double.TYPE == cls) {
            return Double.class;
        }
        if (Float.TYPE == cls) {
            return Float.class;
        }
        if (Integer.TYPE == cls) {
            return Integer.class;
        }
        if (Long.TYPE == cls) {
            return Long.class;
        }
        return Short.TYPE == cls ? Short.class : cls;
    }

    static Set<String> b(String str) {
        Matcher matcher = f40252n.matcher(str);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        while (matcher.find()) {
            linkedHashSet.add(matcher.group(1));
        }
        return linkedHashSet;
    }

    Request c(@Nullable Object... objArr) throws IOException {
        q qVar = new q(this.f40258e, this.f40256c, this.f40259f, this.f40260g, this.f40261h, this.f40262i, this.f40263j, this.f40264k);
        j<?>[] jVarArr = this.f40265l;
        int length = objArr != null ? objArr.length : 0;
        if (length == jVarArr.length) {
            for (int i7 = 0; i7 < length; i7++) {
                jVarArr[i7].a(qVar, objArr[i7]);
            }
            return qVar.g();
        }
        throw new IllegalArgumentException("Argument count (" + length + ") doesn't match expected count (" + jVarArr.length + ")");
    }

    R d(ResponseBody responseBody) throws IOException {
        return this.f40257d.a(responseBody);
    }
}
