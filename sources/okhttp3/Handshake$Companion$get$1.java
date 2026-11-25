package okhttp3;

import a7.d;
import java.security.cert.Certificate;
import java.util.List;
import kotlin.i0;
import kotlin.jvm.internal.n0;

/* JADX INFO: loaded from: classes3.dex */
@i0(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Ljava/security/cert/Certificate;", "invoke"}, k = 3, mv = {1, 4, 0})
final class Handshake$Companion$get$1 extends n0 implements i5.a<List<? extends Certificate>> {
    final /* synthetic */ List $peerCertificatesCopy;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Handshake$Companion$get$1(List list) {
        super(0);
        this.$peerCertificatesCopy = list;
    }

    @Override // i5.a
    @d
    public final List<? extends Certificate> invoke() {
        return this.$peerCertificatesCopy;
    }
}
