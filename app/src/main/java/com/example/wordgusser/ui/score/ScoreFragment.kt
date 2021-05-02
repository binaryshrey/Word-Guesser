package com.example.wordgusser.ui.score

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.wordgusser.R
import com.example.wordgusser.databinding.FragmentScoreBinding

class ScoreFragment : Fragment() {

    private lateinit var binding:FragmentScoreBinding
    private lateinit var viewModel: ScoreViewModel
    private lateinit var viewModelFactory: ScoreViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_score, container, false)
        val args = ScoreFragmentArgs.fromBundle(requireArguments())

        viewModelFactory = ScoreViewModelFactory(args.finalScore)
        viewModel = ViewModelProvider(this,viewModelFactory).get(ScoreViewModel::class.java)
        binding.scoreViewModel = viewModel
        binding.setLifecycleOwner(this)

        viewModel.playAgain.observe(viewLifecycleOwner, Observer { playAgain ->
            if(playAgain){
                findNavController().navigate(R.id.action_scoreFragment_to_titleFragment)
                viewModel.eventPlayAgainComplete()
            }
        })
        return binding.root
    }


}