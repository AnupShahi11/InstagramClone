package com.example.instagramclone

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.instagramclone.model.Student
import com.example.instagramclone.model.StudentPost

class NewPostActivity : AppCompatActivity() {
    private lateinit var etInsertLink: EditText
    private lateinit var btnSubmit: Button
    private var studentArrayList:ArrayList<Student>?=ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_post)

        etInsertLink=findViewById(R.id.etInsertLink)
        btnSubmit=findViewById(R.id.btnSubmit)
        studentArrayList=intent.getParcelableArrayListExtra("studentArrayList")
        btnSubmit.setOnClickListener {
            if (isValid()) {
                val newPost = StudentPost(
                    studentArrayList?.get(studentArrayList?.size!! - 1)!!,
                    etInsertLink.text.toString()
                )
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("newPosts", newPost)
                setResult(Activity.RESULT_OK, intent)
                finish()
            }
        }


    }
    private fun isValid():Boolean{
        when{
            etInsertLink.text?.isEmpty()==true ->{
                etInsertLink.error="Field must not be empty"
                return false
            }
        }
        return true
    }
}