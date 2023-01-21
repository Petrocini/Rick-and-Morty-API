package com.petrocini.rickandmorty.data.network.dto

data class PageInfoDto(
    val info: Info,
    val results: List<Charac>
)

data class Info(
    val count: Int,
    val pages: Int,
    val next: String?,
    val prev: String?
)