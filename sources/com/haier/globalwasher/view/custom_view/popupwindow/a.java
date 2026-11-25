package com.haier.globalwasher.view.custom_view.popupwindow;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupWindow;
import androidx.constraintlayout.core.motion.utils.w;
import com.haier.globalwasher.R;

/* JADX INFO: loaded from: classes2.dex */
public class a extends PopupWindow {

    /* JADX INFO: renamed from: com.haier.globalwasher.view.custom_view.popupwindow.a$a, reason: collision with other inner class name */
    class ViewOnTouchListenerC0340a implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f25868a;

        ViewOnTouchListenerC0340a(View view) {
            this.f25868a = view;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int top = this.f25868a.findViewById(R.id.iv_cancel).getTop();
            int y7 = (int) motionEvent.getY();
            if (motionEvent.getAction() == 1 && y7 < top) {
                a.this.dismiss();
            }
            return true;
        }
    }

    public a(Context context, View view) {
        super(context);
        setContentView(view);
        setWidth(-1);
        setHeight(w.h.f3152j);
        setFocusable(true);
        setAnimationStyle(R.style.popupAnimation);
        setBackgroundDrawable(new ColorDrawable(-1342177280));
        view.setOnTouchListener(new ViewOnTouchListenerC0340a(view));
    }
}
