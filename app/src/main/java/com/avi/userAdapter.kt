package com.avi

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.avi.base_mvvm.R
import com.avi.base_mvvm.models.users.Data
import com.bumptech.glide.Glide


class userAdapter(private  val data:List<Data> ,val context: Context) :
    RecyclerView.Adapter<userAdapter.CustomAdapter>() {

    class CustomAdapter(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageView: ImageView
        var textView: TextView

//        var relativeLayout: RelativeLayout

        init {
            imageView = itemView.findViewById<View>(R.id.imageView2) as ImageView
            textView = itemView.findViewById<View>(R.id.textView) as TextView
//            relativeLayout = itemView.findViewById<View>(R.id.relativeLayout) as RelativeLayout
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomAdapter {
      var view = LayoutInflater.from(context).inflate(R.layout.custom_list_recycler,parent,false)
        return  CustomAdapter(view)
    }

    override fun onBindViewHolder(holder: CustomAdapter, position: Int) {

//        holder.itemView.findViewById<TextView>(com.avi.base_mvvm.R.id.textView).text = data[0].first_name
//        holder.itemView.findViewById<TextView>(com.avi.base_mvvm.R.id.textView2).text = data[0].email

        Log.d("sadassf", "onBindViewHolder: $data")
        holder.textView.text = data[position].email;

        Glide.with(context).load(data[position].avatar).into(holder.imageView)
    }

    override fun getItemCount(): Int {
      return data.size
    }
}