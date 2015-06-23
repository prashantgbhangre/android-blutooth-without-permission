package com.ptashantb.demoApp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

/*

Following Permission are used in manifest

    <uses-permission android:name="android.permission.BLUETOOTH" />
    <uses-permission android:name="android.permission.BLUETOOTH_ADMIN" />
    
    For BLE use add these feature
    
    <uses-feature
    android:name="android.hardware.bluetooth_le"
    android:required="true" />

*/

public class BlutoothActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		            
		checkBlutoothWithoutPermission();
        
        checkBlutoothWithPermission();
		
	}

	private void checkBlutoothWithoutPermission() {

        private BluetoothAdapter bt = BluetoothAdapter.getDefaultAdapter();
		if (bt == null) {
			Toast.makeText(this, "No bluetooth found.." + bt, Toast.LENGTH_LONG)
					.show();
		} else {
			if (!bt.isEnabled()) {
				bt.enable();   // For Disable use bt.disable();
			} 
		}
	}
	
    	private void checkBlutoothWithPermission() {
		if (!getPackageManager().hasSystemFeature(
				PackageManager.FEATURE_BLUETOOTH_LE)) {
			Toast.makeText(this, "Blutooth Not supported !!!", Toast.LENGTH_SHORT)
					.show();
		}
		
		  BluetoothAdapter mBluetoothAdapter; final BluetoothManager
		  bluetoothManager = (BluetoothManager)
		  getSystemService(Context.BLUETOOTH_SERVICE); mBluetoothAdapter =
		  bluetoothManager.getAdapter();
		  
		  if (mBluetoothAdapter == null || !mBluetoothAdapter.isEnabled()) {
		  
		  Intent enableBtIntent = new
		  Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
		  startActivityForResult(enableBtIntent, 1); 
	}
}
