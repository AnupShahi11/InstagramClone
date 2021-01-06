package com.example.instagramclone.model

import android.os.Parcel
import android.os.Parcelable

data class Student(
    val cuID: Int, val fName: String?,
    val lName: String?, val userName: String?,
    val password: String?, val batch: String?,
    val studentProfilePic: String?
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(cuID)
        parcel.writeString(fName)
        parcel.writeString(lName)
        parcel.writeString(userName)
        parcel.writeString(password)
        parcel.writeString(batch)
        parcel.writeString(studentProfilePic)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Student> {
        override fun createFromParcel(parcel: Parcel): Student {
            return Student(parcel)
        }

        override fun newArray(size: Int): Array<Student?> {
            return arrayOfNulls(size)
        }
    }
}
