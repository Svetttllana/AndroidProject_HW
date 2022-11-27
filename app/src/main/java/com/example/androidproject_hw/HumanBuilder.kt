package com.example.androidproject_hw

class HumanBuilder (val builder: Builder) {


fun hasArm()= builder.arm
fun hasLeg()= builder.leg
fun hasBrain()= builder.brain

    companion object Builder{
        var arm: Int = 0
        var leg:Int =0
        var brain:Boolean=false

        fun setArm(arm:Int)=apply { this.arm=arm }
        fun setLeg(leg:Int)=apply { this.leg=leg }
        fun setBrain(brain:Boolean)= apply { this.brain=brain }

        fun build():HumanBuilder{
            return HumanBuilder(this)
        }

    }
}


