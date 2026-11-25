package o5;

import a7.d;
import a7.e;
import h5.h;
import kotlin.g1;
import kotlin.jvm.internal.l0;
import kotlin.text.j;
import kotlin.text.k;
import kotlin.text.l;

/* JADX INFO: loaded from: classes2.dex */
@h(name = "RegexExtensionsJDK8Kt")
public final class a {
    @g1(version = "1.2")
    @e
    public static final j a(@d k kVar, @d String name) {
        l0.p(kVar, "<this>");
        l0.p(name, "name");
        l lVar = kVar instanceof l ? (l) kVar : null;
        if (lVar != null) {
            return lVar.c(name);
        }
        throw new UnsupportedOperationException("Retrieving groups by name is not supported on this platform.");
    }
}
