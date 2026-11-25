package androidx.databinding.adapters;

import android.widget.NumberPicker;
import c.x0;

/* JADX INFO: loaded from: classes.dex */
@androidx.databinding.o({@androidx.databinding.n(attribute = "android:value", type = NumberPicker.class)})
@x0({x0.a.LIBRARY})
@androidx.databinding.h({@androidx.databinding.g(attribute = "android:format", method = "setFormatter", type = NumberPicker.class), @androidx.databinding.g(attribute = "android:onScrollStateChange", method = "setOnScrollListener", type = NumberPicker.class)})
public class s {

    static class a implements NumberPicker.OnValueChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ NumberPicker.OnValueChangeListener f7250a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ androidx.databinding.m f7251b;

        a(NumberPicker.OnValueChangeListener onValueChangeListener, androidx.databinding.m mVar) {
            this.f7250a = onValueChangeListener;
            this.f7251b = mVar;
        }

        @Override // android.widget.NumberPicker.OnValueChangeListener
        public void onValueChange(NumberPicker numberPicker, int i7, int i8) {
            NumberPicker.OnValueChangeListener onValueChangeListener = this.f7250a;
            if (onValueChangeListener != null) {
                onValueChangeListener.onValueChange(numberPicker, i7, i8);
            }
            this.f7251b.a();
        }
    }

    @androidx.databinding.d(requireAll = false, value = {"android:onValueChange", "android:valueAttrChanged"})
    public static void a(NumberPicker numberPicker, NumberPicker.OnValueChangeListener onValueChangeListener, androidx.databinding.m mVar) {
        if (mVar == null) {
            numberPicker.setOnValueChangedListener(onValueChangeListener);
        } else {
            numberPicker.setOnValueChangedListener(new a(onValueChangeListener, mVar));
        }
    }

    @androidx.databinding.d({"android:value"})
    public static void b(NumberPicker numberPicker, int i7) {
        if (numberPicker.getValue() != i7) {
            numberPicker.setValue(i7);
        }
    }
}
