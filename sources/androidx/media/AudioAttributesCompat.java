package androidx.media;

import android.media.AudioAttributes;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseIntArray;
import c.m0;
import c.o0;
import c.x0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public class AudioAttributesCompat implements androidx.versionedparcelable.h {
    private static final SparseIntArray A;
    static boolean B = false;
    private static final int[] C;
    public static final int D = 1;
    static final int E = 2;
    static final int F = 4;
    static final int G = 8;
    public static final int H = 16;
    static final int I = 32;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    static final int f8460J = 64;
    static final int K = 128;
    static final int L = 256;
    static final int M = 512;
    static final int N = 1023;
    static final int O = 273;
    static final int P = -1;
    static final String Q = "androidx.media.audio_attrs.FRAMEWORKS";
    static final String R = "androidx.media.audio_attrs.USAGE";
    static final String S = "androidx.media.audio_attrs.CONTENT_TYPE";
    static final String T = "androidx.media.audio_attrs.FLAGS";
    static final String U = "androidx.media.audio_attrs.LEGACY_STREAM_TYPE";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f8461b = "AudioAttributesCompat";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f8462c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f8463d = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f8464e = 2;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f8465f = 3;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f8466g = 4;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f8467h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f8468i = 1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f8469j = 2;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f8470k = 3;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f8471l = 4;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f8472m = 5;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f8473n = 6;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f8474o = 7;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f8475p = 8;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f8476q = 9;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f8477r = 10;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f8478s = 11;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f8479t = 12;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f8480u = 13;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f8481v = 14;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final int f8482w = 15;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f8483x = 16;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final int f8484y = 1;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final int f8485z = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    AudioAttributesImpl f8486a;

    @x0({x0.a.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
    }

    @x0({x0.a.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface b {
    }

    static abstract class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f8487a = 6;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f8488b = 7;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f8489c = 9;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f8490d = 10;

        private c() {
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        A = sparseIntArray;
        sparseIntArray.put(5, 1);
        sparseIntArray.put(6, 2);
        sparseIntArray.put(7, 2);
        sparseIntArray.put(8, 1);
        sparseIntArray.put(9, 1);
        sparseIntArray.put(10, 1);
        C = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 16};
    }

    AudioAttributesCompat() {
    }

    @x0({x0.a.LIBRARY_GROUP})
    public static AudioAttributesCompat g(Bundle bundle) {
        AudioAttributesImpl audioAttributesImplG = AudioAttributesImplApi21.g(bundle);
        if (audioAttributesImplG == null) {
            return null;
        }
        return new AudioAttributesCompat(audioAttributesImplG);
    }

    @x0({x0.a.LIBRARY_GROUP})
    public static void h(boolean z7) {
        B = z7;
    }

    static int i(boolean z7, int i7, int i8) {
        if ((i7 & 1) == 1) {
            return z7 ? 1 : 7;
        }
        if ((i7 & 4) == 4) {
            return z7 ? 0 : 6;
        }
        switch (i8) {
            case 0:
                return z7 ? Integer.MIN_VALUE : 3;
            case 1:
            case 12:
            case 14:
            case 16:
                return 3;
            case 2:
                return 0;
            case 3:
                return z7 ? 0 : 8;
            case 4:
                return 4;
            case 5:
            case 7:
            case 8:
            case 9:
            case 10:
                return 5;
            case 6:
                return 2;
            case 11:
                return 10;
            case 13:
                return 1;
            case 15:
            default:
                if (!z7) {
                    return 3;
                }
                throw new IllegalArgumentException("Unknown usage value " + i8 + " in audio attributes");
        }
    }

    static int j(boolean z7, AudioAttributesCompat audioAttributesCompat) {
        return i(z7, audioAttributesCompat.w(), audioAttributesCompat.d());
    }

    static int l(int i7) {
        switch (i7) {
            case 0:
                return 2;
            case 1:
            case 7:
                return 13;
            case 2:
                return 6;
            case 3:
                return 1;
            case 4:
                return 4;
            case 5:
                return 5;
            case 6:
                return 2;
            case 8:
                return 3;
            case 9:
            default:
                return 0;
            case 10:
                return 11;
        }
    }

    static String m(int i7) {
        switch (i7) {
            case 0:
                return "USAGE_UNKNOWN";
            case 1:
                return "USAGE_MEDIA";
            case 2:
                return "USAGE_VOICE_COMMUNICATION";
            case 3:
                return "USAGE_VOICE_COMMUNICATION_SIGNALLING";
            case 4:
                return "USAGE_ALARM";
            case 5:
                return "USAGE_NOTIFICATION";
            case 6:
                return "USAGE_NOTIFICATION_RINGTONE";
            case 7:
                return "USAGE_NOTIFICATION_COMMUNICATION_REQUEST";
            case 8:
                return "USAGE_NOTIFICATION_COMMUNICATION_INSTANT";
            case 9:
                return "USAGE_NOTIFICATION_COMMUNICATION_DELAYED";
            case 10:
                return "USAGE_NOTIFICATION_EVENT";
            case 11:
                return "USAGE_ASSISTANCE_ACCESSIBILITY";
            case 12:
                return "USAGE_ASSISTANCE_NAVIGATION_GUIDANCE";
            case 13:
                return "USAGE_ASSISTANCE_SONIFICATION";
            case 14:
                return "USAGE_GAME";
            case 15:
            default:
                return "unknown usage " + i7;
            case 16:
                return "USAGE_ASSISTANT";
        }
    }

    @o0
    public static AudioAttributesCompat n(@m0 Object obj) {
        if (B) {
            return null;
        }
        AudioAttributesImplApi21 audioAttributesImplApi21 = new AudioAttributesImplApi21((AudioAttributes) obj);
        AudioAttributesCompat audioAttributesCompat = new AudioAttributesCompat();
        audioAttributesCompat.f8486a = audioAttributesImplApi21;
        return audioAttributesCompat;
    }

    @x0({x0.a.LIBRARY_GROUP})
    @m0
    public Bundle a() {
        return this.f8486a.a();
    }

    public int b() {
        return this.f8486a.b();
    }

    int c() {
        return this.f8486a.c();
    }

    public int d() {
        return this.f8486a.d();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AudioAttributesCompat)) {
            return false;
        }
        AudioAttributesCompat audioAttributesCompat = (AudioAttributesCompat) obj;
        AudioAttributesImpl audioAttributesImpl = this.f8486a;
        if (audioAttributesImpl == null) {
            return audioAttributesCompat.f8486a == null;
        }
        return audioAttributesImpl.equals(audioAttributesCompat.f8486a);
    }

    public int f() {
        return this.f8486a.f();
    }

    public int getContentType() {
        return this.f8486a.getContentType();
    }

    public int hashCode() {
        return this.f8486a.hashCode();
    }

    @o0
    public Object k() {
        return this.f8486a.e();
    }

    public String toString() {
        return this.f8486a.toString();
    }

    public int w() {
        return this.f8486a.w();
    }

    AudioAttributesCompat(AudioAttributesImpl audioAttributesImpl) {
        this.f8486a = audioAttributesImpl;
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f8491a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f8492b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f8493c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f8494d;

        public d() {
            this.f8491a = 0;
            this.f8492b = 0;
            this.f8493c = 0;
            this.f8494d = -1;
        }

        public AudioAttributesCompat a() {
            AudioAttributesImpl audioAttributesImplBase;
            if (AudioAttributesCompat.B) {
                audioAttributesImplBase = new AudioAttributesImplBase(this.f8492b, this.f8493c, this.f8491a, this.f8494d);
            } else {
                AudioAttributes.Builder usage = new AudioAttributes.Builder().setContentType(this.f8492b).setFlags(this.f8493c).setUsage(this.f8491a);
                int i7 = this.f8494d;
                if (i7 != -1) {
                    usage.setLegacyStreamType(i7);
                }
                audioAttributesImplBase = new AudioAttributesImplApi21(usage.build(), this.f8494d);
            }
            return new AudioAttributesCompat(audioAttributesImplBase);
        }

        public d b(int i7) {
            if (i7 == 0 || i7 == 1 || i7 == 2 || i7 == 3 || i7 == 4) {
                this.f8492b = i7;
            } else {
                this.f8491a = 0;
            }
            return this;
        }

        public d c(int i7) {
            this.f8493c = (i7 & AudioAttributesCompat.N) | this.f8493c;
            return this;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        d d(int i7) {
            switch (i7) {
                case 0:
                    this.f8492b = 1;
                    break;
                case 1:
                    this.f8492b = 4;
                    break;
                case 2:
                    this.f8492b = 4;
                    break;
                case 3:
                    this.f8492b = 2;
                    break;
                case 4:
                    this.f8492b = 4;
                    break;
                case 5:
                    this.f8492b = 4;
                    break;
                case 6:
                    this.f8492b = 1;
                    this.f8493c |= 4;
                    break;
                case 7:
                    this.f8493c = 1 | this.f8493c;
                    this.f8492b = 4;
                    break;
                case 8:
                    this.f8492b = 4;
                    break;
                case 9:
                    this.f8492b = 4;
                    break;
                case 10:
                    this.f8492b = 1;
                    break;
                default:
                    Log.e(AudioAttributesCompat.f8461b, "Invalid stream type " + i7 + " for AudioAttributesCompat");
                    break;
            }
            this.f8491a = AudioAttributesCompat.l(i7);
            return this;
        }

        public d e(int i7) {
            if (i7 == 10) {
                throw new IllegalArgumentException("STREAM_ACCESSIBILITY is not a legacy stream type that was used for audio playback");
            }
            this.f8494d = i7;
            return d(i7);
        }

        public d f(int i7) {
            switch (i7) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                    this.f8491a = i7;
                    return this;
                case 16:
                    if (AudioAttributesCompat.B || Build.VERSION.SDK_INT <= 25) {
                        this.f8491a = 12;
                    } else {
                        this.f8491a = i7;
                    }
                    return this;
                default:
                    this.f8491a = 0;
                    return this;
            }
        }

        public d(AudioAttributesCompat audioAttributesCompat) {
            this.f8491a = 0;
            this.f8492b = 0;
            this.f8493c = 0;
            this.f8494d = -1;
            this.f8491a = audioAttributesCompat.d();
            this.f8492b = audioAttributesCompat.getContentType();
            this.f8493c = audioAttributesCompat.w();
            this.f8494d = audioAttributesCompat.c();
        }
    }
}
