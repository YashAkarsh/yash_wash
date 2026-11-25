package com.google.android.gms.common.server.response;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import c.m0;
import c.o0;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.u;
import g1.d0;
import g1.r;
import g1.s;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.a(creator = "SafeParcelResponseCreator")
@d0
@c1.a
public class SafeParcelResponse extends FastSafeParcelableJsonResponse {

    @c1.a
    @m0
    public static final Parcelable.Creator<SafeParcelResponse> CREATOR = new o();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SafeParcelable.g(getter = "getVersionCode", id = 1)
    private final int f15923a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SafeParcelable.c(getter = "getParcel", id = 2)
    private final Parcel f15924b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f15925c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SafeParcelable.c(getter = "getFieldMappingDictionary", id = 3)
    private final zan f15926d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @o0
    private final String f15927e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f15928f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f15929g;

    @SafeParcelable.b
    SafeParcelResponse(@SafeParcelable.e(id = 1) int i7, @SafeParcelable.e(id = 2) Parcel parcel, @SafeParcelable.e(id = 3) zan zanVar) {
        this.f15923a = i7;
        this.f15924b = (Parcel) u.k(parcel);
        this.f15925c = 2;
        this.f15926d = zanVar;
        this.f15927e = zanVar == null ? null : zanVar.K();
        this.f15928f = 2;
    }

