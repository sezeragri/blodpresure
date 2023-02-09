package com.bloodpressurechecker.bpblood.bptracker.screen

import androidx.room.*


@Dao
interface BPTrackerDao {
    @Query("SELECT * FROM kisiler ORDER BY person_id DESC")
    suspend fun tumKisiler():List<BPTracker>

    @Insert
    suspend fun kisiEkle(kisiler: BPTracker)

    @Update
    suspend fun kisiGuncelle(kisiler: BPTracker)

    @Delete
    suspend fun kisiSil(kisiler: BPTracker)

    @Query("SELECT * FROM kisiler ORDER BY person_id DESC LIMIT 1 ")
    suspend fun buyukTansiyon() : List<BPTracker>

    @Query("SELECT kTan FROM kisiler ORDER BY person_id DESC LIMIT 1 ")
    suspend fun kucukTansiyon() : Int

    @Insert
    suspend fun listeyeEkle(kisiler: BPTracker)

    @Query("SELECT bTan FROM kisiler ORDER BY bTan DESC LIMIT 1")
    suspend fun  maxBtanAl() : Int
    @Query("SELECT kTan FROM kisiler ORDER BY kTan DESC LIMIT 1")
    suspend fun maxKtanAl() :Int
    @Query("SELECT nabiz FROM kisiler ORDER BY nabiz DESC LIMIT 1")
    suspend fun maxNabizAl() : Int


    @Query("SELECT bTan FROM kisiler ORDER BY bTan ASC LIMIT 1")
    suspend fun  minBtanAl() : Int
    @Query("SELECT kTan FROM kisiler ORDER BY kTan ASC LIMIT 1")
    suspend fun minKtanAl() :Int
    @Query("SELECT nabiz FROM kisiler ORDER BY nabiz ASC LIMIT 1")
    suspend fun minNabizAl() : Int














}