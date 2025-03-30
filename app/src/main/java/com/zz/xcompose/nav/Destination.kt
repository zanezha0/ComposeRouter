package com.zz.xcompose.nav

import kotlinx.serialization.Serializable

@Serializable
object OneDestination

@Serializable
object TwoDestination

@Serializable
data class ThreeDestination(val channelId: String)

@Serializable
data class FourDestination(val name: String, val phone: String)

@Serializable
data  class FiveDestination(val age: Int,val name: String)