package com.alibaba.fastjson.parser.deserializer;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class g implements e1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final Class<?> f12882a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final Enum[] f12883b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final Enum[] f12884c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected long[] f12885d;

    public g(Class<?> cls) {
        e0.b bVar;
        this.f12882a = cls;
        this.f12884c = (Enum[]) cls.getEnumConstants();
        HashMap map = new HashMap();
        int i7 = 0;
        while (true) {
            Enum[] enumArr = this.f12884c;
            if (i7 >= enumArr.length) {
                break;
            }
            Enum r7 = enumArr[i7];
            String strName = r7.name();
            e0.b bVar2 = null;
            try {
                bVar = (e0.b) cls.getField(strName).getAnnotation(e0.b.class);
                if (bVar != null) {
                    try {
                        String strName2 = bVar.name();
                        if (strName2 != null && strName2.length() > 0) {
                            strName = strName2;
                        }
                    } catch (Exception unused) {
                        bVar2 = bVar;
                        bVar = bVar2;
                    }
                }
            } catch (Exception unused2) {
            }
            int i8 = 0;
            long j7 = -3750763034362895579L;
            long j8 = -3750763034362895579L;
            while (i8 < strName.length()) {
                int iCharAt = strName.charAt(i8);
                long j9 = ((long) iCharAt) ^ j7;
                if (iCharAt >= 65 && iCharAt <= 90) {
                    iCharAt += 32;
                }
                j8 = (((long) iCharAt) ^ j8) * 1099511628211L;
                i8++;
                j7 = j9 * 1099511628211L;
            }
            map.put(Long.valueOf(j7), r7);
            if (j7 != j8) {
                map.put(Long.valueOf(j8), r7);
            }
            if (bVar != null) {
                String[] strArrAlternateNames = bVar.alternateNames();
                int length = strArrAlternateNames.length;
                int i9 = 0;
                while (i9 < length) {
                    String str = strArrAlternateNames[i9];
                    int i10 = 0;
                    long jCharAt = -3750763034362895579L;
                    while (i10 < str.length()) {
                        jCharAt = (jCharAt ^ ((long) str.charAt(i10))) * 1099511628211L;
                        i10++;
                        i7 = i7;
                    }
                    int i11 = i7;
                    if (jCharAt != j7 && jCharAt != j8) {
                        map.put(Long.valueOf(jCharAt), r7);
                    }
                    i9++;
                    i7 = i11;
                }
            }
            i7++;
        }
        this.f12885d = new long[map.size()];
        Iterator it = map.keySet().iterator();
        int i12 = 0;
        while (it.hasNext()) {
            this.f12885d[i12] = ((Long) it.next()).longValue();
            i12++;
        }
        Arrays.sort(this.f12885d);
        this.f12883b = new Enum[this.f12885d.length];
        int i13 = 0;
        while (true) {
            long[] jArr = this.f12885d;
            if (i13 >= jArr.length) {
                return;
            }
            this.f12883b[i13] = (Enum) map.get(Long.valueOf(jArr[i13]));
            i13++;
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.e1
    public <T> T b(com.alibaba.fastjson.parser.b bVar, Type type, Object obj) {
        try {
            com.alibaba.fastjson.parser.d dVar = bVar.f12789f;
            int iL0 = dVar.L0();
            if (iL0 == 2) {
                int iH = dVar.H();
                dVar.Q(16);
                if (iH >= 0) {
                    Object[] objArr = this.f12884c;
                    if (iH <= objArr.length) {
                        return (T) objArr[iH];
                    }
                }
                throw new com.alibaba.fastjson.d("parse enum " + this.f12882a.getName() + " error, value : " + iH);
            }
            if (iL0 == 4) {
                String strX0 = dVar.x0();
                dVar.Q(16);
                if (strX0.length() == 0) {
                    return null;
                }
                long jCharAt = -3750763034362895579L;
                for (int i7 = 0; i7 < strX0.length(); i7++) {
                    jCharAt = (jCharAt ^ ((long) strX0.charAt(i7))) * 1099511628211L;
                }
                return (T) c(jCharAt);
            }
            if (iL0 == 8) {
                dVar.Q(16);
                return null;
            }
            throw new com.alibaba.fastjson.d("parse enum " + this.f12882a.getName() + " error, value : " + bVar.x0());
        } catch (com.alibaba.fastjson.d e8) {
            throw e8;
        } catch (Exception e9) {
            throw new com.alibaba.fastjson.d(e9.getMessage(), e9);
        }
    }

    public Enum c(long j7) {
        int iBinarySearch;
        if (this.f12883b != null && (iBinarySearch = Arrays.binarySearch(this.f12885d, j7)) >= 0) {
            return this.f12883b[iBinarySearch];
        }
        return null;
    }

    public Enum<?> d(int i7) {
        return this.f12884c[i7];
    }

    @Override // com.alibaba.fastjson.parser.deserializer.e1
    public int e() {
        return 2;
    }
}
