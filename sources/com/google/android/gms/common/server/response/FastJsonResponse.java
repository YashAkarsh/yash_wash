package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.util.Log;
import c.m0;
import c.o0;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.u;
import com.google.android.gms.common.internal.y;
import com.google.android.gms.common.server.converter.zaa;
import g1.d0;
import g1.r;
import g1.s;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@c1.a
@y
public abstract class FastJsonResponse {

    @y
    public interface a<I, O> {
        int b();

        int e();

        @m0
        I f(@m0 O o7);

        @o0
        O g(@m0 I i7);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @m0
    protected static final <O, I> I w(@m0 Field<I, O> field, @o0 Object obj) {
        return ((Field) field).f15922k != null ? field.e1(obj) : obj;
    }

    private final <I, O> void x(Field<I, O> field, @o0 I i7) {
        String str = field.f15917f;
        O oD1 = field.d1(i7);
        int i8 = field.f15915d;
        switch (i8) {
            case 0:
                if (oD1 != null) {
                    k(field, str, ((Integer) oD1).intValue());
                    return;
                } else {
                    z(str);
                    return;
                }
            case 1:
                G(field, str, (BigInteger) oD1);
                return;
            case 2:
                if (oD1 != null) {
                    l(field, str, ((Long) oD1).longValue());
                    return;
                } else {
                    z(str);
                    return;
                }
            case 3:
            default:
                StringBuilder sb = new StringBuilder(44);
                sb.append("Unsupported type for conversion: ");
                sb.append(i8);
                throw new IllegalStateException(sb.toString());
            case 4:
                if (oD1 != null) {
                    P(field, str, ((Double) oD1).doubleValue());
                    return;
                } else {
                    z(str);
                    return;
                }
            case 5:
                B(field, str, (BigDecimal) oD1);
                return;
            case 6:
                if (oD1 != null) {
                    i(field, str, ((Boolean) oD1).booleanValue());
                    return;
                } else {
                    z(str);
                    return;
                }
            case 7:
                n(field, str, (String) oD1);
                return;
            case 8:
            case 9:
                if (oD1 != null) {
                    j(field, str, (byte[]) oD1);
                    return;
                } else {
                    z(str);
                    return;
                }
        }
    }

    private static final void y(StringBuilder sb, Field field, Object obj) {
        int i7 = field.f15913b;
        if (i7 == 11) {
            Class<? extends FastJsonResponse> cls = field.f15919h;
            u.k(cls);
            sb.append(cls.cast(obj).toString());
        } else {
            if (i7 != 7) {
                sb.append(obj);
                return;
            }
            sb.append("\"");
            sb.append(r.b((String) obj));
            sb.append("\"");
        }
    }

