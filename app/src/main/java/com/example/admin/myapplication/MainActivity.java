package com.example.admin.myapplication;


        import android.view.View;
        import android.os.Bundle;
        import android.app.Activity;
        import android.widget.Button;
        import android.content.Intent;
        import android.widget.EditText;
        import android.util.Log;

public class MainActivity extends Activity {
    EditText ed1,ed2,ed3;
    String st1,st2,st3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void showMap(View view) {

        ed1   = (EditText)findViewById(R.id.editText);
        ed2  = (EditText)findViewById(R.id.editText1);
        ed3   = (EditText)findViewById(R.id.editText2);
        st1= ed1.getText().toString();
        st2= ed2.getText().toString();
        st3= ed3.getText().toString();
        st1=st1+st2+st3;
        Intent intent = new Intent(this, MapActivity.class);
        intent.putExtra("msg",st1);
        startActivity(intent);

    }
}