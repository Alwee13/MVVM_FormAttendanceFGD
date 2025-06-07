package com.example.mvvmfgd.model

data class AttendanceModel(
    val name: String ="",
    val phone: String ="",
    val email: String ="",
    val gender: String ="",
    val skillset: List<String> = emptyList(),
    var kategori: String =""
)
