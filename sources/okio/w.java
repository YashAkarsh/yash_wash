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
public final class w extends r {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f38547c = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MessageDigest f38548a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Mac f38549b;

    public static final class a {
        private a() {
        }

        @a7.d
        @h5.l
        public final w a(@a7.d m0 sink, @a7.d p key) {
            kotlin.jvm.internal.l0.p(sink, "sink");
            kotlin.jvm.internal.l0.p(key, "key");
            return new w(sink, key, "HmacSHA1");
        }

        @a7.d
        @h5.l
        public final w b(@a7.d m0 sink, @a7.d p key) {
            kotlin.jvm.internal.l0.p(sink, "sink");
            kotlin.jvm.internal.l0.p(key, "key");
            return new w(sink, key, "HmacSHA256");
        }

        @a7.d
        @h5.l
        public final w c(@a7.d m0 sink, @a7.d p key) {
            kotlin.jvm.internal.l0.p(sink, "sink");
            kotlin.jvm.internal.l0.p(key, "key");
            return new w(sink, key, "HmacSHA512");
        }

        @a7.d
        @h5.l
        public final w d(@a7.d m0 sink) {
            kotlin.jvm.internal.l0.p(sink, "sink");
            return new w(sink, "MD5");
        }

        @a7.d
        @h5.l
        public final w e(@a7.d m0 sink) {
            kotlin.jvm.internal.l0.p(sink, "sink");
            return new w(sink, "SHA-1");
        }

        @a7.d
        @h5.l
        public final w f(@a7.d m0 sink) {
            kotlin.jvm.internal.l0.p(sink, "sink");
            return new w(sink, "SHA-256");
        }

        @a7.d
        @h5.l
        public final w g(@a7.d m0 sink) {
            kotlin.jvm.internal.l0.p(sink, "sink");
            return new w(sink, "SHA-512");
        }

        public /* synthetic */ a(kotlin.jvm.internal.w wVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(@a7.d m0 sink, @a7.d String algorithm) {
        super(sink);
        kotlin.jvm.internal.l0.p(sink, "sink");
        kotlin.jvm.internal.l0.p(algorithm, "algorithm");
        this.f38548a = MessageDigest.getInstance(algorithm);
        this.f38549b = null;
    }

    @a7.d
    @h5.l
    public static final w f(@a7.d m0 m0Var, @a7.d p pVar) {
        return f38547c.a(m0Var, pVar);
    }

    @a7.d
    @h5.l
    public static final w g(@a7.d m0 m0Var, @a7.d p pVar) {
        return f38547c.b(m0Var, pVar);
    }

    @a7.d
    @h5.l
    public static final w m(@a7.d m0 m0Var, @a7.d p pVar) {
        return f38547c.c(m0Var, pVar);
    }

    @a7.d
    @h5.l
    public static final w q(@a7.d m0 m0Var) {
        return f38547c.d(m0Var);
    }

    @a7.d
    @h5.l
    public static final w r(@a7.d m0 m0Var) {
        return f38547c.e(m0Var);
    }

    @a7.d
    @h5.l
    public static final w s(@a7.d m0 m0Var) {
        return f38547c.f(m0Var);
    }

    @a7.d
    @h5.l
    public static final w u(@a7.d m0 m0Var) {
        return f38547c.g(m0Var);
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
        MessageDigest messageDigest = this.f38548a;
        if (messageDigest != null) {
            result = messageDigest.digest();
        } else {
            Mac mac = this.f38549b;
            kotlin.jvm.internal.l0.m(mac);
            result = mac.doFinal();
        }
        kotlin.jvm.internal.l0.o(result, "result");
        return new p(result);
    }

    @Override // okio.r, okio.m0
    public void write(@a7.d m source, long j7) throws IOException {
        kotlin.jvm.internal.l0.p(source, "source");
        j.e(source.B1(), 0L, j7);
        j0 j0Var = source.f38494a;
        kotlin.jvm.internal.l0.m(j0Var);
        long j8 = 0;
        while (j8 < j7) {
            int iMin = (int) Math.min(j7 - j8, j0Var.f38470c - j0Var.f38469b);
            MessageDigest messageDigest = this.f38548a;
            if (messageDigest != null) {
                messageDigest.update(j0Var.f38468a, j0Var.f38469b, iMin);
            } else {
                Mac mac = this.f38549b;
                kotlin.jvm.internal.l0.m(mac);
                mac.update(j0Var.f38468a, j0Var.f38469b, iMin);
            }
            j8 += (long) iMin;
            j0Var = j0Var.f38473f;
            kotlin.jvm.internal.l0.m(j0Var);
        }
        super.write(source, j7);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(@a7.d m0 sink, @a7.d p key, @a7.d String algorithm) throws NoSuchAlgorithmException {
        super(sink);
        kotlin.jvm.internal.l0.p(sink, "sink");
        kotlin.jvm.internal.l0.p(key, "key");
        kotlin.jvm.internal.l0.p(algorithm, "algorithm");
        try {
            Mac mac = Mac.getInstance(algorithm);
            mac.init(new SecretKeySpec(key.k0(), algorithm));
            l2 l2Var = l2.f34958a;
            this.f38549b = mac;
            this.f38548a = null;
        } catch (InvalidKeyException e8) {
            throw new IllegalArgumentException(e8);
        }
    }
}
