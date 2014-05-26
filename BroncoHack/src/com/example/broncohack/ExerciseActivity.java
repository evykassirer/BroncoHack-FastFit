package com.example.broncohack;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.NavUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ExerciseActivity extends Activity {
	ExerciseList list;
	int view;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_exercise);

		if (savedInstanceState == null) {
			
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
		        
		        TextView desc = (TextView)con.findViewById(R.id.exercise_descr);
				desc.setText("\nGOOD JOB!!");
				desc.setTextSize(40);
		        
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
