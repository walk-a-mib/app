package com.example.walk_a_mib.logic_layer.domain

import android.os.Parcelable
import android.util.Log
import androidx.room.Embedded
import com.example.walk_a_mib.logic_layer.domain.NodeType.getTypeName
import com.example.walk_a_mib.logic_layer.domain.NodeType.getTypeInt
import kotlinx.parcelize.Parcelize

@Parcelize
class Path(val pathLength: Int,
           @Embedded var nodeList: ArrayList<Node>,
           @Embedded var edgeList: ArrayList<Edge>) : Parcelable {

    fun getTextIndications() : ArrayList<Array<String>> {
        val result : ArrayList<Array<String>> = arrayListOf()
        val e = edgeList
        val n = nodeList
        val p = simplifyPath()

        result.add(indArray(0, 0, getStepTextIndications(p[0], e[0], p[1], 0, e[0].distance), e[0].distance))
        Log.d("FUCKINGDEBUGINCOMING!", "0, 0, ${getStepTextIndications(p[0], e[0], p[1], 0, e[0].distance)}, ${e[0].distance}")
        for(i in 1..(p.size - 2)){
            val heading = p[i].getPathDirection(p[i-1], p[i+1])
            val index1 = n.indexOf(p[i])
            val index2 = n.indexOf(p[i+1])
            var distance = 0
            for(j in index1 until index2) {
                distance += e[j].distance
                Log.d("FUCKINGEDGEINCOMING!", "${e[j]}")
            }
            val text = getStepTextIndications(p[i], e[index1], p[i+1], heading, distance)
            result.add(indArray(index1, heading, text, distance))
            Log.d("FUCKINGDEBUGINCOMING!", "$index1, $heading, $text, $distance")

        }


        return result
    }

    fun indArray(index : Int, heading: Int, text : String, distance : Int) : Array<String>{
        var arr : Array<String> = arrayOf("", "", "", "")
        arr[0] = index.toString()
        arr[1] = heading.toString()
        arr[2] = text
        arr[3] = distance.toString()
        return arr
    }

    fun simplifyPath() : ArrayList<Node>{
        val result : ArrayList<Node> = arrayListOf()
        val n = nodeList
        val e = edgeList
        result.add(n[0])
        for(i in 1..n.size - 2){
            if(n[i].getPathDirection(n[i-1], n[i+1]) != 0
                || n[i].ga.floor != n[i-1].ga.floor
                || e[i-1].label != e[i].label){
                result.add(n[i])
            }
        }
        result.add(n[n.size - 1]);
        return result
    }

    fun getStepTextIndications(start : Node,
                               way : Edge,
                               end : Node,
                               heading : Int,
                               distance: Int) : String {
        var indications = ""

        val n1Prep = getPreposition(NodeType.getTypePreposition(getTypeInt(start.label)), false)
        val n2Prep = getPreposition(NodeType.getTypePreposition(getTypeInt(end.label)), false)
        val n1 = getTypeName(start.label)
        val n2 = getTypeName(end.label)

        //val e = EdgeType.getTypeName(way.type)
        val e = EdgeType.getTypeName(way.label)
        val ePrep = EdgeType.getTypePreposition(EdgeType.getTypeInt(way.label))
        var eVerb = EdgeType.getTypeVerb(EdgeType.getTypeInt(way.label), true)
        if(start.ga.floor > end.ga.floor)
            eVerb = EdgeType.getTypeVerb(EdgeType.getTypeInt(way.label), false)

        val turn = getTurnTextIndications(heading)
        val dDistance = (distance - distance % 10).toDouble() / 100.0

        if((start.label != "waypoint" && start.label != "stairs") and
            (end.label != "waypoint" && end.label != "stairs"))
            indications = "$n1Prep$n1 $turn e $eVerb $ePrep$e fino $n2Prep$n2"
        else if((start.label == "waypoint" || start.label == "stairs") and
            (end.label != "waypoint" && end.label != "stairs"))
            indications = "$turn e $eVerb $ePrep$e fino $n2Prep$n2"
        else

            indications = "$turn e $eVerb $ePrep$e per $dDistance m"

        return indications
    }

    private fun getTurnTextIndications(heading : Int) : String{
        when(heading) {
            0 -> return "vai avanti"
            1 -> return "gira un poco a destra"
            2 -> return "gira a destra"
            3 -> return "gira a destra"
            4 -> return "torna indietro"
            5 -> return "gira a sinistra"
            6 -> return "gira a sinistra"
            7 -> return "gira un poco a sinistra"
        }
        return "vai dove vuoi"
    }

    private fun getPreposition(art : String, from: Boolean) : String{
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