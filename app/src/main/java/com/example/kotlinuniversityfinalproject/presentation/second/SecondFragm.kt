package com.example.kotlinuniversityfinalproject.presentation.second


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.kotlinuniversityfinalproject.databinding.FragmentSecondfragmentBinding


class SecondFragm : Fragment() {

    private var _binding: FragmentSecondfragmentBinding? = null
    private val binding get() = _binding!!
    lateinit var secondViewModel: SecondViewModel

    companion object {
        val number = "number"
        val randFact = "randFact"
        val nameof = "nameof"
        val url = "url"
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSecondfragmentBinding.inflate(inflater, container, false)
        secondViewModel = ViewModelProvider(this).get(SecondViewModel::class.java)

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.textViewCoffee.text = arguments?.getString(nameof)
        binding.textViewFullDesk.text = arguments?.getString(randFact)

        secondViewModel.getCoffee()
        secondViewModel.isLoading.observe(viewLifecycleOwner) { it ->
            if (it == true) {
                binding.progressBar2.visibility = View.VISIBLE
            } else if (it == false) {
                binding.progressBar2.visibility = View.INVISIBLE
                secondViewModel.myCoffeeFromApi.observe(viewLifecycleOwner) {
                    Glide.with(view).load(it).fitCenter().into(binding.imageViewCoffee)
                }
            }
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}