package com.alibaba.fastjson.parser.deserializer;

import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
public class j2 implements e1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j2 f12896a = new j2();

    @Override // com.alibaba.fastjson.parser.deserializer.e1
    public <T> T b(com.alibaba.fastjson.parser.b bVar, Type type, Object obj) {
        com.alibaba.fastjson.parser.d dVar = bVar.f12789f;
        if (dVar.L0() == 8) {
            dVar.E();
            return null;
        }
        if (dVar.L0() != 12 && dVar.L0() != 16) {
            throw new com.alibaba.fastjson.d("syntax error: " + com.alibaba.fastjson.parser.h.a(dVar.L0()));
        }
        int iH = 0;
        String strX0 = null;
        String strX1 = null;
        String strX2 = null;
        while (true) {
            String strT0 = dVar.T0(bVar.r0());
            if (strT0 == null) {
                if (dVar.L0() == 13) {
                    dVar.Q(16);
                    break;
                }
                if (dVar.L0() != 16 || !dVar.G(com.alibaba.fastjson.parser.c.AllowArbitraryCommas)) {
                }
            }
            dVar.v0(4);
            if ("className".equals(strT0)) {
                if (dVar.L0() == 8) {
                    strX0 = null;
                } else {
                    if (dVar.L0() != 4) {
                        throw new com.alibaba.fastjson.d("syntax error");
                    }
                    strX0 = dVar.x0();
                }
            } else if ("methodName".equals(strT0)) {
                if (dVar.L0() == 8) {
                    strX1 = null;
                } else {
                    if (dVar.L0() != 4) {
                        throw new com.alibaba.fastjson.d("syntax error");
                    }
                    strX1 = dVar.x0();
                }
            } else if ("fileName".equals(strT0)) {
                if (dVar.L0() == 8) {
                    strX2 = null;
                } else {
                    if (dVar.L0() != 4) {
                        throw new com.alibaba.fastjson.d("syntax error");
                    }
                    strX2 = dVar.x0();
                }
            } else if ("lineNumber".equals(strT0)) {
                if (dVar.L0() == 8) {
                    iH = 0;
                } else {
                    if (dVar.L0() != 2) {
                        throw new com.alibaba.fastjson.d("syntax error");
                    }
                    iH = dVar.H();
                }
            } else if ("nativeMethod".equals(strT0)) {
                if (dVar.L0() != 8 && dVar.L0() != 6 && dVar.L0() != 7) {
                    throw new com.alibaba.fastjson.d("syntax error");
                }
                dVar.Q(16);
            } else if (strT0 == com.alibaba.fastjson.a.f12529c) {
                if (dVar.L0() == 4) {
                    String strX3 = dVar.x0();
                    if (!strX3.equals("java.lang.StackTraceElement")) {
                        throw new com.alibaba.fastjson.d("syntax error : " + strX3);
                    }
                } else if (dVar.L0() != 8) {
                    throw new com.alibaba.fastjson.d("syntax error");
                }
            } else if ("moduleName".equals(strT0)) {
                if (dVar.L0() != 8) {
                    if (dVar.L0() != 4) {
                        throw new com.alibaba.fastjson.d("syntax error");
                    }
                    dVar.x0();
                }
            } else if ("moduleVersion".equals(strT0)) {
                if (dVar.L0() != 8) {
                    if (dVar.L0() != 4) {
                        throw new com.alibaba.fastjson.d("syntax error");
                    }
                    dVar.x0();
                }
            } else {
                if (!"classLoaderName".equals(strT0)) {
                    throw new com.alibaba.fastjson.d("syntax error : " + strT0);
                }
                if (dVar.L0() != 8) {
                    if (dVar.L0() != 4) {
                        throw new com.alibaba.fastjson.d("syntax error");
                    }
                    dVar.x0();
                }
            }
            if (dVar.L0() == 13) {
                dVar.Q(16);
                break;
            }
        }
        return (T) new StackTraceElement(strX0, strX1, strX2, iH);
    }

    @Override // com.alibaba.fastjson.parser.deserializer.e1
    public int e() {
        return 12;
    }
}
