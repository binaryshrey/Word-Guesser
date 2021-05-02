package com.example.wordgusser.ui.score

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.wordgusser.R
import com.example.wordgusser.databinding.FragmentScoreBinding

class ScoreFragment : Fragment() {

    private lateinit var binding:FragmentScoreBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_score, container, false)
        binding.playAgainButton.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_scoreFragment_to_titleFragment)
        }
        return binding.root
    }


}