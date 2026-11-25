package androidx.databinding.adapters;

import android.widget.CompoundButton;
import c.x0;

/* JADX INFO: loaded from: classes.dex */
@androidx.databinding.o({@androidx.databinding.n(attribute = "android:checked", type = CompoundButton.class)})
@x0({x0.a.LIBRARY})
@androidx.databinding.h({@androidx.databinding.g(attribute = "android:buttonTint", method = "setButtonTintList", type = CompoundButton.class), @androidx.databinding.g(attribute = "android:onCheckedChanged", method = "setOnCheckedChangeListener", type = CompoundButton.class)})
public class k {

    static class a implements CompoundButton.OnCheckedChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ CompoundButton.OnCheckedChangeListener f7238a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ androidx.databinding.m f7239b;

        a(CompoundButton.OnCheckedChangeListener onCheckedChangeListener, androidx.databinding.m mVar) {
            this.f7238a = onCheckedChangeListener;
            this.f7239b = mVar;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z7) {
            CompoundButton.OnCheckedChangeListener onCheckedChangeListener = this.f7238a;
            if (onCheckedChangeListener != null) {
                onCheckedChangeListener.onCheckedChanged(compoundButton, z7);
            }
            this.f7239b.a();
        }
    }

    @androidx.databinding.d({"android:checked"})
    public static void a(CompoundButton compoundButton, boolean z7) {
        if (compoundButton.isChecked() != z7) {
            compoundButton.setChecked(z7);
        }
    }

    @androidx.databinding.d(requireAll = false, value = {"android:onCheckedChanged", "android:checkedAttrChanged"})
    public static void b(CompoundButton compoundButton, CompoundButton.OnCheckedChangeListener onCheckedChangeListener, androidx.databinding.m mVar) {
        if (mVar == null) {
            compoundButton.setOnCheckedChangeListener(onCheckedChangeListener);
        } else {
            compoundButton.setOnCheckedChangeListener(new a(onCheckedChangeListener, mVar));
        }
    }
}
