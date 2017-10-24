package studio.kucuela.tweetsvetjada;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText et = (EditText) findViewById(R.id.editText);

        Button btn = (Button) findViewById(R.id.button);
        final TextView tv_counter = (TextView) findViewById(R.id.brojac);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Set the first EditText empty
                et.setText("");


            }
        });

        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                tv_counter.setText(140 - s.toString().length() + "/140");

            }
        });







    }

    public void posalji (View view){

        EditText et=(EditText)findViewById(R.id.editText);
        String mString= et.getText().toString();
        Intent intent = null;

        try {

            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.putExtra(Intent.EXTRA_TEXT, mString);
            shareIntent.setPackage("com.twitter.android");
            shareIntent.setType("text/plain");
            startActivity(shareIntent);

            //this.getPackageManager().getPackageInfo("com.twitter.android", 0);
            /*intent = new Intent(Intent.ACTION_VIEW, Uri.parse("twitter://user?screen_name=<place_user_name_here>"));
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);*/


        } catch (Exception e) {
            // no Twitter app, revert to browser
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/"));
            startActivity(intent);
        }


    }






}
