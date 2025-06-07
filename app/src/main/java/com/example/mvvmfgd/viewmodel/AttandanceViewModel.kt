package com.example.mvvmfgd.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmfgd.model.AttendanceModel

class AttandanceViewModel : ViewModel() {

    private val _attandanceData = MutableLiveData<AttendanceModel>()
    val attendanceData: LiveData<AttendanceModel>get() = _attandanceData

    //fungsi menyimpan data peserta
    fun setAttandanceData(model: AttendanceModel) {
        _attandanceData.value = model
    }
}