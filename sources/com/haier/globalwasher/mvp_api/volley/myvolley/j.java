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
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import org.apache.commons.codec.binary.Base64;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class j<T> extends n<T> {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final String f24883x = "volleyNormalRequest";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f24884y = 1;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f24885z = 2;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private Map<String, String> f24886r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private com.haier.globalwasher.mvp_api.moudle.b<T> f24887s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private Map<String, String> f24888t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private Class f24889u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f24890v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private com.google.gson.f f24891w;

    class a implements ParameterizedType {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Class f24892a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Type[] f24893b;

        a(Class cls, Type[] typeArr) {
            this.f24892a = cls;
            this.f24893b = typeArr;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            return this.f24893b;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getOwnerType() {
            return null;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            return this.f24892a;
        }
    }

    public j(String str, com.haier.globalwasher.mvp_api.moudle.b<T> bVar, Map<String, String> map, Class cls, int i7) {
        super(1, str, bVar);
        this.f24888t = new HashMap();
        this.f24889u = cls;
        this.f24890v = i7;
        this.f24887s = bVar;
        this.f24886r = map;
        this.f24891w = new com.google.gson.f();
        c0.e(false);
    }

    private ParameterizedType U(Class cls, Type... typeArr) {
        return new a(cls, typeArr);
    }

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
        try {
            String str = new String(jVar.f24843b, com.haier.globalwasher.mvp_api.volley.toolbox.i.b(jVar.f24844c));
            q.c(f24883x, str);
            BaseBeen baseBeen = (BaseBeen) this.f24891w.n(str, BaseBeen.class);
            ParameterizedType parameterizedTypeU = null;
            Object objO = null;
            if (baseBeen.getRetSign() == null || "null".equals(baseBeen.getRetSign()) || "".equals(baseBeen.getRetSign())) {
                Class cls = this.f24889u;
                if (cls != null) {
                    int i7 = this.f24890v;
                    if (i7 == 1) {
                        parameterizedTypeU = U(BaseData.class, cls);
                    } else if (i7 == 2) {
                        parameterizedTypeU = U(BaseListDate.class, cls);
                    }
                    objN = this.f24891w.o(str, parameterizedTypeU);
                } else {
                    objN = this.f24891w.n(str, BaseData.class);
                }
                return p.c(objN, com.haier.globalwasher.mvp_api.volley.toolbox.i.a(jVar));
            }
            baseBeen.getRetData();
            if (!m0.e(i2.a.f34108j, Base64.decodeBase64(baseBeen.getRetData().getBytes("UTF-8")), Base64.decodeBase64(baseBeen.getRetSign().getBytes("UTF-8")))) {
                return p.a(new l(new Exception("验签失败，非法请求！")));
            }
            String str2 = new String(m0.a(i2.a.f34111k.getBytes(), Base64.decodeBase64(baseBeen.getRetData().getBytes("UTF-8"))), "UTF-8");
            q.c("GsonRequest", str2);
            if (this.f24889u != null) {
                int i8 = this.f24890v;
                if (i8 == 1) {
                    JSONObject jSONObject = new JSONObject(str2);
                    JSONObject jSONObject2 = new JSONObject(str);
                    jSONObject2.put("retData", jSONObject);
                    objO = this.f24891w.o(jSONObject2.toString(), U(BaseData.class, this.f24889u));
                } else if (i8 == 2) {
                    JSONArray jSONArray = new JSONArray(str2);
                    q.c(f24883x, "" + jSONArray);
                    JSONObject jSONObject3 = new JSONObject(str);
                    jSONObject3.put("retData", jSONArray);
                    objO = this.f24891w.o(jSONObject3.toString(), U(BaseListDate.class, this.f24889u));
                }
            } else {
                baseBeen.setRetData(null);
                com.google.gson.f fVar = this.f24891w;
                objO = fVar.o(fVar.z(baseBeen), BaseData.class);
            }
            return p.c(objO, com.haier.globalwasher.mvp_api.volley.toolbox.i.a(jVar));
        } catch (UnsupportedEncodingException e8) {
            q.b(f24883x, "" + e8.toString());
            return p.a(new l(e8));
        } catch (IOException e9) {
            return p.a(new l(e9));
        } catch (IllegalStateException e10) {
            e = e10;
            q.b(f24883x, "-" + e.toString());
            return p.a(new l(e));
        } catch (InvalidKeyException e11) {
            return p.a(new l(e11));
        } catch (NoSuchAlgorithmException e12) {
            return p.a(new l(e12));
        } catch (SignatureException e13) {
            return p.a(new l(e13));
        } catch (InvalidKeySpecException e14) {
            return p.a(new l(e14));
        } catch (BadPaddingException e15) {
            return p.a(new l(e15));
        } catch (IllegalBlockSizeException e16) {
            return p.a(new l(e16));
        } catch (NoSuchPaddingException e17) {
            return p.a(new l(e17));
        } catch (JSONException e18) {
            e = e18;
            q.b(f24883x, "-" + e.toString());
            return p.a(new l(e));
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
        if (this.f24887s != null) {
            q.a(f24883x, t7.toString());
            this.f24887s.b(t7);
        }
    }

    @Override // com.haier.globalwasher.mvp_api.volley.n
    public Map<String, String> p() throws com.haier.globalwasher.mvp_api.volley.a {
        return this.f24888t;
    }

    @Override // com.haier.globalwasher.mvp_api.volley.n
    protected Map<String, String> t() throws com.haier.globalwasher.mvp_api.volley.a {
        return this.f24886r;
    }
}
