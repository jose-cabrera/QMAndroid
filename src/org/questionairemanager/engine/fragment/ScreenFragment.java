package org.questionairemanager.engine.fragment;

import org.questionairemanager.engine.utility.ScreenMaker;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

@SuppressLint("NewApi")
public class ScreenFragment extends Fragment {

	ScreenMaker sScreen;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	Bundle savedInstanceState) {
	    // TODO Auto-generated method stub
	   sScreen = new ScreenMaker(getActivity());

	   return sScreen.MakeScreen();
	}

} 
