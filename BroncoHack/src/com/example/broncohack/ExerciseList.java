package com.example.broncohack;

import java.util.ArrayList;

public class ExerciseList{
    ArrayList<Exercise> list;
    
    public ExerciseList(){
	list = new ArrayList<Exercise>();
    }

    public Exercise getRandom(){
	return list.get((int)(Math.random()*(list.size()-1)));
    }
}
