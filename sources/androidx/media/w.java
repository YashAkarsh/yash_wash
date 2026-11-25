package androidx.media;

import android.media.VolumeProvider;
import c.t0;

/* JADX INFO: loaded from: classes.dex */
@t0(21)
class w {

    static class a extends VolumeProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f8702a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(int i7, int i8, int i9, b bVar) {
            super(i7, i8, i9);
            this.f8702a = bVar;
        }

        @Override // android.media.VolumeProvider
        public void onAdjustVolume(int i7) {
            this.f8702a.b(i7);
        }

        @Override // android.media.VolumeProvider
        public void onSetVolumeTo(int i7) {
            this.f8702a.a(i7);
        }
    }

    public interface b {
        void a(int i7);

        void b(int i7);
    }

    private w() {
    }

    public static Object a(int i7, int i8, int i9, b bVar) {
        return new a(i7, i8, i9, bVar);
    }

    public static void b(Object obj, int i7) {
        ((VolumeProvider) obj).setCurrentVolume(i7);
    }
}
