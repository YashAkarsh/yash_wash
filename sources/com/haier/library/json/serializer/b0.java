package com.haier.library.json.serializer;

import java.io.IOException;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes2.dex */
public class b0 implements h3.f, t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static b0 f26813a = new b0();

    private b0() {
    }

    @Override // h3.f
    public <T> T a(com.haier.library.json.parser.b bVar, Type type, Object obj) {
        return (T) bVar.Q0();
    }

    @Override // com.haier.library.json.serializer.t
    public void b(m mVar, Object obj, Object obj2, Type type) throws IOException {
        String str = (String) obj;
        z zVar = mVar.f26832b;
        if (str == null) {
            zVar.H();
        } else {
            zVar.K(str);
        }
    }
}
