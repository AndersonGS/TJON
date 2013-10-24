package com.ads.proplan.activity;

import java.lang.reflect.Field;

import com.ads.proplan.R;
import com.ads.proplan.control.QuestionControl;
import com.ads.proplan.db.entity.QuestionEntity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class CaseFragment extends Fragment {
	
	/**
	 * A constante ARG_OBJECT do tipo String foi declarada. O
	 * objetivo dessa variavel é determinar o nome do fragmento.
	 */
	public static final String ARG_OBJECT = "object";
	private QuestionControl control;
	private QuestionEntity questionEntity ;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_case, container,	false);
		Bundle args = getArguments();
		control = QuestionControl.getInstance();
		questionEntity = control.getQuestionEntity();
		//((TextView) rootView.findViewById(R.id.case_text_description)).setText(questionEntity.getDescription());
		R.raw rID = new R.raw();
		try {
			Field photoNameField = rID.getClass().getField(questionEntity.getImage());
			((ImageView) rootView.findViewById(R.id.case_image_arcada)).setImageResource(photoNameField.getInt(rID));
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		//Bitmap bitmap = BitmapFactory.decodeByteArray(questionEntity.getImage(), 0, questionEntity.getImage().length);
		//.setImageBitmap(bitmap);
		return rootView;
	}

}
