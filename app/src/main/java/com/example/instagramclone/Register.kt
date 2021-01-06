package com.example.instagramclone

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.instagramclone.model.Student

class Register : AppCompatActivity(),View.OnClickListener {
    private lateinit var etCuId: EditText
    private lateinit var etfName: EditText
    private lateinit var etlName: EditText
    private lateinit var etUserName: EditText
    private lateinit var etPassword: EditText
    private lateinit var spBatch: Spinner
    private lateinit var etImageLink: EditText
    private lateinit var tvGoToLogin: TextView
    private lateinit var btnRegister: Button

    private val batch= arrayOf("21","22","23","24","25","26")

    var selectedItem:String=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        etCuId=findViewById(R.id.etCuId)
        etfName=findViewById(R.id.etFName)
        etlName=findViewById(R.id.etLName)
        etUserName=findViewById(R.id.etUserName)
        etPassword=findViewById(R.id.etPassword)
        etImageLink=findViewById(R.id.etImageLink)
        spBatch=findViewById(R.id.spBatch)
        tvGoToLogin=findViewById(R.id.tvGoToLogin)
        btnRegister=findViewById(R.id.btnRegister)
        spinner()

        tvGoToLogin.setOnClickListener(this)
        btnRegister.setOnClickListener(this)



    }
    private fun spinner(){
        val adapter= ArrayAdapter(this,android.R.layout.simple_list_item_1,batch)
        spBatch.adapter=adapter
        spBatch.onItemSelectedListener=
            object: AdapterView.OnItemSelectedListener{
                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    selectedItem=parent?.getItemAtPosition(position).toString()

                }
                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }
            }
    }

    override fun onClick(v: View?) {
        val intent= Intent(this, Register::class.java)
        when(v?.id){
            R.id.tvGoToLogin->{
                startActivity(Intent(intent))
            }

            R.id.btnRegister->{
                if(isValid()){
                    val cuID=etCuId.text.toString().toInt()
                    val firstName=etfName.text.toString()
                    val lastName=etlName.text.toString()
                    val userName=etUserName.text.toString()
                    val password=etPassword.text.toString()
                    val image=etImageLink.text.toString()

                    val students=Student(cuID,firstName,lastName,userName,password,selectedItem,image)

                    intent.putExtra("students",students)
                    setResult(Activity.RESULT_OK,intent)
                    finish()
                }
            }
        }
    }
    private fun isValid():Boolean{
        when{
            etCuId.text.isEmpty()->{
                etCuId.error="Field must not be empty"
                return false
            }
            etfName.text.isEmpty()->{
                etfName.error="Field must not be empty"
                return false
            }

            etlName.text.isEmpty()->{
                etlName.error="Field must not be empty"
                return false
            }
            etUserName.text.isEmpty()->{
                etUserName.error="Field must not be empty"
                return false
            }
            etPassword.text.isEmpty()->{
                etPassword.error="Field must not be empty"
                return false
            }
        }
        return true
    }
}