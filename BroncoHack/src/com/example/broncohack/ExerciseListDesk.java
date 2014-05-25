package com.example.broncohack;

import android.app.Activity;

public class ExerciseListDesk extends ExerciseList {
	public ExerciseListDesk(Activity a) {
		list.add(new Exercise(a.getString(R.string.quad), R.drawable.quadricep, a
				.getString(R.string.quad_desc)));
		list.add(new Exercise(a.getString(R.string.kicks),
				R.drawable.flutterkickdesk, a.getString(R.string.kicks_desc)));
		list.add(new Exercise(a.getString(R.string.water), R.drawable.armraises, a
				.getString(R.string.water_desc)));
		list.add(new Exercise(a.getString(R.string.seated), R.drawable.armcircles, a
				.getString(R.string.seated_desc)));
		list.add(new Exercise(a.getString(R.string.bottom),
				R.drawable.bottomlinelifters, a.getString(R.string.bottom_desc)));
		list.add(new Exercise(a.getString(R.string.calf), R.drawable.calfraises, a
				.getString(R.string.calf_desc)));
		list.add(new Exercise(a.getString(R.string.lifts), R.drawable.leglifts, a
				.getString(R.string.lifts_desc)));
		list.add(new Exercise(a.getString(R.string.shrug), R.drawable.shouldershrug,
				a.getString(R.string.shrug_desc)));
		list.add(new Exercise(a.getString(R.string.overhead),
				R.drawable.overheadarm, a.getString(R.string.overhead_desc)));
		list.add(new Exercise(a.getString(R.string.cork), R.drawable.corkscrew, a
				.getString(R.string.cork_desc)));
	}

}
