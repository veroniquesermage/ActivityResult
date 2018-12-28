package fr.wcs.activityresult;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final int TABACTIVITY_REQUEST_CODE = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendMessage(View view){
        Intent firstOfAll = new Intent(this, TabActivity.class);
        startActivityForResult(firstOfAll,TABACTIVITY_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == TABACTIVITY_REQUEST_CODE){
            if (resultCode == RESULT_OK){
                String message = data.getStringExtra("keyOne");
                TextView textView = (TextView)findViewById(R.id.mainActivityTextView);
                textView.setText(message);
            }
        }
    }
}
