package com.example.lockscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.lockscreen.databinding.FragLockscreenBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class LockScreenFragment : Fragment() {

    private var _binding: FragLockscreenBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragLockscreenBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        binding.buttonFirst.setOnClickListener {
//            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
//        }
        binding.btnCheck.setOnClickListener{
            val userInput = binding.etAnswer.text.toString()
            if(userInput == Answer.getInstance().answer) {
                Toast.makeText(context, "축하합니다.\n정답입니다.", Toast.LENGTH_SHORT).show()
                binding.tvItem.text = "획득한 아이템: 8"
            } else {
                Toast.makeText(context, "$userInput 은(는) 정답이 아닙니다.", Toast.LENGTH_SHORT).show()
                binding.etAnswer.text.clear()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}