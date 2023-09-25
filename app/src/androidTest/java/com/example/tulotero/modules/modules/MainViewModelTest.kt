package com.example.tulotero.modules.modules

import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.ExperimentalCoroutinesApi


@ExperimentalCoroutinesApi
class MainViewModelTest{


    @RelaxedMockK
    private lateinit var viewModel: MainViewModel

    fun setUp(){
        viewModel
    }


/*
    @Test
    fun `insertAdmin inserts admin into database`() = runBlockingTest {
        // Arrange
        val admin = Administration("1",)

        // Mockear la instancia de App
        val app = mockk<App>()
        val db = mockk<AdminsDatabase>()
        val adminDao = mockk<AdminDao>()


        coEvery { app.db } returns db
        coEvery { db.adminDao() } returns adminDao
        coEvery { adminDao.insert(admin) } just runs

        viewModel.app = app

        // Act
        viewModel.(admin)

        // Assert
        coEvery { adminDao.insert(admin) }
    }*/
}


