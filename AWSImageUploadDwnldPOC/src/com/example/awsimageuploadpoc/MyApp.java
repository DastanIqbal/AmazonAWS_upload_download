package com.example.awsimageuploadpoc;

import org.acra.ACRA;
import org.acra.ReportingInteractionMode;
import org.acra.annotation.ReportsCrashes;

import android.app.Application;

@ReportsCrashes(formKey = " ", mailTo = "ask2iqbal@gmail.com", mode = ReportingInteractionMode.TOAST, resToastText = R.string.action_settings)
public class MyApp extends Application {

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		ACRA.init(this);
	}
}
