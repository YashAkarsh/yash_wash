package com.haier.uhome.ble.hal.a.a;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.content.Intent;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public class b extends BluetoothGattCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final f f28237a;

    public b(f fVar) {
        this.f28237a = fVar;
    }

    private void a(String str, UUID uuid, UUID uuid2, byte[] bArr) {
        e3.a.d("BLE", com.haier.uhome.ble.a.f28128b, "broadcastCharacterChanged  %s.", uuid);
        Intent intent = new Intent(com.haier.uhome.ble.a.f28139m);
        intent.putExtra(com.haier.uhome.ble.a.f28144r, str);
        intent.putExtra(com.haier.uhome.ble.a.f28145s, uuid.toString());
        intent.putExtra(com.haier.uhome.ble.a.f28146t, uuid2.toString());
        intent.putExtra(com.haier.uhome.ble.a.f28147u, bArr);
        com.haier.uhome.usdk.base.d.d dVar = new com.haier.uhome.usdk.base.d.d(com.haier.uhome.ble.hal.b.f28280c, 2);
        dVar.f31264c = intent;
        com.haier.uhome.usdk.base.d.c.a().c(dVar);
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        e3.a.d("BLE", com.haier.uhome.ble.a.f28128b, "----->  onCharacteristicChanged", new Object[0]);
        a(bluetoothGatt.getDevice().getAddress(), bluetoothGattCharacteristic.getService().getUuid(), bluetoothGattCharacteristic.getUuid(), bluetoothGattCharacteristic.getValue());
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i7) {
        e3.a.d("BLE", com.haier.uhome.ble.a.f28128b, "----->  onCharacteristicRead %d", Integer.valueOf(i7));
        this.f28237a.a(bluetoothGattCharacteristic, i7, bluetoothGattCharacteristic.getValue());
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i7) {
        e3.a.d("BLE", com.haier.uhome.ble.a.f28128b, "----->  onCharacteristicWrite %d", Integer.valueOf(i7));
        this.f28237a.b(bluetoothGattCharacteristic, i7, bluetoothGattCharacteristic.getValue());
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i7, int i8) {
        e3.a.d("BLE", com.haier.uhome.ble.a.f28128b, "----->  onConnectionStateChange status = %d, newState = %d", Integer.valueOf(i7), Integer.valueOf(i8));
        this.f28237a.a(i7, i8);
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onDescriptorRead(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i7) {
        e3.a.d("BLE", com.haier.uhome.ble.a.f28128b, "----->  onDescriptorRead %d", Integer.valueOf(i7));
        this.f28237a.a(bluetoothGattDescriptor, i7, bluetoothGattDescriptor.getValue());
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i7) {
        e3.a.d("BLE", com.haier.uhome.ble.a.f28128b, "----->  onDescriptorWrite %d", Integer.valueOf(i7));
        this.f28237a.a(bluetoothGattDescriptor, i7);
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onMtuChanged(BluetoothGatt bluetoothGatt, int i7, int i8) {
        e3.a.d("BLE", com.haier.uhome.ble.a.f28128b, "----->  onMtuChanged %d", Integer.valueOf(i8));
        this.f28237a.b(i7, i8);
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i7) {
        e3.a.d("BLE", com.haier.uhome.ble.a.f28128b, "----->  onServicesDiscovered %d", Integer.valueOf(i7));
        this.f28237a.a(i7);
    }
}
