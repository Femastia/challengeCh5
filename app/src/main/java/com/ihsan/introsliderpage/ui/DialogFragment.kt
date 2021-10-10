package com.ihsan.introsliderpage.ui

import android.app.Dialog
import android.os.Bundle
import android.view.*
import androidx.fragment.app.DialogFragment
import com.ihsan.introsliderpage.R
import com.ihsan.introsliderpage.databinding.FragmentDialogBinding
import kotlin.system.exitProcess

class DialogFragment : DialogFragment() {
    private lateinit var binding: FragmentDialogBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentDialogBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val params: WindowManager.LayoutParams? = dialog?.window?.attributes
        params?.width = WindowManager.LayoutParams.MATCH_PARENT
        params?.height = WindowManager.LayoutParams.WRAP_CONTENT
        dialog?.window?.attributes = params as WindowManager.LayoutParams

        binding.btnYes.setOnClickListener {
            requireActivity().finishAffinity()
        }
        binding.btnNo.setOnClickListener {
            dismiss()
        }
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        // request a window without the title
        dialog.window?.requestFeature(Window.FEATURE_NO_TITLE)
        return dialog
    }

}