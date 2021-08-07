package com.kolon.recyclerview_kotiln

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class ProfileAdapter(val profileList: ArrayList<Profiles>) : RecyclerView.Adapter<ProfileAdapter.CustomViewHolder>()
{

    // adapter에서 연결된 화면이 무엇인가? 그 화면을 setContentView처럼 붙인다.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileAdapter.CustomViewHolder {

        // context에는 이 Adapter와 연결된 Activity의 모든 정보를 가져온다. 여기서는 MainActivity의 모든 정보가 담겨있게 된다.
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)


        // 선언한 view가 CustomViewHolder의 view가 된다.
        return CustomViewHolder(view).apply {
            itemView.setOnClickListener {
                val curPosition : Int = adapterPosition
                val profile: Profiles = profileList.get(curPosition)

                Toast.makeText(parent.context, "이름: ${profile.name}\n나이: ${profile.age}\n직업: ${profile.job}", Toast.LENGTH_SHORT).show()
            }
        }
    }


    // 실제 연결을 해주는 부분
    // 스크롤을 할 때 지속적으로 호출이 된다.
    override fun onBindViewHolder(holder: ProfileAdapter.CustomViewHolder, position: Int) {
        holder.gender.setImageResource(profileList.get(position).gender)
        holder.name.text = profileList.get(position).name
        holder.age.text = profileList.get(position).age.toString()
        holder.job.text = profileList.get(position).job
    }


    override fun getItemCount(): Int {
        return profileList.size
    }


    class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val gender = itemView.findViewById<ImageView>(R.id.id_profile) // 성별
        val name = itemView.findViewById<TextView>(R.id.tv_name)
        val age = itemView.findViewById<TextView>(R.id.tv_age)
        val job = itemView.findViewById<TextView>(R.id.tv_job)
    }
}