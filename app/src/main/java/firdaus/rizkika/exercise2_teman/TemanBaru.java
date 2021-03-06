package firdaus.rizkika.exercise2_teman;

import androidx.appcompat.app.AppCompatActivity;
import firdaus.rizkika.exercise2_teman.database.DBController;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.HashMap;

public class TemanBaru extends AppCompatActivity {
    private TextInputEditText tNama,tTelpon;
    private Button simpanbtn;
    String nm,tlp;
    DBController controller = new DBController(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teman_baru);

        tNama = findViewById(R.id.edtNama);
        tTelpon = findViewById(R.id.edttelpon);
        simpanbtn = findViewById(R.id.bttnSave);

        simpanbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tNama.getText().toString().equals("") || tTelpon.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Mohon di isi nama dan telpon",Toast.LENGTH_SHORT).show();
                }
                else{
                    nm = tNama.getText().toString();
                    tlp = tTelpon.getText().toString();

                    HashMap<String,String>qvalues = new HashMap<>();
                    qvalues.put("nama",nm);
                    qvalues.put("telpon",tlp);

                    controller.insertData(qvalues);
                    callHome();
                }
            }
        });
    }
    public void callHome(){
        Intent intent = new Intent(TemanBaru.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}