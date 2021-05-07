package org.kazantsev.coursework

import android.app.Application
import org.kazantsev.coursework.database.CourseworkRepository

class CourseworkApp : Application() {
    override fun onCreate() {
        super.onCreate()

        CourseworkRepository.initialize(this)
    }
}