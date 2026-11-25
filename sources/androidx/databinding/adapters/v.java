package androidx.databinding.adapters;

import android.widget.RadioGroup;
import c.x0;

/* JADX INFO: loaded from: classes.dex */
@androidx.databinding.o({@androidx.databinding.n(attribute = "android:checkedButton", method = "getCheckedRadioButtonId", type = RadioGroup.class)})
@x0({x0.a.LIBRARY})
public class v {

    static class a implements RadioGroup.OnCheckedChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ RadioGroup.OnCheckedChangeListener f7260a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ androidx.databinding.m f7261b;

        a(RadioGroup.OnCheckedChangeListener onCheckedChangeListener, androidx.databinding.m mVar) {
            this.f7260a = onCheckedChangeListener;
            this.f7261b = mVar;
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public void onCheckedChanged(RadioGroup radioGroup, int i7) {
            RadioGroup.OnCheckedChangeListener onCheckedChangeListener = this.f7260a;
            if (onCheckedChangeListener != null) {
                onCheckedChangeListener.onCheckedChanged(radioGroup, i7);
            }
            this.f7261b.a();
        }
    }

    @androidx.databinding.d({"android:checkedButton"})
    public static void a(RadioGroup radioGroup, int i7) {
        if (i7 != radioGroup.getCheckedRadioButtonId()) {
            radioGroup.check(i7);
        }
    }

    @androidx.databinding.d(requireAll = false, value = {"android:onCheckedChanged", "android:checkedButtonAttrChanged"})
    public static void b(RadioGroup radioGroup, RadioGroup.OnCheckedChangeListener onCheckedChangeListener, androidx.databinding.m mVar) {
        if (mVar == null) {
            radioGroup.setOnCheckedChangeListener(onCheckedChangeListener);
        } else {
            radioGroup.setOnCheckedChangeListener(new a(onCheckedChangeListener, mVar));
        }
    }
}
