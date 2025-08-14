package com.alamin.todo


import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.alamin.todo.databinding.ActivityAddToDoBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class AddToDoBottomSheet : BottomSheetDialogFragment() {

    lateinit var binding: ActivityAddToDoBottomSheetBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ActivityAddToDoBottomSheetBinding.inflate(inflater, container , false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
    }

    private fun initListeners() {
      binding.addBotton.setOnClickListener {}
    }

    private  fun isValidFor(): Boolean {
        if(binding.titleInputLayout.editText?.text.toString().isEmpty())
        {
            binding.titleInputLayout.error= "Please Enter Title"
            return false
        }
        if(binding.descriptionInputLayout.editText?.text.toString().isEmpty())
        {
            binding.titleInputLayout.error= "Please Enter Description"
            return false
        }
    return true
    }

}
