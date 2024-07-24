package com.example.lockscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.lockscreen.databinding.FragSettingBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SettingFragment : Fragment() {

    private var _binding: FragSettingBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragSettingBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.etPass1.setText(Answer.getInstance().answer)
        binding.btnOK.setOnClickListener{
            if(binding.etPass1.text.toString() == binding.etPass2.text.toString()) {
                Answer.getInstance().answer = binding.etPass1.text.toString()
                Toast.makeText(context, "정답이 변경되었습니다.", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
            } else {
                Toast.makeText(context, "정답이 일치하지 않습니다", Toast.LENGTH_SHORT).show()
            }
        }
        binding.btnCancel.setOnClickListener{
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
//        binding.buttonSecond.setOnClickListener {
//            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
//        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}