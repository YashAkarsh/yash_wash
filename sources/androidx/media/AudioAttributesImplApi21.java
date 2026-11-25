package androidx.media;

import android.annotation.TargetApi;
import android.media.AudioAttributes;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import c.m0;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
@TargetApi(21)
class AudioAttributesImplApi21 implements AudioAttributesImpl {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f8495c = "AudioAttributesCompat21";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static Method f8496d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    AudioAttributes f8497a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f8498b;

    AudioAttributesImplApi21() {
        this.f8498b = -1;
    }

    public static AudioAttributesImpl g(Bundle bundle) {
        AudioAttributes audioAttributes;
        if (bundle == null || (audioAttributes = (AudioAttributes) bundle.getParcelable("androidx.media.audio_attrs.FRAMEWORKS")) == null) {
            return null;
        }
        return new AudioAttributesImplApi21(audioAttributes, bundle.getInt("androidx.media.audio_attrs.LEGACY_STREAM_TYPE", -1));
    }

    static Method h() {
        try {
            if (f8496d == null) {
                f8496d = AudioAttributes.class.getMethod("toLegacyStreamType", AudioAttributes.class);
            }
            return f8496d;
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    @Override // androidx.media.AudioAttributesImpl
    @m0
    public Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("androidx.media.audio_attrs.FRAMEWORKS", this.f8497a);
        int i7 = this.f8498b;
        if (i7 != -1) {
            bundle.putInt("androidx.media.audio_attrs.LEGACY_STREAM_TYPE", i7);
        }
        return bundle;
    }

    @Override // androidx.media.AudioAttributesImpl
    public int b() {
        int i7 = this.f8498b;
        if (i7 != -1) {
            return i7;
        }
        Method methodH = h();
        if (methodH == null) {
            Log.w(f8495c, "No AudioAttributes#toLegacyStreamType() on API: " + Build.VERSION.SDK_INT);
            return -1;
        }
        try {
            return ((Integer) methodH.invoke(null, this.f8497a)).intValue();
        } catch (IllegalAccessException | InvocationTargetException e8) {
            Log.w(f8495c, "getLegacyStreamType() failed on API: " + Build.VERSION.SDK_INT, e8);
            return -1;
        }
    }

    @Override // androidx.media.AudioAttributesImpl
    public int c() {
        return this.f8498b;
    }

    @Override // androidx.media.AudioAttributesImpl
    public int d() {
        return this.f8497a.getUsage();
    }

    @Override // androidx.media.AudioAttributesImpl
    public Object e() {
        return this.f8497a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof AudioAttributesImplApi21) {
            return this.f8497a.equals(((AudioAttributesImplApi21) obj).f8497a);
        }
        return false;
    }

    @Override // androidx.media.AudioAttributesImpl
    public int f() {
        return Build.VERSION.SDK_INT >= 26 ? this.f8497a.getVolumeControlStream() : AudioAttributesCompat.i(true, w(), d());
    }

    @Override // androidx.media.AudioAttributesImpl
    public int getContentType() {
        return this.f8497a.getContentType();
    }

    public int hashCode() {
        return this.f8497a.hashCode();
    }

    public String toString() {
        return "AudioAttributesCompat: audioattributes=" + this.f8497a;
    }

    @Override // androidx.media.AudioAttributesImpl
    public int w() {
        return this.f8497a.getFlags();
    }

    AudioAttributesImplApi21(AudioAttributes audioAttributes) {
        this(audioAttributes, -1);
    }

    AudioAttributesImplApi21(AudioAttributes audioAttributes, int i7) {
        this.f8497a = audioAttributes;
        this.f8498b = i7;
    }
}
