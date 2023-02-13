package com.example.demoapiarch.domain;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\bR\u001c\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0004X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006\u00a8\u0006\r"}, d2 = {"Lcom/example/demoapiarch/domain/NodeType;", "Lcom/example/demoapiarch/domain/Type;", "()V", "table", "", "", "[[Ljava/lang/String;", "getTypeInt", "", "type", "getTypePreposition", "id", "getTypeString", "app_debug"})
public final class NodeType implements com.example.demoapiarch.domain.Type {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.demoapiarch.domain.NodeType INSTANCE = null;
    private static java.lang.String[][] table = {{"waypoint", "", ""}, {"classroom", "l\'", "aula"}, {"restroom_M", "il ", "bagno"}, {"restroom_F", "il ", "bagno"}, {"restroom_H", "il ", "bagno"}, {"study_room", "l\'", "aula studio"}, {"study_tables", "i ", "tavolini"}, {"bar", "il ", "bar"}, {"canteen", "la ", "mensa"}, {"restaurant", "il ", "ristorante"}, {"vending_machine_food", "il ", "distributore"}, {"vending_machine_hotdrinks", "il ", "distributore"}, {"vending_machine_colddrinks", "il ", "distributore"}, {"association_room", "l\'", "aula dedicata a un\'associazione"}, {"laboratory", "il ", "laboratorio"}, {"elevator", "l\'", "ascensore"}, {"stairs", "le ", "scale"}, {"stairs_automated", "le ", "scale mobili"}, {"water_point", "il ", "punto d\'acqua"}, {"door_exit", "la ", "porta d\'uscita"}, {"door_fire", "la ", "porta antincendio"}, {"door_window", "la ", "portafinestra"}, {"door_normal", "la ", "porta"}, {"library", "la ", "biblioteca"}, {"reception", "il ", "punto informazioni"}, {"professor_office", "l\'", "ufficio"}, {"parking_student", "il ", "parcheggio"}, {"parking_private", "il ", "parcheggio"}, {"bike_parking", "il ", "parcheggio per bici"}};
    
    private NodeType() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTypeString(int id) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTypePreposition(int id) {
        return null;
    }
    
    public final int getTypeInt(@org.jetbrains.annotations.NotNull()
    java.lang.String type) {
        return 0;
    }
}