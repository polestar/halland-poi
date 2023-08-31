package com.example.varbergpoi

import com.example.varbergpoi.dummydata.Category
import com.example.varbergpoi.dummydata.DummyHandler
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun isDummyFilled(){
        ObjectBox.initTest()
        DummyHandler.initDummyData()
        val categoryBox = ObjectBox.boxStore.boxFor(Category::class.java)
        assertTrue(categoryBox.count() > 0)
    }
}