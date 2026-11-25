package com.alibaba.fastjson.parser.deserializer;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/* JADX INFO: loaded from: classes.dex */
public abstract class b extends e implements e1 {
    @Override // com.alibaba.fastjson.parser.deserializer.e, com.alibaba.fastjson.parser.deserializer.e1
    public <T> T b(com.alibaba.fastjson.parser.b bVar, Type type, Object obj) {
        return (T) f(bVar, type, obj, null, 0);
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0071  */
    /* JADX WARN: Code duplicated, block: B:29:0x007c  */
    /* JADX WARN: Code duplicated, block: B:31:0x0087  */
    /* JADX WARN: Code duplicated, block: B:37:0x00a0 A[PHI: r6
      0x00a0: PHI (r6v1 java.lang.Object) = (r6v0 java.lang.Object), (r6v3 java.lang.Object) binds: [B:36:0x009d, B:26:0x006f] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.alibaba.fastjson.parser.deserializer.e
    public <T> T f(com.alibaba.fastjson.parser.b bVar, Type type, Object obj, String str, int i7) throws Throwable {
        Object objX0;
        SimpleDateFormat simpleDateFormat;
        Object obj2;
        Object obj3;
        com.alibaba.fastjson.parser.g gVar;
        Object time;
        com.alibaba.fastjson.parser.d dVar = bVar.f12789f;
        if (dVar.L0() == 2) {
            Object objValueOf = Long.valueOf(dVar.q());
            dVar.Q(16);
            objX0 = objValueOf;
        } else {
            Object obj4 = null;
            if (dVar.L0() == 4) {
                String strX0 = dVar.x0();
                if (str != null) {
                    try {
                        simpleDateFormat = new SimpleDateFormat(str, com.alibaba.fastjson.a.f12528b);
                    } catch (IllegalArgumentException unused) {
                        if (str.equals("yyyy-MM-ddTHH:mm:ss.SSS")) {
                            str = "yyyy-MM-dd'T'HH:mm:ss.SSS";
                            simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
                        } else if (str.equals("yyyy-MM-ddTHH:mm:ss")) {
                            str = "yyyy-MM-dd'T'HH:mm:ss";
                            simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                        } else {
                            simpleDateFormat = null;
                        }
                    }
                    try {
                        obj2 = simpleDateFormat.parse(strX0);
                    } catch (ParseException unused2) {
                        if (str.equals("yyyy-MM-dd'T'HH:mm:ss.SSS") && strX0.length() == 19) {
                            try {
                                obj2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(strX0);
                            } catch (ParseException unused3) {
                            }
                        }
                        if (obj4 == null) {
                            dVar.Q(16);
                            if (dVar.G(com.alibaba.fastjson.parser.c.AllowISO8601DateFormat)) {
                                gVar = new com.alibaba.fastjson.parser.g(strX0);
                                if (gVar.S2()) {
                                    obj3 = strX0;
                                    time = strX0;
                                    time = gVar.X1().getTime();
                                }
                                obj3 = strX0;
                                time = strX0;
                                gVar.close();
                                obj3 = time;
                            }
                            obj3 = strX0;
                            objX0 = obj3;
                        } else {
                            objX0 = obj4;
                        }
                        return (T) g(bVar, type, obj, objX0);
                    }
                    obj4 = obj2;
                }
                if (obj4 == null) {
                    dVar.Q(16);
                    if (dVar.G(com.alibaba.fastjson.parser.c.AllowISO8601DateFormat)) {
                        gVar = new com.alibaba.fastjson.parser.g(strX0);
                        if (gVar.S2()) {
                            obj3 = strX0;
                            time = strX0;
                            time = gVar.X1().getTime();
                        }
                        obj3 = strX0;
                        time = strX0;
                        gVar.close();
                        obj3 = time;
                    }
                    obj3 = strX0;
                    objX0 = obj3;
                } else {
                    objX0 = obj4;
                }
            } else if (dVar.L0() == 8) {
                dVar.E();
                objX0 = obj4;
            } else if (dVar.L0() == 12) {
                dVar.E();
                if (dVar.L0() != 4) {
                    throw new com.alibaba.fastjson.d("syntax error");
                }
                if (com.alibaba.fastjson.a.f12529c.equals(dVar.x0())) {
                    dVar.E();
                    bVar.b(17);
                    Type typeF = bVar.u().f(dVar.x0(), null, dVar.V0());
                    if (typeF != null) {
                        type = typeF;
                    }
                    bVar.b(4);
                    bVar.b(16);
                }
                dVar.v0(2);
                if (dVar.L0() != 2) {
                    throw new com.alibaba.fastjson.d("syntax error : " + dVar.A1());
                }
                long jQ = dVar.q();
                dVar.E();
                Object objValueOf2 = Long.valueOf(jQ);
                bVar.b(13);
                objX0 = objValueOf2;
            } else if (bVar.o0() == 2) {
                bVar.e2(0);
                bVar.b(16);
                if (dVar.L0() != 4) {
                    throw new com.alibaba.fastjson.d("syntax error");
                }
                if (!"val".equals(dVar.x0())) {
                    throw new com.alibaba.fastjson.d("syntax error");
                }
                dVar.E();
                bVar.b(17);
                Object objX1 = bVar.x0();
                bVar.b(13);
                objX0 = objX1;
            } else {
                objX0 = bVar.x0();
            }
        }
        return (T) g(bVar, type, obj, objX0);
    }

    protected abstract <T> T g(com.alibaba.fastjson.parser.b bVar, Type type, Object obj, Object obj2);
}
