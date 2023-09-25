package com.example.tulotero.modules.models

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

import kotlinx.coroutines.flow.Flow

@Dao
interface AdminDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun  insert(administration: Administration)
    @Update
    suspend fun update(administration: Administration)
    @Delete
    suspend fun delete(administration: Administration)


    @Query("SELECT * from admins WHERE name = :name")
    fun getAdminByName(name: String): Flow<List<Administration>>

    @Query("SELECT * from admins ORDER BY name ASC")
    fun getAllItems(): Flow<List<Administration>>

    @Query("SELECT * FROM admins WHERE LOWER(name) LIKE '%' || LOWER(:searchText) || '%' OR LOWER(town) LIKE '%' || LOWER(:searchText) || '%' OR LOWER(province) LIKE '%' || LOWER(:searchText) || '%'")
    fun getAdminsBySearchText(searchText: String): Flow<List<Administration>>

}