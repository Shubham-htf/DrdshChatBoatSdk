package com.htf.drdshsdklibrary.Utills

import android.util.Patterns

import java.util.regex.Pattern


object RegExp {
    var EMPTY_TEXT = "^(?!\\s*$).+"
    var MOBILE_NUMBER = "^\\d{9,14}$"
    var BANK_NUMBER = "^\\d{10,16}$"
    var NAME = "^[a-zA-Z ]*$"
    // public static String PASSWORD = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{5,20})";

    var PASSWORD = "^.{6,14}\$"

    //var PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[$@$!%*?&])[A-Za-z\\d$@$!%*?&]{6,}"

    var EMAIL_ADDRESS = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$"

    fun isValidEmail(email: String): Boolean {
        println("Email Validation")
        return when {
            Patterns.EMAIL_ADDRESS.matcher(email).matches() -> {
                println("Email Valid")
                true
            }
            else -> {
                println("Email InValid")
                false
            }
        }
    }

    fun isValidNAME(email: String): Boolean {
        println("Email Validation")
        return when {
            Pattern.compile(NAME).matcher(email).matches() -> {
                println("Email Valid")
                true
            }
            else -> {
                println("Email InValid")
                false
            }
        }
    }

    fun isValidPASSWORD(password: String): Boolean {
        println("Password Validation")
        return when {
            Pattern.compile(PASSWORD).matcher(password).matches() -> {
                println("Password Valid")
                true
            }
            else -> {
                println("Password InValid")
                false
            }
        }
    }

    fun isValidBankAccount(accountNumber: String): Boolean {
        println("Account Number Validation")
        return when {
            Pattern.compile(BANK_NUMBER).matcher(accountNumber).matches() -> {
                println("Account Number is Valid")
                true
            }
            else -> {
                println("Account Number InValid")
                false
            }
        }
    }

    fun isValidPhone(phone: String): Boolean {
        println("Phone Validation")
        return when {
            Pattern.compile(MOBILE_NUMBER).matcher(phone).matches() -> {
                println("Mobile Valid")
                true
            }
            else -> {
                println("Mobile InValid")
                false
            }
        }
    }

    fun chkEmpty(`object`: String): Boolean {
        return when {
            `object`.trim { it <= ' ' }.isEmpty() -> {
                println("Is Empty")
                true
            }
            else -> {
                println("Is UnEmpty")
                false
            }
        }
    }

    fun chkNull(`object`: Any?): Boolean {
        return `object` == null
    }
}
