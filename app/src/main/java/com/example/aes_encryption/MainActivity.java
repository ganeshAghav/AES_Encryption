package com.example.aes_encryption;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class MainActivity extends AppCompatActivity {

    private static String TAG="MainActivity:- ";
    private EditText edtKey,edtDecryptionData,edtEncryptionData;
    private Button btnClear,btnShowResult;

    private String strKey,strDecryptionData,strEncryptionData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtKey=(EditText)findViewById(R.id.edt_key);
        edtDecryptionData=(EditText)findViewById(R.id.edt_decryptionData);
        edtEncryptionData=(EditText)findViewById(R.id.edt_encryptionData);

        btnClear=(Button)findViewById(R.id.btn_clear);
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtKey.setText("");
                edtDecryptionData.setText("");
                edtEncryptionData.setText("");
            }
        });

        btnShowResult=(Button)findViewById(R.id.btn_showResult);
        btnShowResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                strKey=edtKey.getText().toString().trim();
                strDecryptionData=edtDecryptionData.getText().toString().trim();
                strEncryptionData=edtEncryptionData.getText().toString().trim();

                if(!strKey.equals("")){

                    if(!strDecryptionData.equals("")){
                        try {
                            String EncryptionData = new AESEncryptionDecryption().encrypt(edtDecryptionData.getText().toString().trim(), edtKey.getText().toString().trim());
                            edtEncryptionData.setText(EncryptionData);
                        }
                        catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                    else if(!strEncryptionData.equals("")){
                        try {
                            String DecryptionData = new AESEncryptionDecryption().decrypt(edtEncryptionData.getText().toString().trim(), edtKey.getText().toString().trim());
                            edtDecryptionData.setText(DecryptionData);
                        }
                        catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                }
                else {
                    Toast.makeText(getApplicationContext(),"Please enter key",Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}