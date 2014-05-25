package com.example.broncohack;

import android.app.Activity;

public class ExerciseListHome extends ExerciseList {
	public ExerciseListHome(Activity a){
	         list.add(new Exercise(a.getString(R.string.bike), R.drawable.airbike, a.getString(R.string.bike_desc)));
		     list.add(new Exercise(a.getString(R.string.burpees), R.drawable.burpee, a.getString(R.string.burpees_desc)));
		     list.add(new Exercise(a.getString(R.string.flutter), R.drawable.flutterkick, a.getString(R.string.flutter_desc)));
		     list.add(new Exercise(a.getString(R.string.jacks), R.drawable.jumpingjack, a.getString(R.string.jacks_desc)));
		     list.add(new Exercise(a.getString(R.string.plank), R.drawable.plank, a.getString(R.string.plank_desc)));
		     list.add(new Exercise(a.getString(R.string.push), R.drawable.pushups, a.getString(R.string.push_desc)));
		     list.add(new Exercise(a.getString(R.string.situps), R.drawable.situps, a.getString(R.string.situps_desc)));
		     list.add(new Exercise(a.getString(R.string.squats), R.drawable.squat, a.getString(R.string.squats_desc)));
		     list.add(new Exercise(a.getString(R.string.wall), R.drawable.wallsit, a.getString(R.string.wall_desc)));
		     list.add(new Exercise(a.getString(R.string.climber), R.drawable.mountainclimbers, a.getString(R.string.climber_desc)));		     
	}
}
