package androidx.databinding.adapters;

import android.widget.SeekBar;
import c.x0;

/* JADX INFO: loaded from: classes.dex */
@androidx.databinding.o({@androidx.databinding.n(attribute = "android:progress", type = SeekBar.class)})
@x0({x0.a.LIBRARY})
public class y {

    static class a implements SeekBar.OnSeekBarChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f7268a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ androidx.databinding.m f7269b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ c f7270c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ d f7271d;

        a(b bVar, androidx.databinding.m mVar, c cVar, d dVar) {
            this.f7268a = bVar;
            this.f7269b = mVar;
            this.f7270c = cVar;
            this.f7271d = dVar;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i7, boolean z7) {
            b bVar = this.f7268a;
            if (bVar != null) {
                bVar.onProgressChanged(seekBar, i7, z7);
            }
            androidx.databinding.m mVar = this.f7269b;
            if (mVar != null) {
                mVar.a();
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            c cVar = this.f7270c;
            if (cVar != null) {
                cVar.onStartTrackingTouch(seekBar);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            d dVar = this.f7271d;
            if (dVar != null) {
                dVar.onStopTrackingTouch(seekBar);
            }
        }
    }

    public interface b {
        void onProgressChanged(SeekBar seekBar, int i7, boolean z7);
    }

    public interface c {
        void onStartTrackingTouch(SeekBar seekBar);
    }

    public interface d {
        void onStopTrackingTouch(SeekBar seekBar);
    }

    @androidx.databinding.d(requireAll = false, value = {"android:onStartTrackingTouch", "android:onStopTrackingTouch", "android:onProgressChanged", "android:progressAttrChanged"})
    public static void a(SeekBar seekBar, c cVar, d dVar, b bVar, androidx.databinding.m mVar) {
        if (cVar == null && dVar == null && bVar == null && mVar == null) {
            seekBar.setOnSeekBarChangeListener(null);
        } else {
            seekBar.setOnSeekBarChangeListener(new a(bVar, mVar, cVar, dVar));
        }
    }

    @androidx.databinding.d({"android:progress"})
    public static void b(SeekBar seekBar, int i7) {
        if (i7 != seekBar.getProgress()) {
            seekBar.setProgress(i7);
        }
    }
}
