package com.android.houcem.barcodereader;

import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;

public class MainActivity extends AppCompatActivity {

    TextView barcode_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        barcode_text = (TextView) findViewById(R.id.barecode);

    }

    public void scanBarcode(View view){
        startActivityForResult( new Intent(MainActivity.this,ScanBarcodeActivity.class),0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==0){
            if(requestCode== CommonStatusCodes.SUCCESS){
                if(data!=null) {
                    Barcode barcode = data.getParcelableExtra("barcode");
                    barcode_text.setText(barcode.displayValue);
                }
                else
                    barcode_text.setText("No BarCode");
            }
        }
        super.onActivityResult(requestCode,resultCode,data);
    }
}
