package com.alamin.todo.ui.screens.screens.add_todo


import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker

import com.alamin.todo.databinding.ActivityAddToDoBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import java.util.Calendar


class AddToDoBottomSheet : BottomSheetDialogFragment() {

    lateinit var binding: ActivityAddToDoBottomSheetBinding
    var selectedDate = Calendar.getInstance()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ActivityAddToDoBottomSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
        bindDate()
        bindTime()
    }

    private fun bindDate() {

        binding.selectedDateTv.text = getFormattedDate()

    }

    private fun bindTime() {

        binding.selectedTimeTv.text = getFormattedTime()

    }

    private fun getFormattedTime(): String {
        var hour = selectedDate.get(Calendar.HOUR)
        var minute = selectedDate.get(Calendar.MINUTE)

        return "$hour:$minute"
    }

    private fun getFormattedDate(): String {
        var year = selectedDate.get(Calendar.YEAR)
        var month = selectedDate.get(Calendar.MONTH) + 1
        var day = selectedDate.get(Calendar.DAY_OF_MONTH)

        return "$day/$month/$year"
    }

    private fun initListeners() {
        binding.addBotton.setOnClickListener {
            if (isValidFor()) {
            }
        }
        binding.selectedDateTv.setOnClickListener {
            showDatePickerDialog()
        }
        binding.selectedTimeTv.setOnClickListener {
            showTimePickerDialog()
        }

    }

    private fun showTimePickerDialog() {
        val picker =
            TimePickerDialog(requireContext(),
                { p0, hour, minute ->
                    selectedDate[Calendar.HOUR] = hour
                    selectedDate[Calendar.MINUTE] = minute
                    bindTime()
                }, selectedDate.get(Calendar.HOUR), selectedDate.get(Calendar.MINUTE),  true)
        picker.show()
    }

    private fun showDatePickerDialog() {
        val picker =
            DatePickerDialog(
                requireContext(),
                { p0, year, month, day ->
                    selectedDate[Calendar.YEAR] = year
                    selectedDate[Calendar.MONTH] = month
                    selectedDate[Calendar.DAY_OF_MONTH] = day

                    bindDate()
                },
                selectedDate.get(Calendar.YEAR),
                selectedDate.get(Calendar.MONTH),
                selectedDate.get(Calendar.DAY_OF_MONTH)
            )
        picker.show()
    }

    private fun isValidFor(): Boolean {
        var isValid = true
        if (binding.titleInputLayout.editText?.text.toString().isEmpty()) {
            binding.titleInputLayout.error = "Please Enter Title"
            //return false
            isValid = false
        } else {
            binding.titleInputLayout.error = null
        }
        if (binding.descriptionInputLayout.editText?.text.toString().isEmpty()) {
            binding.descriptionInputLayout.error = "Please Enter Description"
            isValid = false
        } else {
            binding.descriptionInputLayout.error = null
        }
        return isValid
    }

}
