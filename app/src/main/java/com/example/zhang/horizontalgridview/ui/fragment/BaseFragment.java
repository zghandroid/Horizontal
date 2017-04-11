package com.example.zhang.horizontalgridview.ui.fragment;

import android.app.Dialog;
import android.support.v4.app.Fragment;

/**
 * Created by 12345 on 2017/4/6.
 */

public class BaseFragment extends Fragment {
    private Dialog dialog;
    public void showDialog(String mes){
        dialog=new Dialog(getContext());
        dialog.show();
    }
    public void heidDialog(){
        if(dialog.isShowing()){
            dialog.hide();
        }
    }
}
