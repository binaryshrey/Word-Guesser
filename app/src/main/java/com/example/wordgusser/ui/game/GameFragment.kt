package com.example.wordgusser.ui.game

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.wordgusser.R
import com.example.wordgusser.databinding.FragmentGameBinding

class GameFragment : Fragment() {

    private lateinit var binding:FragmentGameBinding
    private lateinit var viewModel: GameViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_game, container, false)
        viewModel = ViewModelProvider(this).get(GameViewModel::class.java)
        binding.gameViewModel = viewModel
        binding.setLifecycleOwner(this)

//        viewModel.gameComplete.observe(viewLifecycleOwner, Observer { iscComplete ->
//            if(iscComplete){
//                findNavController().navigate()
//            }
//        })


        return binding.root
    }


}