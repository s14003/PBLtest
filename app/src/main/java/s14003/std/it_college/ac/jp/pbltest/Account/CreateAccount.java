package s14003.std.it_college.ac.jp.pbltest.Account;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import s14003.std.it_college.ac.jp.pbltest.R;

public class CreateAccount extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        final Button returnButton =  (Button)findViewById(R.id.btnReturn);
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("onClick", "true");
                Toast.makeText(CreateAccount.this, "戻ります", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
