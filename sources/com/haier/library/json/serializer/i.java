package com.haier.library.json.serializer;

import java.io.IOException;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes2.dex */
public class i implements t {
    @Override // com.haier.library.json.serializer.t
    public void b(m mVar, Object obj, Object obj2, Type type) throws IOException {
        z zVar = mVar.f26832b;
        if ((zVar.f26874c & a0.WriteEnumUsingToString.f26811a) == 0) {
            zVar.C(((Enum) obj).ordinal());
            return;
        }
        String string = ((Enum) obj).toString();
        if ((zVar.f26874c & a0.UseSingleQuotes.f26811a) != 0) {
            zVar.g0(string);
        } else {
            zVar.Q(string, (char) 0, false);
        }
    }
}
