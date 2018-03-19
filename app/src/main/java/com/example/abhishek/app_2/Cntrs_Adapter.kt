package com.example.abhishek.app_2

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

import com.squareup.picasso.Picasso

import java.util.ArrayList

/**
 * Created by Abhishek on 3/18/2018.
 */

class Cntrs_Adapter(private val lItems: ArrayList<Countries>, internal var context: Context) : RecyclerView.Adapter<Cntrs_Adapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.list_item, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        val c = lItems[i]
        viewHolder.tRank.text = c.rank.toString()
        viewHolder.tName.text = c.country
        viewHolder.tPopulation.text = c.population

        Picasso.with(context)
                .load(c.flag)
                .into(viewHolder.iFlag)

        viewHolder.iFlag.setOnClickListener {
            val i = Intent(context, FScreen::class.java)
            i.putExtra("url_string", c.flag)
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(i)
        }


    }

    override fun getItemCount(): Int {
        return lItems.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var tRank: TextView
        var tName: TextView
        var tPopulation: TextView
        var iFlag: ImageView


        init {

            tRank = itemView.findViewById<View>(R.id.tRank) as TextView
            tName = itemView.findViewById<View>(R.id.tName) as TextView
            tPopulation = itemView.findViewById<View>(R.id.tPopulation) as TextView
            iFlag = itemView.findViewById<View>(R.id.iFlag) as ImageView


        }
    }


}
