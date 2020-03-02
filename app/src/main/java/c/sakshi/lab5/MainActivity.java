package c.sakshi.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String usernameKey = "username";

        SharedPreferences sharedPreferences = getSharedPreferences("c.sakshi.lab5", Context.MODE_PRIVATE);

        if(!sharedPreferences.getString(usernameKey, "").equals("")){
            String username = sharedPreferences.getString(usernameKey, "");
            goToNotesActivity(username);
        } else{
            setContentView(R.layout.activity_main);
        }


    }

    public void loginFunction (View view){
        EditText username = (EditText) findViewById(R.id.username);
        String str =   username.getText().toString();

        SharedPreferences sharedPreferences = getSharedPreferences("c.sakshi.lab5", Context.MODE_PRIVATE);
        sharedPreferences.edit().putString("username", "username").apply();

        goToNotesActivity(str);
    }

    public void goToNotesActivity(String s){
        Intent intent = new Intent (this, NotesActivity.class);
        intent.putExtra("message", "Welcome " + s + "!");
        startActivity(intent);
    }
}
