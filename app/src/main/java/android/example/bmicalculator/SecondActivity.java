package android.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import javax.xml.transform.Result;

public class SecondActivity extends AppCompatActivity {

    private bmiCalc mbmiCalc;
    EditText bb_, tb_, nama_;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mbmiCalc = new bmiCalc();
        bb_ = findViewById(R.id.bb);
        tb_ = findViewById(R.id.tb);
        nama_ = findViewById(R.id.nama);
    }

    public void bukaAct1(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    public void hitung_bmi(View view) {

        String status;

        if (bb_.getText().toString().isEmpty()){
            displayToast("Berat Badan tidak boleh kososng");
        } else if (tb_.getText().toString().isEmpty()){
            displayToast("Tinggi Badan tidak boleh kososng");
        } else if (nama_.getText().toString().isEmpty()){
            displayToast("Tolong diisi namanya ya :D");
        } else {
            Intent intent = new Intent(this, ResultActivity.class);

            String bb = bb_.getText().toString();
            String tb = tb_.getText().toString();
            String nama = nama_.getText().toString();

            double result, berat, tinggi;

            berat = Double.parseDouble(bb);
            tinggi = Double.parseDouble(tb);

            result = Double.valueOf(mbmiCalc.bmiCalculate(berat, tinggi));

            if(result < 18.5){
                status = "Wah sepertinya kamu kekurangan massa tubuh";
                intent.putExtra("extra_gambar", R.drawable.allmight);
            } else if(result >= 18.5 && result <= 24.9){
                status = "Selamat massa tubuhmu sudah ideal :D";
                intent.putExtra("extra_gambar", R.drawable.saitama);
            } else if(result > 24.9 && result <= 29.9){
                status = "Waduh kamu kelebihan berat badan, harus \n diet nih";
                intent.putExtra("extra_gambar", R.drawable.chouji);
            } else if (result > 29.9){
                status = "Oh tidak!! kamu terkena obesitas, diperbaiki pola makannya ya";
                intent.putExtra("extra_gambar", R.drawable.pokemon);
            } else{
                status = "Oh tidak!! kamu terkena obesitas, diperbaiki pola makannya ya";
                intent.putExtra("extra_gambar", R.drawable.pokemon);
            }

            String result_ = String.format("%.2f", result);

            intent.putExtra("extra_nama", nama);
            intent.putExtra("extra_status", status);
            intent.putExtra("extra_angka", result_);

            startActivity(intent);
        }

    }
}
