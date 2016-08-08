package s14003.std.it_college.ac.jp.pbltest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import s14003.std.it_college.ac.jp.pbltest.Account.CreateAccount;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText setAddress = (EditText)findViewById(R.id.setAddress);

        Button createAccountBtn = (Button)findViewById(R.id.btnCreateAccount);
        createAccountBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createAccount();
            }
        });
        Button login = (Button)findViewById(R.id.btnLogin);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //全角半角の判定
                String str = setAddress.toString();
                for (int i = 0; i < str.length(); i++) {
                    char c = str.charAt(i);
                    if ((c <= '\u007e') || (c == '\u00a5') || ((c >= '\uff61') && (c <= '\uff9f'))) {//半角
                        Log.d("test", str);

                    } else {
                        Toast.makeText(MainActivity.this, "半角英数で入力してください", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 0, 0, "商品画面一覧へ");
        menu.add(0, 10, 1, "メニュー2");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 0:
                Toast.makeText(this, "商品一覧画面へ遷移します",Toast.LENGTH_SHORT).show();
                productView();
                return true;
            case 10:
                Toast.makeText(this, "メニュー2がクリックされました", Toast.LENGTH_SHORT).show();
                return true;
            default:

                Toast.makeText(this, "オプションメニューがクリックされました", Toast.LENGTH_LONG).show();
                return super.onOptionsItemSelected(item);

        }

    }
    public void createAccount() {
        Log.d("createAccount", "call");
        Intent intent = new Intent(MainActivity.this, CreateAccount.class);
        startActivity(intent);
    }
    public void productView() {
        Intent it = new Intent(MainActivity.this, ProductView.class);
        startActivity(it);
    }


}
