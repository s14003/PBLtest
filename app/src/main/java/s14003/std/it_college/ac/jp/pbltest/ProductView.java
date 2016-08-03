package s14003.std.it_college.ac.jp.pbltest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class ProductView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_view);

        final String[] item = new String[]{
                "鉛筆",
                "消しゴム",
                "本"
        };

        // 追加するアイテムを生成する
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_multiple_choice, item);

        // リストビューにアイテム (adapter) を追加
        ListView listView1 = (ListView) findViewById(R.id.List);
        listView1.setAdapter(adapter);

        // ボタンクリックイベント
        Button btn = (Button) findViewById(R.id.btnOk);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // 選択アイテムを取得
                ListView listView1 = (ListView) findViewById(R.id.List);
                SparseBooleanArray checked = listView1.getCheckedItemPositions();

                // チェックされたアイテムの文字列を生成
                // checked には、「チェックされているアイテム」ではなく、
                // 「一度でもチェックされたアイテム」が入ってくる。
                // なので、現在チェックされているかどうかを valutAt の戻り値
                // で判定する必要がある！！！
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < checked.size(); i++) {
                    if (checked.valueAt(i)) {
                        sb.append(item[i] + ",");
                    }
                }
                // 通知
                Toast.makeText(ProductView.this, sb.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        final Button returnButton =  (Button)findViewById(R.id.btnReturn);
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("onClick", "true");
                Toast.makeText(ProductView.this, "戻ります", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
