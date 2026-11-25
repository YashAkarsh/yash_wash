package androidx.media;

import c.x0;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY})
public final class AudioAttributesCompatParcelizer {
    public static AudioAttributesCompat read(androidx.versionedparcelable.e eVar) {
        AudioAttributesCompat audioAttributesCompat = new AudioAttributesCompat();
        audioAttributesCompat.f8486a = (AudioAttributesImpl) eVar.h0(audioAttributesCompat.f8486a, 1);
        return audioAttributesCompat;
    }

    public static void write(AudioAttributesCompat audioAttributesCompat, androidx.versionedparcelable.e eVar) {
        eVar.j0(false, false);
        eVar.m1(audioAttributesCompat.f8486a, 1);
    }
}
