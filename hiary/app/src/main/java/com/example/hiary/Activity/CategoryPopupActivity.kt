package com.example.hiary.Activity
import kotlinx.android.synthetic.main.activity_main.*
import android.app.Dialog
import android.content.Context
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import com.example.hiary.R

class CategoryPopupActivity(context: Context) {
    private val dlg = Dialog(context)   //부모 액티비티의 context 가 들어감
    private lateinit var categoryPopupAddbtnBtn : Button
    private lateinit var categoryPopupCancelBtn : Button
    private lateinit var categoryPopupPlaintext : EditText


    fun start() {
        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE)   //타이틀바 제거
        dlg.setContentView(R.layout.activity_category_popup)     //다이얼로그에 사용할 xml 파일을 불러옴
        dlg.setCancelable(false)    //다이얼로그의 바깥 화면을 눌렀을 때 다이얼로그가 닫히지 않도록 함
        dlg.window?.setLayout(MATCH_PARENT, WRAP_CONTENT)
        categoryPopupAddbtnBtn = dlg.findViewById(R.id.categoryPopupAddBtn)
        categoryPopupCancelBtn = dlg.findViewById(R.id.categoryPopupCancelBtn)
        categoryPopupPlaintext = dlg.findViewById(R.id.categoryPopupPlaintext)


        categoryPopupAddbtnBtn.setOnClickListener {
            onClickLisener.onClicked(categoryPopupPlaintext.text.toString())
            dlg.dismiss()
        }
        categoryPopupCancelBtn.setOnClickListener {
            dlg.dismiss()
        }
        dlg.show()
    }
    interface  ButtonClickLisener{
        fun onClicked(category: String)
    }
    private  lateinit var onClickLisener: ButtonClickLisener
    fun setOnCLickedListenr(listener: ButtonClickLisener){
        onClickLisener = listener
    }

}