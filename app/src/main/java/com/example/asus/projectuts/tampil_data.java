package com.example.asus.projectuts;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class tampil_data extends AppCompatActivity implements View.OnClickListener {
    Button close;
    TextView tvNama, tvNim, tvKelas, tvStatus, tvProdi, tvSenin, tvSelasa, tvRabu, tvKamis;
    ImageView imgTampil;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil_data);
        Intent intent = getIntent();

        close = findViewById(R.id.keluar);
        close.setOnClickListener(this);

        tvNama = findViewById(R.id.tvNama);
        tvNim = findViewById(R.id.tvNim);
        tvProdi = findViewById(R.id.tvProdi);
        tvKelas = findViewById(R.id.tvKelas);
        tvStatus = findViewById(R.id.tvStatus);
        imgTampil = findViewById(R.id.gambar);

        tvSenin = findViewById(R.id.tvSenin);
        tvSelasa = findViewById(R.id.tvSelasa);
        tvRabu = findViewById(R.id.tvRabu);
        tvKamis = findViewById(R.id.tvKamis);

        tvNama.setText  ("Nama    : "+intent.getStringExtra("nama"));
        tvNim.setText   ("NIM       : "+intent.getStringExtra("nim"));
        tvKelas.setText ("Kelas     : "+intent.getStringExtra("kelas"));
        tvProdi.setText ("Prodi     : "+intent.getStringExtra("prodi"));
        tvStatus.setText("Status   : "+intent.getStringExtra("status"));

        tvSenin.setText ("Senin      : "+intent.getStringExtra("senin"));
        tvSelasa.setText("Selasa   : "+intent.getStringExtra("selasa"));
        tvRabu.setText  ("Rabu      : "+intent.getStringExtra("rabu"));
        tvKamis.setText ("Kamis    : "+intent.getStringExtra("kamis"));

        if (intent.getStringExtra("image") != null) {
            Uri ImageUri = Uri.parse(intent.getStringExtra("image"));
            imgTampil.setImageURI(ImageUri);

        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.keluar:
                Intent moveIntent = new Intent(tampil_data.this, MainActivity.class);
                startActivity(moveIntent);
                finish();
                break;
        }
    }
}


