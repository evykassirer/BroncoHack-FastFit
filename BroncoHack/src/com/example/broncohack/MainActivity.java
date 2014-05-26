package com.example.broncohack;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {
	
	public final static String EXTRA_MESSAGE = "com.example.broncohack.IEM";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);

        if (savedInstanceState == null) {
        }
    }

    
    public void atDesk(View view){
    	Intent intent = new Intent(this, ExerciseActivity.class);
    	intent.putExtra(EXTRA_MESSAGE, "desk");
    	startActivity(intent);
    	
    }
    
    public void atHome(View view){
    	Intent intent = new Intent(this, ExerciseActivity.class);
    	intent.putExtra(EXTRA_MESSAGE, "home");
    	startActivity(intent);
    }
    

}


