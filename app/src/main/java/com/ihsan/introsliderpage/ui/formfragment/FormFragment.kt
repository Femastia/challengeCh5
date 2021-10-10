package com.ihsan.introsliderpage.ui.formfragment

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.BaseTransientBottomBar.LENGTH_SHORT
import com.google.android.material.snackbar.Snackbar
import com.ihsan.introsliderpage.databinding.FragmentFormBinding
import com.ihsan.introsliderpage.ui.SecondActivity


class FormFragment : Fragment() {

    private lateinit var binding: FragmentFormBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentFormBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setButtonClickListener()
    }

    private fun setButtonClickListener() {
        binding.btnSetName.setOnClickListener {
            //todo : navigate to menu, bring data name to menu page or using sharedpreference
            val nama = binding.etName.text.toString()
            Log.e("Nama Player 1", "$nama")
            val mode = "pvp"
            val intent = Intent(requireActivity(), SecondActivity::class.java).apply {
                putExtra("nama", nama)
                putExtra("mode", mode)
            }
            startActivity(intent)
        }
        binding.btnVsCom.setOnClickListener {
            val nama = binding.etName.text.toString()
            Log.e("Nama Player 1", "$nama")
            val mode = "vscom"
            val intent = Intent(requireActivity(), SecondActivity::class.java).apply {
                putExtra("nama", nama)
                putExtra("mode", mode)
            }
            startActivity(intent)
        }
        binding.etName.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
            override fun afterTextChanged(s: Editable?) {
                binding.btnSetName.isVisible = s!!.isNotEmpty()
                binding.btnVsCom.isVisible = s.isNotEmpty()
            }
        })
    }

}