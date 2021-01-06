package com.example.instagramclone.model

import android.os.Parcel
import android.os.Parcelable

data class StudentPost (
    val student:Student,
    val imagePost:String?
): Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readParcelable(Student::class.java.classLoader)!!,
        parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(student,flags)
        parcel.writeString(imagePost)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<StudentPost> {
        override fun createFromParcel(parcel: Parcel): StudentPost {
            return StudentPost(parcel)
        }

        override fun newArray(size: Int): Array<StudentPost?> {
            return arrayOfNulls(size)
        }
    }
}
