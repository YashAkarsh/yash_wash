package androidx.databinding.adapters;

import android.widget.CalendarView;
import c.x0;

/* JADX INFO: loaded from: classes.dex */
@androidx.databinding.o({@androidx.databinding.n(attribute = "android:date", type = CalendarView.class)})
@x0({x0.a.LIBRARY})
public class g {

    static class a implements CalendarView.OnDateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ CalendarView.OnDateChangeListener f7228a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ androidx.databinding.m f7229b;

        a(CalendarView.OnDateChangeListener onDateChangeListener, androidx.databinding.m mVar) {
            this.f7228a = onDateChangeListener;
            this.f7229b = mVar;
        }

        @Override // android.widget.CalendarView.OnDateChangeListener
        public void onSelectedDayChange(CalendarView calendarView, int i7, int i8, int i9) {
            CalendarView.OnDateChangeListener onDateChangeListener = this.f7228a;
            if (onDateChangeListener != null) {
                onDateChangeListener.onSelectedDayChange(calendarView, i7, i8, i9);
            }
            this.f7229b.a();
        }
    }

    @androidx.databinding.d({"android:date"})
    public static void a(CalendarView calendarView, long j7) {
        if (calendarView.getDate() != j7) {
            calendarView.setDate(j7);
        }
    }

    @androidx.databinding.d(requireAll = false, value = {"android:onSelectedDayChange", "android:dateAttrChanged"})
    public static void b(CalendarView calendarView, CalendarView.OnDateChangeListener onDateChangeListener, androidx.databinding.m mVar) {
        if (mVar == null) {
            calendarView.setOnDateChangeListener(onDateChangeListener);
        } else {
            calendarView.setOnDateChangeListener(new a(onDateChangeListener, mVar));
        }
    }
}
