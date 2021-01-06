package com.example.instagramclone

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.instagramclone.adapter.PostAdapter
import com.example.instagramclone.adapter.StoryAdapter
import com.example.instagramclone.model.Student
import com.example.instagramclone.model.StudentPost
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(),View.OnClickListener {
    private lateinit var floatingButton: FloatingActionButton
    private lateinit var rvStories: RecyclerView
    private lateinit var rvUserPost: RecyclerView
    private var studentPostList=ArrayList<StudentPost>()
    private var studentStoryList=ArrayList<StudentPost>()
    private var studentArrayList:ArrayList<Student>?= ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvStories=findViewById(R.id.rvStories)
        rvUserPost=findViewById(R.id.rvPosts)
        floatingButton=findViewById(R.id.floatingButton)
        floatingButton.setOnClickListener(this)
        studentArrayList=intent.getParcelableArrayListExtra("studentArrayList")
        stories()
        recyclerViewLoader()
    }

    fun recyclerViewLoader(){
        studentStoryList.reverse()
        val storyAdapter=StoryAdapter(studentStoryList,this)
        rvStories.layoutManager= LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        rvStories.adapter=storyAdapter

        val postAdapter = PostAdapter(studentPostList,this)
        rvUserPost.layoutManager = LinearLayoutManager(this)
        rvUserPost.adapter = postAdapter
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==1){
            if(resultCode== Activity.RESULT_OK){
                val newPosts=data?.getParcelableExtra<StudentPost>("newPosts")
                if(newPosts !=null){
                    studentPostList.add(0,newPosts)
                    recyclerViewLoader()
                }
            }
        }
    }


    override fun onClick(v: View?) {
        when(v?.id){
            R.id.floatingButton->{
                val intent=Intent(this,NewPostActivity::class.java)
                intent.putExtra("studentArrayList",studentArrayList)
                startActivityForResult(intent,1)
            }
        }
    }
    fun stories(){
        studentStoryList.add(StudentPost(studentArrayList?.get(0)!!,"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQvsNAsZLQah4dV9Za-T85sYm8vUc95MF8J8A&usqp=CAU"))
        studentStoryList.add(StudentPost(studentArrayList?.get(1)!!,"https://static.billboard.com/files/media/eddie-vedder-pearl-jam-1992-nyc-performance-billboard-650-compressed.jpg"))
        studentStoryList.add(StudentPost(studentArrayList?.get(2)!!,"https://upload.wikimedia.org/wikipedia/commons/a/ab/Chris_Cornell.jpg"))
        studentStoryList.add(StudentPost(studentArrayList?.get(0)!!,"https://img.etimg.com/thumb/msid-74264499,width-640,resizemode-4,imgsize-206922/sounds-like-the-90s.jpg"))
        studentStoryList.add(StudentPost(studentArrayList?.get(1)!!,"https://townsquare.media/site/366/files/2015/04/Billie-Joe-Armstrong-630x420.jpg?w=980&q=75"))
        studentStoryList.add(StudentPost(studentArrayList?.get(2)!!,"https://e3.365dm.com/20/10/2048x1152/skynews-eddie-van-halen-halen_5128327.jpg"))
        studentStoryList.add(StudentPost(studentArrayList?.get(0)!!,"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSK4dImVu-uiFFRbjrTC2Oj_zTQsHLsx3rswg&usqp=CAU"))
        studentStoryList.add(StudentPost(studentArrayList?.get(1)!!,"https://cdn.britannica.com/s:400x225,c:crop/82/101882-050-9FA7F900/Kurt-Cobain-Nirvana-1993.jpg"))
        studentStoryList.add(StudentPost(studentArrayList?.get(2)!!,"https://static.billboard.com/files/media/eddie-vedder-pearl-jam-1992-nyc-performance-billboard-650-compressed.jpg"))
    }
}