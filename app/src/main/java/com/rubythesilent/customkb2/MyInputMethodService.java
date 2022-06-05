package com.rubythesilent.customkb2;

import android.inputmethodservice.InputMethodService;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputConnection;

public class MyInputMethodService extends InputMethodService implements KeyboardView.OnKeyboardActionListener {
    int layout_mode = 0;
    KeyboardView kbview = null;

    @Override
    public View onCreateInputView() {
        // get the KeyboardView and add our Keyboard layout to it
        this.kbview = (KeyboardView) getLayoutInflater().inflate(R.layout.keyboard_view, null);
        int targetxml;
        switch (this.layout_mode) {
            case 1:
                targetxml = R.xml.morse_code_keyboard;
            default:
                targetxml = R.xml.rune_keyboard;
        }

        Keyboard keyboard = new Keyboard(this, targetxml);
        this.kbview.setKeyboard(keyboard);
        this.kbview.setOnKeyboardActionListener(this);
        return this.kbview;
    }

    @Override
    public void onKey(int primaryCode, int[] keyCodes) {

        InputConnection ic = getCurrentInputConnection();
        if (ic == null) return;
        switch (primaryCode) {
            case Keyboard.KEYCODE_DELETE:
                CharSequence selectedText = ic.getSelectedText(0);
                if (TextUtils.isEmpty(selectedText)) {
                    // no selection, so delete previous character
                    ic.deleteSurroundingText(1, 0);
                } else {
                    // delete the selection
                    ic.commitText("", 1);
                }
                break;
            case Keyboard.KEYCODE_ALT:
                this.layout_mode += 1;
                if (this.layout_mode > 3) {
                    this.layout_mode = 0;
                }
                this.kbview = (KeyboardView) getLayoutInflater().inflate(R.layout.keyboard_view, null);
                int targetxml;
                switch (this.layout_mode) {
                    case 1:
                        targetxml = R.xml.morse_code_keyboard;
                    default:
                        targetxml = R.xml.rune_keyboard;
                }

                Keyboard keyboard = new Keyboard(this, targetxml);
                this.kbview.setKeyboard(keyboard);
                this.kbview.setOnKeyboardActionListener(this);
                break;
            default:
                char code = (char) primaryCode;
                String dot = String.valueOf((char) 46);
                String dash = String.valueOf((char) 45);
                String space = String.valueOf((char) 32);
                String slash = String.valueOf((char) 47);
                switch (this.layout_mode) {
                    case 1: //Morse Code
                        switch (String.valueOf(code)) {
                            case "a":
                                ic.commitText(dot, 1);
                                ic.commitText(dash, 1);
                                ic.commitText(space, 1);
                                break;
                            case "b":
                                ic.commitText(dash, 1);
                                ic.commitText(dot, 1);
                                ic.commitText(dot, 1);
                                ic.commitText(dot, 1);
                                ic.commitText(space, 1);
                                break;
                            case "c":
                                ic.commitText(dash, 1);
                                ic.commitText(dot, 1);
                                ic.commitText(dash, 1);
                                ic.commitText(dot, 1);
                                ic.commitText(space, 1);
                                break;
                            case "d":
                                ic.commitText(dash, 1);
                                ic.commitText(dot, 1);
                                ic.commitText(dot, 1);
                                ic.commitText(space, 1);
                                break;
                            case "e":
                                ic.commitText(dot, 1);
                                ic.commitText(space, 1);
                                break;
                            case "f":
                                ic.commitText(dot, 1);
                                ic.commitText(dot, 1);
                                ic.commitText(dash, 1);
                                ic.commitText(dot, 1);
                                ic.commitText(space, 1);
                                break;
                            case "g":
                                ic.commitText(dash, 1);
                                ic.commitText(dash, 1);
                                ic.commitText(dot, 1);
                                ic.commitText(space, 1);
                                break;
                            case "h":
                                ic.commitText(dot, 1);
                                ic.commitText(dot, 1);
                                ic.commitText(dot, 1);
                                ic.commitText(dot, 1);
                                ic.commitText(space, 1);
                                break;
                            case "i":
                                ic.commitText(dot, 1);
                                ic.commitText(dot, 1);
                                ic.commitText(space, 1);
                                break;
                            case "j":
                                ic.commitText(dot, 1);
                                ic.commitText(dash, 1);
                                ic.commitText(dash, 1);
                                ic.commitText(dash, 1);
                                ic.commitText(space, 1);
                                break;
                            case "k":
                                ic.commitText(dash, 1);
                                ic.commitText(dot, 1);
                                ic.commitText(dash, 1);
                                ic.commitText(space, 1);
                                break;
                            case "l":
                                ic.commitText(dot, 1);
                                ic.commitText(dash, 1);
                                ic.commitText(dot, 1);
                                ic.commitText(dot, 1);
                                ic.commitText(space, 1);
                                break;
                            case "m":
                                ic.commitText(dash, 1);
                                ic.commitText(dash, 1);
                                ic.commitText(space, 1);
                                break;
                            case "n":
                                ic.commitText(dash, 1);
                                ic.commitText(dot, 1);
                                ic.commitText(space, 1);
                                break;
                            case "o":
                                ic.commitText(dash, 1);
                                ic.commitText(dash, 1);
                                ic.commitText(dash, 1);
                                ic.commitText(space, 1);
                                break;
                            case "p":
                                ic.commitText(dot, 1);
                                ic.commitText(dash, 1);
                                ic.commitText(dash, 1);
                                ic.commitText(dot, 1);
                                ic.commitText(space, 1);
                                break;
                            case "q":
                                ic.commitText(dash, 1);
                                ic.commitText(dash, 1);
                                ic.commitText(dot, 1);
                                ic.commitText(dash, 1);
                                ic.commitText(space, 1);
                                break;
                            case "r":
                                ic.commitText(dot, 1);
                                ic.commitText(dash, 1);
                                ic.commitText(dot, 1);
                                ic.commitText(space, 1);
                                break;
                            case "s":
                                ic.commitText(dot, 1);
                                ic.commitText(dot, 1);
                                ic.commitText(dot, 1);
                                ic.commitText(space, 1);
                                break;
                            case "t":
                                ic.commitText(dash, 1);
                                ic.commitText(space, 1);
                                break;
                            case "u":
                                ic.commitText(dot, 1);
                                ic.commitText(dot, 1);
                                ic.commitText(dash, 1);
                                ic.commitText(space, 1);
                                break;
                            case "v":
                                ic.commitText(dot, 1);
                                ic.commitText(dot, 1);
                                ic.commitText(dot, 1);
                                ic.commitText(dash, 1);
                                ic.commitText(space, 1);
                                break;
                            case "w":
                                ic.commitText(dot, 1);
                                ic.commitText(dash, 1);
                                ic.commitText(dash, 1);
                                ic.commitText(space, 1);
                                break;
                            case "x":
                                ic.commitText(dash, 1);
                                ic.commitText(dot, 1);
                                ic.commitText(dot, 1);
                                ic.commitText(dash, 1);
                                ic.commitText(space, 1);
                                break;
                            case "y":
                                ic.commitText(dash, 1);
                                ic.commitText(dot, 1);
                                ic.commitText(dash, 1);
                                ic.commitText(dash, 1);
                                ic.commitText(space, 1);
                                break;
                            case "z":
                                ic.commitText(dash, 1);
                                ic.commitText(dash, 1);
                                ic.commitText(dot, 1);
                                ic.commitText(dot, 1);
                                ic.commitText(space, 1);
                                break;
                            case " ":
                                ic.commitText(slash, 1);
                                ic.commitText(space, 1);
                            default:
                                ic.commitText(String.valueOf(code), 1);
                        }
                        break;
                    case 2: //Standard Galactic Alphabet
                        switch (String.valueOf(code)) {
                            case "a":
                                //"ᔑ"
                                ic.commitText(String.valueOf((char) 5393), 1);
                                break;
                            case "b":
                                //"ʖ"
                                ic.commitText(String.valueOf((char) 662), 1);
                                break;
                            case "c":
                                //"ᓵ"
                                ic.commitText(String.valueOf((char) 5365), 1);
                                break;
                            case "d":
                                //"↸"
                                ic.commitText(String.valueOf((char) 8632), 1);
                                break;
                            case "e":
                                //"ᒷ"
                                ic.commitText(String.valueOf((char) 5303), 1);
                                break;
                            case "f":
                                //"⎓"
                                ic.commitText(String.valueOf((char) 9107), 1);
                                break;
                            case "g":
                                //"⊣"
                                ic.commitText(String.valueOf((char) 8867), 1);
                                break;
                            case "h":
                                //"⍑"
                                ic.commitText(String.valueOf((char) 9041), 1);
                                break;
                            case "i":
                                //"╎"
                                ic.commitText(String.valueOf((char) 9550), 1);
                                break;
                            case "j":
                                //"⋮"
                                ic.commitText(String.valueOf((char) 8942), 1);
                                break;
                            case "k":
                                //"ꖌ"
                                ic.commitText(String.valueOf((char) 42380), 1);
                                break;
                            case "l":
                                //"ꖎ"
                                ic.commitText(String.valueOf((char) 42382), 1);
                                break;
                            case "m":
                                //"ᒲ"
                                ic.commitText(String.valueOf((char) 5298), 1);
                                break;
                            case "n":
                                //"リ"
                                ic.commitText(String.valueOf((char) 12522), 1);
                                break;
                            case "o":
                                //"𝙹"
                                ic.commitText((CharSequence) "\uD835\uDE79", 1);
                                break;
                            case "p":
                                //"!¡"
                                ic.commitText(String.valueOf((char) 33), 1);
                                ic.commitText(String.valueOf((char) 161), 1);
                                break;
                            case "q":
                                //"ᑑ"
                                ic.commitText(String.valueOf((char) 5201), 1);
                                break;
                            case "r":
                                //"∷"
                                ic.commitText(String.valueOf((char) 8759), 1);
                                break;
                            case "s":
                                //"ᓭ"
                                ic.commitText(String.valueOf((char) 5357), 1);
                                break;
                            case "t":
                                //" ̣ℸ"
                                ic.commitText(String.valueOf((char) 32), 1);
                                ic.commitText(String.valueOf((char) 803), 1);
                                ic.commitText(String.valueOf((char) 8504), 1);
                                break;
                            case "u":
                                //"⚍"
                                ic.commitText(String.valueOf((char) 9869), 1);
                                break;
                            case "v":
                                //"⍊"
                                ic.commitText(String.valueOf((char) 9034), 1);
                                break;
                            case "w":
                                //"∴"
                                ic.commitText(String.valueOf((char) 8756), 1);
                                break;
                            case "x":
                                //" ̇/"
                                ic.commitText(String.valueOf((char) 32), 1);
                                ic.commitText(String.valueOf((char) 775), 1);
                                ic.commitText(String.valueOf((char) 47), 1);
                                break;
                            case "y":
                                //"||"
                                ic.commitText(String.valueOf((char) 124), 1);
                                ic.commitText(String.valueOf((char) 124), 1);
                                break;
                            case "z":
                                //"⨅"
                                ic.commitText(String.valueOf((char) 10757), 1);
                                break;
                            default:
                                ic.commitText(String.valueOf(code), 1);
                                break;
                        }
                        break;
                    case 3: //ascii
                        switch (String.valueOf(code)) {
                            case "\n":
                                ic.commitText(String.valueOf((char) 10), 1);
                                break;
                            default:
                                ic.commitText(String.valueOf(primaryCode), 1);
                                ic.commitText(space, 1);
                                break;
                        }
                        break;
                    default:
                        switch (String.valueOf(code)) {
                            case "a":
                                ic.commitText(String.valueOf((char) 5802), 1);
                                break;
                            case "b":
                                ic.commitText(String.valueOf((char) 5842), 1);
                                break;
                            case "c":
                                ic.commitText(String.valueOf((char) 5811), 1);
                                break;
                            case "d":
                                ic.commitText(String.valueOf((char) 5854), 1);
                                break;
                            case "e":
                                ic.commitText(String.valueOf((char) 5846), 1);
                                break;
                            case "f":
                                ic.commitText(String.valueOf((char) 5792), 1);
                                break;
                            case "g":
                                ic.commitText(String.valueOf((char) 5815), 1);
                                break;
                            case "h":
                                ic.commitText(String.valueOf((char) 5819), 1);
                                break;
                            case "i":
                                ic.commitText(String.valueOf((char) 5825), 1);
                                break;
                            case "j":
                                ic.commitText(String.valueOf((char) 5857), 1);
                                break;
                            case "l":
                                ic.commitText(String.valueOf((char) 5850), 1);
                                break;
                            case "m":
                                ic.commitText(String.valueOf((char) 5847), 1);
                                break;
                            case "n":
                                ic.commitText(String.valueOf((char) 5822), 1);
                                break;
                            case "o":
                                ic.commitText(String.valueOf((char) 5801), 1);
                                break;
                            case "p":
                                ic.commitText(String.valueOf((char) 5832), 1);
                                break;
                            case "r":
                                ic.commitText(String.valueOf((char) 5809), 1);
                                break;
                            case "s":
                                ic.commitText(String.valueOf((char) 5835), 1);
                                break;
                            case "t":
                                ic.commitText(String.valueOf((char) 5839), 1);
                                break;
                            case "u":
                                ic.commitText(String.valueOf((char) 5794), 1);
                                break;
                            case "w":
                                ic.commitText(String.valueOf((char) 5817), 1);
                                break;
                            case "x":
                                ic.commitText(String.valueOf((char) 5833), 1);
                                break;
                            case "y":
                                ic.commitText(String.valueOf((char) 5795), 1);
                                break;
                            default:
                                ic.commitText(String.valueOf(code), 1);
                                break;
                        }
                }
        }
    }

    @Override
    public void onPress(int primaryCode) {
    }

    @Override
    public void onRelease(int primaryCode) {
    }

    @Override
    public void onText(CharSequence text) {
    }

    @Override
    public void swipeLeft() {
    }

    @Override
    public void swipeRight() {
    }

    @Override
    public void swipeDown() {
    }

    @Override
    public void swipeUp() {
    }
}