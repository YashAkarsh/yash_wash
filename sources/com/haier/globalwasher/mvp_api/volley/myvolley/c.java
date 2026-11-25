package com.haier.globalwasher.mvp_api.volley.myvolley;

import com.haier.globalwasher.modle.utils.c0;
import com.haier.globalwasher.modle.utils.m0;
import com.haier.globalwasher.modle.utils.q;
import com.haier.globalwasher.mvp_api.moudle.BaseBeen;
import com.haier.globalwasher.mvp_api.moudle.BaseData;
import com.haier.globalwasher.mvp_api.moudle.BaseListDate;
import com.haier.globalwasher.mvp_api.volley.l;
import com.haier.globalwasher.mvp_api.volley.n;
import com.haier.globalwasher.mvp_api.volley.p;
import com.haier.globalwasher.mvp_api.volley.u;
import com.haier.globalwasher.mvp_api.volley.v;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.codec.binary.Base64;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class c<T> extends n<T> {
    public static final int B = 1;
    public static final int C = 2;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final String f24854r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final com.haier.globalwasher.mvp_api.moudle.b<T> f24855s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final String f24856t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private com.google.gson.f f24857u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private Class<T> f24858v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private com.google.gson.reflect.a<T> f24859w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private Class f24860x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f24861y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private Map<String, String> f24862z;
    private static final String A = "utf-8";
    private static final String D = String.format("application/json; charset=%s", A);

    class a implements ParameterizedType {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Class f24863a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Type[] f24864b;

        a(Class cls, Type[] typeArr) {
            this.f24863a = cls;
            this.f24864b = typeArr;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            return this.f24864b;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getOwnerType() {
            return null;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            return this.f24863a;
        }
    }

    public c(int i7, String str, Class<T> cls, String str2, com.haier.globalwasher.mvp_api.moudle.b<T> bVar) {
        super(i7, U(str.trim(), null), bVar);
        this.f24854r = "GsonRequest";
        this.f24858v = null;
        this.f24861y = 2;
        this.f24862z = new HashMap();
        this.f24857u = new com.google.gson.f();
        this.f24858v = cls;
        this.f24855s = bVar;
        this.f24856t = str2;
        c0.e(false);
    }

    private static String U(String str, Map<String, String> map) {
        return str;
    }

    private ParameterizedType V(Class cls, Type... typeArr) {
        return new a(cls, typeArr);
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0180  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.haier.globalwasher.mvp_api.volley.n
    protected p<T> L(com.haier.globalwasher.mvp_api.volley.j jVar) {
        Object objN;
        Object objN2;
        try {
            String str = new String(jVar.f24843b, com.haier.globalwasher.mvp_api.volley.toolbox.i.b(jVar.f24844c));
            q.a("GsonRequest", "1111----" + str);
            BaseBeen baseBeen = (BaseBeen) this.f24857u.o(str, V(BaseBeen.class, new Type[0]));
            if (baseBeen.getRetSign() == null || "".equals(baseBeen.getRetSign()) || "null".equals(baseBeen.getRetSign())) {
                Class cls = this.f24860x;
                if (cls != null) {
                    int i7 = this.f24861y;
                    if (i7 == 1) {
                        objN = this.f24857u.o(str, V(BaseData.class, cls));
                    } else if (i7 == 2) {
                        objN = this.f24857u.o(str, V(BaseListDate.class, cls));
                    } else {
                        objN = null;
                    }
                } else {
                    objN = this.f24857u.n(str, BaseData.class);
                }
            } else {
                boolean zE = m0.e(i2.a.f34108j, Base64.decodeBase64(baseBeen.getRetData().getBytes("UTF-8")), Base64.decodeBase64(baseBeen.getRetSign().getBytes("UTF-8")));
                q.a("GsonRequest", "boo===" + zE);
                if (!zE) {
                    return p.a(new l(new Exception("验签失败，非法请求！")));
                }
                String retData = baseBeen.getRetData();
                String str2 = new String(m0.a(i2.a.f34111k.getBytes(), Base64.decodeBase64(baseBeen.getRetData().getBytes("UTF-8"))), "UTF-8");
                String strReplace = str.replace(retData, str2);
                q.c("GsonRequest", "" + strReplace);
                if (this.f24860x != null) {
                    int i8 = this.f24861y;
                    if (i8 == 1) {
                        JSONObject jSONObject = new JSONObject(str2);
                        JSONObject jSONObject2 = new JSONObject(str);
                        jSONObject2.put("retData", jSONObject);
                        ParameterizedType parameterizedTypeV = V(BaseData.class, this.f24860x);
                        q.a("GsonRequest", "" + jSONObject2.toString());
                        objN2 = this.f24857u.o(jSONObject2.toString(), parameterizedTypeV);
                    } else if (i8 == 2) {
                        JSONArray jSONArray = new JSONArray(str2);
                        q.c("GsonRequest", "" + jSONArray);
                        JSONObject jSONObject3 = new JSONObject(str);
                        jSONObject3.put("retData", jSONArray);
                        objN2 = this.f24857u.o(jSONObject3.toString(), V(BaseListDate.class, this.f24860x));
                    } else {
                        objN = null;
                    }
                } else {
                    objN2 = this.f24857u.n(strReplace, BaseBeen.class);
                }
                objN = objN2;
            }
            return p.c(objN, com.haier.globalwasher.mvp_api.volley.toolbox.i.a(jVar));
        } catch (Exception e8) {
            q.c("GsonRequest", "  GsonRequest " + e8.toString());
            return p.a(new l(e8));
        }
    }

    @Override // com.haier.globalwasher.mvp_api.volley.n
    public void f(u uVar) {
        c0.e(true);
        super.f(uVar);
    }

    @Override // com.haier.globalwasher.mvp_api.volley.n
    protected void g(T t7) {
        c0.e(true);
        if (this.f24855s != null) {
            q.c("GsonRequest", "RequestNetWork_deliverResponse" + t7.toString());
            this.f24855s.b(t7);
        }
    }

    @Override // com.haier.globalwasher.mvp_api.volley.n
    public byte[] k() {
        try {
            String str = this.f24856t;
            if (str == null) {
                return null;
            }
            return str.getBytes(A);
        } catch (UnsupportedEncodingException unused) {
            v.g("Unsupported Encoding while trying to get the bytes of %s using %s", this.f24856t, A);
            return null;
        }
    }

    @Override // com.haier.globalwasher.mvp_api.volley.n
    public String l() {
        return D;
    }

    @Override // com.haier.globalwasher.mvp_api.volley.n
    public Map<String, String> p() throws com.haier.globalwasher.mvp_api.volley.a {
        return this.f24862z;
    }

    public c(int i7, String str, Map<String, String> map, com.google.gson.reflect.a<T> aVar, String str2, com.haier.globalwasher.mvp_api.moudle.b<T> bVar, Class cls) {
        super(i7, U(str.trim(), map), bVar);
        this.f24854r = "GsonRequest";
        this.f24858v = null;
        this.f24861y = 2;
        this.f24862z = new HashMap();
        q.a("url:", "" + U(str.trim(), map));
        this.f24857u = new com.google.gson.f();
        this.f24860x = cls;
        this.f24859w = aVar;
        this.f24855s = bVar;
        this.f24856t = str2;
        this.f24862z = map;
        c0.e(false);
    }

    public c(int i7, String str, com.haier.globalwasher.mvp_api.moudle.b<T> bVar, Class cls, int i8) {
        super(i7, str, bVar);
        this.f24854r = "GsonRequest";
        this.f24858v = null;
        this.f24861y = 2;
        this.f24862z = new HashMap();
        this.f24857u = new com.google.gson.f();
        this.f24860x = cls;
        this.f24855s = bVar;
        this.f24856t = "";
        this.f24862z = this.f24862z;
        this.f24861y = i8;
        c0.e(false);
    }

    public c(int i7, String str, com.google.gson.reflect.a<T> aVar, String str2, com.haier.globalwasher.mvp_api.moudle.b<T> bVar) {
        super(i7, U(str.trim(), null), bVar);
        this.f24854r = "GsonRequest";
        this.f24858v = null;
        this.f24861y = 2;
        this.f24862z = new HashMap();
        this.f24857u = new com.google.gson.f();
        this.f24859w = aVar;
        this.f24855s = bVar;
        this.f24856t = str2;
        c0.e(false);
    }
}
