package android.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import static java.lang.String.valueOf;

public class ResultActivity extends AppCompatActivity {

    TextView nama_, hasil_, status_;
    ImageView gambar_stat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);


        nama_ = (TextView) findViewById(R.id.hasil_nama);
        status_ = (TextView) findViewById(R.id.hasil_status);
        hasil_ = (TextView) findViewById(R.id.hasil_angka);
        gambar_stat = (ImageView) findViewById(R.id.hasil_gambar);

        Intent intent = getIntent();
        String nama = intent.getStringExtra("extra_nama");
        String hasil = intent.getStringExtra("extra_angka");
        String status = intent.getStringExtra("extra_status");

        nama_.setText("Hai! "+nama);
        hasil_.setText("Score BMI-mu: "+hasil);
        status_.setText(status);
        gambar_stat.setImageResource(getIntent().getIntExtra("extra_gambar", R.drawable.pokemon));

    }


    public void backHit(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }
}
