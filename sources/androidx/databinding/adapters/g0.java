package androidx.databinding.adapters;

import android.widget.TimePicker;
import c.x0;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY})
public class g0 {

    static class a implements TimePicker.OnTimeChangedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ TimePicker.OnTimeChangedListener f7230a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ androidx.databinding.m f7231b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ androidx.databinding.m f7232c;

        a(TimePicker.OnTimeChangedListener onTimeChangedListener, androidx.databinding.m mVar, androidx.databinding.m mVar2) {
            this.f7230a = onTimeChangedListener;
            this.f7231b = mVar;
            this.f7232c = mVar2;
        }

        @Override // android.widget.TimePicker.OnTimeChangedListener
        public void onTimeChanged(TimePicker timePicker, int i7, int i8) {
            TimePicker.OnTimeChangedListener onTimeChangedListener = this.f7230a;
            if (onTimeChangedListener != null) {
                onTimeChangedListener.onTimeChanged(timePicker, i7, i8);
            }
            androidx.databinding.m mVar = this.f7231b;
            if (mVar != null) {
                mVar.a();
            }
            androidx.databinding.m mVar2 = this.f7232c;
            if (mVar2 != null) {
                mVar2.a();
            }
        }
    }

    @androidx.databinding.l(attribute = "android:hour")
    public static int a(TimePicker timePicker) {
        return timePicker.getHour();
    }

    @androidx.databinding.l(attribute = "android:minute")
    public static int b(TimePicker timePicker) {
        return timePicker.getMinute();
    }

    @androidx.databinding.d({"android:hour"})
    public static void c(TimePicker timePicker, int i7) {
        if (timePicker.getHour() != i7) {
            timePicker.setHour(i7);
        }
    }

    @androidx.databinding.d(requireAll = false, value = {"android:onTimeChanged", "android:hourAttrChanged", "android:minuteAttrChanged"})
    public static void d(TimePicker timePicker, TimePicker.OnTimeChangedListener onTimeChangedListener, androidx.databinding.m mVar, androidx.databinding.m mVar2) {
        if (mVar == null && mVar2 == null) {
            timePicker.setOnTimeChangedListener(onTimeChangedListener);
        } else {
            timePicker.setOnTimeChangedListener(new a(onTimeChangedListener, mVar, mVar2));
        }
    }

    @androidx.databinding.d({"android:minute"})
    public static void e(TimePicker timePicker, int i7) {
        if (timePicker.getMinute() != i7) {
            timePicker.setMinute(i7);
        }
    }
}
