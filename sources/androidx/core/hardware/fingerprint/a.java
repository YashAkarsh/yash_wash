package androidx.core.hardware.fingerprint;

import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import c.m0;
import c.o0;
import c.t;
import c.t0;
import c.w0;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f5934a;

    /* JADX INFO: renamed from: androidx.core.hardware.fingerprint.a$a, reason: collision with other inner class name */
    class C0064a extends FingerprintManager.AuthenticationCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f5935a;

        C0064a(c cVar) {
            this.f5935a = cVar;
        }

        @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
        public void onAuthenticationError(int i7, CharSequence charSequence) {
            this.f5935a.a(i7, charSequence);
        }

        @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
        public void onAuthenticationFailed() {
            this.f5935a.b();
        }

        @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
        public void onAuthenticationHelp(int i7, CharSequence charSequence) {
            this.f5935a.c(i7, charSequence);
        }

        @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
        public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult authenticationResult) {
            this.f5935a.d(new d(a.f(b.b(authenticationResult))));
        }
    }

    @t0(23)
    static class b {
        private b() {
        }

        @w0("android.permission.USE_FINGERPRINT")
        @t
        static void a(Object obj, Object obj2, CancellationSignal cancellationSignal, int i7, Object obj3, Handler handler) {
            ((FingerprintManager) obj).authenticate((FingerprintManager.CryptoObject) obj2, cancellationSignal, i7, (FingerprintManager.AuthenticationCallback) obj3, handler);
        }

        @t
        static FingerprintManager.CryptoObject b(Object obj) {
            return ((FingerprintManager.AuthenticationResult) obj).getCryptoObject();
        }

        @t
        public static FingerprintManager c(Context context) {
            int i7 = Build.VERSION.SDK_INT;
            if (i7 == 23) {
                return (FingerprintManager) context.getSystemService(FingerprintManager.class);
            }
            if (i7 <= 23 || !context.getPackageManager().hasSystemFeature("android.hardware.fingerprint")) {
                return null;
            }
            return (FingerprintManager) context.getSystemService(FingerprintManager.class);
        }

        @w0("android.permission.USE_FINGERPRINT")
        @t
        static boolean d(Object obj) {
            return ((FingerprintManager) obj).hasEnrolledFingerprints();
        }

        @w0("android.permission.USE_FINGERPRINT")
        @t
        static boolean e(Object obj) {
            return ((FingerprintManager) obj).isHardwareDetected();
        }

        @t
        public static e f(Object obj) {
            FingerprintManager.CryptoObject cryptoObject = (FingerprintManager.CryptoObject) obj;
            if (cryptoObject == null) {
                return null;
            }
            if (cryptoObject.getCipher() != null) {
                return new e(cryptoObject.getCipher());
            }
            if (cryptoObject.getSignature() != null) {
                return new e(cryptoObject.getSignature());
            }
            if (cryptoObject.getMac() != null) {
                return new e(cryptoObject.getMac());
            }
            return null;
        }

        @t
        public static FingerprintManager.CryptoObject g(e eVar) {
            if (eVar == null) {
                return null;
            }
            if (eVar.a() != null) {
                return new FingerprintManager.CryptoObject(eVar.a());
            }
            if (eVar.c() != null) {
                return new FingerprintManager.CryptoObject(eVar.c());
            }
            if (eVar.b() != null) {
                return new FingerprintManager.CryptoObject(eVar.b());
            }
            return null;
        }
    }

    public static abstract class c {
        public void a(int i7, CharSequence charSequence) {
        }

        public void b() {
        }

        public void c(int i7, CharSequence charSequence) {
        }

        public void d(d dVar) {
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final e f5936a;

        public d(e eVar) {
            this.f5936a = eVar;
        }

        public e a() {
            return this.f5936a;
        }
    }

    private a(Context context) {
        this.f5934a = context;
    }

    @m0
    public static a b(@m0 Context context) {
        return new a(context);
    }

    @o0
    @t0(23)
    private static FingerprintManager c(@m0 Context context) {
        return b.c(context);
    }

    @t0(23)
    static e f(FingerprintManager.CryptoObject cryptoObject) {
        return b.f(cryptoObject);
    }

    @t0(23)
    private static FingerprintManager.AuthenticationCallback g(c cVar) {
        return new C0064a(cVar);
    }

    @t0(23)
    private static FingerprintManager.CryptoObject h(e eVar) {
        return b.g(eVar);
    }

    @w0("android.permission.USE_FINGERPRINT")
    public void a(@o0 e eVar, int i7, @o0 androidx.core.os.e eVar2, @m0 c cVar, @o0 Handler handler) {
        FingerprintManager fingerprintManagerC = c(this.f5934a);
        if (fingerprintManagerC != null) {
            b.a(fingerprintManagerC, h(eVar), eVar2 != null ? (CancellationSignal) eVar2.b() : null, i7, g(cVar), handler);
        }
    }

    @w0("android.permission.USE_FINGERPRINT")
    public boolean d() {
        FingerprintManager fingerprintManagerC = c(this.f5934a);
        return fingerprintManagerC != null && b.d(fingerprintManagerC);
    }

    @w0("android.permission.USE_FINGERPRINT")
    public boolean e() {
        FingerprintManager fingerprintManagerC = c(this.f5934a);
        return fingerprintManagerC != null && b.e(fingerprintManagerC);
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Signature f5937a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Cipher f5938b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Mac f5939c;

        public e(@m0 Signature signature) {
            this.f5937a = signature;
            this.f5938b = null;
            this.f5939c = null;
        }

        @o0
        public Cipher a() {
            return this.f5938b;
        }

        @o0
        public Mac b() {
            return this.f5939c;
        }

        @o0
        public Signature c() {
            return this.f5937a;
        }

        public e(@m0 Cipher cipher) {
            this.f5938b = cipher;
            this.f5937a = null;
            this.f5939c = null;
        }

        public e(@m0 Mac mac) {
            this.f5939c = mac;
            this.f5938b = null;
            this.f5937a = null;
        }
    }
}
