package com.example.analogkeyboard;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.EditText;

public class EaxmpleActivity extends Activity {
	Dialog dialog;
	EditText et_example;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_example);
		et_example=(EditText) findViewById(R.id.et_example);
		
		et_example.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				KeyboardUtils keyUtils = new KeyboardUtils(EaxmpleActivity.this, et_example);
				if (dialog == null) {
					dialog = keyUtils.showKeyBoard();
				} else if (dialog != null && !dialog.isShowing()) {
					dialog.show();
				}
				return false;
			}
		});
	}

}
