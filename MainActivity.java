package com.cunanan.labexercise4;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.style.ParagraphStyle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {
    Button Shared,Clear,Display;
    EditText Paragraph ;
    TextView Output;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Paragraph = (EditText) findViewById(R.id.Paragraph);
        Shared= (Button) findViewById(R.id.Shared);
        Clear = (Button) findViewById(R.id.Clear);
        Display = (Button)  findViewById(R.id.Display);
        Output = (TextView) findViewById(R.id.Output);
    }
    public void Share(View view){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("paragraph", Paragraph.getText().toString());
        editor.commit();
        Toast.makeText(this, "Data Saved", Toast.LENGTH_SHORT).show();
    }
    public void btDisplay(View view) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String user = preferences.getString("paragraph", "");
        Output.setText(user);
    }
    public void btClear(View view){
        Output.setText("");
    }
}
