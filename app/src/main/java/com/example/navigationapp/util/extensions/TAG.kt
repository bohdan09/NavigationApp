package com.example.navigationapp.util.extensions

val Any.TAG: String
    get() {
        return if (!javaClass.isAnonymousClass) {
            javaClass.simpleName
        } else {
            javaClass.name
        }
    }