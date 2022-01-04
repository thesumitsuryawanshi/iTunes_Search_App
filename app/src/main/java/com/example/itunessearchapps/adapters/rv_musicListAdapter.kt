package com.example.itunessearchapps.adapters

import android.util.Log.d
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.itunessearchapps.databinding.RvMusicListItemsBinding
import com.example.itunessearchapps.model.Result

class rv_musicListAdapter(val MusicList: ArrayList<Result>) :
    RecyclerView.Adapter<rv_musicListAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            RvMusicListItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val viewholder = ViewHolder(view)

        return viewholder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val trackname = MusicList[position].trackName

        holder.tvArtistName.text = MusicList[position].artistName
        holder.tvPrice.text = "$" + MusicList[position].trackPrice.toString()
        if (MusicList[position].trackName == "null") holder.tvTrackName.text =
            "Not available"; else holder.tvTrackName.text = trackname

    }

    override fun getItemCount(): Int {
        d("testing in RV ", "item count ; ${MusicList.size}")
        return MusicList.size
    }

    class ViewHolder(binding: RvMusicListItemsBinding) : RecyclerView.ViewHolder(binding.root) {
        val tvArtistName = binding.tvArtistName
        val tvPrice = binding.tvSongPrice
        val tvTrackName = binding.tvTrackName

    }


}