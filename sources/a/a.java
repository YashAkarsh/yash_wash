package a;

import android.content.Context;
import c.m0;
import c.o0;

/* JADX INFO: loaded from: classes.dex */
public interface a {
    void addOnContextAvailableListener(@m0 c cVar);

    @o0
    Context peekAvailableContext();

    void removeOnContextAvailableListener(@m0 c cVar);
}
