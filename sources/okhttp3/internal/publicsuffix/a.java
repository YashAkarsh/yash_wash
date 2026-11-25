package okhttp3.internal.publicsuffix;

import a7.e;
import kotlin.jvm.internal.v0;

/* JADX INFO: loaded from: classes3.dex */
final /* synthetic */ class a extends v0 {
    a(PublicSuffixDatabase publicSuffixDatabase) {
        super(publicSuffixDatabase, PublicSuffixDatabase.class, "publicSuffixListBytes", "getPublicSuffixListBytes()[B", 0);
    }

    @Override // kotlin.jvm.internal.v0, kotlin.reflect.p
    @e
    public Object get() {
        return PublicSuffixDatabase.b((PublicSuffixDatabase) this.f34895b);
    }

    @Override // kotlin.jvm.internal.v0, kotlin.reflect.k
    public void set(@e Object obj) {
        ((PublicSuffixDatabase) this.f34895b).f38293c = (byte[]) obj;
    }
}
