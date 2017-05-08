package him.testloginpro;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static android.R.attr.value;
import static him.testloginpro.R.id.editText;
import static him.testloginpro.R.id.editText2;

public class MainActivity extends Activity implements View.OnClickListener {
    EditText userId;
    EditText passowrdData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.loginButton);
        button.setOnClickListener(this);
        userId = (EditText)findViewById(R.id.editText);
        passowrdData=(EditText)findViewById(R.id.editText2);

    }
    @Override
    public void onClick(View v) {
        Intent myIntent = new Intent(MainActivity.this, Main2Activity.class);
        myIntent.putExtra("userdId", userId.getText().toString()); //Optional parameters
        myIntent.putExtra("password", passowrdData.getText().toString());
        MainActivity.this.startActivity(myIntent);

    }

}


