package com.bloodpressurechecker.bpblood.bptracker.screen

import androidx.room.*
import org.jetbrains.annotations.NotNull
import org.w3c.dom.Text


@Entity(tableName = "kisiler")
data class BPTracker(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "person_id") @NotNull var person_id: Int,
    @ColumnInfo(name = "bTan") @NotNull var bTan: Int,
    @ColumnInfo(name = "kTan") @NotNull var kTan: Int,
    @ColumnInfo(name = "nabiz") @NotNull var nabiz: Int,
    @ColumnInfo(name = "date") @NotNull var date : String


) {
}


