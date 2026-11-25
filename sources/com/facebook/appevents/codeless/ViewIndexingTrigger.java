package com.facebook.appevents.codeless;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

/* JADX INFO: loaded from: classes.dex */
class ViewIndexingTrigger implements SensorEventListener {
    private static final double SHAKE_THRESHOLD_GRAVITY = 2.299999952316284d;
    private OnShakeListener mListener;

    public interface OnShakeListener {
        void onShake();
    }

    ViewIndexingTrigger() {
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i7) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (this.mListener != null) {
            float[] fArr = sensorEvent.values;
            double d8 = fArr[0] / 9.80665f;
            double d9 = fArr[1] / 9.80665f;
            double d10 = fArr[2] / 9.80665f;
            if (Math.sqrt((d8 * d8) + (d9 * d9) + (d10 * d10)) > SHAKE_THRESHOLD_GRAVITY) {
                this.mListener.onShake();
            }
        }
    }

    public void setOnShakeListener(OnShakeListener onShakeListener) {
        this.mListener = onShakeListener;
    }
}
