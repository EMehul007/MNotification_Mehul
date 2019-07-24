package com.example.mnotification.WhatsappAndMessage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;

import com.example.mnotification.R;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Whatsapp_MessageActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whatsapp__message);


        try {
            PackageInfo info = getPackageManager().getPackageInfo("com.example.mnotification", PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                String sign= Base64.encodeToString(md.digest(), Base64.DEFAULT);
                Log.e("MYKeyHash",""+sign);
                //textInstructionsOrLink = (TextView)findViewById(R.id.textstring);
                //textInstructionsOrLink.setText(sign);
                Toast.makeText(getApplicationContext(),sign, Toast.LENGTH_LONG).show();


            }
        } catch (PackageManager.NameNotFoundException e) {
            Log.d("nope","nope");
        } catch (NoSuchAlgorithmException e) {
        }
    }
}
