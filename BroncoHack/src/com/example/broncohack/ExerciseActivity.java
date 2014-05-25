package com.example.broncohack;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ExerciseActivity extends ActionBarActivity {
	ExerciseList list;
	int view;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_exercise);

		if (savedInstanceState == null) {
			//getSupportFragmentManager().beginTransaction()
				//	.add(R.id.container, new PlaceholderFragment()).commit();
			
		}
		
		Intent intent = getIntent();
		String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
		if(message.equals("desk"))
		{
			list = new ExerciseListDesk(this);
			view = R.layout.fragment_exercise_desk;  
		}
		else if(message.equals("home"))
		{
			list = new ExerciseListHome(this);
			view = R.layout.fragment_exercise;
		}
		
		updateView();
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.exercise, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_exercise,
					container, false);
			return rootView;
		}
	}
	
	public void updateView(){
		Exercise exercise = list.getRandom();
		this.setContentView(view);
		
		TextView en = (TextView)this.findViewById(R.id.exercise_name);
		en.setText(exercise.getName());
		
		ImageView iv = (ImageView)this.findViewById(R.id.exercise_image);
		iv.setImageResource(exercise.getImage());
		
		TextView desc = (TextView)this.findViewById(R.id.exercise_descr);
		desc.setText(exercise.getDesc());
		
		Button skip = (Button)this.findViewById(R.id.updateButton);
		skip.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				updateView();	
			}
		});
		
		Button sbb = (Button)this.findViewById(R.id.startBackButton);
		sbb.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				start();	
			}
		});
	}
	
	
	public void start()
	{		
    	final MediaPlayer player = MediaPlayer.create(this, R.raw.alarm);
		
		final AlertDialog alertDialog = new AlertDialog.Builder(this).create();  
		alertDialog.setTitle("Time left:");  
		alertDialog.setMessage("01:00");
		alertDialog.setCanceledOnTouchOutside(false);
		alertDialog.show();   
		
		final Activity con = this;
		
		final CountDownTimer timer = new CountDownTimer(61000, 1000) {
		    @Override
		    public void onTick(long millisUntilFinished) {
		       alertDialog.setMessage("00:"+ (millisUntilFinished/1000));
		    }

		    @Override
		    public void onFinish() {
				player.start();
		        alertDialog.dismiss();
		        
		        ///change buttons
		        //start --> back to main menu
		        //skip --> next
				Button sbb = (Button)con.findViewById(R.id.startBackButton);
				sbb.setText("Menu");
				sbb.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						NavUtils.navigateUpFromSameTask(con);
					}
				});
				
				Button next = (Button)con.findViewById(R.id.updateButton);
				next.setText("Next");
				next.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						updateView();	
					}
				});
		        
		    }
 
		};
		timer.start();
		
		alertDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {         
	        @Override
	        public void onCancel(DialogInterface dialog) {
	            timer.cancel();
	        }
	    } );
		
	}

}
