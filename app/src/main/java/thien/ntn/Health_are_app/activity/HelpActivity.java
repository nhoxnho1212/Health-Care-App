package thien.ntn.Health_are_app.activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;

import thien.ntn.myapplication.R;

public class HelpActivity extends AppCompatActivity {

    //Reading/Writing the steps related history on to a local storage file
    public String path  = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Step Counter";
    File myDirs = new File(path);
    File file =new File(path+"/stepCountHistory.txt");

    private Intent intentMainactivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        buttonClickListener();
    }

    private void buttonClickListener() {
        Button clear = (Button) findViewById(R.id.clear_data);
        Button back = (Button) findViewById(R.id.button_back);
        //Play Button onclick listener
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                if(file.exists()){
                    file.delete();
                }
                String msg = "Data cleared";
                Toast toast = Toast.makeText(HelpActivity.this,msg,Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        //Handling back button click
        //Going back from current StepDetector Activity to Main Activity
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intentMainactivity = new Intent(HelpActivity.this, MainActivity.class);
                intentMainactivity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intentMainactivity);
            }
        });
    }
}
