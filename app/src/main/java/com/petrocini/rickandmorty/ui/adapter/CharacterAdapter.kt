package com.petrocini.rickandmorty.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.petrocini.rickandmorty.databinding.AdapterCharacterBinding
import com.petrocini.rickandmorty.domain.model.Character

class CharacterAdapter: PagingDataAdapter<Character, CharacterAdapter.CharaterViewHolder>(CHARACTERS_COMPARATOR){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharaterViewHolder {
        val binding = AdapterCharacterBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CharaterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CharaterViewHolder, position: Int) {
        val characterItem = getItem(position)
        characterItem?.let { character ->
            holder.bind(character)
        }
    }

    inner class CharaterViewHolder(
        private val binding: AdapterCharacterBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(character: Character) {
            with(binding) {
                binding.character = character
                avatarImageview.load(character.imageUrl)
            }
        }
    }

    companion object {
        private val CHARACTERS_COMPARATOR = object : DiffUtil.ItemCallback<Character>() {

            override fun areItemsTheSame(oldItem: Character, newItem: Character) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Character, newItem: Character) =
                oldItem == newItem
        }
    }

}