package com.example.walk_a_mib.model

import android.util.Log
import android.webkit.JavascriptInterface
import android.webkit.WebView
import com.example.walk_a_mib.logic_layer.domain.Node

//  CARISSIMI COLLEGHI CE L'ABBIAMO FATTA
//  ciao squiddi questa classe è per te
//
//  sono stata fino alle 3 ad ottimizzare la funzione per cambiare piano e ora va che
//  è una meraviglia, non "flasha" più la mappa, è istantaneo il caricamento

class JSBridge(){
        @JavascriptInterface
        fun showPointInfo(id:String){
            // restituisce l'id del punto di interesse toccato sulla mappa
            Log.d("MESSAGE FROM WEBVIEW", id);
            // mettere qui tutto il codice che bisogna eseguire quando viene
            // toccato un punto della mappa, per esempio una chiamata al controller
            // che setta tutto quanto per vedere le info del punto.
            // Se serve oltre all'id posso ritornare, in formato stringa, anche:
            // nome, edificio, piano, tipo, coordinate.


        }

        // Da chiamare quando si vuole cambiare piano sulla mappa
        fun setFloor(webview: WebView, floor: Int){
            webview.evaluateJavascript("javascript:setFloor(${floor})", null)
        }

        // Da chiamare per centrare la vista della mappa su certe coordinate
        fun centerView(webview: WebView, lon:Double, lat:Double){
            webview.evaluateJavascript("javascript:centerOnCoordinates([${lon}, ${lat}])", null)
        }

        // Da chiamare per centrare la vista della mappa su certe coordinate e ruotarla affinché
        // abbia un angolo di n radianti rispetto alla direzione nord (è assoluto, non relativo)
        // 0 per esempio te la fa ruotare mettendo il nord a nord, mentre pi greco la mette col
        // nord a sud indipendentemente dall'angolo precedente
        fun centerTurnView(webview: WebView, lon:Double, lat:Double, n:Double){
            webview.evaluateJavascript("javascript:centerAndTurn([${lon}, ${lat}], ${n})", null)
        }

        // per avere il nord a nord
        fun resetRotation(webview: WebView){
            webview.evaluateJavascript("javascript:resetRotation()", null)
        }

        // Da chiamare per far vedere tutte le icone che sono presenti nella lista List<Nodes>
        fun showIcons(webview: WebView, nodes: List<Node>){
            val allowed_nodes = arrayOf(
                "restroom_M",
                "restroom_F",
                "restroom_H",
                "stairs",
                "classroom",
                "vending_machine_hotdrinks",
                "vending_machine_colddrinks"
            )
            for(node in nodes){
                if(allowed_nodes.contains(node.label)){
                    val id = node.id
                    val name = node.name
                    val coord = "[${node.position.lon}, ${node.position.lat}]"
                    val floor = node.ga.floor;
                    val type = node.label;

                    val param = "\"${id}\", \"${name}\", ${coord}, 24, ${floor}, \"${type}\""
                    webview.evaluateJavascript("javascript:insertIcon(${param})", null)
                }
            }

            webview.evaluateJavascript("javascript:initializeIcons()", null)
        }

        // da chiamare per filtrare le icone sulla mappa alle sole icone del tipo "label".
        // notare che filtra solo quelle di un piano, quindi se si cambia piano vanno ri-filtrate.
        // Non causa lag visibile filtrarle subito dopo al cambio piano, quindi gestisciti come vuoi
        fun filterByType(webview: WebView, label: String){
            webview.evaluateJavascript("javascript:filterByType(\"${label}\")", null)
        }

        // si autodescrive
        fun resetFilters(webview: WebView){
            webview.evaluateJavascript("javascript:resetFilters()", null)
        }

    // Fa la print del path da una lista di nodi ordinata.
    // Dovremo gestire da qui il fatto che bisogna stampare solo i path su uno stesso piano.
    // Esempio:
    // utente va da classe a macchinetta
    // si stampa il percorso al piano 0 fino alle scale
    // quando l'utente arriva all'indicazione di cambio piano:
    // si resetta il path
    // si cambia piano
    // si ristampa il path, con i nodi del percorso che sono al primo piano
    // L'idea è di tenere, per la durata dell'attività di navigazione,
    // un array che per ogni piano (in ordine) salva i nodi che stanno su quel piano
    // quando si rileva da recyclerview un'índicazione di piano diverso da quello precedente,
    // si esegue il miniciclo sopra
    fun showPath(webview: WebView, nodes: List<Node>){
        var s = "["
        for(node in nodes){
            s += "[${node.position.lon}, ${node.position.lat}],"
            }
        s += "]"
        webview.evaluateJavascript("javascript:showPath(${s})", null)
        }

    //si autocommenta????
    fun resetPath(webview: WebView){
        webview.evaluateJavascript("javascript:resetPath()", null)
    }

    //mostra il personaggino ahah alle coordinate che vuoi
    fun showUserLocation(webview: WebView, lon:Double, lat:Double){
        webview.evaluateJavascript("javascript:showUserLocation([${lon}, ${lat}])", null)
    }

    //...
    fun hideUserLocation(webview: WebView){
        webview.evaluateJavascript("javascript:hideUserLocation()", null)
    }

    //facciamo finta che sia buona, tanto non lagga anche ad eseguirla un botto di volte
    fun updateUserLocation(webview: WebView, lon:Double, lat:Double){
        hideUserLocation(webview)
        showUserLocation(webview, lon, lat)
    }


    }

