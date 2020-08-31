package com.noname;

import android.app.*;
import android.content.*;
import android.graphics.*;
import android.os.*;
import android.text.*;
import android.text.style.*;
import android.view.*;
import android.widget.*;
import android.widget.LinearLayout.*;

public class LauncherActivity extends Activity {
	static EditText cmdArgs;
	static SharedPreferences mPref;
	public static final int sdk = Integer.valueOf(Build.VERSION.SDK);
	public SpannableString styleButtonString(String str)
	{
		if(sdk < 21)
			str = str.toUpperCase();

		SpannableString spanString = new SpannableString(str.toUpperCase());
		if(sdk < 21)
			spanString.setSpan(new StyleSpan(Typeface.BOLD), 0, str.length(), 0);

		return spanString;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);

		// set theme
		if ( sdk >= 21 ) super.setTheme( 0x01030224 );
		else super.setTheme( 0x01030005 );

		// Build layout
		LinearLayout launcher = new LinearLayout(this);
		launcher.setOrientation(LinearLayout.VERTICAL);
		launcher.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
		launcher.setBackgroundColor(0xFF252525);

		Button startButton = new Button(this);
		startButton.setText(styleButtonString("Start proxy"));
		LayoutParams buttonParams = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
		buttonParams.gravity = 5;
		startButton.setLayoutParams(buttonParams);
		if(sdk < 21)
		{
			startButton.getBackground().setAlpha(96);
			startButton.getBackground().invalidateSelf();
			startButton.setTextColor(0xFFFFFFFF);
			startButton.setTextAppearance(this, android.R.attr.textAppearanceLarge);
			startButton.setTextSize(20);
		}

		startButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				
			}
		});

		// Add other options here

		launcher.addView(startButton);
		setContentView(launcher);
	}
}
