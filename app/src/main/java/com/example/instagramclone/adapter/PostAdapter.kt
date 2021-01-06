package com.example.instagramclone.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.instagramclone.R
import com.example.instagramclone.model.StudentPost
import de.hdodenhof.circleimageview.CircleImageView

class PostAdapter (
    val studentPost:ArrayList<StudentPost>,
    val context:Context
):RecyclerView.Adapter<PostAdapter.PostViewHolder>() {
    class PostViewHolder(view: View):RecyclerView.ViewHolder(view){
        val postProfilePic:CircleImageView
        val tvPostUserName:TextView
        val imgUserPost:ImageView

        init {

            postProfilePic=view.findViewById(R.id.cvProfilePic)
            tvPostUserName=view.findViewById(R.id.tvProfileUserName)
            imgUserPost=view.findViewById(R.id.imgUserPost)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.postlayout,parent,false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post=studentPost[position]
        holder.tvPostUserName.text="${post.student.fName} ${post.student.lName}"
        Glide.with(context)
            .load(post.student.studentProfilePic)
            .into(holder.postProfilePic)

        Glide.with(context)
            .load(post.imagePost)
            .into(holder.imgUserPost)

    }

    override fun getItemCount(): Int {
        return studentPost.size
    }
}