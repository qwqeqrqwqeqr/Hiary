package com.example.hiary.Popup

import android.app.Dialog
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import com.example.hiary.R

class DeleteCategoryPopupActivity(context: Context) {
    private val dlg = Dialog(context)
    private lateinit var deleteCategoryPopupDeleteBtn : Button

    fun start() {
        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE)   //타이틀바 제거
        dlg.setContentView(R.layout.activity_category_popup)     //다이얼로그에 사용할 xml 파일을 불러옴
        dlg.setCancelable(true)    //다이얼로그의 바깥 화면을 눌렀을 때 다이얼로그가 닫히도록 함
        dlg.window?.setLayout(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
       deleteCategoryPopupDeleteBtn = dlg.findViewById(R.id.deleteCategoryPopupDeleteBtn)
        deleteCategoryPopupDeleteBtn.setOnClickListener(){
            dlg.dismiss()
            onClickLisener.onClicked()
        }
        dlg.show()
    }
    interface  ButtonClickLisener{
        fun onClicked()
    }
    private  lateinit var onClickLisener: DeleteCategoryPopupActivity.ButtonClickLisener
    fun setOnCLickedListenr(listener: DeleteCategoryPopupActivity.ButtonClickLisener){
        onClickLisener = listener
    }
}