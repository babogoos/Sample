package my.app.android.softkeyboard;

import android.inputmethodservice.InputMethodService;
import android.inputmethodservice.KeyboardView.OnKeyboardActionListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import android.content.res.AssetManager;


/*
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;

import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;

import android.view.View.OnKeyListener;

import android.view.inputmethod.CompletionInfo;

import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
*/
	
public class SoftKeyboard extends InputMethodService implements OnKeyboardActionListener{
	@Override public void onCreate() {
        super.onCreate();
      //將模組存至應用程式資料夾	
      		AssetManager assetManager = getAssets();
              InputStream inputStream = null;
      		
              try {
                  // 指定/assets/handwriting-ja.model
             inputStream = assetManager.open("handwriting-ja.model");
             
                 byte[] bytes = new byte[4096];
             
             int len = -1;
             		//開新檔案在應用程式資料夾
             File file = new File(this.getFilesDir(),"handwriting-ja.model");
             FileOutputStream outputStream = new FileOutputStream(file);
             
             while ((len = inputStream.read(bytes)) != -1){
             	outputStream.write(bytes, 0, len);
             }
             
             inputStream.close();
             outputStream.close();
             
            } catch (IOException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
            }   
    }
	@Override public void onInitializeInterface() {
		 super.onInitializeInterface();
	}
	LinearLayout layout;
	my.app.zinnia.InputView draw;
	my.app.zinnia.CandidateCharacter character;
	LinearLayout candidate;
	EditText edit;
	Button commit;
	Button clear;
	@Override
	public View onCreateInputView(){
		
		super.onCreateInputView();
		
		layout = (LinearLayout)getLayoutInflater().inflate(R.layout.invisible,null);
		
		character =(my.app.zinnia.CandidateCharacter)getLayoutInflater().inflate(R.layout.character, null);
		character.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,50));	
		layout.addView(character);
		
		candidate = (LinearLayout)getLayoutInflater().inflate(R.layout.candidate,null);
		candidate.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,50));	
		edit=(EditText)candidate.getChildAt(1);
		
		commit=(Button)candidate.getChildAt(2);
		
		commit.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				InputConnection ic = getCurrentInputConnection();
				ic.commitText(edit.getText().toString(), 1);
				edit.setText("");
			}});
		
		clear=(Button)candidate.getChildAt(3);
		
		clear.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				edit.setText("");
				character.clear();
				draw.clear();
			}});
		
		layout.addView(candidate);
		character.setEditText(edit);
		
		draw =(my.app.zinnia.InputView)getLayoutInflater().inflate(R.layout.input, null);
		draw.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,200));
		layout.addView(draw);	
		draw.setResultView(character);
		
		return layout;
	}
	
	@Override
	public View onCreateCandidatesView(){
		return null;
	}
	
	 @Override public void onStartInput(EditorInfo attribute, boolean restarting) {
	    super.onStartInput(attribute, restarting);
	 }
	
	@Override
	public void onPress(int primaryCode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onRelease(int primaryCode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onKey(int primaryCode, int[] keyCodes) {
		System.out.println("Test");
	}

	@Override
	public void onText(CharSequence text) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void swipeLeft() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void swipeRight() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void swipeDown() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void swipeUp() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
}