    private static final <O> void z(String str) {
        if (Log.isLoggable("FastJsonResponse", 6)) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 58);
            sb.append("Output field (");
            sb.append(str);
            sb.append(") has a null value, but expected a primitive");
            Log.e("FastJsonResponse", sb.toString());
        }
    }

    public final <O> void A(@m0 Field<BigDecimal, O> field, @o0 BigDecimal bigDecimal) {
        if (((Field) field).f15922k != null) {
            x(field, bigDecimal);
        } else {
            B(field, field.f15917f, bigDecimal);
        }
    }

    protected void B(@m0 Field<?, ?> field, @m0 String str, @o0 BigDecimal bigDecimal) {
        throw new UnsupportedOperationException("BigDecimal not supported");
    }

    public final <O> void D(@m0 Field<ArrayList<BigDecimal>, O> field, @o0 ArrayList<BigDecimal> arrayList) {
        if (((Field) field).f15922k != null) {
            x(field, arrayList);
        } else {
            E(field, field.f15917f, arrayList);
        }
    }

    protected void E(@m0 Field<?, ?> field, @m0 String str, @o0 ArrayList<BigDecimal> arrayList) {
        throw new UnsupportedOperationException("BigDecimal list not supported");
    }

    public final <O> void F(@m0 Field<BigInteger, O> field, @o0 BigInteger bigInteger) {
        if (((Field) field).f15922k != null) {
            x(field, bigInteger);
        } else {
            G(field, field.f15917f, bigInteger);
        }
    }

    protected void G(@m0 Field<?, ?> field, @m0 String str, @o0 BigInteger bigInteger) {
        throw new UnsupportedOperationException("BigInteger not supported");
    }

    public final <O> void I(@m0 Field<ArrayList<BigInteger>, O> field, @o0 ArrayList<BigInteger> arrayList) {
        if (((Field) field).f15922k != null) {
            x(field, arrayList);
        } else {
            J(field, field.f15917f, arrayList);
        }
    }

    protected void J(@m0 Field<?, ?> field, @m0 String str, @o0 ArrayList<BigInteger> arrayList) {
        throw new UnsupportedOperationException("BigInteger list not supported");
    }

    public final <O> void K(@m0 Field<Boolean, O> field, boolean z7) {
        if (((Field) field).f15922k != null) {
            x(field, Boolean.valueOf(z7));
        } else {
            i(field, field.f15917f, z7);
        }
    }

    public final <O> void L(@m0 Field<ArrayList<Boolean>, O> field, @o0 ArrayList<Boolean> arrayList) {
        if (((Field) field).f15922k != null) {
            x(field, arrayList);
        } else {
            M(field, field.f15917f, arrayList);
        }
    }

    protected void M(@m0 Field<?, ?> field, @m0 String str, @o0 ArrayList<Boolean> arrayList) {
        throw new UnsupportedOperationException("Boolean list not supported");
    }

    public final <O> void N(@m0 Field<byte[], O> field, @o0 byte[] bArr) {
        if (((Field) field).f15922k != null) {
            x(field, bArr);
        } else {
            j(field, field.f15917f, bArr);
        }
    }

    public final <O> void O(@m0 Field<Double, O> field, double d8) {
        if (((Field) field).f15922k != null) {
            x(field, Double.valueOf(d8));
        } else {
            P(field, field.f15917f, d8);
        }
    }

    protected void P(@m0 Field<?, ?> field, @m0 String str, double d8) {
        throw new UnsupportedOperationException("Double not supported");
    }

    public final <O> void Q(@m0 Field<ArrayList<Double>, O> field, @o0 ArrayList<Double> arrayList) {
        if (((Field) field).f15922k != null) {
            x(field, arrayList);
        } else {
            R(field, field.f15917f, arrayList);
        }
    }

    protected void R(@m0 Field<?, ?> field, @m0 String str, @o0 ArrayList<Double> arrayList) {
        throw new UnsupportedOperationException("Double list not supported");
    }

    public final <O> void S(@m0 Field<Float, O> field, float f8) {
        if (((Field) field).f15922k != null) {
            x(field, Float.valueOf(f8));
        } else {
            T(field, field.f15917f, f8);
        }
    }

    protected void T(@m0 Field<?, ?> field, @m0 String str, float f8) {
        throw new UnsupportedOperationException("Float not supported");
    }

    public final <O> void U(@m0 Field<ArrayList<Float>, O> field, @o0 ArrayList<Float> arrayList) {
        if (((Field) field).f15922k != null) {
            x(field, arrayList);
        } else {
            V(field, field.f15917f, arrayList);
        }
    }

    protected void V(@m0 Field<?, ?> field, @m0 String str, @o0 ArrayList<Float> arrayList) {
        throw new UnsupportedOperationException("Float list not supported");
    }

    public final <O> void W(@m0 Field<Integer, O> field, int i7) {
        if (((Field) field).f15922k != null) {
            x(field, Integer.valueOf(i7));
        } else {
            k(field, field.f15917f, i7);
        }
    }

    public final <O> void X(@m0 Field<ArrayList<Integer>, O> field, @o0 ArrayList<Integer> arrayList) {
        if (((Field) field).f15922k != null) {
            x(field, arrayList);
        } else {
            Y(field, field.f15917f, arrayList);
        }
    }

    protected void Y(@m0 Field<?, ?> field, @m0 String str, @o0 ArrayList<Integer> arrayList) {
        throw new UnsupportedOperationException("Integer list not supported");
    }

    public final <O> void Z(@m0 Field<Long, O> field, long j7) {
        if (((Field) field).f15922k != null) {
            x(field, Long.valueOf(j7));
        } else {
            l(field, field.f15917f, j7);
        }
    }

    @c1.a
    public <T extends FastJsonResponse> void a(@m0 Field field, @m0 String str, @o0 ArrayList<T> arrayList) {
        throw new UnsupportedOperationException("Concrete type array not supported");
    }

    public final <O> void a0(@m0 Field<ArrayList<Long>, O> field, @o0 ArrayList<Long> arrayList) {
        if (((Field) field).f15922k != null) {
            x(field, arrayList);
        } else {
            b0(field, field.f15917f, arrayList);
        }
    }

    @c1.a
    public <T extends FastJsonResponse> void b(@m0 Field field, @m0 String str, @m0 T t7) {
        throw new UnsupportedOperationException("Concrete type not supported");
    }

    protected void b0(@m0 Field<?, ?> field, @m0 String str, @o0 ArrayList<Long> arrayList) {
        throw new UnsupportedOperationException("Long list not supported");
    }

    @c1.a
    @m0
    public abstract Map<String, Field<?, ?>> d();

    @o0
    @c1.a
    protected Object e(@m0 Field field) {
        String str = field.f15917f;
        if (field.f15919h == null) {
            return f(str);
        }
        u.s(f(str) == null, "Concrete field shouldn't be value object: %s", field.f15917f);
        try {
            char upperCase = Character.toUpperCase(str.charAt(0));
            String strSubstring = str.substring(1);
            StringBuilder sb = new StringBuilder(String.valueOf(strSubstring).length() + 4);
            sb.append("get");
            sb.append(upperCase);
            sb.append(strSubstring);
            return getClass().getMethod(sb.toString(), new Class[0]).invoke(this, new Object[0]);
        } catch (Exception e8) {
            throw new RuntimeException(e8);
        }
    }

    @o0
    @c1.a
    protected abstract Object f(@m0 String str);

    @c1.a
    protected boolean g(@m0 Field field) {
        if (field.f15915d != 11) {
            return h(field.f15917f);
        }
        if (field.f15916e) {
            throw new UnsupportedOperationException("Concrete type arrays not supported");
        }
        throw new UnsupportedOperationException("Concrete types not supported");
    }

    @c1.a
    protected abstract boolean h(@m0 String str);

    @c1.a
    protected void i(@m0 Field<?, ?> field, @m0 String str, boolean z7) {
        throw new UnsupportedOperationException("Boolean not supported");
    }

    @c1.a
    protected void j(@m0 Field<?, ?> field, @m0 String str, @o0 byte[] bArr) {
        throw new UnsupportedOperationException("byte[] not supported");
    }

    @c1.a
    protected void k(@m0 Field<?, ?> field, @m0 String str, int i7) {
        throw new UnsupportedOperationException("Integer not supported");
    }

    @c1.a
    protected void l(@m0 Field<?, ?> field, @m0 String str, long j7) {
        throw new UnsupportedOperationException("Long not supported");
    }

    @c1.a
    protected void n(@m0 Field<?, ?> field, @m0 String str, @o0 String str2) {
        throw new UnsupportedOperationException("String not supported");
    }

    @c1.a
    protected void o(@m0 Field<?, ?> field, @m0 String str, @o0 Map<String, String> map) {
        throw new UnsupportedOperationException("String map not supported");
    }

    @c1.a
    protected void p(@m0 Field<?, ?> field, @m0 String str, @o0 ArrayList<String> arrayList) {
        throw new UnsupportedOperationException("String list not supported");
    }

    public final <O> void s(@m0 Field<String, O> field, @o0 String str) {
        if (((Field) field).f15922k != null) {
            x(field, str);
        } else {
            n(field, field.f15917f, str);
        }
    }

    public final <O> void t(@m0 Field<Map<String, String>, O> field, @o0 Map<String, String> map) {
        if (((Field) field).f15922k != null) {
            x(field, map);
        } else {
            o(field, field.f15917f, map);
        }
    }

    @c1.a
    @m0
    public String toString() {
        Map<String, Field<?, ?>> mapD = d();
        StringBuilder sb = new StringBuilder(100);
        for (String str : mapD.keySet()) {
            Field<?, ?> field = mapD.get(str);
            if (g(field)) {
                Object objW = w(field, e(field));
                if (sb.length() == 0) {
                    sb.append("{");
                } else {
                    sb.append(",");
                }
                sb.append("\"");
                sb.append(str);
                sb.append("\":");
                if (objW != null) {
                    switch (field.f15915d) {
                        case 8:
                            sb.append("\"");
                            sb.append(g1.c.d((byte[]) objW));
                            sb.append("\"");
                            break;
                        case 9:
                            sb.append("\"");
                            sb.append(g1.c.e((byte[]) objW));
                            sb.append("\"");
                            break;
                        case 10:
                            s.a(sb, (HashMap) objW);
                            break;
                        default:
                            if (field.f15914c) {
                                ArrayList arrayList = (ArrayList) objW;
                                sb.append("[");
                                int size = arrayList.size();
                                for (int i7 = 0; i7 < size; i7++) {
                                    if (i7 > 0) {
                                        sb.append(",");
                                    }
                                    Object obj = arrayList.get(i7);
                                    if (obj != null) {
                                        y(sb, field, obj);
                                    }
                                }
                                sb.append("]");
                            } else {
                                y(sb, field, objW);
                            }
                            break;
                    }
                } else {
                    sb.append("null");
                }
            }
        }
        if (sb.length() > 0) {
            sb.append(com.alipay.sdk.util.j.f13808d);
        } else {
            sb.append("{}");
        }
        return sb.toString();
    }

    public final <O> void u(@m0 Field<ArrayList<String>, O> field, @o0 ArrayList<String> arrayList) {
        if (((Field) field).f15922k != null) {
            x(field, arrayList);
        } else {
            p(field, field.f15917f, arrayList);
        }
    }

    @d0
    @SafeParcelable.a(creator = "FieldCreator")
    @c1.a
    @y
    public static class Field<I, O> extends AbstractSafeParcelable {
        public static final k CREATOR = new k();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SafeParcelable.g(getter = "getVersionCode", id = 1)
        private final int f15912a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @SafeParcelable.c(getter = "getTypeIn", id = 2)
        protected final int f15913b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @SafeParcelable.c(getter = "isTypeInArray", id = 3)
        protected final boolean f15914c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @SafeParcelable.c(getter = "getTypeOut", id = 4)
        protected final int f15915d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @SafeParcelable.c(getter = "isTypeOutArray", id = 5)
        protected final boolean f15916e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @m0
        @SafeParcelable.c(getter = "getOutputFieldName", id = 6)
        protected final String f15917f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @SafeParcelable.c(getter = "getSafeParcelableFieldId", id = 7)
        protected final int f15918g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @o0
        protected final Class<? extends FastJsonResponse> f15919h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @o0
        @SafeParcelable.c(getter = "getConcreteTypeName", id = 8)
        protected final String f15920i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private zan f15921j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        @o0
        @SafeParcelable.c(getter = "getWrappedConverter", id = 9, type = "com.google.android.gms.common.server.converter.ConverterWrapper")
        private a<I, O> f15922k;

        @SafeParcelable.b
        Field(@SafeParcelable.e(id = 1) int i7, @SafeParcelable.e(id = 2) int i8, @SafeParcelable.e(id = 3) boolean z7, @SafeParcelable.e(id = 4) int i9, @SafeParcelable.e(id = 5) boolean z8, @SafeParcelable.e(id = 6) String str, @SafeParcelable.e(id = 7) int i10, @o0 @SafeParcelable.e(id = 8) String str2, @o0 @SafeParcelable.e(id = 9) zaa zaaVar) {
            this.f15912a = i7;
            this.f15913b = i8;
            this.f15914c = z7;
            this.f15915d = i9;
            this.f15916e = z8;
            this.f15917f = str;
            this.f15918g = i10;
            if (str2 == null) {
                this.f15919h = null;
                this.f15920i = null;
            } else {
                this.f15919h = SafeParcelResponse.class;
                this.f15920i = str2;
            }
            if (zaaVar == null) {
                this.f15922k = null;
            } else {
                this.f15922k = (a<I, O>) zaaVar.K();
            }
        }

        @c1.a
        @m0
        public static Field<String, String> G0(@m0 String str, int i7) {
            return new Field<>(7, false, 7, false, str, i7, null, null);
        }

        @c1.a
        @m0
        public static Field<HashMap<String, String>, HashMap<String, String>> I0(@m0 String str, int i7) {
            return new Field<>(10, false, 10, false, str, i7, null, null);
        }

        @c1.a
        @m0
        public static Field<ArrayList<String>, ArrayList<String>> J0(@m0 String str, int i7) {
            return new Field<>(7, true, 7, true, str, i7, null, null);
        }

        @c1.a
        @m0
        public static Field<Boolean, Boolean> K(@m0 String str, int i7) {
            return new Field<>(6, false, 6, false, str, i7, null, null);
        }

        @c1.a
        @m0
        public static <T extends FastJsonResponse> Field<T, T> Q(@m0 String str, int i7, @m0 Class<T> cls) {
            return new Field<>(11, false, 11, false, str, i7, cls, null);
        }

        @c1.a
        @m0
        public static Field Q0(@m0 String str, int i7, @m0 a<?, ?> aVar, boolean z7) {
            aVar.b();
            aVar.e();
            return new Field(7, z7, 0, false, str, i7, null, aVar);
        }

        @c1.a
        @m0
        public static <T extends FastJsonResponse> Field<ArrayList<T>, ArrayList<T>> p0(@m0 String str, int i7, @m0 Class<T> cls) {
            return new Field<>(11, true, 11, true, str, i7, cls, null);
        }

        @c1.a
        @m0
        public static Field<Double, Double> r0(@m0 String str, int i7) {
            return new Field<>(4, false, 4, false, str, i7, null, null);
        }

        @d0
        @c1.a
        @m0
        public static Field<byte[], byte[]> s(@m0 String str, int i7) {
            return new Field<>(8, false, 8, false, str, i7, null, null);
        }

        @c1.a
        @m0
        public static Field<Float, Float> s0(@m0 String str, int i7) {
            return new Field<>(3, false, 3, false, str, i7, null, null);
        }

        @d0
        @c1.a
        @m0
        public static Field<Integer, Integer> v0(@m0 String str, int i7) {
            return new Field<>(0, false, 0, false, str, i7, null, null);
        }

        @c1.a
        @m0
        public static Field<Long, Long> x0(@m0 String str, int i7) {
            return new Field<>(2, false, 2, false, str, i7, null, null);
        }

        @c1.a
        public int L0() {
            return this.f15918g;
        }

        @o0
        final zaa T0() {
            a<I, O> aVar = this.f15922k;
            if (aVar == null) {
                return null;
            }
            return zaa.s(aVar);
        }

        @m0
        public final Field<I, O> V0() {
            return new Field<>(this.f15912a, this.f15913b, this.f15914c, this.f15915d, this.f15916e, this.f15917f, this.f15918g, this.f15920i, T0());
        }

        @m0
        public final FastJsonResponse a1() throws IllegalAccessException, InstantiationException {
            u.k(this.f15919h);
            Class<? extends FastJsonResponse> cls = this.f15919h;
            if (cls != SafeParcelResponse.class) {
                return cls.newInstance();
            }
            u.k(this.f15920i);
            u.l(this.f15921j, "The field mapping dictionary must be set if the concrete type is a SafeParcelResponse object.");
            return new SafeParcelResponse(this.f15921j, this.f15920i);
        }

        @m0
        public final O d1(@o0 I i7) {
            u.k(this.f15922k);
            return (O) u.k(this.f15922k.g(i7));
        }

        @m0
        public final I e1(@m0 O o7) {
            u.k(this.f15922k);
            return this.f15922k.f(o7);
        }

        @o0
        final String i1() {
            String str = this.f15920i;
            if (str == null) {
                return null;
            }
            return str;
        }

        @m0
        public final Map<String, Field<?, ?>> q1() {
            u.k(this.f15920i);
            u.k(this.f15921j);
            return (Map) u.k(this.f15921j.Q(this.f15920i));
        }

        public final void s1(zan zanVar) {
            this.f15921j = zanVar;
        }

        @m0
        public final String toString() {
            com.google.android.gms.common.internal.s.a aVarA = com.google.android.gms.common.internal.s.d(this).a("versionCode", Integer.valueOf(this.f15912a)).a("typeIn", Integer.valueOf(this.f15913b)).a("typeInArray", Boolean.valueOf(this.f15914c)).a("typeOut", Integer.valueOf(this.f15915d)).a("typeOutArray", Boolean.valueOf(this.f15916e)).a("outputFieldName", this.f15917f).a("safeParcelFieldId", Integer.valueOf(this.f15918g)).a("concreteTypeName", i1());
            Class<? extends FastJsonResponse> cls = this.f15919h;
            if (cls != null) {
                aVarA.a("concreteType.class", cls.getCanonicalName());
            }
            a<I, O> aVar = this.f15922k;
            if (aVar != null) {
                aVarA.a("converterName", aVar.getClass().getCanonicalName());
            }
            return aVarA.toString();
        }

        public final boolean w1() {
            return this.f15922k != null;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(@m0 Parcel parcel, int i7) {
            int iA = e1.b.a(parcel);
            e1.b.F(parcel, 1, this.f15912a);
            e1.b.F(parcel, 2, this.f15913b);
            e1.b.g(parcel, 3, this.f15914c);
            e1.b.F(parcel, 4, this.f15915d);
            e1.b.g(parcel, 5, this.f15916e);
            e1.b.Y(parcel, 6, this.f15917f, false);
            e1.b.F(parcel, 7, L0());
            e1.b.Y(parcel, 8, i1(), false);
            e1.b.S(parcel, 9, T0(), i7, false);
            e1.b.b(parcel, iA);
        }

        protected Field(int i7, boolean z7, int i8, boolean z8, @m0 String str, int i9, @o0 Class<? extends FastJsonResponse> cls, @o0 a<I, O> aVar) {
            this.f15912a = 1;
            this.f15913b = i7;
            this.f15914c = z7;
            this.f15915d = i8;
            this.f15916e = z8;
            this.f15917f = str;
            this.f15918g = i9;
            this.f15919h = cls;
            if (cls == null) {
                this.f15920i = null;
            } else {
                this.f15920i = cls.getCanonicalName();
            }
            this.f15922k = aVar;
        }
    }
}
