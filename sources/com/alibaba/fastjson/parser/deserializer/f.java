package com.alibaba.fastjson.parser.deserializer;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/* JADX INFO: loaded from: classes.dex */
public class f extends k {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected e1 f12880d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected boolean f12881e;

    public f(com.alibaba.fastjson.parser.j jVar, Class<?> cls, com.alibaba.fastjson.util.e eVar) {
        super(cls, eVar);
        boolean z7 = false;
        this.f12881e = false;
        e0.b bVarE = eVar.e();
        if (bVarE != null) {
            Class<?> clsDeserializeUsing = bVarE.deserializeUsing();
            if (clsDeserializeUsing != null && clsDeserializeUsing != Void.class) {
                z7 = true;
            }
            this.f12881e = z7;
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.k
    public int a() {
        e1 e1Var = this.f12880d;
        if (e1Var != null) {
            return e1Var.e();
        }
        return 2;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.k
    public void b(com.alibaba.fastjson.parser.b bVar, Object obj, Type type, Map<String, Object> map) {
        Object objB;
        com.alibaba.fastjson.util.e eVar;
        int i7;
        if (this.f12880d == null) {
            i(bVar.u());
        }
        e1 e1VarN = this.f12880d;
        Type typeH = this.f12897a.f13298f;
        if (type instanceof ParameterizedType) {
            com.alibaba.fastjson.parser.i iVarC = bVar.C();
            if (iVarC != null) {
                iVarC.f12968d = type;
            }
            if (typeH != type) {
                typeH = com.alibaba.fastjson.util.e.h(this.f12898b, type, typeH);
                e1VarN = bVar.u().n(typeH);
            }
        }
        Type type2 = typeH;
        if (!(e1VarN instanceof n) || (i7 = (eVar = this.f12897a).f13302j) == 0) {
            com.alibaba.fastjson.util.e eVar2 = this.f12897a;
            String str = eVar2.f13312t;
            objB = (str == null || !(e1VarN instanceof e)) ? e1VarN.b(bVar, type2, eVar2.f13293a) : ((e) e1VarN).f(bVar, type2, eVar2.f13293a, str, eVar2.f13302j);
        } else {
            objB = ((n) e1VarN).g(bVar, type2, eVar.f13293a, i7);
        }
        if ((objB instanceof byte[]) && ("gzip".equals(this.f12897a.f13312t) || "gzip,base64".equals(this.f12897a.f13312t))) {
            try {
                GZIPInputStream gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream((byte[]) objB));
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    byte[] bArr = new byte[1024];
                    int i8 = gZIPInputStream.read(bArr);
                    if (i8 == -1) {
                        break;
                    } else if (i8 > 0) {
                        byteArrayOutputStream.write(bArr, 0, i8);
                    }
                }
                objB = byteArrayOutputStream.toByteArray();
            } catch (IOException e8) {
                throw new com.alibaba.fastjson.d("unzip bytes error.", e8);
            }
        }
        if (bVar.o0() == 1) {
            com.alibaba.fastjson.parser.b.a aVarG0 = bVar.g0();
            aVarG0.f12803c = this;
            aVarG0.f12804d = bVar.C();
            bVar.e2(0);
            return;
        }
        if (obj == null) {
            map.put(this.f12897a.f13293a, objB);
        } else {
            e(obj, objB);
        }
    }

    public e1 i(com.alibaba.fastjson.parser.j jVar) {
        if (this.f12880d == null) {
            e0.b bVarE = this.f12897a.e();
            if (bVarE == null || bVarE.deserializeUsing() == Void.class) {
                com.alibaba.fastjson.util.e eVar = this.f12897a;
                this.f12880d = jVar.m(eVar.f13297e, eVar.f13298f);
            } else {
                try {
                    this.f12880d = (e1) bVarE.deserializeUsing().newInstance();
                } catch (Exception e8) {
                    throw new com.alibaba.fastjson.d("create deserializeUsing ObjectDeserializer error", e8);
                }
            }
        }
        return this.f12880d;
    }

    public void j(com.alibaba.fastjson.parser.b bVar, Object obj, Type type, Map<String, Object> map) {
        throw new com.alibaba.fastjson.d("TODO");
    }
}
