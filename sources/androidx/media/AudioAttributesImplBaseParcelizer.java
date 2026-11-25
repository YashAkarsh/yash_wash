package androidx.media;

import c.x0;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY})
public final class AudioAttributesImplBaseParcelizer {
    public static AudioAttributesImplBase read(androidx.versionedparcelable.e eVar) {
        AudioAttributesImplBase audioAttributesImplBase = new AudioAttributesImplBase();
        audioAttributesImplBase.f8499a = eVar.M(audioAttributesImplBase.f8499a, 1);
        audioAttributesImplBase.f8500b = eVar.M(audioAttributesImplBase.f8500b, 2);
        audioAttributesImplBase.f8501c = eVar.M(audioAttributesImplBase.f8501c, 3);
        audioAttributesImplBase.f8502d = eVar.M(audioAttributesImplBase.f8502d, 4);
        return audioAttributesImplBase;
    }

    public static void write(AudioAttributesImplBase audioAttributesImplBase, androidx.versionedparcelable.e eVar) {
        eVar.j0(false, false);
        eVar.M0(audioAttributesImplBase.f8499a, 1);
        eVar.M0(audioAttributesImplBase.f8500b, 2);
        eVar.M0(audioAttributesImplBase.f8501c, 3);
        eVar.M0(audioAttributesImplBase.f8502d, 4);
    }
}
