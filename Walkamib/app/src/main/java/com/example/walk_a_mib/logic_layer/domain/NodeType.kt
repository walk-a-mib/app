package com.example.walk_a_mib.logic_layer.domain

import com.example.walk_a_mib.logic_layer.domain.Type
import java.lang.Exception

object NodeType : Type.Type {
    private var table = arrayOf(
        arrayOf("waypoint","",""),
        arrayOf("classroom","l'","aula"),
        arrayOf("restroom_M","il ","bagno"),
        arrayOf("restroom_F","il ","bagno"),
        arrayOf("restroom_H","il ","bagno"),
        arrayOf("study_room","l'","aula studio"),
        arrayOf("study_tables","i ","tavolini"),
        arrayOf("bar","il ","bar"),
        arrayOf("canteen","la ","mensa"),
        arrayOf("restaurant","il ","ristorante"),
        arrayOf("vending_machine_food","il ","distributore"),
        arrayOf("vending_machine_hotdrinks","il ","distributore"),
        arrayOf("vending_machine_colddrinks","il ","distributore"),
        arrayOf("association_room","l'","aula dedicata a un'associazione"),
        arrayOf("laboratory","il ","laboratorio"),
        arrayOf("elevator","l'","ascensore"),
        arrayOf("stairs","le ","scale"),
        arrayOf("stairs_automated","le ","scale mobili"),
        arrayOf("water_point","il ","punto d'acqua"),
        arrayOf("door_exit","la ","porta d'uscita"),
        arrayOf("door_fire","la ","porta antincendio"),
        arrayOf("door_window","la ","portafinestra"),
        arrayOf("door_normal","la ","porta"),
        arrayOf("library","la ","biblioteca"),
        arrayOf("reception","il ","punto informazioni"),
        arrayOf("professor_office","l'","ufficio"),
        arrayOf("parking_student","il ","parcheggio"),
        arrayOf("parking_private","il ","parcheggio"),
        arrayOf("bike_parking","il ","parcheggio per bici")
    )

    fun getTypeString(id: Int): String {
        return try {
            table[id][0]
        } catch (e: Exception) {
            e.printStackTrace()
            "indefinite"
        }
    }

    fun getTypePreposition(id: Int): String {
        return try {
            table[id][1]
        } catch (e: Exception) {
            e.printStackTrace()
            "indefinite"
        }
    }

    fun getTypeInt(type: String): Int {
        for (i in table.indices) if (table[i][0] == type) return i
        return -1
    }
}