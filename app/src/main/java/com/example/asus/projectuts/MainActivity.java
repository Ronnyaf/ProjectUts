package com.example.asus.projectuts;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnBrowse;
    FloatingActionButton btnclose;
    EditText etNama, etNim, etKelas, etStatus, etProdi, etSenin, etSelasa, etRabu, etKamis ;
    ImageView imgView;
    private static final int PICK_IMAGE = 100;
    Uri ImageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = findViewById(R.id.etNama);
        etNim = findViewById(R.id.etNim);
        etKelas = findViewById(R.id.etKelas);
        etProdi = findViewById(R.id.etProdi);
        etStatus = findViewById(R.id.etStatus);
        etSenin = findViewById(R.id.etSenin);
        etSelasa = findViewById(R.id.etSelasa);
        etRabu = findViewById(R.id.etRabu);
        etKamis = findViewById(R.id.etKamis);
        imgView = findViewById(R.id.inputfoto);
        btnBrowse = findViewById(R.id.btnBrowse);
        btnBrowse.setOnClickListener(this);

        btnclose = findViewById(R.id.id_add);
        btnclose.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.id_add:
                String strNama = etNama.getText().toString();
                String strNim = etNim.getText().toString();
                String strKelas = etKelas.getText().toString();
                String strProdi = etProdi.getText().toString();
                String strStatus = etStatus.getText().toString();

                String strSenin = etSenin.getText().toString();
                String strSelasa = etSelasa.getText().toString();
                String strRabu = etRabu.getText().toString();
                String strKamis = etKamis.getText().toString();

                Intent intent = new Intent(MainActivity.this, tampil_data.class);
                intent.putExtra("nama", strNama);
                intent.putExtra("nim", strNim);
                intent.putExtra("kelas", strKelas);
                intent.putExtra("prodi", strProdi);
                intent.putExtra("status", strStatus);

                intent.putExtra("senin", strSenin);
                intent.putExtra("selasa", strSelasa);
                intent.putExtra("rabu", strRabu);
                intent.putExtra("kamis", strKamis);

                if (ImageUri != null) {
                    String picture = ImageUri.toString();
                    intent.putExtra("image", picture);
                }
                startActivity(intent);
                break;

            case R.id.btnBrowse:
                Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                startActivityForResult(gallery, PICK_IMAGE);
        }
    }


        @Override
        protected void onActivityResult ( int requestCode, int resultCode, @Nullable Intent data){
            super.onActivityResult(requestCode, resultCode, data);
            if (resultCode == RESULT_OK && requestCode == PICK_IMAGE) {
                ImageUri = data.getData();
                imgView.setImageURI(ImageUri);
            }

        }
    }


