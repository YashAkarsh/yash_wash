package com.haier.library.json.serializer;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.IdentityHashMap;
import java.util.List;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
public final class o implements t {
    @Override // com.haier.library.json.serializer.t
    public final void b(m mVar, Object obj, Object obj2, Type type) throws IOException {
        z zVar = mVar.f26832b;
        int i7 = 1;
        boolean z7 = (zVar.f26874c & a0.WriteClassName.f26811a) != 0;
        Type type2 = (z7 && (type instanceof ParameterizedType)) ? ((ParameterizedType) type).getActualTypeArguments()[0] : null;
        if (obj == null) {
            if ((zVar.f26874c & a0.WriteNullListAsEmpty.f26811a) != 0) {
                zVar.write(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
                return;
            } else {
                zVar.H();
                return;
            }
        }
        List list = (List) obj;
        int size = list.size();
        if (size == 0) {
            zVar.append(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
            return;
        }
        w wVar = mVar.f26843m;
        if ((zVar.f26874c & a0.DisableCircularReferenceDetect.f26811a) == 0) {
            mVar.f26843m = new w(wVar, obj, obj2, 0);
            if (mVar.f26842l == null) {
                mVar.f26842l = new IdentityHashMap<>();
            }
            mVar.f26842l.put(obj, wVar);
        }
        try {
            if ((zVar.f26874c & a0.PrettyFormat.f26811a) != 0) {
                zVar.write(91);
                mVar.p();
                for (int i8 = 0; i8 < size; i8++) {
                    Object obj3 = list.get(i8);
                    if (i8 != 0) {
                        zVar.write(44);
                    }
                    mVar.q();
                    if (obj3 != null) {
                        IdentityHashMap<Object, w> identityHashMap = mVar.f26842l;
                        if (identityHashMap == null || !identityHashMap.containsKey(obj3)) {
                            t tVarA = mVar.f26831a.a(obj3.getClass());
                            mVar.f26843m = new w(wVar, obj, obj2, 0);
                            tVarA.b(mVar, obj3, Integer.valueOf(i8), type2);
                        } else {
                            mVar.B(obj3);
                        }
                    } else {
                        mVar.f26832b.H();
                    }
                }
                mVar.e();
                mVar.q();
                zVar.write(93);
                return;
            }
            int i9 = zVar.f26873b + 1;
            if (i9 > zVar.f26872a.length) {
                if (zVar.f26875d == null) {
                    zVar.g(i9);
                } else {
                    zVar.flush();
                    i9 = 1;
                }
            }
            zVar.f26872a[zVar.f26873b] = '[';
            zVar.f26873b = i9;
            for (int i10 = 0; i10 < list.size(); i10++) {
                Object obj4 = list.get(i10);
                if (i10 != 0) {
                    int i11 = zVar.f26873b + 1;
                    if (i11 > zVar.f26872a.length) {
                        if (zVar.f26875d == null) {
                            zVar.g(i11);
                        } else {
                            zVar.flush();
                            i11 = 1;
                        }
                    }
                    zVar.f26872a[zVar.f26873b] = ',';
                    zVar.f26873b = i11;
                }
                if (obj4 == null) {
                    zVar.append("null");
                } else {
                    Class<?> cls = obj4.getClass();
                    if (cls == Integer.class) {
                        zVar.C(((Integer) obj4).intValue());
                    } else if (cls == Long.class) {
                        long jLongValue = ((Long) obj4).longValue();
                        if (z7) {
                            zVar.G(jLongValue);
                            zVar.write(76);
                        } else {
                            zVar.G(jLongValue);
                        }
                    } else if (cls == String.class) {
                        String str = (String) obj4;
                        if ((zVar.f26874c & a0.UseSingleQuotes.f26811a) != 0) {
                            zVar.g0(str);
                        } else {
                            zVar.Q(str, (char) 0, true);
                        }
                    } else {
                        if ((zVar.f26874c & a0.DisableCircularReferenceDetect.f26811a) == 0) {
                            mVar.f26843m = new w(wVar, obj, obj2, 0);
                        }
                        IdentityHashMap<Object, w> identityHashMap2 = mVar.f26842l;
                        if (identityHashMap2 == null || !identityHashMap2.containsKey(obj4)) {
                            mVar.f26831a.a(obj4.getClass()).b(mVar, obj4, Integer.valueOf(i10), type2);
                        } else {
                            mVar.B(obj4);
                        }
                    }
                }
            }
            int i12 = zVar.f26873b + 1;
            if (i12 <= zVar.f26872a.length) {
                i7 = i12;
            } else if (zVar.f26875d == null) {
                zVar.g(i12);
                i7 = i12;
            } else {
                zVar.flush();
            }
            zVar.f26872a[zVar.f26873b] = ']';
            zVar.f26873b = i7;
        } finally {
            mVar.f26843m = wVar;
        }
    }
}
