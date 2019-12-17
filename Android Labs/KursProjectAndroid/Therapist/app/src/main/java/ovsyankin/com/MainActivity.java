package ovsyankin.com;


import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;

import com.google.firebase.auth.FirebaseAuth;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ImageButton imgbtn1;
    ImageButton imgbtn2;

    ImageButton btnLogout;
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgbtn1 = (ImageButton) findViewById(R.id.imgbtn1);
        imgbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inToMain = new Intent(MainActivity.this,Main.class);
                startActivity(inToMain);
            }
        });

        imgbtn2 = (ImageButton) findViewById(R.id.imgbtn2);

        imgbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inToDiric = new Intent(MainActivity.this,Directory.class);
                startActivity(inToDiric);
            }
        });


        btnLogout=findViewById(R.id.logOut);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent inToMain = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(inToMain);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.about_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        switch (id) {
            case R.id.about_therapist:
                createAboutBox();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void createAboutBox() {
        Dialog aboutBox = new Dialog(this);
        aboutBox.setCanceledOnTouchOutside(true);
        aboutBox.requestWindowFeature(Window.FEATURE_NO_TITLE);
        aboutBox.getWindow().setBackgroundDrawableResource(R.drawable.about_box);
        aboutBox.setContentView(R.layout.about);
        aboutBox.show();
    }

}
