package com.haier.uhome.ble.hal.a.a;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;

/* JADX INFO: loaded from: classes2.dex */
public interface f {
    void a(int i7);

    void a(int i7, int i8);

    void a(BluetoothGattCharacteristic bluetoothGattCharacteristic, int i7, byte[] bArr);

    void a(BluetoothGattDescriptor bluetoothGattDescriptor, int i7);

    void a(BluetoothGattDescriptor bluetoothGattDescriptor, int i7, byte[] bArr);

    void b(int i7, int i8);

    void b(BluetoothGattCharacteristic bluetoothGattCharacteristic, int i7, byte[] bArr);
}
