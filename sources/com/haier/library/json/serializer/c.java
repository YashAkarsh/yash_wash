package com.haier.library.json.serializer;

import java.io.IOException;
import java.lang.reflect.Type;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class<?> f26814a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final t f26815b;

    c(Class<?> cls, t tVar) {
        this.f26814a = cls;
        this.f26815b = tVar;
    }

    @Override // com.haier.library.json.serializer.t
    public final void b(m mVar, Object obj, Object obj2, Type type) throws IOException {
        z zVar = mVar.f26832b;
        if (obj == null) {
            if ((zVar.f26874c & a0.WriteNullListAsEmpty.f26811a) != 0) {
                zVar.write(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
                return;
            } else {
                zVar.H();
                return;
            }
        }
        int i7 = 0;
        if (obj instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj;
            zVar.write(91);
            while (i7 < zArr.length) {
                if (i7 != 0) {
                    zVar.write(44);
                }
                zVar.s(zArr[i7]);
                i7++;
            }
            zVar.write(93);
            return;
        }
        if (obj instanceof byte[]) {
            zVar.u((byte[]) obj);
            return;
        }
        if (obj instanceof char[]) {
            zVar.K(new String((char[]) obj));
            return;
        }
        if (obj instanceof double[]) {
            double[] dArr = (double[]) obj;
            int length = dArr.length - 1;
            if (length == -1) {
                zVar.append(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
                return;
            }
            zVar.write(91);
            while (i7 < length) {
                double d8 = dArr[i7];
                if (Double.isNaN(d8)) {
                    zVar.H();
                } else {
                    zVar.append(Double.toString(d8));
                }
                zVar.write(44);
                i7++;
            }
            double d9 = dArr[length];
            if (Double.isNaN(d9)) {
                zVar.H();
            } else {
                zVar.append(Double.toString(d9));
            }
            zVar.write(93);
            return;
        }
        if (obj instanceof float[]) {
            float[] fArr = (float[]) obj;
            int length2 = fArr.length - 1;
            if (length2 == -1) {
                zVar.append(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
                return;
            }
            zVar.write(91);
            while (i7 < length2) {
                float f8 = fArr[i7];
                if (Float.isNaN(f8)) {
                    zVar.H();
                } else {
                    zVar.append(Float.toString(f8));
                }
                zVar.write(44);
                i7++;
            }
            float f9 = fArr[length2];
            if (Float.isNaN(f9)) {
                zVar.H();
            } else {
                zVar.append(Float.toString(f9));
            }
            zVar.write(93);
            return;
        }
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            zVar.write(91);
            while (i7 < iArr.length) {
                if (i7 != 0) {
                    zVar.write(44);
                }
                zVar.C(iArr[i7]);
                i7++;
            }
            zVar.write(93);
            return;
        }
        if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            zVar.write(91);
            while (i7 < jArr.length) {
                if (i7 != 0) {
                    zVar.write(44);
                }
                zVar.G(jArr[i7]);
                i7++;
            }
            zVar.write(93);
            return;
        }
        if (obj instanceof short[]) {
            short[] sArr = (short[]) obj;
            zVar.write(91);
            while (i7 < sArr.length) {
                if (i7 != 0) {
                    zVar.write(44);
                }
                zVar.C(sArr[i7]);
                i7++;
            }
            zVar.write(93);
            return;
        }
        Object[] objArr = (Object[]) obj;
        int length3 = objArr.length;
        w wVar = mVar.f26843m;
        mVar.t(wVar, obj, obj2, 0);
        try {
            zVar.write(91);
            while (i7 < length3) {
                if (i7 != 0) {
                    zVar.write(44);
                }
                Object obj3 = objArr[i7];
                if (obj3 == null) {
                    zVar.append("null");
                } else if (obj3.getClass() == this.f26814a) {
                    this.f26815b.b(mVar, obj3, Integer.valueOf(i7), null);
                } else {
                    mVar.f26831a.a(obj3.getClass()).b(mVar, obj3, Integer.valueOf(i7), null);
                }
                i7++;
            }
            zVar.write(93);
        } finally {
            mVar.f26843m = wVar;
        }
    }
}
