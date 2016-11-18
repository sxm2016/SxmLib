package com.xxx.commonlib.util.text.emoji;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;

/**
 * 禁止输入表情符号TextWatcher
 * 注：有待完善，当光标不在最后时，会出现错误
 * Created by shixm on 2016/11/18.
 */
public class EmojiTextWatcher implements TextWatcher {
    Context context;
    EditText editText;

    public EmojiTextWatcher(Context context, EditText editText) {
        this.context = context;
        this.editText = editText;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        int index = editText.getSelectionStart() - 1;
        if (index > 0) {
            if (EmojiString.isEmojiCharacter(s.charAt(index))) {
                Editable edit = editText.getText();
                edit.delete(s.length() - 2, s.length());
                Toast.makeText(context, "不支持输入表情符号", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
