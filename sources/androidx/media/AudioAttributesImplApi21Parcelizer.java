package androidx.media;

import android.media.AudioAttributes;
import c.x0;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY})
public final class AudioAttributesImplApi21Parcelizer {
    public static AudioAttributesImplApi21 read(androidx.versionedparcelable.e eVar) {
        AudioAttributesImplApi21 audioAttributesImplApi21 = new AudioAttributesImplApi21();
        audioAttributesImplApi21.f8497a = (AudioAttributes) eVar.W(audioAttributesImplApi21.f8497a, 1);
        audioAttributesImplApi21.f8498b = eVar.M(audioAttributesImplApi21.f8498b, 2);
        return audioAttributesImplApi21;
    }

    public static void write(AudioAttributesImplApi21 audioAttributesImplApi21, androidx.versionedparcelable.e eVar) {
        eVar.j0(false, false);
        eVar.X0(audioAttributesImplApi21.f8497a, 1);
        eVar.M0(audioAttributesImplApi21.f8498b, 2);
    }
}
