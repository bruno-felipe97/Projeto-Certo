package com.example.ismael.teste;


        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button mButton;
    private EditText mNameUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = (Button) findViewById(R.id.enter_button);

        mNameUser = (EditText) findViewById(R.id.username);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String nickText = mNameUser.getText().toString();
                if (nickText.isEmpty()) {
                    Log.e("Erro", "Nome Vazio!!!");
                } else {
                    openGamesListActivity(nickText);
                }
            }
        });
    }



    private void openGamesListActivity(String nickname) {
        Intent i = new Intent(this, GamesListActivity.class);
        startActivity(i);
    }
}