package com.example.walk_a_mib.logic_layer.domain

import com.example.walk_a_mib.logic_layer.domain.Edge

class Path {
    var nodeList: ArrayList<Node>? = null
    var edgeList: ArrayList<Edge>? = null

    fun getTextIndications() : ArrayList<String> {
        val result : ArrayList<String> = arrayListOf()

        val e = edgeList!!.iterator()
        val n = nodeList!!.iterator()

        var node1 = n.next()

        // da completare

        result.add("Destinazione raggiunta!")
        return result
    }

    fun getStepTextIndications(start : Node,
                               way : Edge,
                               end : Node,
                               heading : Int) : String {
        var indications = ""

        val n1Prep = getPreposition(NodeType.getTypePreposition(start.type), false)
        val n2Prep = getPreposition(NodeType.getTypePreposition(end.type), false)
        val n1 = start.name
        val n2 = end.name

        val e = EdgeType.getTypeName(way.type)
        var ePrep = EdgeType.getTypePreposition(way.type)
        var eVerb = EdgeType.getTypeVerb(way.type, true)
        if(start.ga!!.floor > end.ga!!.floor)
            eVerb = EdgeType.getTypeVerb(way.type, false)

        var turn = getTurnTextIndications(heading)

        if((start.type != 0) and (end.type != 0))
            indications = "$n1Prep$n1 $turn e $eVerb $ePrep$e fino $n2Prep$n2"
        else if(start.type == 0)
            indications = "$turn e $eVerb $ePrep$e fino $n2Prep$n2"
        else
            indications = "$n1Prep$n1 $turn e $eVerb $ePrep$e"

        return indications
    }

    fun getTurnTextIndications(heading : Int) : String{
        when(heading) {
            0 -> return "vai avanti"
            1 -> return "gira un poco a destra"
            2 -> return "gira a destra"
            3 -> return "gira molto a destra"
            4 -> return "torna indietro"
            5 -> return "gira molto a sinistra"
            6 -> return "gira a sinistra"
            7 -> return "gira un poco a sinistra"
        }
        return "vai dove vuoi"
    }

    fun getPreposition(art : String, from: Boolean) : String{
        if(from)
            when(art) {
                "il " -> return "dal "
                "lo " -> return "dallo "
                "la " -> return "dalla "
                "i " -> return "dai "
                "gli " -> return "dagli "
                "le " -> return "dalle "
                "l'" -> return "dall'"
            }
        else
            when(art) {
                "il " -> return "al "
                "lo " -> return "allo "
                "la " -> return "alla "
                "i " -> return "ai "
                "gli " -> return "agli "
                "le " -> return "alle "
                "l'" -> return "all'"
            }
        return ""
    }


}