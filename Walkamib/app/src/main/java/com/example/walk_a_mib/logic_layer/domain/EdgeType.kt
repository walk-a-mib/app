package com.example.walk_a_mib.logic_layer.domain

object EdgeType : Type {
    private var table = arrayOf(
        arrayOf("elevator_step","l' ","ascensore", "prendi", "prendi"),
        arrayOf("stairs_step","le ","scale", "sali", "scendi"),
        arrayOf("stairs_automated_step","le ", "scale", "sali", "scendi"),
        arrayOf("corridor","il ", "corridoio", "percorri", "percorri"),
        arrayOf("path", "", "","vai","vai")
    )

    fun getTypeString(id: Int): String {
        return try {
            table[id][0]
        } catch (e: Exception) {
            e.printStackTrace()
            "indefinite"
        }
    }

    fun getTypeName(id: Int): String {
        return try {
            table[id][2]
        } catch (e: Exception) {
            e.printStackTrace()
            "indefinite"
        }
    }

    fun getTypePreposition(id: Int): String {
        return try {
            table[id][1]
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
            "indefinite"
        }
    }


    fun getTypeVerb(id: Int, up: Boolean): String {
        return try {
            if(up) {
                table[id][3]
            } else {
                table[id][4]
            }
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
            "indefinite"
        }
    }

    fun getTypeInt(type: String): Int {
        for (i in table.indices) if (table[i][0].equals(type)) return i
        return -1
    }
}