package com.haier.library.json.serializer;

import java.io.IOException;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements h3.f, t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f26820a = new f();

    private f() {
    }

    @Override // h3.f
    public <T> T a(com.haier.library.json.parser.b bVar, Type type, Object obj) {
        com.haier.library.json.parser.e eVar = bVar.f26664e;
        int iD0 = eVar.d0();
        if (iD0 == 6) {
            eVar.y(16);
            return (T) Boolean.TRUE;
        }
        if (iD0 == 7) {
            eVar.y(16);
            return (T) Boolean.FALSE;
        }
        if (iD0 == 2) {
            int iO = eVar.o();
            eVar.y(16);
            return iO == 1 ? (T) Boolean.TRUE : (T) Boolean.FALSE;
        }
        Object objG = bVar.G();
        if (objG == null) {
            return null;
        }
        return (T) i3.d.f(objG);
    }

    @Override // com.haier.library.json.serializer.t
    public void b(m mVar, Object obj, Object obj2, Type type) throws IOException {
        z zVar = mVar.f26832b;
        Boolean bool = (Boolean) obj;
        if (bool == null) {
            if ((zVar.f26874c & a0.WriteNullBooleanAsFalse.f26811a) != 0) {
                zVar.write(com.paytm.pgsdk.d.G);
                return;
            } else {
                zVar.H();
                return;
            }
        }
        if (bool.booleanValue()) {
            zVar.write("true");
        } else {
            zVar.write(com.paytm.pgsdk.d.G);
        }
    }
}
