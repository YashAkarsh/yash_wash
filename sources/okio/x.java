package okio;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.b1;
import kotlin.l2;

/* JADX INFO: loaded from: classes3.dex */
public final class x extends s {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f38550c = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MessageDigest f38551a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Mac f38552b;

    public static final class a {
        private a() {
        }

        @a7.d
        @h5.l
        public final x a(@a7.d o0 source, @a7.d p key) {
            kotlin.jvm.internal.l0.p(source, "source");
            kotlin.jvm.internal.l0.p(key, "key");
            return new x(source, key, "HmacSHA1");
        }

        @a7.d
        @h5.l
        public final x b(@a7.d o0 source, @a7.d p key) {
            kotlin.jvm.internal.l0.p(source, "source");
            kotlin.jvm.internal.l0.p(key, "key");
            return new x(source, key, "HmacSHA256");
        }

        @a7.d
        @h5.l
        public final x c(@a7.d o0 source, @a7.d p key) {
            kotlin.jvm.internal.l0.p(source, "source");
            kotlin.jvm.internal.l0.p(key, "key");
            return new x(source, key, "HmacSHA512");
        }

        @a7.d
        @h5.l
        public final x d(@a7.d o0 source) {
            kotlin.jvm.internal.l0.p(source, "source");
            return new x(source, "MD5");
        }

        @a7.d
        @h5.l
        public final x e(@a7.d o0 source) {
            kotlin.jvm.internal.l0.p(source, "source");
            return new x(source, "SHA-1");
        }

        @a7.d
        @h5.l
        public final x f(@a7.d o0 source) {
            kotlin.jvm.internal.l0.p(source, "source");
            return new x(source, "SHA-256");
        }

        @a7.d
        @h5.l
        public final x g(@a7.d o0 source) {
            kotlin.jvm.internal.l0.p(source, "source");
            return new x(source, "SHA-512");
        }

        public /* synthetic */ a(kotlin.jvm.internal.w wVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(@a7.d o0 source, @a7.d String algorithm) {
        super(source);
        kotlin.jvm.internal.l0.p(source, "source");
        kotlin.jvm.internal.l0.p(algorithm, "algorithm");
        this.f38551a = MessageDigest.getInstance(algorithm);
        this.f38552b = null;
    }

    @a7.d
    @h5.l
    public static final x f(@a7.d o0 o0Var, @a7.d p pVar) {
        return f38550c.a(o0Var, pVar);
    }

    @a7.d
    @h5.l
    public static final x g(@a7.d o0 o0Var, @a7.d p pVar) {
        return f38550c.b(o0Var, pVar);
    }

    @a7.d
    @h5.l
    public static final x m(@a7.d o0 o0Var, @a7.d p pVar) {
        return f38550c.c(o0Var, pVar);
    }

    @a7.d
    @h5.l
    public static final x q(@a7.d o0 o0Var) {
        return f38550c.d(o0Var);
    }

    @a7.d
    @h5.l
    public static final x r(@a7.d o0 o0Var) {
        return f38550c.e(o0Var);
    }

    @a7.d
    @h5.l
    public static final x s(@a7.d o0 o0Var) {
        return f38550c.f(o0Var);
    }

    @a7.d
    @h5.l
    public static final x u(@a7.d o0 o0Var) {
        return f38550c.g(o0Var);
    }

    @a7.d
    @kotlin.k(level = kotlin.m.ERROR, message = "moved to val", replaceWith = @b1(expression = "hash", imports = {}))
    @h5.h(name = "-deprecated_hash")
    public final p b() {
        return e();
    }

    @a7.d
    @h5.h(name = "hash")
    public final p e() {
        byte[] result;
        MessageDigest messageDigest = this.f38551a;
        if (messageDigest != null) {
            result = messageDigest.digest();
        } else {
            Mac mac = this.f38552b;
            kotlin.jvm.internal.l0.m(mac);
            result = mac.doFinal();
        }
        kotlin.jvm.internal.l0.o(result, "result");
        return new p(result);
    }

    @Override // okio.s, okio.o0
    public long read(@a7.d m sink, long j7) throws IOException {
        kotlin.jvm.internal.l0.p(sink, "sink");
        long j8 = super.read(sink, j7);
        if (j8 != -1) {
            long jB1 = sink.B1() - j8;
            long jB2 = sink.B1();
            j0 j0Var = sink.f38494a;
            kotlin.jvm.internal.l0.m(j0Var);
            while (jB2 > jB1) {
                j0Var = j0Var.f38474g;
                kotlin.jvm.internal.l0.m(j0Var);
                jB2 -= (long) (j0Var.f38470c - j0Var.f38469b);
            }
            while (jB2 < sink.B1()) {
                int i7 = (int) ((((long) j0Var.f38469b) + jB1) - jB2);
                MessageDigest messageDigest = this.f38551a;
                if (messageDigest != null) {
                    messageDigest.update(j0Var.f38468a, i7, j0Var.f38470c - i7);
                } else {
                    Mac mac = this.f38552b;
                    kotlin.jvm.internal.l0.m(mac);
                    mac.update(j0Var.f38468a, i7, j0Var.f38470c - i7);
                }
                jB2 += (long) (j0Var.f38470c - j0Var.f38469b);
                j0Var = j0Var.f38473f;
                kotlin.jvm.internal.l0.m(j0Var);
                jB1 = jB2;
            }
        }
        return j8;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(@a7.d o0 source, @a7.d p key, @a7.d String algorithm) throws NoSuchAlgorithmException {
        super(source);
        kotlin.jvm.internal.l0.p(source, "source");
        kotlin.jvm.internal.l0.p(key, "key");
        kotlin.jvm.internal.l0.p(algorithm, "algorithm");
        try {
            Mac mac = Mac.getInstance(algorithm);
            mac.init(new SecretKeySpec(key.k0(), algorithm));
            l2 l2Var = l2.f34958a;
            this.f38552b = mac;
            this.f38551a = null;
        } catch (InvalidKeyException e8) {
            throw new IllegalArgumentException(e8);
        }
    }
}
