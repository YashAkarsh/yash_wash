package androidx.media;

import android.os.Bundle;
import c.m0;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
class AudioAttributesImplBase implements AudioAttributesImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f8499a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f8500b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f8501c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f8502d;

    AudioAttributesImplBase() {
        this.f8499a = 0;
        this.f8500b = 0;
        this.f8501c = 0;
        this.f8502d = -1;
    }

    public static AudioAttributesImpl g(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        return new AudioAttributesImplBase(bundle.getInt("androidx.media.audio_attrs.CONTENT_TYPE", 0), bundle.getInt("androidx.media.audio_attrs.FLAGS", 0), bundle.getInt("androidx.media.audio_attrs.USAGE", 0), bundle.getInt("androidx.media.audio_attrs.LEGACY_STREAM_TYPE", -1));
    }

    @Override // androidx.media.AudioAttributesImpl
    @m0
    public Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putInt("androidx.media.audio_attrs.USAGE", this.f8499a);
        bundle.putInt("androidx.media.audio_attrs.CONTENT_TYPE", this.f8500b);
        bundle.putInt("androidx.media.audio_attrs.FLAGS", this.f8501c);
        int i7 = this.f8502d;
        if (i7 != -1) {
            bundle.putInt("androidx.media.audio_attrs.LEGACY_STREAM_TYPE", i7);
        }
        return bundle;
    }

    @Override // androidx.media.AudioAttributesImpl
    public int b() {
        int i7 = this.f8502d;
        return i7 != -1 ? i7 : AudioAttributesCompat.i(false, this.f8501c, this.f8499a);
    }

    @Override // androidx.media.AudioAttributesImpl
    public int c() {
        return this.f8502d;
    }

    @Override // androidx.media.AudioAttributesImpl
    public int d() {
        return this.f8499a;
    }

    @Override // androidx.media.AudioAttributesImpl
    public Object e() {
        return null;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AudioAttributesImplBase)) {
            return false;
        }
        AudioAttributesImplBase audioAttributesImplBase = (AudioAttributesImplBase) obj;
        return this.f8500b == audioAttributesImplBase.getContentType() && this.f8501c == audioAttributesImplBase.w() && this.f8499a == audioAttributesImplBase.d() && this.f8502d == audioAttributesImplBase.f8502d;
    }

    @Override // androidx.media.AudioAttributesImpl
    public int f() {
        return AudioAttributesCompat.i(true, this.f8501c, this.f8499a);
    }

    @Override // androidx.media.AudioAttributesImpl
    public int getContentType() {
        return this.f8500b;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f8500b), Integer.valueOf(this.f8501c), Integer.valueOf(this.f8499a), Integer.valueOf(this.f8502d)});
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AudioAttributesCompat:");
        if (this.f8502d != -1) {
            sb.append(" stream=");
            sb.append(this.f8502d);
            sb.append(" derived");
        }
        sb.append(" usage=");
        sb.append(AudioAttributesCompat.m(this.f8499a));
        sb.append(" content=");
        sb.append(this.f8500b);
        sb.append(" flags=0x");
        sb.append(Integer.toHexString(this.f8501c).toUpperCase());
        return sb.toString();
    }

    @Override // androidx.media.AudioAttributesImpl
    public int w() {
        int i7 = this.f8501c;
        int iB = b();
        if (iB == 6) {
            i7 |= 4;
        } else if (iB == 7) {
            i7 |= 1;
        }
        return i7 & 273;
    }

    AudioAttributesImplBase(int i7, int i8, int i9, int i10) {
        this.f8500b = i7;
        this.f8501c = i8;
        this.f8499a = i9;
        this.f8502d = i10;
    }
}