    @c1.a
    @m0
    public static <T extends FastJsonResponse & SafeParcelable> SafeParcelResponse d0(@m0 T t7) {
        String str = (String) u.k(t7.getClass().getCanonicalName());
        zan zanVar = new zan(t7.getClass());
        f0(zanVar, t7);
        zanVar.p0();
        zanVar.r0();
        return new SafeParcelResponse(t7, zanVar, str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void f0(zan zanVar, FastJsonResponse fastJsonResponse) {
        Class<?> cls = fastJsonResponse.getClass();
        if (zanVar.v0(cls)) {
            return;
        }
        Map<String, FastJsonResponse.Field<?, ?>> mapD = fastJsonResponse.d();
        zanVar.s0(cls, mapD);
        Iterator<String> it = mapD.keySet().iterator();
        while (it.hasNext()) {
            FastJsonResponse.Field<?, ?> field = mapD.get(it.next());
            Class<? extends FastJsonResponse> cls2 = field.f15919h;
            if (cls2 != null) {
                try {
                    f0(zanVar, cls2.newInstance());
                } catch (IllegalAccessException e8) {
                    String strValueOf = String.valueOf(((Class) u.k(field.f15919h)).getCanonicalName());
                    throw new IllegalStateException(strValueOf.length() != 0 ? "Could not access object of type ".concat(strValueOf) : new String("Could not access object of type "), e8);
                } catch (InstantiationException e9) {
                    String strValueOf2 = String.valueOf(((Class) u.k(field.f15919h)).getCanonicalName());
                    throw new IllegalStateException(strValueOf2.length() != 0 ? "Could not instantiate an object of type ".concat(strValueOf2) : new String("Could not instantiate an object of type "), e9);
                }
            }
        }
    }

    private final void i0(FastJsonResponse.Field<?, ?> field) {
        if (field.f15918g == -1) {
            throw new IllegalStateException("Field does not have a valid safe parcelable field id.");
        }
        Parcel parcel = this.f15924b;
        if (parcel == null) {
            throw new IllegalStateException("Internal Parcel object is null.");
        }
        int i7 = this.f15928f;
        if (i7 != 0) {
            if (i7 != 1) {
                throw new IllegalStateException("Attempted to parse JSON with a SafeParcelResponse object that is already filled with data.");
            }
        } else {
            this.f15929g = e1.b.a(parcel);
            this.f15928f = 1;
        }
    }

    private final void j0(StringBuilder sb, Map<String, FastJsonResponse.Field<?, ?>> map, Parcel parcel) {
        SparseArray sparseArray = new SparseArray();
        for (Map.Entry<String, FastJsonResponse.Field<?, ?>> entry : map.entrySet()) {
            sparseArray.put(entry.getValue().L0(), entry);
        }
        sb.append('{');
        int iI0 = e1.a.i0(parcel);
        boolean z7 = false;
        while (parcel.dataPosition() < iI0) {
            int iX = e1.a.X(parcel);
            Map.Entry entry2 = (Map.Entry) sparseArray.get(e1.a.O(iX));
            if (entry2 != null) {
                if (z7) {
                    sb.append(",");
                }
                String str = (String) entry2.getKey();
                FastJsonResponse.Field field = (FastJsonResponse.Field) entry2.getValue();
                sb.append("\"");
                sb.append(str);
                sb.append("\":");
                if (field.w1()) {
                    int i7 = field.f15915d;
                    switch (i7) {
                        case 0:
                            m0(sb, field, FastJsonResponse.w(field, Integer.valueOf(e1.a.Z(parcel, iX))));
                            break;
                        case 1:
                            m0(sb, field, FastJsonResponse.w(field, e1.a.c(parcel, iX)));
                            break;
                        case 2:
                            m0(sb, field, FastJsonResponse.w(field, Long.valueOf(e1.a.c0(parcel, iX))));
                            break;
                        case 3:
                            m0(sb, field, FastJsonResponse.w(field, Float.valueOf(e1.a.V(parcel, iX))));
                            break;
                        case 4:
                            m0(sb, field, FastJsonResponse.w(field, Double.valueOf(e1.a.T(parcel, iX))));
                            break;
                        case 5:
                            m0(sb, field, FastJsonResponse.w(field, e1.a.a(parcel, iX)));
                            break;
                        case 6:
                            m0(sb, field, FastJsonResponse.w(field, Boolean.valueOf(e1.a.P(parcel, iX))));
                            break;
                        case 7:
                            m0(sb, field, FastJsonResponse.w(field, e1.a.G(parcel, iX)));
                            break;
                        case 8:
                        case 9:
                            m0(sb, field, FastJsonResponse.w(field, e1.a.h(parcel, iX)));
                            break;
                        case 10:
                            Bundle bundleG = e1.a.g(parcel, iX);
                            HashMap map2 = new HashMap();
                            for (String str2 : bundleG.keySet()) {
                                map2.put(str2, (String) u.k(bundleG.getString(str2)));
                            }
                            m0(sb, field, FastJsonResponse.w(field, map2));
                            break;
                        case 11:
                            throw new IllegalArgumentException("Method does not accept concrete type.");
                        default:
                            StringBuilder sb2 = new StringBuilder(36);
                            sb2.append("Unknown field out type = ");
                            sb2.append(i7);
                            throw new IllegalArgumentException(sb2.toString());
                    }
                } else if (field.f15916e) {
                    sb.append("[");
                    switch (field.f15915d) {
                        case 0:
                            g1.b.l(sb, e1.a.u(parcel, iX));
                            break;
                        case 1:
                            g1.b.n(sb, e1.a.d(parcel, iX));
                            break;
                        case 2:
                            g1.b.m(sb, e1.a.w(parcel, iX));
                            break;
                        case 3:
                            g1.b.k(sb, e1.a.o(parcel, iX));
                            break;
                        case 4:
                            g1.b.j(sb, e1.a.l(parcel, iX));
                            break;
                        case 5:
                            g1.b.n(sb, e1.a.b(parcel, iX));
                            break;
                        case 6:
                            g1.b.o(sb, e1.a.e(parcel, iX));
                            break;
                        case 7:
                            g1.b.p(sb, e1.a.H(parcel, iX));
                            break;
                        case 8:
                        case 9:
                        case 10:
                            throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
                        case 11:
                            Parcel[] parcelArrZ = e1.a.z(parcel, iX);
                            int length = parcelArrZ.length;
                            for (int i8 = 0; i8 < length; i8++) {
                                if (i8 > 0) {
                                    sb.append(",");
                                }
                                parcelArrZ[i8].setDataPosition(0);
                                j0(sb, field.q1(), parcelArrZ[i8]);
                            }
                            break;
                        default:
                            throw new IllegalStateException("Unknown field type out.");
                    }
                    sb.append("]");
                } else {
                    switch (field.f15915d) {
                        case 0:
                            sb.append(e1.a.Z(parcel, iX));
                            break;
                        case 1:
                            sb.append(e1.a.c(parcel, iX));
                            break;
                        case 2:
                            sb.append(e1.a.c0(parcel, iX));
                            break;
                        case 3:
                            sb.append(e1.a.V(parcel, iX));
                            break;
                        case 4:
                            sb.append(e1.a.T(parcel, iX));
                            break;
                        case 5:
                            sb.append(e1.a.a(parcel, iX));
                            break;
                        case 6:
                            sb.append(e1.a.P(parcel, iX));
                            break;
                        case 7:
                            String strG = e1.a.G(parcel, iX);
                            sb.append("\"");
                            sb.append(r.b(strG));
                            sb.append("\"");
                            break;
                        case 8:
                            byte[] bArrH = e1.a.h(parcel, iX);
                            sb.append("\"");
                            sb.append(g1.c.d(bArrH));
                            sb.append("\"");
                            break;
                        case 9:
                            byte[] bArrH2 = e1.a.h(parcel, iX);
                            sb.append("\"");
                            sb.append(g1.c.e(bArrH2));
                            sb.append("\"");
                            break;
                        case 10:
                            Bundle bundleG2 = e1.a.g(parcel, iX);
                            Set<String> setKeySet = bundleG2.keySet();
                            sb.append("{");
                            boolean z8 = true;
                            for (String str3 : setKeySet) {
                                if (!z8) {
                                    sb.append(",");
                                }
                                sb.append("\"");
                                sb.append(str3);
                                sb.append("\":\"");
                                sb.append(r.b(bundleG2.getString(str3)));
                                sb.append("\"");
                                z8 = false;
                            }
                            sb.append(com.alipay.sdk.util.j.f13808d);
                            break;
                        case 11:
                            Parcel parcelY = e1.a.y(parcel, iX);
                            parcelY.setDataPosition(0);
                            j0(sb, field.q1(), parcelY);
                            break;
                        default:
                            throw new IllegalStateException("Unknown field type out");
                    }
                }
                z7 = true;
            }
        }
        if (parcel.dataPosition() == iI0) {
            sb.append('}');
            return;
        }
        StringBuilder sb3 = new StringBuilder(37);
        sb3.append("Overread allowed size end=");
        sb3.append(iI0);
        throw new e1.a.C0405a(sb3.toString(), parcel);
    }

    private static final void k0(StringBuilder sb, int i7, @o0 Object obj) {
        switch (i7) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                sb.append(obj);
                return;
            case 7:
                sb.append("\"");
                sb.append(r.b(u.k(obj).toString()));
                sb.append("\"");
                return;
            case 8:
                sb.append("\"");
                sb.append(g1.c.d((byte[]) obj));
                sb.append("\"");
                return;
            case 9:
                sb.append("\"");
                sb.append(g1.c.e((byte[]) obj));
                sb.append("\"");
                return;
            case 10:
                s.a(sb, (HashMap) u.k(obj));
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                StringBuilder sb2 = new StringBuilder(26);
                sb2.append("Unknown type = ");
                sb2.append(i7);
                throw new IllegalArgumentException(sb2.toString());
        }
    }

    private static final void m0(StringBuilder sb, FastJsonResponse.Field<?, ?> field, Object obj) {
        if (!field.f15914c) {
            k0(sb, field.f15913b, obj);
            return;
        }
        ArrayList arrayList = (ArrayList) obj;
        sb.append("[");
        int size = arrayList.size();
        for (int i7 = 0; i7 < size; i7++) {
            if (i7 != 0) {
                sb.append(",");
            }
            k0(sb, field.f15913b, arrayList.get(i7));
        }
        sb.append("]");
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void B(@m0 FastJsonResponse.Field<?, ?> field, @m0 String str, @o0 BigDecimal bigDecimal) {
        i0(field);
        e1.b.c(this.f15924b, field.L0(), bigDecimal, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void E(@m0 FastJsonResponse.Field<?, ?> field, @m0 String str, @o0 ArrayList<BigDecimal> arrayList) {
        i0(field);
        int size = ((ArrayList) u.k(arrayList)).size();
        BigDecimal[] bigDecimalArr = new BigDecimal[size];
        for (int i7 = 0; i7 < size; i7++) {
            bigDecimalArr[i7] = arrayList.get(i7);
        }
        e1.b.d(this.f15924b, field.L0(), bigDecimalArr, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void G(@m0 FastJsonResponse.Field<?, ?> field, @m0 String str, @o0 BigInteger bigInteger) {
        i0(field);
        e1.b.e(this.f15924b, field.L0(), bigInteger, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void J(@m0 FastJsonResponse.Field<?, ?> field, @m0 String str, @o0 ArrayList<BigInteger> arrayList) {
        i0(field);
        int size = ((ArrayList) u.k(arrayList)).size();
        BigInteger[] bigIntegerArr = new BigInteger[size];
        for (int i7 = 0; i7 < size; i7++) {
            bigIntegerArr[i7] = arrayList.get(i7);
        }
        e1.b.f(this.f15924b, field.L0(), bigIntegerArr, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void M(@m0 FastJsonResponse.Field<?, ?> field, @m0 String str, @o0 ArrayList<Boolean> arrayList) {
        i0(field);
        int size = ((ArrayList) u.k(arrayList)).size();
        boolean[] zArr = new boolean[size];
        for (int i7 = 0; i7 < size; i7++) {
            zArr[i7] = arrayList.get(i7).booleanValue();
        }
        e1.b.h(this.f15924b, field.L0(), zArr, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void P(@m0 FastJsonResponse.Field<?, ?> field, @m0 String str, double d8) {
        i0(field);
        e1.b.r(this.f15924b, field.L0(), d8);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void R(@m0 FastJsonResponse.Field<?, ?> field, @m0 String str, @o0 ArrayList<Double> arrayList) {
        i0(field);
        int size = ((ArrayList) u.k(arrayList)).size();
        double[] dArr = new double[size];
        for (int i7 = 0; i7 < size; i7++) {
            dArr[i7] = arrayList.get(i7).doubleValue();
        }
        e1.b.s(this.f15924b, field.L0(), dArr, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void T(@m0 FastJsonResponse.Field<?, ?> field, @m0 String str, float f8) {
        i0(field);
        e1.b.w(this.f15924b, field.L0(), f8);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void V(@m0 FastJsonResponse.Field<?, ?> field, @m0 String str, @o0 ArrayList<Float> arrayList) {
        i0(field);
        int size = ((ArrayList) u.k(arrayList)).size();
        float[] fArr = new float[size];
        for (int i7 = 0; i7 < size; i7++) {
            fArr[i7] = arrayList.get(i7).floatValue();
        }
        e1.b.x(this.f15924b, field.L0(), fArr, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void Y(@m0 FastJsonResponse.Field<?, ?> field, @m0 String str, @o0 ArrayList<Integer> arrayList) {
        i0(field);
        int size = ((ArrayList) u.k(arrayList)).size();
        int[] iArr = new int[size];
        for (int i7 = 0; i7 < size; i7++) {
            iArr[i7] = arrayList.get(i7).intValue();
        }
        e1.b.G(this.f15924b, field.L0(), iArr, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final <T extends FastJsonResponse> void a(@m0 FastJsonResponse.Field field, @m0 String str, @o0 ArrayList<T> arrayList) {
        i0(field);
        ArrayList arrayList2 = new ArrayList();
        ((ArrayList) u.k(arrayList)).size();
        int size = arrayList.size();
        for (int i7 = 0; i7 < size; i7++) {
            arrayList2.add(((SafeParcelResponse) arrayList.get(i7)).e0());
        }
        e1.b.Q(this.f15924b, field.L0(), arrayList2, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final <T extends FastJsonResponse> void b(@m0 FastJsonResponse.Field field, @m0 String str, @m0 T t7) {
        i0(field);
        e1.b.O(this.f15924b, field.L0(), ((SafeParcelResponse) t7).e0(), true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void b0(@m0 FastJsonResponse.Field<?, ?> field, @m0 String str, @o0 ArrayList<Long> arrayList) {
        i0(field);
        int size = ((ArrayList) u.k(arrayList)).size();
        long[] jArr = new long[size];
        for (int i7 = 0; i7 < size; i7++) {
            jArr[i7] = arrayList.get(i7).longValue();
        }
        e1.b.L(this.f15924b, field.L0(), jArr, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    @o0
    public final Map<String, FastJsonResponse.Field<?, ?>> d() {
        zan zanVar = this.f15926d;
        if (zanVar == null) {
            return null;
        }
        return zanVar.Q((String) u.k(this.f15927e));
    }

    @m0
    public final Parcel e0() {
        int i7 = this.f15928f;
        if (i7 == 0) {
            int iA = e1.b.a(this.f15924b);
            this.f15929g = iA;
            e1.b.b(this.f15924b, iA);
            this.f15928f = 2;
        } else if (i7 == 1) {
            e1.b.b(this.f15924b, this.f15929g);
            this.f15928f = 2;
        }
        return this.f15924b;
    }

    @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse, com.google.android.gms.common.server.response.FastJsonResponse
    @m0
    public final Object f(@m0 String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse, com.google.android.gms.common.server.response.FastJsonResponse
    public final boolean h(@m0 String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void i(@m0 FastJsonResponse.Field<?, ?> field, @m0 String str, boolean z7) {
        i0(field);
        e1.b.g(this.f15924b, field.L0(), z7);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void j(@m0 FastJsonResponse.Field<?, ?> field, @m0 String str, @o0 byte[] bArr) {
        i0(field);
        e1.b.m(this.f15924b, field.L0(), bArr, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void k(@m0 FastJsonResponse.Field<?, ?> field, @m0 String str, int i7) {
        i0(field);
        e1.b.F(this.f15924b, field.L0(), i7);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void l(@m0 FastJsonResponse.Field<?, ?> field, @m0 String str, long j7) {
        i0(field);
        e1.b.K(this.f15924b, field.L0(), j7);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void n(@m0 FastJsonResponse.Field<?, ?> field, @m0 String str, @o0 String str2) {
        i0(field);
        e1.b.Y(this.f15924b, field.L0(), str2, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void o(@m0 FastJsonResponse.Field<?, ?> field, @m0 String str, @o0 Map<String, String> map) {
        i0(field);
        Bundle bundle = new Bundle();
        for (String str2 : ((Map) u.k(map)).keySet()) {
            bundle.putString(str2, map.get(str2));
        }
        e1.b.k(this.f15924b, field.L0(), bundle, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void p(@m0 FastJsonResponse.Field<?, ?> field, @m0 String str, @o0 ArrayList<String> arrayList) {
        i0(field);
        int size = ((ArrayList) u.k(arrayList)).size();
        String[] strArr = new String[size];
        for (int i7 = 0; i7 < size; i7++) {
            strArr[i7] = arrayList.get(i7);
        }
        e1.b.Z(this.f15924b, field.L0(), strArr, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    @m0
    public final String toString() {
        u.l(this.f15926d, "Cannot convert to JSON on client side.");
        Parcel parcelE0 = e0();
        parcelE0.setDataPosition(0);
        StringBuilder sb = new StringBuilder(100);
        j0(sb, (Map) u.k(this.f15926d.Q((String) u.k(this.f15927e))), parcelE0);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@m0 Parcel parcel, int i7) {
        zan zanVar;
        int iA = e1.b.a(parcel);
        e1.b.F(parcel, 1, this.f15923a);
        e1.b.O(parcel, 2, e0(), false);
        int i8 = this.f15925c;
        if (i8 != 0) {
            zanVar = i8 != 1 ? this.f15926d : this.f15926d;
        } else {
            zanVar = null;
        }
        e1.b.S(parcel, 3, zanVar, i7, false);
        e1.b.b(parcel, iA);
    }

    private SafeParcelResponse(SafeParcelable safeParcelable, zan zanVar, String str) {
        this.f15923a = 1;
        Parcel parcelObtain = Parcel.obtain();
        this.f15924b = parcelObtain;
        safeParcelable.writeToParcel(parcelObtain, 0);
        this.f15925c = 1;
        this.f15926d = (zan) u.k(zanVar);
        this.f15927e = (String) u.k(str);
        this.f15928f = 2;
    }

    public SafeParcelResponse(zan zanVar, String str) {
        this.f15923a = 1;
        this.f15924b = Parcel.obtain();
        this.f15925c = 0;
        this.f15926d = (zan) u.k(zanVar);
        this.f15927e = (String) u.k(str);
        this.f15928f = 0;
    }
}
