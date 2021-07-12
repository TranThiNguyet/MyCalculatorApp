package com.longvi.mycalculatorapp
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn0.setOnClickListener { appendOnClick(false, "0") }
        btn1.setOnClickListener { appendOnClick(false, "1")}
        btn2.setOnClickListener {appendOnClick(false, "2") }
        btn3.setOnClickListener { appendOnClick(false, "3")}
        btn4.setOnClickListener { appendOnClick(false, "4")}
        btn5.setOnClickListener {appendOnClick(false, "5") }
        btn6.setOnClickListener { appendOnClick(false, "6")}
        btn7.setOnClickListener { appendOnClick(false, "7")}
        btn8.setOnClickListener { appendOnClick(false, "8")}
        btn9.setOnClickListener {appendOnClick(false, "9") }
        btnCham.setOnClickListener {appendOnClick(false, ".") }

        btnCong.setOnClickListener {appendOnClick(false, "+") }
        btnTru.setOnClickListener { appendOnClick(false, "-")}
        btnNhan.setOnClickListener {appendOnClick(false, "*") }
        btnChia.setOnClickListener { appendOnClick(false, "/")}

        btnCE.setOnClickListener{
            clear()
        }
        btnBang.setOnClickListener{
            calculator()
        }
    }
    fun clear(){
        editTextInput.text = ""
        editTextOutput.text = ""
    }
    private fun appendOnClick(clear : Boolean, string : String) {
        if(clear){
            editTextOutput.text = ""
            editTextInput.append(string)
        }else{
            editTextInput.append(editTextOutput.text)
            editTextInput.append(string)
            editTextOutput.text = ""
        }
    }
    fun calculator(){
        try {
            var input = ExpressionBuilder(editTextInput.text.toString()).build()
            var output = input.evaluate()
            var longOutput = output.toLong()
            if(output == longOutput.toDouble()){
                editTextOutput.text = longOutput.toString()
            }else{
                editTextOutput.text = output.toString()
            }
        }catch (e:Exception){
            Toast.makeText(this@MainActivity, e.message, Toast.LENGTH_LONG).show()
        }
    }
}