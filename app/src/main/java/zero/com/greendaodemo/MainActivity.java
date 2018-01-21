package zero.com.greendaodemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sample(View view) {
        Intent intent = new Intent(MainActivity.this, SampleActivity.class);
        startActivity(intent);
    }

    public void sample2(View view) {
        Intent intent = new Intent(MainActivity.this, Sample2Activity.class);
        startActivity(intent);
    }
}
