package com.example.alarm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.NumberPicker
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.alarm.databinding.FragmentAlarmSettingaBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Alarm_settinga.newInstance] factory method to
 * create an instance of this fragment.
 */
class Alarm_settinga : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var navController: NavController
    private var _binding : FragmentAlarmSettingaBinding? = null
    private val binding get() = _binding!!
    val ampm = arrayOf("오전", "오후")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAlarmSettingaBinding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        binding.mission.setOnClickListener{
            findNavController().navigate(R.id.action_alarm_settinga_to_alarm_mission_setting)
        }

        setupNumberPickerForStringValues()

        binding.timeAmpm.displayedValues
        binding.timeHour.minValue = 1
        binding.timeHour.maxValue = 12

        binding.timeMinute.maxValue= 59
        binding.timeMinute.minValue = 0

        binding.timeAmpm.maxValue=1
        binding.timeAmpm.minValue=0

        binding.missionSet.bringToFront()
        binding.mission2.bringToFront()
        binding.checkBox2.bringToFront()
        binding.buttonMon.setOnClickListener{
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Alarm_settinga.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Alarm_settinga().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
    private fun setupNumberPickerForStringValues() {
        val numberPicker = binding.timeAmpm
        val values = arrayOf("오전","오후")
        numberPicker.minValue = 0
        numberPicker.maxValue = values.size - 1
        numberPicker.displayedValues = values
        numberPicker.wrapSelectorWheel = true
    }
}

