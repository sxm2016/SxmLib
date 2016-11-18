package com.xxx.commonlib.util.text.rename;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

/**
 * 重命名TextWatcher
 * 只能输入中文、英文、数字
 * 规定一个中文占有两个字节，字母数字占有一个字节
 * 不能输入空格、输入超过最大字节后不提示
 * 光标在文字中，输入多个文字，截取输入后的文字
 * Create by shixm on 2016/11/18
 */
public class RenameTextWatcher implements TextWatcher {

    private static final String TAG = "RenameTextWatcher";

    int intMaxBytesCount;
    int intDestCut = 0;
    int intBlankCut = 0;
    int intPreSelection = 0;
    String strPreText = "";
    EditText editText;

    public RenameTextWatcher(EditText editText, int maxLength) {
        this.editText = editText;
        this.intMaxBytesCount = maxLength;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        intPreSelection = start;
        strPreText = s.toString();
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        String addText = s.toString().substring(start, start + count);
        intDestCut = 0;
        intBlankCut = 0;
        if (addText.contains(" ") && addText.length() == 1) {
            for (int i = 0; i < addText.length(); i++) {
                if (addText.charAt(i) == ' ') {
                    intBlankCut++;
                }
            }
            if (intPreSelection == 0 && editText.getSelectionEnd() >= RenameString.getIndexOfTotalBytesLen(s.toString(), intMaxBytesCount)) {
                intPreSelection = RenameString.getIndexOfTotalBytesLen(s.toString(), intMaxBytesCount);
            } else {
                intPreSelection = editText.getSelectionEnd() - 1;
            }
            intDestCut = editText.getSelectionEnd();
        } else if (RenameString.getTotalBytes(s.toString()) > intMaxBytesCount) {
            // 改变前光标左侧的文字
            String strPreCursorLeft = strPreText.substring(0, intPreSelection);
            // 改变前光标右侧的文字
            String strPreCursorRight = strPreText.substring(intPreSelection);
            // 改变前光标左侧的文字占用的字节数
            int intPreCursorBytesLeftCount = RenameString.getTotalBytes(strPreCursorLeft);
            // 改变前光标右侧的文字占用的字节数
            int intPreCursorBytesRightCount = RenameString.getTotalBytes(strPreCursorRight);
            if (intPreCursorBytesLeftCount + intPreCursorBytesRightCount == intMaxBytesCount) {
                intDestCut = intPreSelection + addText.length();
            } else {
                intPreSelection = RenameString.getIndexOfTotalBytesLen(s.toString(), intMaxBytesCount - intPreCursorBytesRightCount);
                intDestCut = s.length() - strPreCursorRight.length();
            }
        }

    }

    @Override
    public void afterTextChanged(Editable s) {
        if (intBlankCut > 0) {
            s.delete(intPreSelection, editText.getSelectionEnd());
            editText.setSelection(intPreSelection);
        } else if (intDestCut > 0) {
            s.delete(intPreSelection, intDestCut);
            editText.setSelection(intPreSelection);
        }
    }
}
