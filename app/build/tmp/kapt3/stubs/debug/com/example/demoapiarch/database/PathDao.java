package com.example.demoapiarch.database;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J \u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\'\u00a8\u0006\t"}, d2 = {"Lcom/example/demoapiarch/database/PathDao;", "Lcom/example/demoapiarch/database/MapsDao;", "Lcom/example/demoapiarch/database/relationship/Pathway;", "getPath", "", "Lcom/example/demoapiarch/model/path/Step;", "referenceId", "", "destinationId", "app_debug"})
public abstract interface PathDao extends com.example.demoapiarch.database.MapsDao<com.example.demoapiarch.database.relationship.Pathway> {
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT e.*, n.* FROM pathway INNER JOIN node AS n ON intermediate_id = n.node_id INNER JOIN edge AS e ON connecting_edge_id = e.edge_id WHERE reference_id = :referenceId AND destination_id = :destinationId ORDER BY order_number ASC")
    public abstract java.util.List<com.example.demoapiarch.model.path.Step> getPath(@org.jetbrains.annotations.NotNull()
    java.lang.String referenceId, @org.jetbrains.annotations.NotNull()
    java.lang.String destinationId);
}