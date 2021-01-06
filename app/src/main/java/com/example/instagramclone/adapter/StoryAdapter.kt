package com.example.instagramclone.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.instagramclone.R
import com.example.instagramclone.model.StudentPost
import de.hdodenhof.circleimageview.CircleImageView

class StoryAdapter (
    val studentStory:ArrayList<StudentPost>,
    val context: Context
): RecyclerView.Adapter<StoryAdapter.StoryViewHolder>(){

    class StoryViewHolder(view: View):
        RecyclerView.ViewHolder(view){
        val storyProfilePic: CircleImageView

        init {
            storyProfilePic=view.findViewById(R.id.cvStories)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.storylayout,parent,false)
        return StoryViewHolder(view)
    }



    override fun getItemCount(): Int {
        return studentStory.size
    }
    override fun onBindViewHolder(holder:StoryViewHolder, position: Int) {
        val story=studentStory[position]
        Glide.with(context).load(story.imagePost).into(holder.storyProfilePic)

    }

}